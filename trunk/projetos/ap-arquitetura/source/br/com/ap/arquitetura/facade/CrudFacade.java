/*
 * CrudFacade.java
 * 
 * Data de criação: 20/03/2009
 */
package br.com.ap.arquitetura.facade;

import br.com.ap.arquitetura.util.CRUD;

/**
 * Classe que representa o CRUD. de uma Facade.
 * 
 * @param <T> Tipo do objeto que será mantido pelo Crud.
 * @author AdrianoP
 */
public interface CrudFacade<T extends Object> extends Facade, CRUD<T> {
	// Interface
}
