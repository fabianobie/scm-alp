/*
 * ConversorDeStringParaTime.java
 * 
 * Data de cria��o: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Time;

import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de String para time no formato hh:mm.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaTime extends ConversorAbstrato<String, Time> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Time converter(String objeto) throws ConversorException {
		Time res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaTime_HHmm(objeto);
		}

		return res;
	}

}
