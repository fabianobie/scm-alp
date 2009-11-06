/*
 * UtilValidadorDeDataNoPeriodo.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

import br.com.ap.comum.constante.Data;
import br.com.ap.comum.data.UtilData;

/**
 * Validador de data no período.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeDataNoPeriodo extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeDataNoPeriodo() {
		// Construtor.
	}

	/**
	 * Retorna true se a data estiver entre as duas datas informadas.
	 * 
	 * @param data Data validada
	 * @param dataInicial Data de início
	 * @param dataFinal Data final.
	 * @return true se a data estiver entre as duas datas informadas.
	 */
	public static boolean validar(Date data, Date dataInicial, Date dataFinal) {
		boolean result = false;

		if (isReferencia(data, dataInicial, dataFinal)) {
			data = UtilData.ajustarDataParaMilisegundo(data, 0);
			dataInicial = UtilData.ajustarDataParaMilisegundo(dataInicial, 0);
			dataFinal = UtilData.ajustarDataParaMilisegundo(dataFinal, 0);
			result = isPrimeiroObjetoMaiorOuIgual(data, dataInicial)
					&& isPrimeiroObjetoMaiorOuIgual(dataFinal, data);
		}
		return result;
	}

	/**
	 * Retorna true se a data estiver entre as duas datas informadas.
	 * 
	 * @param data Data validada
	 * @param anoInicial Ano de início
	 * @param anoFinal Ano final.
	 * @return true se a data estiver entre as duas datas informadas.
	 */
	public static boolean validarNoAno(Date data, int anoInicial, int anoFinal) {
		boolean result = false;
		if (isReferencia(data)
				&& isAnoFinalMaiorQueAnoInicial(anoFinal, anoInicial)) {
			Date dataInicial = novoDate(getPrimeiroDiaDoMesDefault(),
					getJaneiro(), anoInicial, 00, 00, 00);
			Date dataFinal = novoDate(getUltimoDiaDoMes(getDezembro()),
					getDezembro(), anoFinal, 23, 59, 59);
			result = validar(data, dataInicial, dataFinal);
		}
		return result;
	}

	/**
	 * Cria um novo objeto date.
	 * 
	 * @param dia Dia
	 * @param mes Mês
	 * @param ano Ano
	 * @param hora Hora
	 * @param minuto
	 * @param segundo
	 * @return data
	 */
	private static Date novoDate(int dia, int mes, int ano, int hora,
			int minuto, int segundo) {
		return getDataFactory().novoDate(dia, mes, ano, hora, minuto, segundo);
	}

	/**
	 * @param mes mês
	 * @return último dia do mês
	 */
	private static int getUltimoDiaDoMes(int mes) {
		return UtilData.getUltimoDiaDoMes(mes);
	}

	/**
	 * @return janeiro
	 */
	private static int getJaneiro() {
		return Data.getJaneiro();
	}

	/**
	 * @return dezembro
	 */
	private static int getDezembro() {
		return Data.getDezembro();
	}

	/**
	 * @return primeiro dia do mês
	 */
	private static int getPrimeiroDiaDoMesDefault() {
		return Data.getPrimeiroDiaDoMesDefault();
	}

	/**
	 * Retorna true se o ano final for maior que ano inicial.
	 * 
	 * @param anoFinal Ano Final
	 * @param anoInicial Ano Inicial
	 * @return booleano
	 */
	@SuppressWarnings("boxing")
	private static boolean isAnoFinalMaiorQueAnoInicial(int anoFinal,
			int anoInicial) {
		return UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.validar(
				anoFinal, anoInicial);
	}
}
