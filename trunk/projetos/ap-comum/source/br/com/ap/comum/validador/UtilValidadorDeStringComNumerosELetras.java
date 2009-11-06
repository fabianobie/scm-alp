/*
 * UtilValidadorDeStringComNumeros.java
 * 
 * Data de cria��o: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.numerico.UtilNumero;
import br.com.ap.comum.string.UtilString;

/**
 * Classe Respons�vel em verificar se uma string possui string(s) e n�mero(s).
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
	 * Retorna true se a string possuir letra e n�mero.
	 * 
	 * @param string String
	 * @return true se a string possuir letra e n�mero.
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
