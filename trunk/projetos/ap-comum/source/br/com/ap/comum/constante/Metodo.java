/*
 * Metodo.java
 * 
 * Data de criação: 24/02/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.constante;

/**
 * Constantes de método.
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
	 * Retorna prefixo do método get.
	 * 
	 * @return get
	 */
	public static String getPrefixoGet() {
		return "get";
	}

	/**
	 * Retorna prefixo do método get dos booleanos.
	 * 
	 * @return is
	 */
	public static String getPrefixoIs() {
		return "is";
	}

	/**
	 * Retorna prefixo do método set.
	 * 
	 * @return set
	 */
	public static String getPrefixoSet() {
		return "set";
	}
}
