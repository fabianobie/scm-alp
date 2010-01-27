package teste.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import teste.dao.IClienteDAO;
import teste.entidade.Cliente;

/**
 * Classe responsável pela persistência da entidade Cliente.
 * 
 * @see teste.entidade.Cliente
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ClienteDAO extends TesteJSFDaoAbstrato<Cliente> implements
		IClienteDAO {

	/**
	 * Remove o objeto da entidade gerenciada por esta classe.
	 * 
	 * @param entidade
	 *            Objeto da entidade
	 */
	public void removerFisicamente(Cliente entidade) {
		Query query = getQuery("removerCliente");
		query.setParameter("codigo", entidade.getCodigo());

		executar(query);
	}

	/**
	 * @see IClienteDAO#restaurar(Cliente)
	 */
	public void restaurar(Cliente entidade) {
		restaurarRemocaoLogica(entidade);
	}
}