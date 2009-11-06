package teste.dao.impl;

import java.util.Collection;

import org.hibernate.Query;

import teste.dao.IProdutoDAO;
import teste.entidade.Produto;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.hibernate.util.SQLQueryNativo;

/**
 * Classe responsável pela persistência da entidade Produto.
 * 
 * @see teste.entidade.Produto
 * @author MyEclipse Persistence Tools
 */

public class ProdutoDAO extends HibernateCrudDaoAbstrato<Produto> implements
		IProdutoDAO {

	/**
	 * @see IProdutoDAO#consultarLivros()
	 */
	public Collection<Produto> consultarLivros() {
		Query q = getQuery("consultarLivros");
		q.setInteger("codigo", 3);

		return consultar(q);
	}

	/**
	 * @see teste.dao.IProdutoDAO#consultarLivrosComSQL()
	 */
	public Collection<Produto> consultarLivrosComSQL() {
		String sql = "select P.* from produto P where P.cod_prd =:codigo";
		SQLQueryNativo query = novoSQLQuery(sql);
		query.setInteger("codigo", new Integer(2));
		query.addEntity("produto", Produto.class);
		//query.setResultSetMapping("produto");
		
		//query.setResultTransformer(Transformers.aliasToBean(Produto.class));
		
		
		//SQLQuery query = novoSQLQuery(sql);
		//query.setInteger("codigo", new Integer(2));
		
		return consultar(query);
	}
	

}