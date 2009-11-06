/*
 * ConversorDeStringParaLong.java
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
 * Conversor de String para long.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaLong extends ConversorAbstrato<String, Long> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Long converter(String objeto) throws ConversorException {
		Long res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaLongWrapper(objeto);
		}

		return res;
	}

}
