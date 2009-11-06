/*
 * UtilSubtratoresDeNumero.java
 * 
 * Data de criação: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import java.math.BigDecimal;

/**
 * Classe utilitária responsável em efetuar subtrações.
 * 
 * @author AdrianoP
 */
public final class UtilSubtratoresDeNumero extends UtilCalculadoresAbstrato {

	/**
	 * Construtor.
	 */
	private UtilSubtratoresDeNumero() {
		// Construtor.
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static int subtrair(Integer valor0, Integer valor1) {
		return getInt(valor0) - getInt(valor1);
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static int subtrair(Integer valor0, int valor1) {
		return getInt(valor0) - valor1;
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static int subtrair(int valor0, int valor1) {
		return valor0 - valor1;
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static long subtrair(Long valor0, Long valor1) {
		return (getLong(valor0) - getLong(valor1));
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static long subtrair(Long valor0, long valor1) {
		return (getLong(valor0) - valor1);
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static long subtrair(long valor0, long valor1) {
		return (valor0 - valor1);
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static double subtrair(Double valor0, Double valor1) {
		BigDecimal bd0 = novoBigDecimal(valor0);
		BigDecimal bd1 = novoBigDecimal(valor1);
		return (bd0.subtract(bd1)).doubleValue();
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static double subtrair(Double valor0, double valor1) {
		return subtrair(valor0, novoDouble(valor1));
	}

	/**
	 * Subtrai 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da subtração.
	 */
	public static double subtrair(double valor0, double valor1) {
		return subtrair(novoDouble(valor0), novoDouble(valor1));
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static float subtrair(Float valor0, Float valor1) {
		BigDecimal bd0 = novoBigDecimal(valor0);
		BigDecimal bd1 = novoBigDecimal(valor1);
		return (bd0.subtract(bd1)).floatValue();
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static float subtrair(Float valor0, float valor1) {
		return subtrair(valor0, novoFloat(valor1));
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static float subtrair(float valor0, float valor1) {
		return subtrair(novoFloat(valor0), novoFloat(valor1));
	}
}
