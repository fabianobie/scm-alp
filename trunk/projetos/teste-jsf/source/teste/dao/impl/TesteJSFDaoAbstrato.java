/*
 * TesteJSFDaoAbstrato.java
 * 
 * Data de criação: 16/10/2009
 */
package teste.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;

/**
 * @author adriano.pamplona
 * 
 */
@Repository
public abstract class TesteJSFDaoAbstrato<T extends Entidade> extends
		HibernateCrudDaoAbstrato<T> {

	@Override
	@Resource (name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
