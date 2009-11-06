/*
 * UtilDivisoresDeNumero.java
 * 
 * Data de criação: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import java.math.BigDecimal;

/**
 * Classe utilitária responsável em efetuar divisões.
 * 
 * @author AdrianoP
 */
public final class UtilDivisoresDeNumero extends UtilCalculadoresAbstrato {

	/**
	 * Construtor
	 */
	private UtilDivisoresDeNumero() {
		// Construtor
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(Integer valor0, Integer valor1) {
		return dividir(getInt(valor0), getInt(valor1));
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(Integer valor0, int valor1) {
		return dividir(getInt(valor0), valor1);
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(int valor0, int valor1) {
		return ((double) valor0 / (double) valor1);
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(Long valor0, Long valor1) {
		return dividir(getLong(valor0), getLong(valor1));
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(Long valor0, long valor1) {
		return dividir(getLong(valor0), valor1);
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(long valor0, long valor1) {
		return ((double) valor0 / (double) valor1);
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(Double valor0, Double valor1) {
		BigDecimal bd0 = novoBigDecimal(valor0);
		BigDecimal bd1 = novoBigDecimal(valor1);
		return (bd0.divide(bd1, BigDecimal.ROUND_UNNECESSARY)).doubleValue();
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(Double valor0, double valor1) {
		return dividir(valor0, novoDouble(valor1));
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static double dividir(double valor0, double valor1) {
		return dividir(novoDouble(valor0), novoDouble(valor1));
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static float dividir(Float valor0, Float valor1) {
		BigDecimal bd0 = novoBigDecimal(valor0);
		BigDecimal bd1 = novoBigDecimal(valor1);
		return (bd0.divide(bd1, BigDecimal.ROUND_UNNECESSARY)).floatValue();
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static float dividir(Float valor0, float valor1) {
		return dividir(valor0, novoFloat(valor1));
	}

	/**
	 * Dividi 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da divisão.
	 */
	public static float dividir(float valor0, float valor1) {
		return dividir(novoFloat(valor0), novoFloat(valor1));
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(Integer valor0, Integer valor1) {
		return resto(getInt(valor0), getInt(valor1));
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(Integer valor0, int valor1) {
		return resto(getInt(valor0), valor1);
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(int valor0, int valor1) {
		return ((double) valor0 % (double) valor1);
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(Long valor0, Long valor1) {
		return resto(getLong(valor0), getLong(valor1));
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(Long valor0, long valor1) {
		return resto(getLong(valor0), valor1);
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(long valor0, long valor1) {
		return ((double) valor0 % (double) valor1);
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(Double valor0, Double valor1) {
		return resto(getDouble(valor0), getDouble(valor1));
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(Double valor0, double valor1) {
		return resto(getDouble(valor0), valor1);
	}

	/**
	 * Resto da divisão de 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resto da divisão.
	 */
	public static double resto(double valor0, double valor1) {
		return (valor0 % valor1);
	}
}
