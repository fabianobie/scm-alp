package teste.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;

import teste.dao.IClienteDAO;
import teste.entidade.Cidade;
import teste.entidade.Cliente;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;

/**
 * Classe responsável pela persistência da entidade Cliente.
 * 
 * @see teste.entidade.Cliente
 * @author MyEclipse Persistence Tools
 */

public class ClienteDAO extends HibernateCrudDaoAbstrato<Cliente> implements
		IClienteDAO {

	/**
	 * Remove o objeto da entidade gerenciada por esta classe.
	 * 
	 * @param entidade Objeto da entidade
	 */
	@SuppressWarnings("boxing")
	public void removerFisicamente(Cliente entidade) {
		Query query = getQuery("removerCliente");
		query.setInteger("codigo", entidade.getCodigo());

		executar(query);
	}

	/**
	 * @see IClienteDAO#restaurar(Cliente)
	 */
	public void restaurar(Cliente entidade) {
		restaurarRemocaoLogica(entidade);
	}

	/**
	 * @see teste.dao.IClienteDAO#consultarPelaCidade(teste.entidade.Cidade)
	 */
	public Collection<Cliente> consultarPelaCidade(Cidade cidade) {
		Criteria criteria = novoCriteria();
		criteria.add(novoCriterioEQ("cidade.codigo", cidade.getCodigo()));
		return consultar(criteria);
	}
}