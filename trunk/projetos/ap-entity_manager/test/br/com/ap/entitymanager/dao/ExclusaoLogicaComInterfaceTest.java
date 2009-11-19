/*
 * ExclusaoLogicaComAnotacaoTest.java
 * 
 * Data de criação: 28/07/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.dao;

import org.junit.Test;

import teste.dao.IClienteDAO;
import teste.dao.impl.ClienteDAO;
import teste.entidade.Cidade;
import teste.entidade.Cliente;
import br.com.ap.entitymanager.TesteAbstrato;

/**
 * JUnit responsável em testar a exclusão lógica.
 * 
 * @author AdrianoP
 */
@SuppressWarnings("boxing")
public class ExclusaoLogicaComInterfaceTest extends TesteAbstrato {
	private static Integer	codigo	= null;

	/**
	 * Test method for br.jus.stj.alp01.hibernate.dao.DAO.inserir(T)
	 */
	@Test
	public void testInserir() {
		Cidade cidade = new Cidade();
		cidade.setCodigo(1);

		Cliente entidade = new Cliente();
		entidade.setCodigo(12);
		entidade.setCidade(cidade);
		entidade.setExcluido(false);
		entidade.setNome("Fulano de Tal");

		teste.dao.IClienteDAO dao = novaClienteDAO();
		Integer pk = (Integer) dao.incluir(entidade);
		setCodigo(pk);
	}

	/**
	 * Test method for br.jus.stj.alp01.hibernate.dao.DAO.remover(T)
	 */
	@Test
	public void testRemover() {
		Cliente entidade = new Cliente();
		entidade.setCodigo(getCodigo());

		IClienteDAO dao = novaClienteDAO();
		dao.excluir(entidade);

		entidade = dao.obter(entidade.getIdentificador());
		Boolean b = entidade.getExcluido();
		assertTrue(b);
	}

	/**
	 * Test method for teste.dao.ICidadeDAO.restaurar(T)
	 */
	@Test
	public void testRestaurar() {
		Cliente entidade = new Cliente();
		entidade.setCodigo(getCodigo());

		IClienteDAO dao = novaClienteDAO();
		entidade = dao.obter(entidade.getIdentificador());
		assertTrue(entidade.getExcluido());

		dao.restaurar(entidade);
		entidade = dao.obter(entidade.getIdentificador());
		assertFalse(entidade.getExcluido());
	}

	/**
	 * Test method for teste.dao.ICidadeDAO.removerFisicamente(T)
	 */
	@Test
	public void testRemoverFisicamente() {
		Cliente entidade = new Cliente();
		entidade.setCodigo(getCodigo());

		IClienteDAO dao = novaClienteDAO();
		dao.removerFisicamente(entidade);
	}

	/**
	 * @return ICidadeDAO
	 */
	protected IClienteDAO novaClienteDAO() {
		return novaDAO(ClienteDAO.class);
	}

	/**
	 * @return codigo
	 */
	protected static Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            Atribui codigo.
	 */
	protected static void setCodigo(Integer codigo) {
		ExclusaoLogicaComInterfaceTest.codigo = codigo;
	}
}
