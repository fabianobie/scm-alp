/*
 * UtilComparadorDeNumeroMaior.java
 * 
 * Data de cria��o: 28/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

/**
 * Efetua a compara��o entre n�meros e retorna o n�mero maior.
 * 
 * @author AdrianoP
 */
public final class UtilComparadorDeNumeroMaior extends
		UtilComparadorAbstrato<Number> {

	/**
	 * Retorna objeto que satisfaz a compara��o.
	 * 
	 * @param <T> Tipo do objeto da compara��o
	 * @param objeto Objeto que ser� comparado.
	 * @return objeto que satisfaz a compara��o.
	 */
	public static <T extends Number> T comparar(T... objeto) {
		return getMaior(objeto);
	}
}
