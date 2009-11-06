/*
 * Data.java
 * 
 * Data de cria��o: 30/06/2008
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
	 * Retorna inteiro que representa o m�s de janeiro.
	 * 
	 * @return inteiro que representa o m�s de janeiro.
	 */
	public static int getJaneiro() {
		return 1;
	}

	/**
	 * Retorna inteiro que representa o m�s de fevereiro.
	 * 
	 * @return inteiro que representa o m�s de fevereiro.
	 */
	public static int getFevereiro() {
		return 2;
	}

	/**
	 * Retorna inteiro que representa o m�s de mar�o.
	 * 
	 * @return inteiro que representa o m�s de mar�o.
	 */
	public static int getMarco() {
		return 3;
	}

	/**
	 * Retorna inteiro que representa o m�s de Abril.
	 * 
	 * @return inteiro que representa o m�s de Abril.
	 */
	public static int getAbril() {
		return 4;
	}

	/**
	 * Retorna inteiro que representa o m�s de Maio.
	 * 
	 * @return inteiro que representa o m�s de Maio.
	 */
	public static int getMaio() {
		return 5;
	}

	/**
	 * Retorna inteiro que representa o m�s de Junho.
	 * 
	 * @return inteiro que representa o m�s de Junho.
	 */
	public static int getJunho() {
		return 6;
	}

	/**
	 * Retorna inteiro que representa o m�s de Julho.
	 * 
	 * @return inteiro que representa o m�s de Julho.
	 */
	public static int getJulho() {
		return 7;
	}

	/**
	 * Retorna inteiro que representa o m�s de Agosto.
	 * 
	 * @return inteiro que representa o m�s de Agosto.
	 */
	public static int getAgosto() {
		return 8;
	}

	/**
	 * Retorna inteiro que representa o m�s de Setembro.
	 * 
	 * @return inteiro que representa o m�s de Setembro.
	 */
	public static int getSetembro() {
		return 9;
	}

	/**
	 * Retorna inteiro que representa o m�s de Outubro.
	 * 
	 * @return inteiro que representa o m�s de Outubro.
	 */
	public static int getOutubro() {
		return 10;
	}

	/**
	 * Retorna inteiro que representa o m�s de Novembro.
	 * 
	 * @return inteiro que representa o m�s de Novembro.
	 */
	public static int getNovembro() {
		return 11;
	}

	/**
	 * Retorna inteiro que representa o m�s de Dezembro.
	 * 
	 * @return inteiro que representa o m�s de Dezembro.
	 */
	public static int getDezembro() {
		return 12;
	}

	/**
	 * Retorna primeiro dia do m�s default.
	 * 
	 * @return primeiro dia do m�s
	 */
	public static int getPrimeiroDiaDoMesDefault() {
		return 1;
	}

	/**
	 * Retorna primeiro m�s do ano default. Retorna o c�digo de janeiro do
	 * Calendar.
	 * 
	 * @return primeiro m�s do ano
	 */
	public static int getPrimeiroMesDefault() {
		return Calendar.JANUARY;
	}

	/**
	 * Retorna primeiro ano v�lido default.
	 * 
	 * @return primeiro ano v�lido
	 */
	public static int getPrimeiroAnoDefault() {
		return 1800;
	}
}
