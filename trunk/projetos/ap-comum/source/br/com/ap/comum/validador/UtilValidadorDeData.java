/*
 * UtilValidadorDeData.java
 * 
 * Data de criação: 18/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.constante.pattern.PatternDeData;
import br.com.ap.comum.data.UtilData;

/**
 * Validador de data.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeData extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeData() {
		// Construtor.
	}

	/**
	 * Retorna true se a data for válida.
	 * 
	 * @param data Data no formato dd/MM/yyyy.
	 * @return true se a data for válida.
	 */
	public static boolean validar(String data) {
		return isDataValida(data, PatternDeData.getddMMyyyy());
	}

	/**
	 * Retorna true se a data for válida.
	 * 
	 * @param data Data no formato definido no pattern.
	 * @param pattern Pattern da data.
	 * @return true se a data for válida.
	 */
	public static boolean validar(String data, String pattern) {
		return isDataValida(data, pattern);
	}

	/**
	 * Retorna true se a data for válida no formato MM/yyyy.
	 * 
	 * @param data Data no formato MM/yyyy.
	 * @return true se a data for válida.
	 */
	public static boolean validar_MMyyyy(String data) {
		return isDataValida(data, PatternDeData.getMMyyyy());
	}

	/**
	 * Retorna true se a data for válida.
	 * 
	 * @param data Data no formato definido no pattern.
	 * @param pattern Pattern da data.
	 * @return true se a data for válida.
	 */
	private static boolean isDataValida(String data, String pattern) {
		boolean res = false;
		if (!isVazio(data, pattern)) {
			res = (isReferencia(UtilData.parse(data, pattern)));
		}
		return res;
	}
}
