/*
 * CrudFacade.java
 * 
 * Data de cria��o: 20/03/2009
 */
package br.com.ap.arquitetura.facade;

import br.com.ap.arquitetura.util.CRUD;
import br.com.ap.comum.javabean.JavaBean;

/**
 * Classe que representa o CRUD. de uma Facade.
 * 
 * @param <T> Tipo do objeto que ser� mantido pelo Crud.
 * @author AdrianoP
 */
public interface CrudFacade<T extends JavaBean> extends Facade, CRUD<T> {
	// Interface
}
