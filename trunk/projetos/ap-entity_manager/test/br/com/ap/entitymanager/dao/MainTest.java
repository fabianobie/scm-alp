/*
 * CrudTest.java
 * 
 * Data de criação: 28/07/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.dao;

import java.util.Collection;

import teste.dao.IClienteDAO;
import teste.dao.impl.ClienteDAO;
import teste.entidade.Cliente;
import br.com.ap.entitymanager.TesteAbstrato;

/**
 * @author adriano.pamplona
 */
public class MainTest extends TesteAbstrato {

	/**
	 * Teste
	 */
	public void test() {
		IClienteDAO dao = novaClienteDAO();
		Collection<Cliente> clientes = dao.consultar();
		assertNotNull(clientes);
		assertTrue(clientes.size() > 0);
	}
	
	/**
	 * @return IClienteDAO
	 */
	protected IClienteDAO novaClienteDAO() {
		return novaDAO(ClienteDAO.class);
	}
}
