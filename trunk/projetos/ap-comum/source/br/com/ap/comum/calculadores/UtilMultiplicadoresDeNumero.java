/*
 * UtilMultiplicadoresDeNumeros.java
 * 
 * Data de cria��o: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import java.math.BigDecimal;

/**
 * Classe utilit�ria respons�vel em efetuar multiplica��es.
 * 
 * @author AdrianoP
 */
public final class UtilMultiplicadoresDeNumero extends
		UtilCalculadoresAbstrato {

	/**
	 * Construtor
	 */
	private UtilMultiplicadoresDeNumero() {
		// Construtor
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static int multiplicar(Integer valor0, Integer valor1) {
		return getInt(valor0) * getInt(valor1);
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static int multiplicar(Integer valor0, int valor1) {
		return getInt(valor0) * valor1;
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static int multiplicar(int valor0, int valor1) {
		return valor0 * valor1;
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static long multiplicar(Long valor0, Long valor1) {
		return (getLong(valor0) * getLong(valor1));
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static long multiplicar(Long valor0, long valor1) {
		return (getLong(valor0) * valor1);
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static long multiplicar(long valor0, long valor1) {
		return (valor0 * valor1);
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static double multiplicar(Double valor0, Double valor1) {
		BigDecimal bd0 = novoBigDecimal(valor0);
		BigDecimal bd1 = novoBigDecimal(valor1);
		return (bd0.multiply(bd1)).doubleValue();
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static double multiplicar(Double valor0, double valor1) {
		return multiplicar(valor0, novoDouble(valor1));
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static double multiplicar(double valor0, double valor1) {
		return multiplicar(novoDouble(valor0), novoDouble(valor1));
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static float multiplicar(Float valor0, Float valor1) {
		BigDecimal bd0 = novoBigDecimal(valor0);
		BigDecimal bd1 = novoBigDecimal(valor1);
		return (bd0.multiply(bd1)).floatValue();
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static float multiplicar(Float valor0, float valor1) {
		return multiplicar(valor0, novoFloat(valor1));
	}

	/**
	 * Multiplica 2 valores.
	 * 
	 * @param valor0 Primeiro valor
	 * @param valor1 Segundo valor
	 * @return resultado da multiplica��o.
	 */
	public static float multiplicar(float valor0, float valor1) {
		return multiplicar(novoFloat(valor0), novoFloat(valor1));
	}
}
