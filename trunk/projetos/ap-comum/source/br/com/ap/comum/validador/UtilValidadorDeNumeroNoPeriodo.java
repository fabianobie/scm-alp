/*
 * UtilValidadorDeNumeroNoPeriodo.java
 * 
 * Data de criação: 02/10/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

/**
 * Classe utilitária responsável em verificar se o número informado está no
 * período.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeNumeroNoPeriodo extends
		UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeNumeroNoPeriodo() {
		// Construtor.
	}

	/**
	 * Retorna true se o numero informado for maior que o número menor e maior
	 * que o número maior.
	 * 
	 * @param <T> Tipo do objeto numérico
	 * @param numero Valor que será validado.
	 * @param menor Menor valor.
	 * @param maior Maior valor.
	 * @return booleano
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Number> boolean validar(T numero, T menor, T maior) {
		boolean result = false;

		if (isReferencia(numero, menor, maior)
				&& isComparable(numero, menor, maior)) {
			result = isPrimeiroObjetoMaiorOuIgual((Comparable) numero,
					(Comparable) menor)
					&& isPrimeiroObjetoMaiorOuIgual((Comparable) maior,
							(Comparable) numero);
		}
		return result;
	}
}
