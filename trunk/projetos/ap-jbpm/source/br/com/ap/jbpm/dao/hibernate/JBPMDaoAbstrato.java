/*
 * JBPMDaoAbstrato.java
 * 
 * Data de criação: 25/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.jbpm.factory.DecoratorFactory;

/**
 * DAO abstrata com recursos comuns às DAO`s de acesso ao JBPM.
 * 
 * @author AdrianoP
 */
public abstract class JBPMDaoAbstrato<T extends Object> extends HibernateCrudDaoAbstrato<T> {
	
	/**
	 * @param sessionFactory
	 *            Atribui o SessionFactory do hibernate
	 */
	@Override
	@Resource(name = "jbpmSessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * @return DecoratorFactory
	 */
	protected DecoratorFactory getDecoratorFactory() {
		return DecoratorFactory.getInstancia();
	}
}
