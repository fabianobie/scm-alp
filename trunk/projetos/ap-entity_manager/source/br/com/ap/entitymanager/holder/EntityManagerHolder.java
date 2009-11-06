/*
 * EntityManagerHolder.java
 * 
 * Data de criação: 01/08/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.holder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.ap.entitymanager.constante.Acao;

/**
 * Classe responsável pelo armazenamento de objetos do hibernate. Os objetos são
 * armazenados em thread.
 * 
 * @author adrianop
 */
public final class EntityManagerHolder {
	private static ThreadLocal<EntityManagerFactory>	entityManagerFactory	= new ThreadLocal<EntityManagerFactory>();
	private static ThreadLocal<EntityManager>			entityManager			= new ThreadLocal<EntityManager>();
	private static ThreadLocal<EntityTransaction>		transacao				= new ThreadLocal<EntityTransaction>();
	private static ThreadLocal<Integer>					acao					= new ThreadLocal<Integer>();

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
	 * @return entityManagerFactory
	 */
	public static EntityManager getEntityManager() {
		return entityManager.get();
	}

	/**
	 * @param entityManager
	 *            Atribui entityManagerFactory.
	 */
	public static void setSession(EntityManager entityManager) {
		EntityManagerHolder.entityManager.set(entityManager);
	}

	/**
	 * @return entityManagerFactory
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory.get();
	}

	/**
	 * @param entityManagerFactory
	 *            Atribui entityManagerFactory.
	 */
	public static void setSessionFactory(
			EntityManagerFactory entityManagerFactory) {
		EntityManagerHolder.entityManagerFactory.set(entityManagerFactory);
	}

	/**
	 * @return transacao
	 */
	public static EntityTransaction getTransacao() {
		return transacao.get();
	}

	/**
	 * @param transacao
	 *            Atribui transacao.
	 */
	public static void setTransacao(EntityTransaction transacao) {
		EntityManagerHolder.transacao.set(transacao);
	}

	/**
	 * @return acao
	 */
	public static Integer getAcao() {
		return acao.get();
	}

	/**
	 * @param acao
	 *            Atribui acao.
	 */
	public static void setAcao(Integer acao) {
		EntityManagerHolder.acao.set(acao);
	}
}
