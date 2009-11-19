/*
 * UtilValidadorDeHora.java
 * Data: 26/01/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.constante.pattern.PatternDeData;
import br.com.ap.comum.data.UtilData;

/**
 * Validador de horas.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeHora extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeHora() {
		// Construtor.
	}

	/**
	 * Retorna true se a hora for válida.
	 * 
	 * @param hora Hora no formato definido no pattern.
	 * @param pattern Pattern da hora.
	 * @return true se a hora for válida.
	 */
	public static boolean validar(String hora, String pattern) {
		return isHoraValida(hora, pattern);
	}

	/**
	 * Retorna true se a hora for válida.
	 * 
	 * @param hora Hora no formato hh:mm.
	 * @return true se a hora for válida.
	 */
	public static boolean validar(String hora) {
		return isHoraValida(hora, PatternDeData.gethhmm());
	}

	/**
	 * Retorna true se a hora for válida.
	 * 
	 * @param hora Hora no formato HH:mm.
	 * @return true se a hora for válida.
	 */
	public static boolean validar_HHmm(String hora) {
		return isHoraValida(hora, PatternDeData.getHHmm());
	}

	/**
	 * Retorna true se a hora for válida.
	 * 
	 * @param hora Hora no formato HH:mm.
	 * @return true se a hora for válida.
	 */
	public static boolean validar_hhmmss(String hora) {
		return isHoraValida(hora, PatternDeData.gethhmmss());
	}

	/**
	 * Retorna true se a hora for válida.
	 * 
	 * @param hora Hora no formato HH:mm.
	 * @return true se a hora for válida.
	 */
	public static boolean validar_HHmmss(String hora) {
		return isHoraValida(hora, PatternDeData.getHHmmss());
	}

	/**
	 * Retorna true se a hora for válida.
	 * 
	 * @param hora Hora no formato definido no pattern.
	 * @param pattern Pattern da hora.
	 * @return true se a hora for válida.
	 */
	private static boolean isHoraValida(String hora, String pattern) {
		boolean result = false;
		if (!isVazio(hora, pattern)) {
			result = (isReferencia(UtilData.parse(hora, pattern)));
		}
		return result;
	}
}
