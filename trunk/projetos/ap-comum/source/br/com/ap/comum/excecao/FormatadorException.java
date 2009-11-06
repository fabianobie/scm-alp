/*
 * FormatadorException.java
 * 
 * Data de cria��o: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe que representa uma exce��o ocorrida no processo de formata��o.
 * 
 * @author AdrianoP
 */
public class FormatadorException extends ComumException {

	/**
	 * Construtor.
	 */
	public FormatadorException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exce��o
	 */
	public FormatadorException(ExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 */
	public FormatadorException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 * @param args Par�metros da mensagem
	 */
	public FormatadorException(String key, String... args) {
		super(key, args);
	}
}
