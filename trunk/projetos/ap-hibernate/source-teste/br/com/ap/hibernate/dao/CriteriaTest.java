/*
 * CriteriaTest.java
 * 
 * Data de criação: Oct 1, 2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.dao;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import teste.dao.IClienteDAO;
import teste.dao.impl.ClienteDAO;
import teste.entidade.Cidade;
import teste.entidade.Cliente;
import br.com.ap.hibernate.TesteAbstrato;

/**
 * JUnit responsável em testar o uso do critéria.
 * 
 * @author AdrianoP
 */
public class CriteriaTest extends TesteAbstrato {

	/**
	 * Test method for teste.dao.IClienteDAO.consultarPelaCidade(Cidade)
	 */
	@SuppressWarnings("boxing")
	@Test
	public void testConsultarClientesPelaCidade() {
		IClienteDAO dao = novaClienteDAO();

		int chamadas = 0;
		while (chamadas < 10) {
			for (int codigo = 1; codigo < 5; codigo++) {
				Cidade cidade = new Cidade();
				cidade.setCodigo(codigo);

				Collection<Cliente> clientes = dao.consultarPelaCidade(cidade);
				System.out.println(codigo + ": " + clientes.size()
						+ " pessoas");
				Iterator<Cliente> iterator = clientes.iterator();
				while (iterator.hasNext()) {
					Cliente c = iterator.next();
					System.out.println("\t"+ c.getNome());
				}
			}
			chamadas++;
		}
	}

	/**
	 * @return ICidadeDAO
	 */
	protected IClienteDAO novaClienteDAO() {
		return novaDAO(ClienteDAO.class);
	}
}
