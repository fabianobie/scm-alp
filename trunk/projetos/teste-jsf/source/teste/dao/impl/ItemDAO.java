package teste.dao.impl;

import org.springframework.stereotype.Repository;

import teste.dao.IItemDAO;
import teste.entidade.Item;

/**
 * Classe responsável pela persistência da entidade Item.
 * 
 * @see teste.entidade.Item
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ItemDAO extends TesteJSFDaoAbstrato<Item> implements IItemDAO {
	// Classe
}