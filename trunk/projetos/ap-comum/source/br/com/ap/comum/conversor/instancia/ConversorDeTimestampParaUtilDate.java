/*
 * ConversorDeTimestampParaUtilDate.java
 * 
 * Data de cria��o: 19/12/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Timestamp;
import java.util.Date;

import br.com.ap.comum.conversor.UtilConversorDeTimestamp;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de timestamp para util.Date.
 * 
 * @author adrianop
 */
public class ConversorDeTimestampParaUtilDate extends
		ConversorAbstrato<Timestamp, Date> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Date converter(Timestamp objeto) throws ConversorException {
		Date res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeTimestamp.converterParaDate(objeto);
		}

		return res;
	}

}
