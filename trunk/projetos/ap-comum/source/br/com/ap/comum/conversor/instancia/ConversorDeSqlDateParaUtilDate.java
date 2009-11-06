/*
 * ConversorDeSqlDateParaUtilDate.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import br.com.ap.comum.conversor.UtilConversorDeData;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de sql.Date para util.Date.
 * 
 * @author adrianop
 */
public class ConversorDeSqlDateParaUtilDate extends
		ConversorAbstrato<java.sql.Date, java.util.Date> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public java.util.Date converter(java.sql.Date objeto)
			throws ConversorException {
		java.util.Date res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeData.converterParaUtilDate(objeto);
		}

		return res;
	}

}
