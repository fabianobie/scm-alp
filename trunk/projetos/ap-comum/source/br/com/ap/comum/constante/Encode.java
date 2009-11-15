/*
 * Encode.java
 * 
 * Data de criação: 15/11/2009
 */
package br.com.ap.comum.constante;

/**
 * Classe de constantes dos encodes.
 * 
 * @author AdrianoP
 */
public final class Encode {

	private Encode() {
		// Construtor
	}
	
	/**
	 * @return ISO-8859-1
	 */
	public static String getISO8859_1() {
		return "ISO-8859-1";
	}

	/**
	 * @return UTF-8
	 */
	public static String getUTF8() {
		return "UTF-8";
	}
}
