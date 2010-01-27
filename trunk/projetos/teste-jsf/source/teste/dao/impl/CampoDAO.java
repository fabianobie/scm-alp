package teste.dao.impl;

import org.springframework.stereotype.Repository;

import teste.dao.ICampoDAO;
import teste.entidade.Campo;

/**
 * Classe respons�vel pela persist�ncia da entidade Categoria.
 * 
 * @see teste.entidade.Categoria
 * @author adrianop
 */
@Repository
public class CampoDAO extends TesteJSFDaoAbstrato<Campo> implements ICampoDAO {
	// Classe
}