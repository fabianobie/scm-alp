/*
 * InterceptorAbstrato.java
 * 
 * Data de criação: 31/07/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.interceptor;

import java.util.Arrays;
import java.util.List;

import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.Type;

import br.com.ap.hibernate.holder.HibernateHolder;
import br.com.ap.comum.estrategia.UtilEstrategiaDeFormatadores;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.formatador.instancia.IFormatador;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.reflexao.UtilReflexaoPropriedade;

/**
 * Classe que provê os recursos necessários aos interceptors.
 * 
 * @author adrianop
 */
public abstract class InterceptorAbstrato extends EmptyInterceptor {
	private static ThreadLocal<Session>			session			= new ThreadLocal<Session>();
	private static ThreadLocal<Transaction>		transaction		= new ThreadLocal<Transaction>();
	
	/**
	 * Retorna o session factory do hibernate.
	 * 
	 * @return session factory.
	 */
	protected SessionFactory getSessionFactory() {
		return HibernateHolder.getSessionFactory();
	}

	/**
	 * Retorna o valor da propriedade da entidade do tipo pojo. Se o valor da
	 * propriedade não exisitr no metadata da classe o respectivo valor será
	 * recuperado por reflexão. A reflexão é usada para recuperar o valor dos
	 * atributos que representam chave primária.
	 * 
	 * @param entidade Entidade.
	 * @param propriedade Propriedade.
	 * @return valor da propriedade da entidade do tipo pojo.
	 */
	protected Object getValorDaPropriedadeDoPOJO(Object entidade,
			String propriedade) {
		Object resultado = null;
		ClassMetadata cm = getClassMetadata(entidade);

		if (isReferencia(cm) && !isVazio(propriedade)) {

			String[] arrayPropriedades = cm.getPropertyNames();
			List<String> listaPropriedades = Arrays.asList(arrayPropriedades);
			if (listaPropriedades.contains(propriedade)) {
				EntityMode em = EntityMode.POJO;
				resultado = cm.getPropertyValue(entidade, propriedade, em);
			} else {
				resultado = UtilReflexaoPropriedade.get(entidade, propriedade);
			}
		}

		return resultado;
	}

	/**
	 * Retorna o tipo da propriedade da entidade do tipo pojo.
	 * 
	 * @param entidade Entidade.
	 * @param propriedade Propriedade.
	 * @return tipo da propriedade da entidade do tipo pojo.
	 */
	protected Type getTipoDaPropriedadeDoPOJO(Object entidade,
			String propriedade) {
		Type resultado = null;
		ClassMetadata cm = getClassMetadata(entidade);

		if (isReferencia(cm) && !isVazio(propriedade)) {

			Type tipo = cm.getPropertyType(propriedade);
			if (!isReferencia(tipo)) {
				Class<?> tipoDaPropriedade = UtilReflexaoPropriedade
						.getTipoDaPropriedade(entidade, propriedade);
				tipo = Hibernate.custom(tipoDaPropriedade);
			} else {
				resultado = tipo;
			}
		}

		return resultado;
	}

	/**
	 * Retorna o meta data da entidade passada por parâmetro.
	 * 
	 * @param entidade Entidade.
	 * @return meta data da classe
	 */
	protected ClassMetadata getClassMetadata(Object entidade) {
		ClassMetadata resultado = null;

		if (isReferencia(entidade)) {
			Class<?> classe = UtilObjeto.getClasse(entidade);
			resultado = getSessionFactory().getClassMetadata(classe);
		}
		return resultado;
	}

	/**
	 * Formata o objeto solicitado.
	 * 
	 * @param <T> Tipo do objeto que será formatado.
	 * @param objeto Objeto que será formatado
	 * @param tipo Tipo do objeto que será formatado.
	 * @return objeto formatado.
	 */
	@SuppressWarnings("unchecked")
	protected <T extends Object> String formatar(T objeto, Class<?> tipo) {
		String resultado = getStringFactory().novaString();

		if (isExisteFormatador(tipo)) {
			IFormatador<T> formatador = (IFormatador<T>) getFormatador(tipo);
			resultado = formatador.formatar(objeto);
		}
		return resultado;
	}

	/**
	 * Formata o objeto solicitado.
	 * 
	 * @param <T> Tipo do objeto que será formatado.
	 * @param objeto Objeto que será formatado
	 * @param tipo Tipo do objeto que será formatado.
	 * @return objeto formatado.
	 */
	protected <T extends Object> String formatar(T objeto,
			DiscriminatorType tipo) {
		String resultado = getStringFactory().novaString();

		if (isReferencia(tipo)) {
			Class<?> classeDoTipo = tipo.getReturnedClass();
			resultado = formatar(objeto, classeDoTipo);
		}
		return resultado;
	}

	/**
	 * Retorna true se existir um formatador para o tipo solicitado.
	 * 
	 * @param tipo Tipo de objeto solicitado.
	 * @return true se existir um formatador para o tipo solicitado.
	 */
	protected boolean isExisteFormatador(Class<?> tipo) {
		return getUtilEstrategiaDeFormatadores().isExiste(tipo);
	}

	/**
	 * Retorna o formatador para o tipo solicitado.
	 * 
	 * @param tipo Tipo da classe.
	 * @return formatador para o tipo solicitado.
	 */
	protected IFormatador<?> getFormatador(DiscriminatorType tipo) {
		IFormatador<?> resultado = null;

		if (isReferencia(tipo)) {
			Class<?> classe = tipo.getReturnedClass();
			resultado = getFormatador(classe);
		}

		return resultado;
	}

	/**
	 * Retorna o formatador para o tipo solicitado.
	 * 
	 * @param tipo Tipo da classe.
	 * @return formatador para o tipo solicitado.
	 */
	protected IFormatador<?> getFormatador(Class<?> tipo) {
		IFormatador<?> resultado = null;

		if (isReferencia(tipo)) {
			resultado = getUtilEstrategiaDeFormatadores().recuperar(tipo);
		}
		return resultado;
	}

	/**
	 * @return estratégia de formatadores.
	 */
	protected UtilEstrategiaDeFormatadores getUtilEstrategiaDeFormatadores() {
		return UtilEstrategiaDeFormatadores.getInstancia();
	}

	/**
	 * @return fábrica de número.
	 */
	protected NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * @return fábrica de coleção.
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * @return fábrica de data.
	 */
	protected DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * @return fábrica de string.
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * @param strings Strings que serão verificadas.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazioTodos(String[])
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * @param objetos Objetos que serão validados.
	 * @return true se o objeto tiver referência.
	 * @see UtilObjeto#isReferenciaTodos(Object[])
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}
	
	/**
	 * @return session
	 */
	protected Session getSession() {
		Session sessao = session.get();
		
		if (!isReferencia(sessao) || !sessao.isOpen()) {
			sessao = getSessionFactory().openSession(EmptyInterceptor.INSTANCE);
			sessao.setFlushMode(FlushMode.MANUAL);
			setSession(sessao);
		}
		return session.get();
	}
	
	/**
	 * Atribui sessao do hibernate à threadlocal.
	 * 
	 * @param sessao Sessão
	 */
	protected void setSession(Session sessao) {
		session.set(sessao);
	}

	/**
	 * @return transacao
	 */
	protected Transaction getTransacao() {
		Transaction transacao = transaction.get();
		Session sessao = getSession();
		
		if (!isReferencia(transacao) && isReferencia(sessao)) {
			transacao = sessao.beginTransaction();
			setTransaction(transacao);
		}
		return transaction.get();
	}
	
	/**
	 * Atribui a transação do hibernate à threadlocal.
	 * 
	 * @param transacao Transaction
	 */
	protected void setTransaction(Transaction transacao) {
		transaction.set(transacao);
	}
	
	/**
	 * Fecha a sessão do Hibernate utilizada no log
	 */
	protected void finalizarSessao() {
		Session sessao = getSession();
		if (isReferencia(sessao) && sessao.isOpen()) {
			sessao.close();
			sessao = null;
		}
		setSession(null);
		setTransaction(null);
	}
}
