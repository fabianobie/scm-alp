/*
 * CrudTest.java
 * 
 * Data de cria��o: 28/07/2008
 *
 * 
 * F�brica de Software - Bras�lia
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
