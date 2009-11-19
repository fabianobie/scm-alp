/*
 * UtilFormatadorDeData.java
 * Data: 26/01/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.formatador;

import java.util.Date;

import br.com.ap.comum.constante.pattern.PatternDeData;

/**
 * Formatador de Data.
 * 
 * @author AdrianoP
 */
public final class UtilFormatadorDeData extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeData() {
		// Construtor.
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @param pattern Pattern que será usado para a formatação.
	 * @return String formatada.
	 */
	public static String formatar(Date data, String pattern) {
		return formatarData(data, pattern);
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_ddMMyyyy(Date data) {
		return formatarData(data, PatternDeData.getddMMyyyy());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_ddHifenMMHifenyyyy(Date data) {
		return formatarData(data, PatternDeData.getddHifenMMHifenyyyy());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_ddMMyyyyEspacoHHmm(Date data) {
		return formatarData(data, PatternDeData.getddMMyyyyEspacoHHmm());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_ddMMyyyyEspacohhmm(Date data) {
		return formatarData(data, PatternDeData.getddMMyyyyEspacohhmm());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_ddMMyyyyEspacoHHmmss(Date data) {
		return formatarData(data, PatternDeData.getddMMyyyyEspacoHHmmss());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_ddMMyyyyEspacohhmmss(Date data) {
		return formatarData(data, PatternDeData.getddMMyyyyEspacohhmmss());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_hhmm(Date data) {
		return formatarData(data, PatternDeData.gethhmm());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_hhmmss(Date data) {
		return formatarData(data, PatternDeData.gethhmmss());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_HHmm(Date data) {
		return formatarData(data, PatternDeData.getHHmm());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_HHmmss(Date data) {
		return formatarData(data, PatternDeData.getHHmmss());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_MMMyyyy(Date data) {
		return formatarData(data, PatternDeData.getMMMyyyy());
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_MMyyyy(Date data) {
		return formatarData(data, PatternDeData.getMMyyyy());
	}

	/**
	 * Formata o date no formato DB2.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_padraoDB2(Date data) {
		return formatarData(data, PatternDeData.getPadraoDB2());
	}

	/**
	 * Formata o date no formato DB2.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_padraoDB2yyyyMMdd(Date data) {
		String pattern = PatternDeData.getyyyyMMddSeparadoPorTraco();
		return formatarData(data, pattern);
	}

	/**
	 * Formata o date.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatarParaExtenso(Date data) {
		return formatarData(data, PatternDeData.getEEEEvirguladddeMMMMdeyyyy());
	}

	/**
	 * Formata o date para o dia da semana.
	 * 
	 * @param data Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatarParaDiaDaSemana(Date data) {
		return formatarData(data, PatternDeData.getEEEE());
	}

}
