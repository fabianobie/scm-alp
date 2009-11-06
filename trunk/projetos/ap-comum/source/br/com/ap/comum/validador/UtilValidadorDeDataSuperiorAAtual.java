/*
 * UtilValidadorDeDataSuperiorAAtual.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

/**
 * Validador de data superior à data atual.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeDataSuperiorAAtual extends
		UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeDataSuperiorAAtual() {
		// Construtor.
	}

	/**
	 * Retorna true se a data informada for maior que a data atual.
	 * 
	 * @param data Data validada
	 * @return true se a data informada for maior que a data atual.
	 */
	public static boolean validar(Date data) {
		boolean result = false;

		if (isReferencia(data)) {
			Date dataAtual = getDataFactory().novoDate();
			result = isPrimeiroObjetoMaior(data, dataAtual);
		}

		return result;
	}
}
