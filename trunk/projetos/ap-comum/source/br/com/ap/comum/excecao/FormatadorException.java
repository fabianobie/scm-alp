/*
 * FormatadorException.java
 * 
 * Data de criação: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe que representa uma exceção ocorrida no processo de formatação.
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
	 * @param excecao Exceção
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
	 * @param args Parâmetros da mensagem
	 */
	public FormatadorException(String key, String... args) {
		super(key, args);
	}
}
