/*
 * JBPMDaoAbstrato.java
 * 
 * Data de criação: 25/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.util.Collection;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbpm.api.cmd.Environment;
import org.jbpm.pvm.internal.env.EnvironmentFactory;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.jbpm.factory.DecoratorFactory;
import br.com.ap.reflexao.UtilReflexaoPropriedade;

/**
 * DAO abstrata com recursos comuns às DAO`s de acesso ao JBPM.
 * 
 * @author AdrianoP
 */
public abstract class JBPMDaoAbstrato<T extends Object> extends HibernateCrudDaoAbstrato<T> {
	@Resource(name = "processEngine")
	private EnvironmentFactory	environmentFactory;

	/**
	 * @param sessionFactory Atribui o SessionFactory do hibernate
	 */
	@Override
	@Resource(name = "jbpmSessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	protected Session getSession() {
		return novaSession();
	}

	@Override
	protected Session novaSession() {
		Environment environment = environmentFactory.openEnvironment();
		Session session = environment.get(Session.class);
		if (!isReferencia(session)) {
			session = getSessionFactory().openSession();
		}
		return session;
	}

	/**
	 * @return DecoratorFactory
	 */
	protected DecoratorFactory getDecoratorFactory() {
		return DecoratorFactory.getInstancia();
	}
	
	/**
	 * @param <T>
	 * @param colecao
	 * @param atributos
	 */
	protected <E> void invocarGet(Collection<E> colecao,
			String... atributos) {
		
		if (!UtilColecao.isVazio(colecao)) {
			for (E objeto : colecao) {
				for (String atributo : atributos) {
					UtilReflexaoPropriedade.get(objeto, atributo);
				}
			}
		}
	}
	
	/**
	 * Retorna novo criteria para entidade.
	 * @param alias Alias da entidade
	 * @return novo criteria para entidade.
	 */
	protected Criteria novoCriteria(String alias) {
		Class<T> tipo = getTipoDaEntidade();
		return getSession().createCriteria(tipo, alias);
	}
}
