/*
 * ValidadorDeDatasDoMesmoAno.java
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
 * Validador de datas do mesmo ano.
 * 
 * @author AdrianoP
 */
public final class UtilValidadorDeDatasDoMesmoAno extends
		UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeDatasDoMesmoAno() {
		// Construtor.
	}

	/**
	 * Retorna true se as duas datas forem iguais. As datas são obrigatórias.
	 * 
	 * @param data0 Data.
	 * @param data1 Data.
	 * @return true se as duas datas forem iguais.
	 */
	public static boolean validar(Date data0, Date data1) {
		boolean result = false;

		if (isReferencia(data0, data1)) {
			int ano0 = UtilData.getAno(data0);
			int ano1 = UtilData.getAno(data1);
			result = UtilValidadorDeNumerosIguais.validar(ano0, ano1);
		}

		return result;
	}
}
