/*
 * JdbcException.java
 * 
 * Data de cria��o: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe que representa uma exce��o lan�ada pela api do JDBC.
 * 
 * @author adrianop
 */
public class JdbcException extends ComumRuntimeException {

	/**
	 * Construtor.
	 */
	public JdbcException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exce��o
	 */
	public JdbcException(RuntimeExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 */
	public JdbcException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 * @param args Par�metros da mensagem
	 */
	public JdbcException(String key, String... args) {
		super(key, args);
	}

}
