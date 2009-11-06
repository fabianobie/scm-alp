package teste.dao.impl;

import java.util.Collection;

import javax.persistence.Query;

import teste.dao.IProdutoDAO;
import teste.entidade.Produto;
import br.com.ap.entitymanager.dao.EntityManagerDAOAbstrato;

/**
 * Classe responsável pela persistência da entidade Produto.
 * 
 * @see teste.entidade.Produto
 * @author MyEclipse Persistence Tools
 */

public class ProdutoDAO extends EntityManagerDAOAbstrato<Produto> implements
		IProdutoDAO {

	/**
	 * @see IProdutoDAO#consultarLivros()
	 */
	@SuppressWarnings("boxing")
	public Collection<Produto> consultarLivros() {
		Query q = getQuery("consultarLivros");
		q.setParameter("codigo", 3);

		return consultar(q);
	}
}