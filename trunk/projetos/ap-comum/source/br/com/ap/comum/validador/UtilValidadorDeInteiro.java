/*
 * UtilValidadorDeInteiro.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.numerico.UtilNumero;

/**
 * Classe responsável em validar se um determinado valor é um integer.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeInteiro extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeInteiro() {
		// Construtor.
	}

	/**
	 * Retorna true se o valor for um inteiro válido.
	 * 
	 * @param numero Valor que será validado.
	 * @return true se o valor for um inteiro válido.
	 */
	public static boolean validar(String numero) {
		return UtilNumero.isInteiro(numero);
	}
}
