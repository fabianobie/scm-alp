/*
 * ConversorDeUtilDateParaStringNoPadrao.java
 * 
 * Data de criação: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.util.Date;

import br.com.ap.comum.excecao.ConversorException;
import br.com.ap.comum.formatador.UtilFormatadorDeData;

/**
 * Conversor de util.Date string no padrão dd/MM/yyyy
 * 
 * @author adrianop
 */
public class ConversorDeUtilDateParaStringNoPadrao extends
		ConversorAbstrato<Date, String> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public String converter(Date objeto) throws ConversorException {
		String res = null;

		if (isReferencia(objeto)) {
			res = UtilFormatadorDeData.formatar_ddMMyyyy(objeto);
		}

		return res;
	}
}
