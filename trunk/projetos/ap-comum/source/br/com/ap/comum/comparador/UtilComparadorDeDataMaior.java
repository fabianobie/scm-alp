/*
 * UtilComparadorDeDataMaior.java
 * 
 * Data de criação: 13/02/2007
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

import java.util.Date;

/**
 * Efetua a comparação entre datas e retorna a data maior.
 * 
 * @author AdrianoP
 */
public final class UtilComparadorDeDataMaior extends
		UtilComparadorAbstrato<Date> {

	/**
	 * Retorna a maior data das datas passadas por parâmetro.
	 * 
	 * @param objeto Datas
	 * @return maior data.
	 */
	public static Date comparar(Date... objeto) {
		return getMaior(objeto);
	}

}
