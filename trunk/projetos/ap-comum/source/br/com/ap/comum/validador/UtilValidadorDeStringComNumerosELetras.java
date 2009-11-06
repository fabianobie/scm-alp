/*
 * UtilValidadorDeStringComNumeros.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.numerico.UtilNumero;
import br.com.ap.comum.string.UtilString;

/**
 * Classe Responsável em verificar se uma string possui string(s) e número(s).
 * 
 * @author adrianop
 */
public final class UtilValidadorDeStringComNumerosELetras extends
		UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeStringComNumerosELetras() {
		// Construtor.
	}

	/**
	 * Retorna true se a string possuir letra e número.
	 * 
	 * @param string String
	 * @return true se a string possuir letra e número.
	 */
	public static boolean validar(String string) {
		boolean result = false;

		if (!isVazio(string)) {
			result = !UtilNumero.isInteiro(string)
					&& !UtilString.isSomenteLetras(string);
		}
		return result;
	}
}
