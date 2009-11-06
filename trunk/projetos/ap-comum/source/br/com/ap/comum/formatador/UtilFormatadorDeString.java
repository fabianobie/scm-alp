/*
 * UtilFormatadorDeString.java
 * 
 * Data de cria��o: 23/04/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.formatador;

import br.com.ap.comum.string.UtilString;

/**
 * Formatador de string.
 * 
 * @author AdrianoP
 */
public final class UtilFormatadorDeString extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeString() {
		// Construtor.
	}

	/**
	 * Remove os espa�os de uma String.
	 * 
	 * @param string String que ser� formatada.
	 * @return String formatada.
	 */
	public static String formatarSemEspacos(String string) {
		if (!isVazio(string)) {
			string = string.trim();
		}
		return string;
	}

	/**
	 * Retorna a string do objeto passado por par�metro.
	 * 
	 * @param valor Objeto
	 * @return string do objeto passado por par�metro.
	 */
	public static String formatar(Object valor) {
		return UtilString.getString(valor);
	}
}
