/*
 * TemporizadorException.java
 * 
 * Data de cria��o: 24/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe que representa uma exce��o lan�ada pelo temporizador.
 * 
 * @author AdrianoP
 */
public class TemporizadorException extends ComumRuntimeException {

	/**
	 * Construtor.
	 */
	public TemporizadorException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exce��o
	 */
	public TemporizadorException(RuntimeExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 */
	public TemporizadorException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 * @param args Par�metros da mensagem
	 */
	public TemporizadorException(String key, String... args) {
		super(key, args);
	}

}
