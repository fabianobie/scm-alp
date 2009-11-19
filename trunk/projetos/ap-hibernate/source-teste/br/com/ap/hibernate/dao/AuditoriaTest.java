/*
 * CrudTest.java
 * 
 * Data de criação: 28/07/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.dao;

import java.util.Date;

import org.junit.Test;

import teste.dao.ICategoriaDAO;
import teste.dao.impl.CategoriaDAO;
import teste.entidade.Categoria;
import br.com.ap.comum.formatador.UtilFormatadorDeData;
import br.com.ap.hibernate.TesteAbstrato;

/**
 * JUnit responsável em testar os métodos básicos da DAO.
 * 
 * @author AdrianoP
 * @see CategoriaDAO
 */
public class AuditoriaTest extends TesteAbstrato {

	/**
	 * Teste do recurso de auditoria.
	 */
	@Test
	public void test() {
		ICategoriaDAO dao = novaCategoriaDAO();
		
		Categoria categoria = novaCategoria();
		Integer codigo = dao.incluir(categoria);
		
		Date date = new Date();
		String dataformatada = UtilFormatadorDeData.formatar_ddMMyyyyEspacohhmmss(
				date);
		Categoria outra = new Categoria();
		outra.setCodigo(codigo);
		Categoria inserido = dao.obter(outra);
		inserido.setDescricao("Descrição "+ dataformatada);
		dao.alterar(inserido);

		dao.excluir(inserido);
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
}
