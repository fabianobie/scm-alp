package teste.dao.impl;

import teste.dao.IItemDAO;
import teste.entidade.Item;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;

/**
 * Classe respons�vel pela persist�ncia da entidade Item.
 * 
 * @see teste.entidade.Item
 * @author MyEclipse Persistence Tools
 */

public class ItemDAO extends HibernateCrudDaoAbstrato<Item> implements IItemDAO {
	// Classe
}