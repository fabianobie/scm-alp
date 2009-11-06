package teste.dao;

import teste.entidade.Categoria;
import br.com.ap.arquitetura.dao.CrudDao;

/**
 * Interface for CategoriaDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICategoriaDAO extends CrudDao<Categoria> {

	/**
	 * @return identificador do próximo registro.
	 */
	public Long getCodigoDoProximoRegistro();
}