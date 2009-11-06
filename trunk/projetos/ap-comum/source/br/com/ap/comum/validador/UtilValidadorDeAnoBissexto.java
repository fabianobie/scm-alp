/*
 * UtilValidadorDeAnoBissexto.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Calendar;
import java.util.Date;

/**
 * Validador de ano bissexto.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeAnoBissexto extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeAnoBissexto() {
		// Construtor.
	}

	/**
	 * Retorna true se a data for um ano bissexto.
	 * 
	 * @param data Data que será validada.
	 * @return true se a data for um ano bissexto.
	 */
	public static boolean validar(Date data) {
		boolean result = false;

		if (isReferencia(data)) {
			Calendar calendar = getDataFactory().novoCalendar(data);
			int year = calendar.get(Calendar.YEAR);
			result = ((year % 4) == 0);
		}
		return result;
	}
}
