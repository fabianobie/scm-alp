/*
 * UtilComparadorDeStringMenor.java
 * 
 * Data de criação: 13/02/2007
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

/**
 * Efetua a comparação entre strings e retorna a string menor.
 * 
 * @author AdrianoP
 */
public final class UtilComparadorDeStringMenor extends
		UtilComparadorAbstrato<String> {

	/**
	 * Retorna a maior data das datas passadas por parâmetro.
	 * 
	 * @param objeto Datas
	 * @return maior data.
	 */
	public static String comparar(String... objeto) {
		return getMenor(objeto);
	}

}
