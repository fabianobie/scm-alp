/*
 * FormatadorDeDataPara_ddMMyyyy.java
 * 
 * Data de criação: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.util.Date;

import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.UtilFormatadorDeData;

/**
 * Formatador de data para dd/MM/yyyy
 * 
 * @author AdrianoP
 */
public class FormatadorDeDataParaPadrao extends FormatadorAbstrato<Date> {

	/**
	 * @param objeto Objeto formatado
	 * @return string formatada
	 * @throws FormatadorException Exceção de formatação
	 * @see br.com.ap.comum.formatador.instancia.IFormatador#formatar(java.lang.Object)
	 */
	public String formatar(Date objeto) throws FormatadorException {
		String resultado = getStringFactory().novaString();

		if (isReferencia(objeto)) {
			resultado = UtilFormatadorDeData.formatar_ddMMyyyy(objeto);
		}
		return resultado;
	}
}
