/*
 * ConversorDeStringParaByte.java
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
 * Conversor de String para byte.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaByte extends ConversorAbstrato<String, Byte> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Byte converter(String objeto) throws ConversorException {
		Byte res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaByteWrapper(objeto);
		}

		return res;
	}

}
