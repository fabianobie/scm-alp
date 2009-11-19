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

import org.junit.Test;

import teste.dao.ICategoriaDAO;
import teste.dao.impl.CategoriaDAO;
import teste.entidade.Categoria;
import br.com.ap.hibernate.TesteAbstrato;

/**
 * JUnit responsável em testar os métodos básicos da DAO.
 * 
 * @author AdrianoP
 * @see CategoriaDAO
 */
public class CrudTest extends TesteAbstrato {

	private static Integer codigo = null;

	/**
	 * Test method for teste.dao.ICategoriaDAO.getCodigoDoProximoRegistro()
	 */
	@Test
	public void testGetCodigoDoProximoRegistro() {
		ICategoriaDAO dao = novaCategoriaDAO();
		assertNotNull(dao.getCodigoDoProximoRegistro().intValue());
	}

	/**
	 * Test method for br.com.ap.hibernate.dao.DAO.inserir(T)
	 */
	@Test
	public void testInserir_T() {
		Categoria c = novaCategoria();
		ICategoriaDAO dao = novaCategoriaDAO();
		dao.incluir(null);

		setCodigo((Integer) dao.incluir(c));
		assertNotNull(codigo);
	}

	/**
	 * Test method for br.com.ap.hibernate.dao.DAO.obter(Serializable)
	 */
	@Test
	public void testObter_Serializable() {
		ICategoriaDAO dao = novaCategoriaDAO();

		Categoria categoria = dao.obter(null);
		assertNull(categoria);
		
		categoria = dao.obter(getCodigo());

		assertNotNull(categoria);
		assertNotNull(categoria.getCodigo());
		assertNotNull(categoria.getDescricao());
	}

	/**
	 * Test method for br.com.ap.hibernate.dao.DAO.alterar(T)
	 */
	@Test
	public void testAlterar_T() {
		ICategoriaDAO dao = novaCategoriaDAO();

		dao.alterar(null);

		Categoria c = novaCategoriaIncluida();
		c.setDescricao("Alterado");

		dao.alterar(c);

		c = dao.obter(c);
		assertNotNull(c);
		assertEquals("Alterado", c.getDescricao());
	}

	/**
	 * Test method for br.com.ap.hibernate.dao.DAO.salvar(T)
	 */
	@Test
	public void testSalvar_T() {
		ICategoriaDAO dao = novaCategoriaDAO();
		dao.salvar(null);

		Categoria c = novaCategoria();
		dao.salvar(c);
		assertNotNull(c);
		assertFalse(c.getCodigo() == getCodigo());
	}

	/**
	 * Test method for br.com.ap.hibernate.dao.DAO.consultar()
	 */
	@Test
	public void testConsultar() {
		ICategoriaDAO dao = novaCategoriaDAO();
		Collection<Categoria> r = dao.consultar();

		assertNotNull(r);
		assertTrue(r.size() > 0);
	}

	/**
	 * Test method for br.com.ap.hibernate.dao.DAO.consultar(T)
	 */
	@Test
	public void testConsultar_T() {
		ICategoriaDAO dao = novaCategoriaDAO();

		Collection<Categoria> r = dao.consultar(null);
		assertNotNull(r);

		Categoria c = novaCategoria();
		c.setDescricao("Categoria Teste");

		r = dao.consultar(c);
		assertNotNull(r);
		assertTrue(r.size() > 0);
	}

	/**
	 * Test method for br.com.ap.hibernate.dao.DAO.remover(T)
	 */
	@Test
	public void testRemover_T() {
		ICategoriaDAO dao = novaCategoriaDAO();

		dao.excluir(null);

		Categoria c = novaCategoriaIncluida();
		dao.excluir(c);
	}

	/**
	 * Test method for br.com.ap.hibernate.dao.DAO.removerTodos(T)
	 */
	@Test
	public void testRemoverTodos_Collection() {
		ICategoriaDAO dao = novaCategoriaDAO();

		dao.excluirTodos(null);

		Categoria entidade = novaCategoria();
		Collection<Categoria> r = dao.consultar(entidade);
		dao.excluirTodos(r);

		r = dao.consultar(entidade);
		assertNotNull(r);

		entidade.setDescricao("Alterado");
		r = dao.consultar(entidade);
		dao.excluirTodos(r);
	}

	/**
	 * @return ICategoriaDAO
	 */
	protected ICategoriaDAO novaCategoriaDAO() {
		return novaDAO(CategoriaDAO.class);
	}

	/**
	 * @return nova categoria.
	 */
	protected Categoria novaCategoria() {
		Categoria entidade = new Categoria();
		entidade.setDescricao("Categoria Teste");

		return entidade;
	}

	/**
	 * @return nova categoria incluída.
	 */
	protected Categoria novaCategoriaIncluida() {
		Categoria entidade = new Categoria();
		entidade.setCodigo(getCodigo());

		return entidade;
	}

	/**
	 * @return codigo
	 */
	protected static Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo Atribui codigo.
	 */
	protected static void setCodigo(Integer codigo) {
		CrudTest.codigo = codigo;
	}
}
