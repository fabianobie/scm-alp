/*
 * TransacaoException.java
 * 
 * Data de criação: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe que representa uma exceção lançada pela transação.
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
	 * @param excecao Exceção
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
	 * @param args Parâmetros da mensagem
	 */
	public TransacaoException(String key, String... args) {
		super(key, args);
	}

}
