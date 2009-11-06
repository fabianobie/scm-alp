/*
 * ConversorException.java
 * 
 * Data de criação: 24/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

/**
 * Classe que representa uma exceção ocorrida no processo de conversão.
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
	 * @param excecao Exceção
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
	 * @param args Parâmetros da mensagem
	 */
	public ConversorException(String key, String... args) {
		super(key, args);
	}
}
