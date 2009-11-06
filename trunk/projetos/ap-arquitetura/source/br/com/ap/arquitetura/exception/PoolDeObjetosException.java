/*
 * PoolDeObjetosException.java
 * 
 * Data de cria��o: 03/07/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.exception;

import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;

/**
 * Classe que representa uma exce��o lan�ada pelo pool de objetos.
 * 
 * @author adrianop
 */
public class PoolDeObjetosException extends ArquiteturaException {

	/**
	 * Construtor.
	 */
	public PoolDeObjetosException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao
	 *            Exce��o
	 */
	public PoolDeObjetosException(RuntimeExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key
	 *            chave
	 */
	public PoolDeObjetosException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key
	 *            chave
	 * @param args
	 *            argumentos
	 */
	public PoolDeObjetosException(String key, String... args) {
		super(key, args);
	}
}
