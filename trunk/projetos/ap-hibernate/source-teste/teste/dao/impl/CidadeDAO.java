package teste.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;

import teste.dao.ICidadeDAO;
import teste.entidade.Cidade;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;

/**
 * Classe responsável pela persistência da entidade Cidade.
 * 
 * @see teste.entidade.Cidade
 * @author MyEclipse Persistence Tools
 */

public class CidadeDAO extends HibernateCrudDaoAbstrato<Cidade> implements
		ICidadeDAO {

	/**
	 * Remove o objeto da entidade gerenciada por esta classe.
	 * 
	 * @param entidade Objeto da entidade
	 */
	@SuppressWarnings("boxing")
	public void removerFisicamente(Cidade entidade) {
		Query query = getQuery("removerCidade");
		query.setInteger("codigo", entidade.getCodigo());

		executar(query);
	}

	/**
	 * @see ICidadeDAO#restaurar(Cidade)
	 */
	public void restaurar(Cidade entidade) {
		restaurarRemocaoLogica(entidade);
	}

	/**
	 * @see teste.dao.ICidadeDAO#consultar(int)
	 */
	public Collection<Cidade> consultar(int cidadeAte) {
		Criteria criteria = novoCriteria();
		criteria.add(novoCriterioBetween("codigo", new Integer(1),
				new Integer(cidadeAte)));
		criteria.addOrder(novaOrdenacaoASC("nome"));
		
		return consultar(criteria);
	}

	/**
	 * @see teste.dao.ICidadeDAO#consultarPorQuery(int)
	 */
	public Collection<Cidade> consultarPorQuery(int cidadeAte) {
		Query query = novaQuery(
				"from Cidade where codigo between 1 and ? order by nome");
		query.setInteger(0, cidadeAte);

		return consultar(query);
	}

	/**
	 * @see teste.dao.ICidadeDAO#consultarTudoPorQuery()
	 */
	public Collection<Cidade> consultarTudoPorQuery() {
		Query query = novaQuery("from Cidade order by nome");

		return consultar(query);
	}

	/**
	 * @see teste.dao.ICidadeDAO#consultarTudoPorCriteriaOrdenando()
	 */
	public Collection<Cidade> consultarTudoPorCriteriaOrdenando() {
		Criteria criteria = novoCriteria();
		criteria.addOrder(novaOrdenacaoASC("nome"));
		
		return consultar(criteria);
	}
}