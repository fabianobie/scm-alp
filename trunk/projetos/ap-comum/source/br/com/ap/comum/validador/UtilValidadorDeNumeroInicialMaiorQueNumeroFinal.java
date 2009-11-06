/*
 * UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.java
 * 
 * Data de criação: 01/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

/**
 * Validador de número inicial maior que número final.
 * 
 * @author AdrianoP
 */
public final class UtilValidadorDeNumeroInicialMaiorQueNumeroFinal extends
		UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeNumeroInicialMaiorQueNumeroFinal() {
		// Construtor.
	}

	/**
	 * Retorna true se o número inicial for maior que o número final.
	 * 
	 * @param <T> Tipo de numérico
	 * @param numeroInicial Número inicial.
	 * @param numeroFinal Número final.
	 * @return true se o número inicial for maior que o número final.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Number> boolean validar(T numeroInicial,
			T numeroFinal) {
		boolean result = false;

		if (isReferencia(numeroInicial, numeroFinal)
				&& isComparable(numeroInicial, numeroFinal)) {
			result = isPrimeiroObjetoMaior((Comparable) numeroInicial,
					(Comparable) numeroFinal);
		}
		return result;
	}

}
