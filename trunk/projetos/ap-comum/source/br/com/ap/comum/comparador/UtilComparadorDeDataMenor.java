/*
 * UtilComparadorDeDataMenor.java
 * 
 * Data de criação: 13/02/2007
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

import java.util.Date;

/**
 * Efetua a comparação entre datas e retorna a data menor.
 * 
 * @author AdrianoP
 */
public final class UtilComparadorDeDataMenor extends
		UtilComparadorAbstrato<Date> {

	/**
	 * Retorna a menor data das datas passadas por parâmetro.
	 * 
	 * @param objeto Datas
	 * @return maior data.
	 */
	public static Date comparar(Date... objeto) {
		return getMenor(objeto);
	}
}
