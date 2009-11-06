package teste.dao;

import java.util.Collection;

import teste.entidade.Cidade;
import teste.entidade.Cliente;
import br.com.ap.arquitetura.dao.CrudDao;

/**
 * Interface for ClienteDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IClienteDAO extends CrudDao<Cliente> {

	/**
	 * Remove o objeto da entidade gerenciada por esta classe.
	 * 
	 * @param entidade Objeto da entidade
	 */
	public void removerFisicamente(Cliente entidade);

	/**
	 * @param entidade Entidade
	 */
	public void restaurar(Cliente entidade);

	/**
	 * @param cidade Cidade
	 * @return coleção de clientes.
	 */
	public Collection<Cliente> consultarPelaCidade(Cidade cidade);
}