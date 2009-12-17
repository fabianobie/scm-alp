/*
 * CrudTest.java
 * 
 * Data de cria��o: 28/07/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import teste.dao.IClienteDAO;
import teste.dao.impl.ClienteDAO;
import br.com.ap.hibernate.TesteAbstrato;

/**
 * @author adriano.pamplona
 */
public class MainTest extends TesteAbstrato {

	/**
	 * Teste
	 */
	public void test() {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("select c.* from Cliente as c");
		List list = query.list();
		System.out.println(list);
	}

	/**
	 * @return IClienteDAO
	 */
	protected IClienteDAO novaClienteDAO() {
		return novaDAO(ClienteDAO.class);
	}
}
