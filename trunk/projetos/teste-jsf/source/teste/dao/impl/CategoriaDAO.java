package teste.dao.impl;

import org.springframework.stereotype.Repository;

import teste.dao.ICategoriaDAO;
import teste.entidade.Categoria;

/**
 * Classe respons�vel pela persist�ncia da entidade Categoria.
 * 
 * @see teste.entidade.Categoria
 * @author adrianop
 */
@Repository
public class CategoriaDAO extends TesteJSFDaoAbstrato<Categoria> implements
		ICategoriaDAO {

	/**
	 * @see ICategoriaDAO#getCodigoDoProximoRegistro()
	 */
	public Long getCodigoDoProximoRegistro() {
		return obterProximoIdentificar();
	}
}