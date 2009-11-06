/*
 * FormatadorDeDoubleParaMonetario.java
 * 
 * Data de criação: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.UtilFormatadorDeReal;

/**
 * Formatador de Double para monetário.
 * 
 * @author AdrianoP
 */
public class FormatadorDeDoubleParaMonetario extends
		FormatadorAbstrato<Double> {

	/**
	 * @param objeto Objeto formatado
	 * @return string formatada
	 * @throws FormatadorException Exceção de formatação
	 * @see br.com.ap.comum.formatador.instancia.IFormatador#formatar(java.lang.Object)
	 */
	public String formatar(Double objeto) throws FormatadorException {
		String resultado = getStringFactory().novaString();

		if (isReferencia(objeto)) {
			resultado = UtilFormatadorDeReal.formatarParaMonetario(objeto);
		}
		return resultado;
	}
}
