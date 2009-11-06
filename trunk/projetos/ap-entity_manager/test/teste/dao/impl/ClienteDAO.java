package teste.dao.impl;

import javax.persistence.Query;

import teste.dao.IClienteDAO;
import teste.entidade.Cliente;
import br.com.ap.entitymanager.dao.EntityManagerDAOAbstrato;

/**
 * Classe responsável pela persistência da entidade Cliente.
 * 
 * @see teste.entidade.Cliente
 * @author MyEclipse Persistence Tools
 */

public class ClienteDAO extends EntityManagerDAOAbstrato<Cliente> implements
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