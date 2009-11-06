/*
 * EntityManagerDAOAbstrato.java
 * 
 * Data de cria��o: 21/08/2008
 *
 * Desenvolvido por Politec Ltda.
 * F�brica de Software - Bras�lia
 */
package br.com.ap.entitymanager.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.arquitetura.dao.DAO;
import br.com.ap.arquitetura.holder.PaginacaoHolder;
import br.com.ap.comum.calculadores.UtilSomadoresDeNumero;
import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.estrategia.UtilEstrategiaDeConversores;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.comum.javabean.entidade.ExclusaoLogica;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.validador.UtilValidadorDeNumerosIguais;
import br.com.ap.entitymanager.holder.EntityManagerHolder;
import br.com.ap.entitymanager.parametrizacao.ParametrizarQuery;
import br.com.ap.entitymanager.util.UtilRecuperarNomeDaColunaID;
import br.com.ap.reflexao.UtilReflexaoGeneric;

/**
 * Classe respons�vel pela persist�ncia usando entity manager.
 * 
 * @author Rafael Veloso
 * @author adrianop
 * @param <T>
 *            Tipo da entidade
 */
public abstract class EntityManagerDAOAbstrato<T extends Entidade> implements
		CrudDao<T> {
	private EntityManager entityManager;

	/**
	 * @return O valor do atributo entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            atribui um valor ao atributo entityManager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * @see DAO#alterar(Entidade)
	 */
	public void alterar(T entidade) {

		if (isReferencia(entidade)) {
			registrarAcaoDeAlteracao();
			getEntityManager().merge(entidade);
			removerAcaoSolicitada();
		}
	}

	/**
	 * @see DAO#consultar()
	 */
	public Collection<T> consultar() {
		String entidade = getNomeDaEntidade();
		Query query = novaQuery("from " + entidade);
		return consultar(query);
	}

	/**
	 * @see DAO#consultar(Entidade)
	 */
	public Collection<T> consultar(T entidade) {
		Collection<T> resultado = null;

		if (isReferencia(entidade)) {
			ParametrizarQuery parametrizar = ParametrizarQuery.novo(
					getEntityManager(), entidade);
			Query query = parametrizar.getQuery();
			resultado = consultar(query);
		}

		return resultado;
	}

	/**
	 * @see DAO#incluir(Entidade)
	 */
	@SuppressWarnings("unchecked")
	public <R extends Serializable> R incluir(T entidade) {
		R resultado = null;

		if (isReferencia(entidade)) {
			registrarAcaoDeInclusao();
			getEntityManager().persist(entidade);
			resultado = (R) entidade.getIdentificador();
			removerAcaoSolicitada();
		}
		return resultado;
	}
	
	/**
	 * @see DAO#obter(Serializable)
	 */
	public T obter(Serializable pk) {
		T resultado = null;
	
		if (isReferencia(pk)) {
			registrarAcaoDeConsulta();
			Class<T> tipo = getTipoDaEntidade();
			resultado = getEntityManager().find(tipo, pk);
			removerAcaoSolicitada();
		}
		return resultado;
	}
	
	/**
	 * Obtem a entidade solicitada.
	 * 
	 * @param entidade
	 * @return entidade
	 */
	public T obter(T entidade) {
		T resultado = null;
	
		if (isReferencia(entidade)) {
			resultado = obter(entidade.getIdentificador());
		}
		return resultado;
	}

	/**
	 * @see DAO#excluir(Entidade)
	 */
	public void excluir(T entidade) {

		if (isReferencia(entidade)) {
			entidade = carregarEntidadePersistente(entidade);

			if (isEntidadeComExclusaoLogica(entidade)) {
				removerLogicamente(entidade);
			} else {
				registrarAcaoDeExclusao();
				getEntityManager().remove(entidade);
				removerAcaoSolicitada();
			}
		}
	}

	/**
	 * @see DAO#excluirTodos(Collection)
	 */
	public void excluirTodos(Collection<T> entidades) {
		if (isReferencia(entidades)) {
			for (T entidade : entidades) {
				remover(entidade);
			}
		}
	}

	/**
	 * @see DAO#salvar(Entidade)
	 */
	public void salvar(T entidade) {
		if (isReferencia(entidade)) {
			if (isReferencia(entidade.getIdentificador())) {
				registrarAcaoDeAlteracao();
			} else {
				registrarAcaoDeInclusao();
			}

			getEntityManager().persist(entidade);
			removerAcaoSolicitada();
		}
	}

	/**
	 * Configura o EntityManager para persistencia.
	 * 
	 * @param entityManager
	 *            EntityManager
	 */
	@Resource(name = "myEntityManager")
	protected void bindEntityManager(EntityManager entityManager) {
		setEntityManager(entityManager);
	}

	/**
	 * Efetua o load da entidade caso esta n�o seja uma entidade persistente.
	 * 
	 * @param entidade
	 *            Entidade que ser� carregada como persistente.
	 * @return Entidade persistente.
	 */
	protected T carregarEntidadePersistente(T entidade) {

		if (isReferencia(entidade) && !isPersistente(entidade)) {
			registrarAcaoDeConsulta();
			Serializable pk = entidade.getIdentificador();
			entidade = obter(pk);
			removerAcaoSolicitada();
		}
		return entidade;
	}

	/**
	 * Configura a pagina��o para a query informada.<br/> As configura��es de
	 * pagina��o s�o definidas no PaginacaoHolder.
	 * 
	 * @param query
	 *            Query de consulta.
	 * @see PaginacaoConsultaHolder
	 */
	@SuppressWarnings("boxing")
	protected void configurarPaginacao(Query query) {
		Integer pagina = PaginacaoHolder.getNumeroPagina();
		Integer regsPag = PaginacaoHolder.getLimiteRegistro();

		if (isReferencia(query) && !isZero(regsPag)) {
			Integer total = getQuantidadeTotalDeRegistros(query);

			if ((total.intValue() > regsPag)) {
				if (pagina == 0)
					pagina = 1;
				int inicio = (pagina * regsPag) - regsPag;
				query.setFirstResult(inicio);
				query.setMaxResults(regsPag);
			}

			PaginacaoHolder.setTotalRegistros(total);
		}
	}

	/**
	 * Efetua a consulta de uma query.
	 * 
	 * @param query
	 *            Query que ser� executada.
	 * @return Cole��o de entidades.
	 */
	@SuppressWarnings("unchecked")
	protected Collection<T> consultar(Query query) {
		registrarAcaoDeConsulta();
		configurarPaginacao(query);
		Collection<T> colecao = query.getResultList();
		removerAcaoSolicitada();
		return colecao;
	}

	/**
	 * Efetua a consulta de um hql.
	 * 
	 * @param hql
	 *            HQL que ser� executado.
	 * @return Cole��o de entidades.
	 */
	protected Collection<T> consultar(String hql) {
		Query query = novaQuery(hql);
		return consultar(query);
	}

	/**
	 * Efetua a consulta de uma query definida nas entidades. A query
	 * identificada pelo ID informado ser� recuperado dos entidades e ser�
	 * executada.
	 * 
	 * @param identificador
	 *            HQL que ser� executado.
	 * @return Cole��o de entidades.
	 */
	protected Collection<T> consultarQueryPeloID(String identificador) {
		Collection<T> resultado = getColecaoFactory().novoArrayList();

		if (!isVazio(identificador)) {
			Query query = getQuery(identificador);
			resultado = consultar(query);
		}
		return resultado;
	}

	/**
	 * Executa um update ou delete na query passada por par�metro.
	 * 
	 * @param query
	 * @return quantidade de registros afetados.
	 */
	protected int executar(Query query) {
		int resultado = 0;

		if (isReferencia(query)) {
			registrarAcaoDeAlteracao();
			resultado = query.executeUpdate();
		}
		return resultado;
	}

	/**
	 * Consulta uma entidade da query passado por par�metro.
	 * 
	 * @param query
	 *            Query que ser� executado.
	 * @return Entidade
	 */
	@SuppressWarnings("unchecked")
	protected T obter(Query query) {
		registrarAcaoDeConsulta();
		T resultado = (T) query.getSingleResult();
		removerAcaoSolicitada();
		return resultado;
	}

	/**
	 * Consulta uma entidade da query passado por par�metro.
	 * 
	 * @param hql
	 *            HQL que ser� executado.
	 * @return Entidade
	 */
	protected T obter(String hql) {
		Query query = novaQuery(hql);
		return obter(query);
	}

	/**
	 * @return f�brica de cole��o.
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna o nome da entidade.
	 * 
	 * @return nome da entidade
	 */
	protected String getNomeDaEntidade() {
		return UtilObjeto.getNomeSemPacote(getTipoDaEntidade());
	}

	/**
	 * @return f�brica de n�mero.
	 */
	protected NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna a quantidade total de registros da consulta.
	 * 
	 * @param query
	 *            Crit�rio da consulta.
	 * @return quantidade total de registros da consulta.
	 */
	@SuppressWarnings("boxing")
	protected Integer getQuantidadeTotalDeRegistros(Query query) {
		Integer resultado = getNumeroFactory().novoInteger(0);
		if (isReferencia(query)) {
			List<?> lista = query.getResultList();
			resultado = UtilColecao.getTamanho(lista);
		}
		return resultado;
	}

	/**
	 * Retorna a quantidade total de registros da consulta.
	 * 
	 * @param hql
	 *            HQL da consulta.
	 * @return quantidade total de registros da consulta.
	 */
	protected Integer getQuantidadeTotalDeRegistros(String hql) {
		Query query = novaQuery(hql);
		return getQuantidadeTotalDeRegistros(query);
	}

	/**
	 * Retorna nova query do Named Query mapeado nas entidades.
	 * 
	 * @param identificador
	 *            Identificador do HQL mapeado nas entidades.
	 * @return nova query.
	 */
	protected Query getQuery(String identificador) {
		return getEntityManager().createNamedQuery(identificador);
	}

	/**
	 * Retorna o tipo da entidade. O tipo � recuperado a partir do generics.
	 * 
	 * @return Classe da entidade.
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getTipoDaEntidade() {
		return (Class<T>) UtilReflexaoGeneric.getClasseDoTipo(this);
	}

	/**
	 * Retorna a estrat�gia de conversores.
	 * 
	 * @return estrat�gia de conversores.
	 */
	protected UtilEstrategiaDeConversores getUtilEstrategiaDeConversores() {
		return UtilEstrategiaDeConversores.getInstancia();
	}

	/**
	 * Retorna true se a entidade possui exclus�o l�gica.
	 * 
	 * @param entidade
	 *            Entidade
	 * @return true se a entidade possui exclus�o l�gica.
	 */
	protected boolean isEntidadeComExclusaoLogica(T entidade) {
		return UtilObjeto.isObjetoDoTipo(entidade, ExclusaoLogica.class);
	}

	/**
	 * Retorna true se a entidade for persistente.
	 * 
	 * @param entidade
	 *            Entidade validada.
	 * @return true se a entidade for persistente.
	 */
	protected boolean isPersistente(T entidade) {
		return getEntityManager().contains(entidade);
	}

	/**
	 * @param objetos
	 *            Objetos que ser�o validados.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferencia(Object)
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * @param strings
	 *            Strings que ser�o validadas.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazio(String)
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * Retorna true se a cole��o estiver vazia.
	 * 
	 * @param colecao
	 *            Cole��o validada
	 * @return true se a cole��o estiver vazia.
	 */
	protected boolean isVazio(Collection<?> colecao) {
		return UtilColecao.isVazio(colecao);
	}

	/**
	 * Retorna true se o valor passado for zero ou nulo.
	 * 
	 * @param valor
	 *            Valor que ser� validado
	 * @return true se o valor passado for zero ou nulo.
	 */
	@SuppressWarnings("boxing")
	protected boolean isZero(Number valor) {
		return !isReferencia(valor)
				|| UtilValidadorDeNumerosIguais.validar(valor, 0);
	}

	/**
	 * Retorna nova query.
	 * 
	 * @param hql
	 *            HQL
	 * @return nova query.
	 */
	protected Query novaQuery(String hql) {
		return getEntityManager().createQuery(hql);
	}

	/**
	 * Retorna o maior identificador da entidade. Ser� feita uma consulta do
	 * tipo 'select max' para obter o maior ID da entidade. � necess�rio que a
	 * entidade possuia um atributo identificador.
	 * 
	 * @param <T>
	 *            Tipo do objeto que ser� retornado. Pode ser Integer ou Long,
	 *            dependendo do tipo da entidade.
	 * @return maior identificador da entidade.
	 */
	@SuppressWarnings("unchecked")
	protected <N extends Number> N obterMaiorIdentificar() {
		N resultado = (N) getNumeroFactory().novoInteger(0);

		Class<?> entidade = getTipoDaEntidade();
		String pk = UtilRecuperarNomeDaColunaID.get(entidade);
		if (!isVazio(pk)) {
			String hql = "select max(" + pk + ") from " + getNomeDaEntidade();
			Query query = novaQuery(hql);
			resultado = (N) query.getSingleResult();
		}
		return resultado;
	}

	/**
	 * Retorna o pr�ximo identificador da entidade. Ser� feita uma consulta do
	 * tipo 'select max + 1' para obter o pr�ximo ID da entidade. � necess�rio
	 * que a entidade possuia um atributo identificador.
	 * 
	 * @return maior identificador da entidade.
	 */
	@SuppressWarnings("boxing")
	protected Long obterProximoIdentificar() {
		return UtilSomadoresDeNumero.somar(obterMaiorIdentificar(), 1);
	}

	/**
	 * Remove a entidade pela chave prim�ria.
	 * 
	 * @param pk
	 *            Chave prim�ria da entidade.
	 */
	protected void remover(Serializable pk) {

		if (isReferencia(pk)) {
			T entidade = obter(pk);
			remover(entidade);
		}
	}

	/**
	 * Remove logicamente uma entidade, ou seja, altera o atributo 'excluido'.
	 * 
	 * @param entidade
	 *            Entidade.
	 */
	@SuppressWarnings("boxing")
	protected void removerLogicamente(T entidade) {
		if (isEntidadeComExclusaoLogica(entidade)) {
			entidade = carregarEntidadePersistente(entidade);
			ExclusaoLogica e = (ExclusaoLogica) entidade;
			e.setExcluido(true);
		}
	}

	/**
	 * Restaura uma entidade com exclus�o l�gica. Ocorrer� a altera��o do
	 * atributo que indica que a entidade est� exclu�da para que seja marcada
	 * como entidade n�o exclu�da.
	 * 
	 * @param entidade
	 *            Entidade
	 */
	@SuppressWarnings("boxing")
	protected void restaurarRemocaoLogica(T entidade) {
		if (isEntidadeComExclusaoLogica(entidade)) {
			carregarEntidadePersistente(entidade);
			ExclusaoLogica e = (ExclusaoLogica) entidade;
			e.setExcluido(false);
		}
	}

	/**
	 * Registra a a��o de altera��o. A a��o � registrada no EntityManagerHolder.
	 * 
	 * @see EntityManagerHolder
	 */
	private void registrarAcaoDeAlteracao() {
		EntityManagerHolder.setAcaoDeAlteracao();
	}

	/**
	 * Registra a a��o de consulta. A a��o � registrada no EntityManagerHolder.
	 * 
	 * @see EntityManagerHolder
	 */
	private void registrarAcaoDeConsulta() {
		EntityManagerHolder.setAcaoDeConsulta();
	}

	/**
	 * Registra a a��o de exclus�o. A a��o � registrada no EntityManagerHolder.
	 * 
	 * @see EntityManagerHolder
	 */
	private void registrarAcaoDeExclusao() {
		EntityManagerHolder.setAcaoDeExclusao();
	}

	/**
	 * Registra a a��o de inclus�o. A a��o � registrada no EntityManagerHolder.
	 * 
	 * @see EntityManagerHolder
	 */
	private void registrarAcaoDeInclusao() {
		EntityManagerHolder.setAcaoDeInclusao();
	}

	/**
	 * Remove o registro de a��o. A a��o � registrada no EntityManagerHolder.
	 * 
	 * @see EntityManagerHolder
	 */
	private void removerAcaoSolicitada() {
		EntityManagerHolder.removerAcao();
	}

}
