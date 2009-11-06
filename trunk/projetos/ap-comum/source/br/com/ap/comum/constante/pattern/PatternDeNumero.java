/*
 * PatternDeNumero.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.constante.pattern;

/**
 * Patterns de número.
 * 
 * @author adrianop
 */
public final class PatternDeNumero {

	/**
	 * Construtor.
	 */
	private PatternDeNumero() {
		// Construtor.
	}

	/**
	 * Retorna o pattern para inteiro.
	 * 
	 * @return [0-9]*
	 */
	public static String getInteger() {
		return "[0-9]*";
	}

	/**
	 * Retorna o pattern para real.
	 * 
	 * @return [-+]?[0-9]*[\\,]?[0-9]*
	 */
	public static String getReal() {
		return "[-+]?[0-9]*[\\,]?[0-9]*";
	}
}
