package teste.dao.impl;

import org.springframework.stereotype.Repository;

import teste.dao.IItemDAO;
import teste.entidade.Item;

/**
 * Classe respons�vel pela persist�ncia da entidade Item.
 * 
 * @see teste.entidade.Item
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ItemDAO extends TesteJSFDaoAbstrato<Item> implements IItemDAO {
	// Classe
}