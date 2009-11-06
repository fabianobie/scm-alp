/*
 * UtilValidadorDeInteiro.java
 * 
 * Data de cria��o: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.numerico.UtilNumero;

/**
 * Classe respons�vel em validar se um determinado valor � um integer.
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
	 * Retorna true se o valor for um inteiro v�lido.
	 * 
	 * @param numero Valor que ser� validado.
	 * @return true se o valor for um inteiro v�lido.
	 */
	public static boolean validar(String numero) {
		return UtilNumero.isInteiro(numero);
	}
}
