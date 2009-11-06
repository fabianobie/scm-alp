/*
 * ConversorDeStringParaBoolean.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de String para booleano.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaBoolean extends
		ConversorAbstrato<String, Boolean> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Boolean converter(String objeto) throws ConversorException {
		Boolean res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaBooleanWrapper(objeto);
		}

		return res;
	}

}
