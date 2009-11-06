/*
 * ConversorDeStringParaTimestamp.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Timestamp;

import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de String para timestamp no formato dd/MM/yyyy hh:mm.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaTimestamp extends
		ConversorAbstrato<String, Timestamp> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Timestamp converter(String objeto) throws ConversorException {
		Timestamp res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString
					.converterParaTimestamp_ddMMyyyyEspacohhmmss(objeto);
		}

		return res;
	}

}
