/*
 * PaginacaoTest.java
 * 
 * Data de criação: 29/07/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.dao;

import java.util.Collection;

import org.junit.Test;

import teste.dao.ICidadeDAO;
import teste.dao.IProdutoDAO;
import teste.dao.impl.CidadeDAO;
import teste.dao.impl.ProdutoDAO;
import teste.entidade.Cidade;
import teste.entidade.Produto;
import br.com.ap.arquitetura.holder.PaginacaoHolder;
import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.hibernate.TesteAbstrato;

/**
 * JUnit para testes de paginação.
 * 
 * @author AdrianoP
 */
public class PaginacaoTest extends TesteAbstrato {

	/**
	 * @throws Exception exceção
	 */
	public void _testCarga() throws Exception {
		ICidadeDAO dao = novaCidadeDAO();
		for (int indice = 6; indice < 80000; indice++) {
			Cidade c = new Cidade();
			c.setNome("Cidade " + indice);
			c.setExcluido(Boolean.FALSE);

			System.out.println(indice);
			dao.incluir(c);
		}
	}

	/**
	 * @throws Exception exceção
	 */
	@SuppressWarnings("boxing")
	public void _testPerformance() throws Exception {
		ICidadeDAO dao = novaCidadeDAO();

		PaginacaoHolder.setNumeroPagina(1);
		PaginacaoHolder.setLimiteRegistro(10);

		long inicio = System.currentTimeMillis();
		// Collection<Cidade> cidades = dao.consultar();
		Collection<Cidade> cidades = dao.consultarTudoPorCriteriaOrdenando();
		// Collection<Cidade> cidades = dao.consultarTudoPorQuery();
		// Collection<Cidade> cidades = dao.consultarPorQuery(102134);
		System.out.println("Total de registros da página.: " + cidades.size());
		System.out.println("Total de registros...........: "
		        + PaginacaoHolder.getTotalRegistros());
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de execução............: "
		        + ((fim - inicio) / 10) + " centésimos");
	}

	/**
	 * Teste de uma paginação simples.
	 */
	@SuppressWarnings("boxing")
	@Test
	public void _testPaginacaoSimplesComSQLQuery() {
		PaginacaoHolder.setNumeroPagina(1);
		PaginacaoHolder.setLimiteRegistro(5);

		IProdutoDAO dao = novoProdutoDAO();
		Collection<Produto> c = dao.consultarLivrosComSQL();
		assertNotNull(c);
	}

	/**
	 * Teste de uma paginação simples.
	 */
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
	public void _testPaginacaoSimplesComHQL() {
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

	/**
	 * @return CidadeDAO
	 */
	protected ICidadeDAO novaCidadeDAO() {
		return novaDAO(CidadeDAO.class);
	}
}
