/*
 * UtilConversorDeData.java
 * 
 * Data de criação: 12/11/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Conversor de objetos do tipo date.
 * 
 * @author adrianop
 */
public final class UtilConversorDeData extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeData() {
		// Construtor
	}

	/**
	 * Converte um java.sql.Date em um java.util.Date.
	 * 
	 * @param sqlDate java.sql.Date que será convertido.
	 * @return java.util.Date
	 */
	public static Date converterParaUtilDate(java.sql.Date sqlDate) {
		Date res = null;

		if (isReferencia(sqlDate)) {
			res = getDataFactory().novoDate(sqlDate.getTime());
		}
		return res;
	}

	/**
	 * Converte um java.util.Date em um java.sql.Date.
	 * 
	 * @param date java.util.Date que será convertido.
	 * @return java.sql.Date
	 */
	public static java.sql.Date converterParaSqlDate(Date date) {
		java.sql.Date res = null;

		if (isReferencia(date)) {
			res = getDataFactory().novoSqlDate(date.getTime());
		}
		return res;
	}

	/**
	 * Converter um date em um timestamp.
	 * 
	 * @param data Objeto do tipo date.
	 * @return Timestamp.
	 */
	public static Timestamp converterParaTimestamp(Date data) {
		Timestamp res = null;

		if (isReferencia(data)) {
			res = getDataFactory().novoTimestamp(data.getTime());
		}
		return res;
	}

	/**
	 * Converte um date para Time
	 * 
	 * @param data Data.
	 * @return Time.
	 */
	public static Time converterParaTime(Date data) {
		Time res = null;

		if (isReferencia(data)) {
			res = getDataFactory().novoTime(data.getTime());
		}
		return res;
	}
}
