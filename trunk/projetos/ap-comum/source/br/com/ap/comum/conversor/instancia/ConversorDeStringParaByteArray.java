/*
 * ConversorDeStringParaByteArray.java
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
 * Conversor de String para array de bytes.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaByteArray extends
		ConversorAbstrato<String, byte[]> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public byte[] converter(String objeto) throws ConversorException {
		byte[] res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaByteArray(objeto);
		}

		return res;
	}

	/**
	 * @see br.com.ap.comum.conversor.instancia.ConversorAbstrato#getTipoDeDestino()
	 */
	@Override
	public Class<byte[]> getTipoDeDestino() {
		return byte[].class;
	}
}
