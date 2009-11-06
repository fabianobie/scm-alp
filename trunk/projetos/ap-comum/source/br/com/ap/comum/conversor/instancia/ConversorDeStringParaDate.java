/*
 * ConversorDeStringParaDate.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.util.Date;

import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de String para date no formato dd/MM/yyyy.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaDate extends ConversorAbstrato<String, Date> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Date converter(String objeto) throws ConversorException {
		Date res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaData_ddMMyyyy(objeto);
		}

		return res;
	}

}
