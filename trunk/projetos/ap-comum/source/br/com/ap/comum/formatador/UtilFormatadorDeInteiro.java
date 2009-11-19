/*
 * UtilFormatadorDeInteiro.java
 * Data: 26/01/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.formatador;

/**
 * Formatador de inteiro.
 * 
 * @author AdrianoP
 */
public final class UtilFormatadorDeInteiro extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeInteiro() {
		// Construtor.
	}

	/**
	 * Formata um integer.
	 * 
	 * @param integer Integer que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(Integer integer) {
		return formatarNumero(integer);
	}

	/**
	 * Formata um short.
	 * 
	 * @param _short Short que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(Short _short) {
		return formatarNumero(_short);
	}

	/**
	 * Formata um long.
	 * 
	 * @param _long Long que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(Long _long) {
		return formatarNumero(_long);
	}

	/**
	 * Formata um inteiro.
	 * 
	 * @param inteiro Inteiro que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(int inteiro) {
		return formatarNumero(new Integer(inteiro));
	}

	/**
	 * Formata um inteiro.
	 * 
	 * @param inteiro Inteiro que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(short inteiro) {
		return formatarNumero(new Short(inteiro));
	}

	/**
	 * Formata um inteiro.
	 * 
	 * @param inteiro Inteiro que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(long inteiro) {
		return formatarNumero(new Long(inteiro));
	}

}
