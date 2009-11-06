/*
 * FormatadorDeDoubleParaMonetario.java
 * 
 * Data de cria��o: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.UtilFormatadorDeReal;

/**
 * Formatador de Double para monet�rio.
 * 
 * @author AdrianoP
 */
public class FormatadorDeDoubleParaMonetario extends
		FormatadorAbstrato<Double> {

	/**
	 * @param objeto Objeto formatado
	 * @return string formatada
	 * @throws FormatadorException Exce��o de formata��o
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
