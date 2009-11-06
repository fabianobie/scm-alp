/*
 * ConversorDeStringParaFloat.java
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
 * Conversor de String para float.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaFloat extends
		ConversorAbstrato<String, Float> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Float converter(String objeto) throws ConversorException {
		Float res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaFloatWrapper(objeto);
		}

		return res;
	}

}
