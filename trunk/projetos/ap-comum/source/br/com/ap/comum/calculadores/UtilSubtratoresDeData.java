/*
 * UtilSubtratoresDeData.java
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
 * Classe utilitária responsável em efetuar subtrações entre datas.
 * 
 * @author adrianop
 */
public final class UtilSubtratoresDeData extends UtilCalculadoresAbstrato {

	/**
	 * Construtor.
	 */
	private UtilSubtratoresDeData() {
		// Construtor.
	}

	/**
	 * Retorna quantidade de minutos entre duas datas.
	 * 
	 * @param dataInicial Data inicial.
	 * @param dataFinal Data final.
	 * @return quantidade de minutos entre duas datas
	 */
	public static long getMinutosEntreDatas(Date dataInicial, Date dataFinal) {
		long res = 0;

		if (isReferencia(dataInicial, dataFinal)) {
			long milisInicial = dataInicial.getTime();
			long milisFinal = dataFinal.getTime();
			if (milisFinal > milisInicial) {
				res = (milisFinal - milisInicial) / 1000 / 60;
			}
		}
		return res;
	}

	/**
	 * Retorna quantidade de dias entre duas datas.
	 * 
	 * @param dataInicial Data inicial.
	 * @param dataFinal Data final.
	 * @return quantidade de dias entre duas datas
	 */
	public static long getDiasEntreDatas(Date dataInicial, Date dataFinal) {
		long result = 0;

		if (isReferencia(dataInicial, dataFinal)) {
			long minutos = getMinutosEntreDatas(dataInicial, dataFinal);
			if (minutos != 0) {
				result = minutos / 1440;
			}
		}
		return result;
	}

	/**
	 * Retorna quantidade de meses entre duas datas.
	 * 
	 * @param dataInicial Data inicial.
	 * @param dataFinal Data final.
	 * @return quantidade de meses entre duas datas
	 */
	public static long getMesesEntreDatas(Date dataInicial, Date dataFinal) {
		long res = 0;

		if (isReferencia(dataInicial, dataFinal)) {
			Calendar calendarInicial = novoCalendar(dataInicial);
			Calendar calendarFinal = novoCalendar(dataFinal);

			if (isDataFinalMaiorQueDataInicial(dataInicial, dataFinal)) {
				int anoInicial = calendarInicial.get(Calendar.YEAR);
				int anoFinal = calendarFinal.get(Calendar.YEAR);
				int mesInicial = calendarInicial.get(Calendar.MONTH);
				int mesFinal = calendarFinal.get(Calendar.MONTH);

				int diferencaDeAnos = anoFinal - anoInicial;
				int diferencaDeMeses = mesFinal - mesInicial;

				res = (diferencaDeAnos * 12) + diferencaDeMeses;
			}
		}
		return res;
	}

	/**
	 * Retorna quantidade de anos entre duas datas.
	 * 
	 * @param dateStart Data inicial.
	 * @param dateEnd Data final.
	 * @return quantidade de anos entre duas datas
	 */
	public static long getAnosEntreDatas(Date dateStart, Date dateEnd) {
		long result = 0;

		if (isReferencia(dateStart, dateEnd)) {
			Calendar calendarInicial = novoCalendar(dateStart);
			Calendar calendarFinal = novoCalendar(dateEnd);
			int anoInicial = calendarInicial.get(Calendar.YEAR);
			int anoFinal = calendarFinal.get(Calendar.YEAR);

			if (anoFinal > anoInicial) {
				result = anoFinal - anoInicial;
			}
		}
		return result;
	}

	/**
	 * Retorna true se a data final for maior que a data inicial.
	 * 
	 * @param dataInicial Data inicial.
	 * @param dataFinal Data final.
	 * @return true se a data final for maior que a data inicial
	 */
	public static boolean isDataFinalMaiorQueDataInicial(Date dataInicial,
			Date dataFinal) {
		boolean result = false;

		if (isReferencia(dataInicial, dataFinal)) {
			result = (dataFinal.getTime() > dataInicial.getTime());
		}
		return result;
	}

}
