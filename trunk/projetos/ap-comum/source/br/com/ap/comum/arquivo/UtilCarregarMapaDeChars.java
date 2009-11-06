/*
 * UtilCarregarMapaDeObjetos.java
 * 
 * Data de criação: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import br.com.ap.comum.conversor.UtilConversorDeInteger;
import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ComumRuntimeException;

/**
 * Classe utilitária responsável em ler o arquivo de propriedades em um mapa. O
 * properties é composto pela chave do tipo string e valor do tipo inteiro, o
 * inteiro representa um caracter específico.<br>
 * Exemplo:<br>
 * <dd>separador.espaco=48<br>
 * <dd>separador.zero=32<br>
 * <br>
 * O valor será convertido em um caracter e esse caracter será convertido em uma
 * string, ou seja, se for passado o valor 97 será adicionado no mapa a letra
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
