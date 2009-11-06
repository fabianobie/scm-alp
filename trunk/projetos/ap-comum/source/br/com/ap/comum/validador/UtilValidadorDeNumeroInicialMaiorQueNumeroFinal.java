/*
 * UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.java
 * 
 * Data de cria��o: 01/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

/**
 * Validador de n�mero inicial maior que n�mero final.
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
	 * Retorna true se o n�mero inicial for maior que o n�mero final.
	 * 
	 * @param <T> Tipo de num�rico
	 * @param numeroInicial N�mero inicial.
	 * @param numeroFinal N�mero final.
	 * @return true se o n�mero inicial for maior que o n�mero final.
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
