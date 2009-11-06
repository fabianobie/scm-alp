/*
 * CriteriaTest.java
 * 
 * Data de cria��o: Oct 1, 2008
 *
 * Desenvolvido por Politec Ltda.
 * F�brica de Software - Bras�lia
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
 * JUnit respons�vel em testar o uso do crit�ria.
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
