/*
 * ConversorDeTimestampParaUtilDate.java
 * 
 * Data de criação: 19/12/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Time;

import br.com.ap.comum.excecao.ConversorException;
import br.com.ap.comum.formatador.UtilFormatadorDeData;

/**
 * Conversor de Time para String no formato HHmm para util.Date.
 * 
 * @author adrianop
 */
public class ConversorDeTimeParaString_HHmm extends
		ConversorAbstrato<Time, String> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da comparação
	 * @throws ConversorException Exceção de conversão
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public String converter(Time objeto) throws ConversorException {
		String res = null;

		if (isReferencia(objeto)) {
			res = UtilFormatadorDeData.formatar_HHmm(objeto);
		}

		return res;
	}

}
