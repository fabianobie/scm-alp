package teste.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import teste.dao.IProdutoDAO;
import teste.entidade.Produto;

/**
 * Classe responsável pela persistência da entidade Produto.
 * 
 * @see teste.entidade.Produto
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ProdutoDAO extends TesteJSFDaoAbstrato<Produto> implements
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