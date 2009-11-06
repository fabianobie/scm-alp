/*
 * UtilCarregarMapaDeObjetos.java
 * 
 * Data de cria��o: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import br.com.ap.comum.conversor.UtilConversorDeInteger;
import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ComumRuntimeException;

/**
 * Classe utilit�ria respons�vel em ler o arquivo de propriedades em um mapa. O
 * properties � composto pela chave do tipo string e valor do tipo inteiro, o
 * inteiro representa um caracter espec�fico.<br>
 * Exemplo:<br>
 * <dd>separador.espaco=48<br>
 * <dd>separador.zero=32<br>
 * <br>
 * O valor ser� convertido em um caracter e esse caracter ser� convertido em uma
 * string, ou seja, se for passado o valor 97 ser� adicionado no mapa a letra
 * 'a'.
 * 
 * @author adrianop
 */
public class UtilCarregarMapaDeChars extends
		UtilCarregarMapaDoProperties<String, Character> {

	/**
	 * @see br.com.ap.comum.arquivo.UtilCarregarMapaAbstrato#converterChave(java.lang.String)
	 */
	@Override
	protected String converterChave(String chave) throws ComumRuntimeException {
		return super.converterChave(chave);
	}

	/**
	 * @see br.com.ap.comum.arquivo.UtilCarregarMapaAbstrato#converterValor(java.lang.String)
	 */
	@Override
	protected Character converterValor(String valor)
			throws ComumRuntimeException {
		int inteiro = UtilConversorDeString.converterParaInt(valor);
		return UtilConversorDeInteger.converterParaCharacter(inteiro);
	}
}
