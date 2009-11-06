/*
 * ConversorDeStringParaString.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import br.com.ap.comum.excecao.ConversorException;
import br.com.ap.comum.string.UtilString;

/**
 * Conversor de String para string.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaString extends
		ConversorAbstrato<String, String> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public String converter(String objeto) throws ConversorException {
		String res = null;

		if (isReferencia(objeto)) {
			res = UtilString.trim(objeto);
		}

		return res;
	}

}
