/*
 * UtilConversorDeTime.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.sql.Time;
import java.util.Date;

import br.com.ap.comum.data.UtilData;

/**
 * Conversão de objetos do tipo time.
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
	 * Retorna o date com a data atual e a hora passada por parâmetro.
	 * 
	 * @param objeto Objeto time
	 * @return data com a hora passada por parâmetro.
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
