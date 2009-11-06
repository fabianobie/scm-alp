/*
 * FormatadorDeInteger.java
 * 
 * Data de criação: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.UtilFormatadorDeString;

/**
 * Formatador default de booleano.
 * 
 * @author adrianop
 */
public class FormatadorDeBoolean extends FormatadorAbstrato<Boolean> {

	/**
	 * @param objeto Objeto formatado
	 * @return string formatada
	 * @throws FormatadorException Exceção de formatação
	 * @see br.com.ap.comum.formatador.instancia.IFormatador#formatar(java.lang.Object)
	 */
	public String formatar(Boolean objeto) throws FormatadorException {
		String resultado = "";

		if (isReferencia(objeto)) {
			resultado = UtilFormatadorDeString.formatar(objeto);
		}
		return resultado;
	}
}
