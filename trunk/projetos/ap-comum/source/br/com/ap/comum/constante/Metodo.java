/*
 * Metodo.java
 * 
 * Data de cria��o: 24/02/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.constante;

/**
 * Constantes de m�todo.
 * 
 * @author AdrianoP
 */
public final class Metodo {

	/**
	 * Construtor.
	 */
	private Metodo() {
		// Construtor.
	}

	/**
	 * Retorna prefixo do m�todo get.
	 * 
	 * @return get
	 */
	public static String getPrefixoGet() {
		return "get";
	}

	/**
	 * Retorna prefixo do m�todo get dos booleanos.
	 * 
	 * @return is
	 */
	public static String getPrefixoIs() {
		return "is";
	}

	/**
	 * Retorna prefixo do m�todo set.
	 * 
	 * @return set
	 */
	public static String getPrefixoSet() {
		return "set";
	}
}
