/*
 * UtilComparadorDeStringMenor.java
 * 
 * Data de cria��o: 13/02/2007
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

/**
 * Efetua a compara��o entre strings e retorna a string menor.
 * 
 * @author AdrianoP
 */
public final class UtilComparadorDeStringMenor extends
		UtilComparadorAbstrato<String> {

	/**
	 * Retorna a maior data das datas passadas por par�metro.
	 * 
	 * @param objeto Datas
	 * @return maior data.
	 */
	public static String comparar(String... objeto) {
		return getMenor(objeto);
	}

}
