package teste.dao;

import java.util.Collection;

import teste.entidade.Produto;
import br.com.ap.arquitetura.dao.CrudDao;

/**
 * Interface for ProdutoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IProdutoDAO extends CrudDao<Produto> {

	/**
	 * Consulta todos os produtos de categoria livro.
	 * 
	 * @return coleção de livros.
	 */
	public Collection<Produto> consultarLivros();
}