/*
 * UtilComparadorDeNumeroMaior.java
 * 
 * Data de criação: 28/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

/**
 * Efetua a comparação entre números e retorna o número maior.
 * 
 * @author AdrianoP
 */
public final class UtilComparadorDeNumeroMaior extends
		UtilComparadorAbstrato<Number> {

	/**
	 * Retorna objeto que satisfaz a comparação.
	 * 
	 * @param <T> Tipo do objeto da comparação
	 * @param objeto Objeto que será comparado.
	 * @return objeto que satisfaz a comparação.
	 */
	public static <T extends Number> T comparar(T... objeto) {
		return getMaior(objeto);
	}
}
