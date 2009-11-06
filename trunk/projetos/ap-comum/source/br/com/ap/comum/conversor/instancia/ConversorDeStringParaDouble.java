/*
 * ConversorDeStringParaDouble.java
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
 * Conversor de String para double.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaDouble extends
		ConversorAbstrato<String, Double> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Double converter(String objeto) throws ConversorException {
		Double res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaDoubleWrapper(objeto);
		}

		return res;
	}

}
