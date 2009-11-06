/*
 * ConversorException.java
 * 
 * Data de cria��o: 24/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe que representa uma exce��o ocorrida no processo de convers�o.
 * 
 * @author AdrianoP
 */
public class ConversorException extends ComumException {

	/**
	 * Construtor.
	 */
	public ConversorException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exce��o
	 */
	public ConversorException(ExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 */
	public ConversorException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 * @param args Par�metros da mensagem
	 */
	public ConversorException(String key, String... args) {
		super(key, args);
	}
}
