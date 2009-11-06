/*
 * CrudDao.java
 * 
 * Data de criação: 20/03/2009
 */
package br.com.ap.arquitetura.dao;

import br.com.ap.arquitetura.util.CRUD;
import br.com.ap.comum.javabean.JavaBean;

/**
 * Interface que representa um CRUD da DAO.
 * 
 * @author AdrianoP
 * @param <T> Tipo do objeto que será tratado na DAO.
 */
public interface CrudDao<T extends JavaBean> extends DAO<T>, CRUD<T> {
	// interface
}
