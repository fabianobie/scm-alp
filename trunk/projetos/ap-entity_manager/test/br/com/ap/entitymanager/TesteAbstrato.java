/*
 * TesteAbstrato.java
 * 
 * Data de criação: 21/08/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import junit.framework.TestCase;
import br.com.ap.arquitetura.dao.DAO;
import br.com.ap.entitymanager.dao.EntityManagerDAOAbstrato;

/**
 * @author adrianop
 */
public class TesteAbstrato extends TestCase {
	private static EntityManager	entityManager;

	@Override
	protected void setUp() throws Exception {
		EntityManager em = getEntityManager();
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();
	}

	@Override
	protected void tearDown() throws Exception {
		EntityManager em = getEntityManager();
		em.flush();
		
		EntityTransaction transacao = em.getTransaction();
		transacao.commit();
	}

	@Override
	protected void finalize() throws Throwable {
		getEntityManager().close();
		getEntityManagerFactory().close();

		entityManager = null;
		super.finalize();
	}

	/**
	 * Retorna nova DAO.
	 * 
	 * @param <T>
	 *            Tipo da Entidade da DAO.
	 * @param classe
	 *            Tipo da DAO
	 * @return nova teste.dao
	 */
	@SuppressWarnings("unchecked")
	protected <T extends DAO<?>> T novaDAO(Class<?> classe) {
		T dao = null;
		try {
			dao = (T) classe.newInstance();
			((EntityManagerDAOAbstrato<?>) dao)
					.setEntityManager(getEntityManager());
		} catch (Exception e) {
			assertNull(e);
		}

		return dao;
	}

	/**
	 * @return EntityManager
	 */
	protected static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = novoEntityManager();
		}
		return entityManager;
	}

	/**
	 * @return novo entity manager.
	 */
	protected static EntityManager novoEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}

	/**
	 * @return entity manager factory.
	 */
	protected static EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(getEntityManagerID());
	}

	/**
	 * Retorna o ID do entity manager.
	 * 
	 * @return ID do entity manager.
	 */
	protected static String getEntityManagerID() {
		return "EntityManagerID";
	}
}
