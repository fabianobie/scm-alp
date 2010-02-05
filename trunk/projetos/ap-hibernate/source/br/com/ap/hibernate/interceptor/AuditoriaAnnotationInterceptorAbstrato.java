/*
 * AuditoriaAnnotationInterceptor.java
 * 
 * Data de criação: 05/08/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.interceptor;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.validador.UtilValidadorDeNumerosIguais;
import br.com.ap.hibernate.annotation.Auditoria;
import br.com.ap.hibernate.constante.Acao;
import br.com.ap.hibernate.holder.HibernateHolder;
import br.com.ap.reflexao.UtilReflexaoAnnotation;
import br.com.ap.reflexao.UtilReflexaoMetodo;

/**
 * Classe responsável pela auditoria de ações solicitadas ao banco de dados. As
 * ações de inclusão, alteração, exclusão e consulta serão captadas e será
 * solicitado que uma entidade que representa a auditoria das informações
 * manipuladas seja gravado no banco de dados.<br/>
 * O método abstrato 'doMontarEntidadeDeAuditoria' deverá ser implementado para
 * que o interceptor saiba qual objeto persistir.
 * 
 * @author adrianop
 */
public abstract class AuditoriaAnnotationInterceptorAbstrato extends
        InterceptorAbstrato {

	private Map<Integer, Object> mapaDeAcoes;

	/**
	 * @see org.hibernate.EmptyInterceptor#onSave(java.lang.Object,
	 *      java.io.Serializable, java.lang.Object[], java.lang.String[],
	 *      org.hibernate.type.Type[])
	 */
	@Override
	public boolean onSave(Object entidade, Serializable pk, Object[] valores,
	        String[] propriedades, Type[] tipos) {

		if (isAuditarInclusao(entidade)) {
			Serializable acao = getValorDaPropriedadeDeAcao(Acao.getInclusao());
			Entidade e = doMontarEntidadeDeAuditoria(entidade, null, acao);
			if (isReferencia(e)) {
				getSession().save(e);
			}
		}
		return false;
	}

	/**
	 * @see org.hibernate.EmptyInterceptor#onDelete(java.lang.Object,
	 *      java.io.Serializable, java.lang.Object[], java.lang.String[],
	 *      org.hibernate.type.Type[])
	 */
	@Override
	public void onDelete(Object entidade, Serializable pk, Object[] valores,
	        String[] propriedades, Type[] tipos) {

		if (isAuditarExclusao(entidade)) {
			HibernateHolder.setAcaoDeExclusao();

			Serializable acao = getValorDaPropriedadeDeAcao(Acao.getExclusao());
			Entidade e = doMontarEntidadeDeAuditoria(entidade, null, acao);
			if (isReferencia(e)) {
				getSession().save(e);
			}
		}
	}

	/**
	 * @see org.hibernate.EmptyInterceptor#findDirty(java.lang.Object,
	 *      java.io.Serializable, java.lang.Object[], java.lang.Object[],
	 *      java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public int[] findDirty(Object entidade, Serializable pk, Object[] valores,
	        Object[] valoresAnterior, String[] propriedades, Type[] tipos) {

		int[] resultado = null;

		if (isAcaoDeAlteracao()) {
			Class<?> classeEntidadeAntiga = UtilObjeto.getClasse(entidade);
			Object entidadeAntiga = getSession().get(classeEntidadeAntiga, pk);
			if (entidade != entidadeAntiga) {
				resultado = new int[propriedades.length];
			}
		}
		return resultado;
	}

	/**
	 * @see org.hibernate.EmptyInterceptor#onFlushDirty(java.lang.Object,
	 *      java.io.Serializable, java.lang.Object[], java.lang.Object[],
	 *      java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onFlushDirty(Object entidade, Serializable pk,
	        Object[] valores, Object[] valoresAnteriores,
	        String[] propriedades, Type[] tipos) {

		boolean resultado = false;
		if (isAuditarAlteracao(entidade)) {
			Serializable acao = getValorDaPropriedadeDeAcao(Acao.getAlteracao());

			Class<?> classeEntidadeAntiga = UtilObjeto.getClasse(entidade);
			Object entidadeAntiga = getSession().get(classeEntidadeAntiga, pk);

			if (entidade != entidadeAntiga) {
				Entidade e = doMontarEntidadeDeAuditoria(entidade,
				        entidadeAntiga, acao);
				if (isReferencia(e)) {
					Session sessao = getSession();
					sessao.save(e);
					sessao.flush();
				}
			}
		}
		return resultado;
	}

	/**
	 * @see org.hibernate.EmptyInterceptor#postFlush(java.util.Iterator)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void postFlush(Iterator entities) {
		super.postFlush(entities);
		HibernateHolder.setAcao(null);
	}

	/**
	 * @see org.hibernate.EmptyInterceptor#afterTransactionCompletion(org.hibernate.Transaction)
	 */
	@Override
	public void afterTransactionCompletion(Transaction tx) {
		super.afterTransactionCompletion(tx);

		if (isReferencia(getSessionFactory())) {
			Transaction transacao = getTransacao();

			if (isReferencia(transacao)) {
				getSession().flush();
				if (tx.wasRolledBack()) {
					transacao.rollback();
				} else {
					transacao.commit();
				}
			}
			finalizarSessao();
		}
	}

	/**
	 * Método responsável pela montagem da entidade que será persistida para
	 * registro de auditoria.
	 * 
	 * @param <T> Entidade montada e persistida.
	 * @param entidade Entidade persistida no momento.
	 * @param entidadeAntiga Entidade antiga.
	 * @param acao Ação executada. (Ex: Acao.getInclusao())
	 * @return Entidade que representa a auditoria.
	 */
	protected abstract <T extends Entidade> T doMontarEntidadeDeAuditoria(
	        Object entidade, Object entidadeAntiga, Serializable acao);

	/**
	 * @return true se a ação atual é uma ação de inclusão.
	 */
	protected boolean isAcaoDeInclusao() {
		Integer acao = HibernateHolder.getAcao();
		Integer inclusao = Acao.getInclusao();
		return UtilValidadorDeNumerosIguais.validar(acao, inclusao);
	}

	/**
	 * @return true se a ação atual é uma ação de exclusão.
	 */
	protected boolean isAcaoDeExclusao() {
		Integer acao = HibernateHolder.getAcao();
		Integer exclusao = Acao.getExclusao();
		return UtilValidadorDeNumerosIguais.validar(acao, exclusao);
	}

	/**
	 * @return true se a ação atual é uma ação de alteração.
	 */
	protected boolean isAcaoDeAlteracao() {
		Integer acao = HibernateHolder.getAcao();
		Integer alteracao = Acao.getAlteracao();
		return UtilValidadorDeNumerosIguais.validar(acao, alteracao);
	}

	/**
	 * @return true se a ação atual é uma ação de consulta.
	 */
	protected boolean isAcaoDeConsulta() {
		Integer acao = HibernateHolder.getAcao();
		Integer consulta = Acao.getConsulta();
		return UtilValidadorDeNumerosIguais.validar(acao, consulta);
	}

	/**
	 * Retorna a anotação de Auditoria para a entidade solicitada.
	 * 
	 * @param entidade Entidade solicitada.
	 * @return anotação de Auditoria.
	 */
	protected Auditoria getAnotacaoDeAuditoria(Object entidade) {
		return getAnotacaoDeClasse(entidade, Auditoria.class);
	}

	/**
	 * Retorna a anotação de tabela (javax.persistence.Table) do objeto passado
	 * por parâmetro.
	 * 
	 * @param <T> Tipo da anotação que será recuperada.
	 * @param entidade Objeto do qual a anotação será recuperada.
	 * @return Anotação do tipo javax.persistence.Table.
	 * @see javax.persistence.Table
	 */
	@SuppressWarnings("unchecked")
	protected <T extends Annotation> T getAnotacaoDeTabela(Object entidade) {
		return (T) getAnotacaoDeClasse(entidade, Table.class);
	}

	/**
	 * Retorna a anotação (Annotation) solicitada à classe.
	 * 
	 * @param <T> Tipo da anotação que será retornada.
	 * @param entidade Objeto do qual a anotação será recuperada.
	 * @param anotacao Tipo da anotação que será recuperada.
	 * @return Anotação da classe.
	 */
	@SuppressWarnings("unchecked")
	protected <T extends Annotation> T getAnotacaoDeClasse(Object entidade,
	        Class<T> anotacao) {
		return (T) UtilReflexaoAnnotation.getAnotacaoDaClasse(entidade,
		        anotacao);
	}

	/**
	 * Retorna a anotação (Annotation) do método GET solicitado.
	 * 
	 * @param <T> Tipo da anotação que será retornada.
	 * @param entidade Objeto do qual a anotação será recuperada.
	 * @param propriedade Propriedade usada para recuperar o método GET.
	 * @param anotacao Anotação que será recuperada.
	 * @return Anotação do método.
	 */
	protected <T extends Annotation> T getAnotacaoDeMetodoGet(Object entidade,
	        String propriedade, Class<T> anotacao) {
		T resultado = null;

		if (isReferencia(entidade, anotacao) && !isVazio(propriedade)) {
			Class<?> classe = UtilObjeto.getClasse(entidade);
			Method m = UtilReflexaoMetodo.getMetodoGet(classe, propriedade);
			resultado = m.getAnnotation(anotacao);
		}
		return resultado;
	}

	/**
	 * Retorna o valor que será persistido para a ação solicitada.
	 * 
	 * @param <T> Tipo do objeto que será atribuído à propriedade da entidade de
	 *            auditoria.
	 * @param acao Ação solicitada (Ex: Acao.getInclusao(), Acao.getAlteracao())
	 * @return Objeto que será atribuído à propriedade que indica a ação
	 *         executada.
	 * @see Acao
	 */
	@SuppressWarnings("unchecked")
	protected <T extends Serializable> T getValorDaPropriedadeDeAcao(
	        Integer acao) {
		T resultado = null;

		if (isReferencia(acao)) {
			resultado = (T) getMapaDeAcoes().get(acao);
		}
		return resultado;
	}

	/**
	 * Retorna o mapa de ações. O mapa é composto pela chave da ação (inclusão,
	 * alteração etc...) e o valor que será atribuído à propriedade da Entidade
	 * de auditoria.
	 * 
	 * @return mapa de ações/valores.
	 */
	protected Map<Integer, Object> getMapaDeAcoes() {
		if (!isReferencia(mapaDeAcoes)) {
			mapaDeAcoes = novoMapaDeAcoes();
		}
		return mapaDeAcoes;
	}

	/**
	 * Cria o mapa de ações. O mapa é composto pela chave da ação (inclusão,
	 * alteração etc...) e o valor que será atribuído à propriedade da Entidade
	 * de auditoria.
	 * 
	 * @return mapa de ações.
	 */
	protected Map<Integer, Object> novoMapaDeAcoes() {
		Map<Integer, Object> mapa = ColecaoFactory.getInstancia().novoHashMap();
		mapa.put(Acao.getAlteracao(), Acao.getAlteracao());
		mapa.put(Acao.getConsulta(), Acao.getConsulta());
		mapa.put(Acao.getExclusao(), Acao.getExclusao());
		mapa.put(Acao.getInclusao(), Acao.getInclusao());
		return mapa;
	}

	/**
	 * Retorna true se a auditoria da inclusão está autorizada para a entidade
	 * solicitada.
	 * 
	 * @param entidade Entidade validada.
	 * @return true se a auditoria da inclusão está autorizada para a entidade
	 *         solicitada.
	 */
	protected boolean isAuditarInclusao(Object entidade) {
		return (isReferencia(entidade) && isAcaoDeInclusao());
	}

	/**
	 * Retorna true se a auditoria da alteração está autorizada para a entidade
	 * solicitada.
	 * 
	 * @param entidade Entidade validada.
	 * @return true se a auditoria da alteração está autorizada para a entidade
	 *         solicitada.
	 */
	protected boolean isAuditarAlteracao(Object entidade) {
		return (isReferencia(entidade) && isAcaoDeAlteracao());
	}

	/**
	 * Retorna true se a auditoria da exclusão está autorizada para a entidade
	 * solicitada.
	 * 
	 * @param entidade Entidade validada.
	 * @return true se a auditoria da exclusão está autorizada para a entidade
	 *         solicitada.
	 */
	protected boolean isAuditarExclusao(Object entidade) {
		return (isReferencia(entidade) && isAcaoDeExclusao());
	}

	/**
	 * Retorna true se a auditoria da consulta está autorizada para a entidade
	 * solicitada.
	 * 
	 * @param entidade Entidade validada.
	 * @return true se a auditoria da consulta está autorizada para a entidade
	 *         solicitada.
	 */
	protected boolean isAuditarConsulta(Object entidade) {
		boolean resultado = false;

		if (isReferencia(entidade)) {
			Auditoria anotacao = getAnotacaoDeAuditoria(entidade);
			resultado = (isReferencia(anotacao) && anotacao.consulta() == true);
		}
		return resultado;
	}

}
