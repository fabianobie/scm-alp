package teste.dao.impl;

import org.springframework.stereotype.Repository;

import teste.dao.ITabelaDAO;
import teste.entidade.Tabela;

/**
 * Classe respons�vel pela persist�ncia da entidade Categoria.
 * 
 * @see teste.entidade.Categoria
 * @author adrianop
 */
@Repository
public class TabelaDAO extends TesteJSFDaoAbstrato<Tabela> implements
		ITabelaDAO {
	// Classe
}