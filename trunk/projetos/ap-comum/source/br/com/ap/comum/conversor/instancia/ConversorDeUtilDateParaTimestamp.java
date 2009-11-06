/*
 * ConversorDeUtilDateParaTimestamp.java
 * 
 * Data de cria��o: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Timestamp;
import java.util.Date;

import br.com.ap.comum.conversor.UtilConversorDeData;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de util.Date para Timestamp.
 * 
 * @author adrianop
 */
public class ConversorDeUtilDateParaTimestamp extends
		ConversorAbstrato<Date, Timestamp> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Timestamp converter(Date objeto) throws ConversorException {
		Timestamp res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeData.converterParaTimestamp(objeto);
		}

		return res;
	}
}
