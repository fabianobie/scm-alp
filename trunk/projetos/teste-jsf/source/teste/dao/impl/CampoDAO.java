package teste.dao.impl;

import org.springframework.stereotype.Repository;

import teste.dao.ICampoDAO;
import teste.entidade.Campo;

/**
 * Classe responsável pela persistência da entidade Categoria.
 * 
 * @see teste.entidade.Categoria
 * @author adrianop
 */
@Repository
public class CampoDAO extends TesteJSFDaoAbstrato<Campo> implements ICampoDAO {
	// Classe
}