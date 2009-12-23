/*
 * JBPMDaoAbstrato.java
 * 
 * Data de criação: 25/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbpm.api.cmd.Environment;
import org.jbpm.pvm.internal.env.EnvironmentFactory;

import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.jbpm.factory.DecoratorFactory;

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
}
