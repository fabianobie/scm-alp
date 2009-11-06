/*
 * ConversorDeStringParaReader.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.io.Reader;

import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de String para reader.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaReader extends
		ConversorAbstrato<String, Reader> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Reader converter(String objeto) throws ConversorException {
		Reader res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaReader(objeto);
		}

		return res;
	}

}
