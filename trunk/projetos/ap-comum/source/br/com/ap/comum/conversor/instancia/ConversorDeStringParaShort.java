/*
 * ConversorDeStringParaShort.java
 * 
 * Data de cria��o: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de String para short.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaShort extends
		ConversorAbstrato<String, Short> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Short converter(String objeto) throws ConversorException {
		Short res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaShortWrapper(objeto);
		}

		return res;
	}

}
