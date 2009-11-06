/*
 * Data.java
 * 
 * Data de criação: 30/06/2008
 *
 * 
 * 
 */
package br.com.ap.comum.constante;

import java.util.Calendar;

/**
 * Constantes de data.
 * 
 * @author adrianop
 */
public final class Data {

	/**
	 * Construtor.
	 */
	private Data() {
		// Construtor.
	}

	/**
	 * Retorna inteiro que representa o mês de janeiro.
	 * 
	 * @return inteiro que representa o mês de janeiro.
	 */
	public static int getJaneiro() {
		return 1;
	}

	/**
	 * Retorna inteiro que representa o mês de fevereiro.
	 * 
	 * @return inteiro que representa o mês de fevereiro.
	 */
	public static int getFevereiro() {
		return 2;
	}

	/**
	 * Retorna inteiro que representa o mês de março.
	 * 
	 * @return inteiro que representa o mês de março.
	 */
	public static int getMarco() {
		return 3;
	}

	/**
	 * Retorna inteiro que representa o mês de Abril.
	 * 
	 * @return inteiro que representa o mês de Abril.
	 */
	public static int getAbril() {
		return 4;
	}

	/**
	 * Retorna inteiro que representa o mês de Maio.
	 * 
	 * @return inteiro que representa o mês de Maio.
	 */
	public static int getMaio() {
		return 5;
	}

	/**
	 * Retorna inteiro que representa o mês de Junho.
	 * 
	 * @return inteiro que representa o mês de Junho.
	 */
	public static int getJunho() {
		return 6;
	}

	/**
	 * Retorna inteiro que representa o mês de Julho.
	 * 
	 * @return inteiro que representa o mês de Julho.
	 */
	public static int getJulho() {
		return 7;
	}

	/**
	 * Retorna inteiro que representa o mês de Agosto.
	 * 
	 * @return inteiro que representa o mês de Agosto.
	 */
	public static int getAgosto() {
		return 8;
	}

	/**
	 * Retorna inteiro que representa o mês de Setembro.
	 * 
	 * @return inteiro que representa o mês de Setembro.
	 */
	public static int getSetembro() {
		return 9;
	}

	/**
	 * Retorna inteiro que representa o mês de Outubro.
	 * 
	 * @return inteiro que representa o mês de Outubro.
	 */
	public static int getOutubro() {
		return 10;
	}

	/**
	 * Retorna inteiro que representa o mês de Novembro.
	 * 
	 * @return inteiro que representa o mês de Novembro.
	 */
	public static int getNovembro() {
		return 11;
	}

	/**
	 * Retorna inteiro que representa o mês de Dezembro.
	 * 
	 * @return inteiro que representa o mês de Dezembro.
	 */
	public static int getDezembro() {
		return 12;
	}

	/**
	 * Retorna primeiro dia do mês default.
	 * 
	 * @return primeiro dia do mês
	 */
	public static int getPrimeiroDiaDoMesDefault() {
		return 1;
	}

	/**
	 * Retorna primeiro mês do ano default. Retorna o código de janeiro do
	 * Calendar.
	 * 
	 * @return primeiro mês do ano
	 */
	public static int getPrimeiroMesDefault() {
		return Calendar.JANUARY;
	}

	/**
	 * Retorna primeiro ano válido default.
	 * 
	 * @return primeiro ano válido
	 */
	public static int getPrimeiroAnoDefault() {
		return 1800;
	}
}
