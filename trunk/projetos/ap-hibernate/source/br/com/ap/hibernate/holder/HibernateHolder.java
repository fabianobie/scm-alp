/*
 * HibernateHolder.java
 * 
 * Data de cria��o: 01/08/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.holder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.ap.hibernate.constante.Acao;

/**
 * Classe respons�vel pelo armazenamento de objetos do hibernate. Os objetos s�o
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
	 * Reinicia os atributos vari�veis da classe. A p�gina atual e o total de
	 * registros ser�o reiniciados.
	 */
	public static void reinicializar() {
		setTransacao(null);
		setSession(null);
		setSessionFactory(null);
		setAcao(null);
	}

	/**
	 * Atribui a��o de inclus�o � classe.
	 */
	public static void setAcaoDeInclusao() {
		setAcao(Acao.getInclusao());
	}

	/**
	 * Atribui a��o de altera��o � classe.
	 */
	public static void setAcaoDeAlteracao() {
		setAcao(Acao.getAlteracao());
	}

	/**
	 * Atribui a��o de exclus�o � classe.
	 */
	public static void setAcaoDeExclusao() {
		setAcao(Acao.getExclusao());
	}

	/**
	 * Atribui a��o de consulta � classe.
	 */
	public static void setAcaoDeConsulta() {
		setAcao(Acao.getConsulta());
	}

	/**
	 * Remove a a��o atual.
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
