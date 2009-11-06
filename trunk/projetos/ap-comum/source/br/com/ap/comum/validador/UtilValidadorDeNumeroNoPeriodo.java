/*
 * UtilValidadorDeNumeroNoPeriodo.java
 * 
 * Data de cria��o: 02/10/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

/**
 * Classe utilit�ria respons�vel em verificar se o n�mero informado est� no
 * per�odo.
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
	 * Retorna true se o numero informado for maior que o n�mero menor e maior
	 * que o n�mero maior.
	 * 
	 * @param <T> Tipo do objeto num�rico
	 * @param numero Valor que ser� validado.
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
