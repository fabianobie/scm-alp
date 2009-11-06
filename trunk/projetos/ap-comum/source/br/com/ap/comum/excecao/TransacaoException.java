/*
 * TransacaoException.java
 * 
 * Data de cria��o: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe que representa uma exce��o lan�ada pela transa��o.
 * 
 * @author adrianop
 */
public class TransacaoException extends ComumRuntimeException {

	/**
	 * Construtor.
	 */
	public TransacaoException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exce��o
	 */
	public TransacaoException(RuntimeExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 */
	public TransacaoException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 * @param args Par�metros da mensagem
	 */
	public TransacaoException(String key, String... args) {
		super(key, args);
	}

}
