/*
 * UtilValidadorDeDataFinalMaiorQueDataInicial.java
 * 
 * Data de cria��o: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

/**
 * Validador que verifica se a data inicial � maior que a data final.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeDataFinalMaiorQueDataInicial extends
		UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeDataFinalMaiorQueDataInicial() {
		// Construtor.
	}

	/**
	 * Retorna true se a data final for maior que a data inicial. As datas s�o
	 * obrigat�rias.
	 * 
	 * @param dataInicial Data inicial.
	 * @param dataFinal Data final.
	 * @return true se a data final for maior que a data inicial.
	 */
	public static boolean validar(Date dataInicial, Date dataFinal) {
		return isPrimeiroObjetoMaior(dataFinal, dataInicial);
	}
}
