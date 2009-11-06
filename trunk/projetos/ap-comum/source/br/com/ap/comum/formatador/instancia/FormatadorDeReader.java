/*
 * FormatadorDeDataPara_ddMMyyyy.java
 * 
 * Data de criação: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.io.BufferedReader;
import java.io.Reader;

import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.comum.excecao.FormatadorException;

/**
 * Formatador de reader, o texto do reader será lido e concatenado.
 * 
 * @author AdrianoP
 */
public class FormatadorDeReader extends FormatadorAbstrato<Reader> {

	/**
	 * @param objeto Objeto formatado
	 * @return string formatada
	 * @throws FormatadorException Exceção de formatação
	 * @see br.com.ap.comum.formatador.instancia.IFormatador#formatar(java.lang.Object)
	 */
	public String formatar(Reader objeto) throws FormatadorException {
		String resultado = getStringFactory().novaString();

		if (isReferencia(objeto)) {
			BufferedReader br = getArquivoFactory().novoBufferedReader(objeto);
			resultado = UtilArquivo.getTextoDoArquivo(br, true);
		}
		return resultado;
	}
}
