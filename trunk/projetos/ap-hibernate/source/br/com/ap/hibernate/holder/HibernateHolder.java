/*
 * HibernateHolder.java
 * 
 * Data de criação: 01/08/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.holder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.ap.hibernate.constante.Acao;

/**
 * Classe responsável pelo armazenamento de objetos do hibernate. Os objetos são
 * armazenados em thread.
 * 
 * @author adrianop
 */
public final class HibernateHolder {

	private static ThreadLocal<SessionFactory>	sessionFactory	= new ThreadLocal<SessionFactory>();
	private static ThreadLocal<Session>			session			= new ThreadLocal<Session>();
	private static ThreadLocal<Transaction>		transacao		= new ThreadLocal<Transaction>();
	private static ThreadLocal<Integer>			acao			= new ThreadLocal<Integer>();

	/**
	 * Reinicia os atributos variáveis da classe. A página atual e o total de
	 * registros serão reiniciados.
	 */
	public static void reinicializar() {
		setTransacao(null);
		setSession(null);
		setSessionFactory(null);
		setAcao(null);
	}

	/**
	 * Atribui ação de inclusão à classe.
	 */
	public static void setAcaoDeInclusao() {
		setAcao(Acao.getInclusao());
	}

	/**
	 * Atribui ação de alteração à classe.
	 */
	public static void setAcaoDeAlteracao() {
		setAcao(Acao.getAlteracao());
	}

	/**
	 * Atribui ação de exclusão à classe.
	 */
	public static void setAcaoDeExclusao() {
		setAcao(Acao.getExclusao());
	}

	/**
	 * Atribui ação de consulta à classe.
	 */
	public static void setAcaoDeConsulta() {
		setAcao(Acao.getConsulta());
	}

	/**
	 * Remove a ação atual.
	 */
	public static void removerAcao() {
		setAcao(null);
	}

	/**
	 * @return sessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory.get();
	}

	/**
	 * @param sessionFactory Atribui sessionFactory.
	 */
	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateHolder.sessionFactory.set(sessionFactory);
	}

	/**
	 * @return session
	 */
	public static Session getSession() {
		return session.get();
	}

	/**
	 * @param _session Atribui session.
	 */
	public static void setSession(Session _session) {
		HibernateHolder.session.set(_session);
	}

	/**
	 * @return transacao
	 */
	public static Transaction getTransacao() {
		return transacao.get();
	}

	/**
	 * @param transacao Atribui transacao.
	 */
	public static void setTransacao(Transaction transacao) {
		HibernateHolder.transacao.set(transacao);
	}

	/**
	 * @return acao
	 */
	public static Integer getAcao() {
		return acao.get();
	}

	/**
	 * @param acao Atribui acao.
	 */
	public static void setAcao(Integer acao) {
		HibernateHolder.acao.set(acao);
	}
}
