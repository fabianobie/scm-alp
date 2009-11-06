/*
 * UtilCalculo.java
 * 
 * Data de criação: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import java.math.BigDecimal;

/**
 * Classe utilitária responsável em efetuar somas.
 * 
 * @author AdrianoP
 */
public final class UtilSomadoresDeNumero extends UtilCalculadoresAbstrato {

	/**
	 * Construtor.
	 */
	private UtilSomadoresDeNumero() {
		// Construtor.
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static int somar(Integer valor0, Integer valor1) {
		return getInt(valor0) + getInt(valor1);
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static int somar(Integer valor0, int valor1) {
		return getInt(valor0) + valor1;
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static int somar(int valor0, int valor1) {
		return valor0 + valor1;
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static long somar(Long valor0, Long valor1) {
		return (getLong(valor0) + getLong(valor1));
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static long somar(Long valor0, long valor1) {
		return (getLong(valor0) + valor1);
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static long somar(long valor0, long valor1) {
		return (valor0 + valor1);
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static double somar(Double valor0, Double valor1) {
		BigDecimal bd0 = novoBigDecimal(valor0);
		BigDecimal bd1 = novoBigDecimal(valor1);
		return (bd0.add(bd1)).doubleValue();
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static double somar(Double valor0, double valor1) {
		return somar(valor0, novoDouble(valor1));
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static double somar(double valor0, double valor1) {
		return somar(novoDouble(valor0), novoDouble(valor1));
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static float somar(Float valor0, Float valor1) {
		BigDecimal bd0 = novoBigDecimal(valor0);
		BigDecimal bd1 = novoBigDecimal(valor1);
		return (bd0.add(bd1)).floatValue();
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static float somar(Float valor0, float valor1) {
		return somar(valor0, novoFloat(valor1));
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static float somar(float valor0, float valor1) {
		return somar(novoFloat(valor0), novoFloat(valor1));
	}

	/**
	 * Soma 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da soma.
	 */
	public static long somar(Number valor0, Number valor1) {
		return somar(novoLong(valor0), novoLong(valor1));
	}
}
