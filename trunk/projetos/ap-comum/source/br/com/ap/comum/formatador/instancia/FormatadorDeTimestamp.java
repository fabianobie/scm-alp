/*
 * FormatadorDeDataPara_ddMMyyyy.java
 * 
 * Data de criação: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.sql.Timestamp;

import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.UtilFormatadorDeData;

/**
 * Formatador de timestamp.
 * 
 * @author AdrianoP
 */
public class FormatadorDeTimestamp extends FormatadorAbstrato<Timestamp> {

	/**
	 * @param objeto Objeto formatado
	 * @return string formatada
	 * @throws FormatadorException Exceção de formatação 
	 * @see br.com.ap.comum.formatador.instancia.IFormatador#formatar(java.lang.Object)
	 */
	public String formatar(Timestamp objeto) throws FormatadorException {
		String resultado = getStringFactory().novaString();

		if (isReferencia(objeto)) {
			resultado = UtilFormatadorDeData
					.formatar_ddMMyyyyEspacoHHmmss(objeto);
		}
		return resultado;
	}
}
