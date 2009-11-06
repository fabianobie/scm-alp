/*
 * UtilValidadorDeDataInferiorAAtual.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

/**
 * Validador de data inferior à data atual.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeDataInferiorAAtual extends
		UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeDataInferiorAAtual() {
		// Construtor.
	}

	/**
	 * Retorna true se a data informada for menor que a data atual.
	 * 
	 * @param data Data validada
	 * @return true se a data informada for menor que a data atual.
	 */
	public static boolean validar(Date data) {
		boolean result = false;

		if (isReferencia(data)) {
			Date dataAtual = getDataFactory().novoDate();
			result = isPrimeiroObjetoMaior(dataAtual, data);
		}

		return result;
	}
}
