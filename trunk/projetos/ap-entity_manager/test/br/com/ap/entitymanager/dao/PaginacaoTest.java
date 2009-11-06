/*
 * PaginacaoTest.java
 * 
 * Data de criação: 29/07/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.dao;

import java.util.Collection;

import org.junit.Test;

import teste.dao.IProdutoDAO;
import teste.dao.impl.ProdutoDAO;
import teste.entidade.Produto;
import br.com.ap.arquitetura.holder.PaginacaoHolder;
import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.entitymanager.TesteAbstrato;

/**
 * JUnit para testes de paginação.
 * 
 * @author AdrianoP
 */
public class PaginacaoTest extends TesteAbstrato {

	/**
	 * Teste de uma paginação simples.
	 */
	@SuppressWarnings("boxing")
	@Test
	public void testPaginacaoSimples() {
		IProdutoDAO dao = novoProdutoDAO();

		// teste 1 = sem paginação
		Collection<Produto> c = dao.consultar();
		assertNotNull(c);
		assertTrue(c.size() > 5);

		// teste 2
		PaginacaoHolder.setNumeroPagina(1);
		PaginacaoHolder.setLimiteRegistro(5);

		c = dao.consultar();
		assertNotNull(c);
		assertTrue(c.size() == 5);
		int total = PaginacaoHolder.getTotalRegistros();
		assertTrue(total > 5);

		// teste 3
		PaginacaoHolder.setNumeroPagina(0);
		PaginacaoHolder.setLimiteRegistro(5);

		c = dao.consultar();
		assertNotNull(c);
		assertTrue(c.size() == 5);
		total = PaginacaoHolder.getTotalRegistros();
		assertTrue(total > 5);

		// teste 4
		PaginacaoHolder.setNumeroPagina(2);
		PaginacaoHolder.setLimiteRegistro(0);
		PaginacaoHolder.setTotalRegistros(0);

		c = dao.consultar();
		assertNotNull(c);
		assertTrue(c.size() > 5);
		total = PaginacaoHolder.getTotalRegistros();
		assertTrue(total == 0);

		// teste 5
		PaginacaoHolder.setNumeroPagina(2);
		PaginacaoHolder.setLimiteRegistro(5);

		c = dao.consultar();
		assertNotNull(c);
		assertTrue(c.size() == 5);
		total = PaginacaoHolder.getTotalRegistros();
		assertTrue(total > 5);
		Produto p = UtilColecao.getElementoDoIndice(c, 0);
		assertTrue(p.getCodigo() == 6);
		
		
	}

	/**
	 * Teste de uma paginação simples.
	 */
	@SuppressWarnings("boxing")
	@Test
	public void testPaginacaoSimplesComHQL() {
		PaginacaoHolder.setNumeroPagina(1);
		PaginacaoHolder.setLimiteRegistro(3);

		IProdutoDAO dao = novoProdutoDAO();

		Collection<Produto> r = dao.consultarLivros();
		assertNotNull(r);
		int total = PaginacaoHolder.getTotalRegistros();
		assertTrue(total > 3);
	}

	/**
	 * @return ProdutoDAO
	 */
	protected IProdutoDAO novoProdutoDAO() {
		return novaDAO(ProdutoDAO.class);
	}
}
