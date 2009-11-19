/*
 * CrudTest.java
 * 
 * Data de criação: 28/07/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.dao;

import java.util.Collection;

import teste.dao.IClienteDAO;
import teste.dao.impl.ClienteDAO;
import teste.entidade.Cliente;
import br.com.ap.hibernate.TesteAbstrato;

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
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getIdentificador() +"\t"+ cliente.getNome());
		}
		
		Cliente c = new Cliente();
		c.setCodigo(new Integer(10));
		
		c = dao.obter(c);
		System.out.println(c.getCodigo());
		System.out.println(c.getNome());
	}

	/**
	 * @return IClienteDAO
	 */
	protected IClienteDAO novaClienteDAO() {
		return novaDAO(ClienteDAO.class);
	}
}
