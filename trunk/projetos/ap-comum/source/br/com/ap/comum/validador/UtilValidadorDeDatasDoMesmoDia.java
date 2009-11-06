/*
 * UtilValidadorDeDatasDoMesmoDia.java
 * 
 * Data de criação: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

import br.com.ap.comum.data.UtilData;

/**
 * Validador de datas do mesmo dia.
 * 
 * @author AdrianoP
 */
public final class UtilValidadorDeDatasDoMesmoDia extends
		UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeDatasDoMesmoDia() {
		// Construtor.
	}

	/**
	 * Retorna true se as duas datas tiverem o mesmo ano. As datas são
	 * obrigatórias.
	 * 
	 * @param data0 Data.
	 * @param data1 Data.
	 * @return true se as duas datas tiverem o mesmo ano.
	 */
	public static boolean validar(Date data0, Date data1) {
		boolean result = false;

		if (isReferencia(data0, data1)) {
			int dia0 = UtilData.getDia(data0);
			int dia1 = UtilData.getDia(data1);
			result = UtilValidadorDeNumerosIguais.validar(dia0, dia1);
		}

		return result;
	}
}
