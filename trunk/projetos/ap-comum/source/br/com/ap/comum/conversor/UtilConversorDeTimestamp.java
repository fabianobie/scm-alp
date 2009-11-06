/*
 * UtilConversorDeTimestamp.java
 * 
 * Data de criação: 18/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Conversor de objetos do tipo Timestamp.
 * 
 * @author adrianop
 */
public final class UtilConversorDeTimestamp extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeTimestamp() {
		// Construtor
	}

	/**
	 * Retorna o time do timestamp.
	 * 
	 * @param timestamp Timestamp
	 * @return time do timestamp.
	 */
	public static Time converterParaTime(Timestamp timestamp) {
		Time res = null;

		if (isReferencia(timestamp)) {
			res = getDataFactory().novoTime(timestamp.getTime());
		}
		return res;
	}

	/**
	 * Retorna o date do timestamp.
	 * 
	 * @param timestamp Timestamp
	 * @return date do timestamp.
	 */
	public static Date converterParaDate(Timestamp timestamp) {
		Date res = null;

		if (isReferencia(timestamp)) {
			res = getDataFactory().novoDate(timestamp.getTime());
		}
		return res;
	}
}
