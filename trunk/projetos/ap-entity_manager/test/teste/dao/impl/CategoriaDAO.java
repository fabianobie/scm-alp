package teste.dao.impl;

import teste.dao.ICategoriaDAO;
import teste.entidade.Categoria;
import br.com.ap.entitymanager.dao.EntityManagerDAOAbstrato;

/**
 * Classe responsável pela persistência da entidade Categoria.
 * 
 * @see teste.entidade.Categoria
 * @author adrianop
 */

public class CategoriaDAO extends EntityManagerDAOAbstrato<Categoria> implements
		ICategoriaDAO {

	/**
	 * @see ICategoriaDAO#getCodigoDoProximoRegistro()
	 */
	public Long getCodigoDoProximoRegistro() {
		return obterProximoIdentificador();
	}
}