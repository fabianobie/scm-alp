/*
 * ConversorDeUtilDateParaTime.java
 * 
 * Data de cria��o: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Time;
import java.util.Date;

import br.com.ap.comum.conversor.UtilConversorDeData;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de util.Date para Time.
 * 
 * @author adrianop
 */
public class ConversorDeUtilDateParaTime extends ConversorAbstrato<Date, Time> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Time converter(Date objeto) throws ConversorException {
		Time res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeData.converterParaTime(objeto);
		}

		return res;
	}
}
