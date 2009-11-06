/*
 * UtilSomadoresDeData.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe utilitária responsável em efetuar calculos em objetos do tipo data.
 * 
 * @author adrianop
 */
public final class UtilSomadoresDeData extends UtilCalculadoresAbstrato {

	/**
	 * Construtor.
	 */
	private UtilSomadoresDeData() {
		// Construtor
	}

	/**
	 * Atualiza os dias da data.
	 * 
	 * @param data Data que será alterada.
	 * @param quantidade Fator da atualização, pode ser positivo ou negativo.
	 * @return Data atualizada.
	 */
	public static Date adicionarDias(Date data, int quantidade) {
		return atualizarCalendario(data, Calendar.DAY_OF_MONTH, quantidade);
	}

	/**
	 * Atualiza os meses da data.
	 * 
	 * @param data Data que será alterada.
	 * @param quantidade Fator da atualização.
	 * @return Data atualizada.
	 */
	public static Date adicionarMeses(Date data, int quantidade) {
		return atualizarCalendario(data, Calendar.MONTH, quantidade);
	}

	/**
	 * Atualiza os anos da data.
	 * 
	 * @param data Data que será alterada.
	 * @param quantidade Fator da atualização.
	 * @return Data atualizada.
	 */
	public static Date adicionarAnos(Date data, int quantidade) {
		return atualizarCalendario(data, Calendar.YEAR, quantidade);
	}

	/**
	 * Atualiza as horas da data.
	 * 
	 * @param data Data que será alterada.
	 * @param quantidade Fator da atualização.
	 * @return Data atualizada.
	 */
	public static Date adicionarHoras(Date data, int quantidade) {
		return atualizarCalendario(data, Calendar.HOUR_OF_DAY, quantidade);
	}

	/**
	 * Atualiza os minutos da data.
	 * 
	 * @param data Data que será alterada.
	 * @param quantidade Fator da atualização.
	 * @return Data atualizada.
	 */
	public static Date adicionarMinutos(Date data, int quantidade) {
		return atualizarCalendario(data, Calendar.MINUTE, quantidade);
	}

	/**
	 * Atualiza os segundos da data.
	 * 
	 * @param data Data que será alterada.
	 * @param quantidade Fator de atualização.
	 * @return Data atualizada.
	 */
	public static Date adicionarSegundos(Date data, int quantidade) {
		return atualizarCalendario(data, Calendar.SECOND, quantidade);
	}

	/**
	 * Incrementa/Decrementa a data.
	 * 
	 * @param data Data que será atualizada.
	 * @param campo Constante que indica qual parte da data será alterada. Ex:
	 *            Calendar.YEAR.
	 * @param quantidade Fator do incremento/decremento.
	 * @return Data atualizada.
	 */
	private static Date atualizarCalendario(Date data, int campo,
			int quantidade) {
		if (isReferencia(data)) {
			Calendar calendar = novoCalendar(data);
			calendar.add(campo, quantidade);

			data = calendar.getTime();
		}
		return data;
	}
}
