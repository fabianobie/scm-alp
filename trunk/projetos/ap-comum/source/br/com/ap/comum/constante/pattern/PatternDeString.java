/*
 * PatternDeString.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.constante.pattern;

/**
 * Patterns de String.
 * 
 * @author adrianop
 */
public final class PatternDeString {

	/**
	 * Construtor.
	 */
	private PatternDeString() {
		// Construtor.
	}

	/**
	 * Retorna a expressão regular que representa todos os caracteres.
	 * 
	 * @return expressão regular que representa todos os caracteres.
	 */
	public static String getPattern() {
		return "[^0-9]";
	}

	/**
	 * Retorna a expressão regular que representa todos os caracteres 
	 * na string como um todo.
	 * 
	 * @return expressão regular que representa todos os caracteres.
	 */
	public static String getStringEmTodosOsCaracteres() {
		return "[^0-9]*";
	}
}
