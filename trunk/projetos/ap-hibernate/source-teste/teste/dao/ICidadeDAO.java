package teste.dao;

import java.util.Collection;

import teste.entidade.Cidade;
import br.com.ap.arquitetura.dao.CrudDao;

/**
 * Interface for CidadeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICidadeDAO extends CrudDao<Cidade> {

	/**
	 * Remove o objeto da entidade gerenciada por esta classe.
	 * 
	 * @param entidade Objeto da entidade
	 */
	public void removerFisicamente(Cidade entidade);

	/**
	 * @param entidade Entidade
	 */
	public void restaurar(Cidade entidade);

	/**
	 * @param cidadeAte CidadeAte
	 * @return cole��o
	 */
	public Collection<Cidade> consultar(int cidadeAte);

	/**
	 * @param cidadeAte CidadeAte
	 * @return cole��o
	 */
	public Collection<Cidade> consultarPorQuery(int cidadeAte);

	/**
	 * @return cole��o
	 */
	public Collection<Cidade> consultarTudoPorQuery();

	/**
	 * @return cole��o
	 */
	public Collection<Cidade> consultarTudoPorCriteriaOrdenando();

}