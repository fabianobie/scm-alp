/*
 * UtilConversorDeTime.java
 * 
 * Data de cria��o: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.sql.Time;
import java.util.Date;

import br.com.ap.comum.data.UtilData;

/**
 * Convers�o de objetos do tipo time.
 * 
 * @author adrianop
 */
public final class UtilConversorDeTime extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeTime() {
		// Construtor.
	}

	/**
	 * Retorna o date com a data atual e a hora passada por par�metro.
	 * 
	 * @param objeto Objeto time
	 * @return data com a hora passada por par�metro.
	 */
	public static Date converterParaDate(Time objeto) {
		Date res = null;

		if (isReferencia(objeto)) {
			res = getDataFactory().novoDate();
			res = UtilData.ajustarData(res, objeto);
		}
		return res;
	}
}
