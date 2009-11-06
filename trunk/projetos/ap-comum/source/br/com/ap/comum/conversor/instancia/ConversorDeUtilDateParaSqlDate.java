/*
 * ConversorDeUtilDateParaSqlDate.java
 * 
 * Data de cria��o: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import br.com.ap.comum.conversor.UtilConversorDeData;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de util.Date para sql.Date.
 * 
 * @author adrianop
 */
public class ConversorDeUtilDateParaSqlDate extends
		ConversorAbstrato<java.util.Date, java.sql.Date> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public java.sql.Date converter(java.util.Date objeto)
			throws ConversorException {
		java.sql.Date res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeData.converterParaSqlDate(objeto);
		}

		return res;
	}
}
