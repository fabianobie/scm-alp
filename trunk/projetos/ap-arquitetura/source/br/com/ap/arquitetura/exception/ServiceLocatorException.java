/*
 * ServiceLocatorException.java
 * 
 * Data de criação: 26/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.exception;

import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;

/**
 * Classe que representa uma exceção lançada pelo service locator.
 * 
 * @author adrianop
 */
public class ServiceLocatorException extends ArquiteturaException {
	/**
	 * Construtor.
	 */
	public ServiceLocatorException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao
	 *            Exceção
	 */
	public ServiceLocatorException(RuntimeExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key
	 *            chave
	 */
	public ServiceLocatorException(String key) {
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
	public ServiceLocatorException(String key, String... args) {
		super(key, args);
	}
}
