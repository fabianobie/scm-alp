/*
 * UtilCarregarMapaDeClasses.java
 * 
 * Data de criação: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import br.com.ap.comum.excecao.ComumRuntimeException;
import br.com.ap.comum.util.UtilComumRuntimeException;

/**
 * Classe utilitária responsável em ler o arquivo de propriedades em um mapa. O
 * properties é composto pela chave do tipo Class e o valor do tipo String
 * Exemplo de um arquivo .properties<br>
 * <dd>java.lang.Integer=VL001
 * 
 * @author adrianop
 */
public class UtilCarregarMapaDeClasseString extends
		UtilCarregarMapaDoProperties<Class<?>, String> {

	/**
	 * @see br.com.ap.comum.arquivo.UtilCarregarMapaAbstrato#converterChave(java.lang.String)
	 */
	@Override
	protected Class<?> converterChave(String chave)
			throws ComumRuntimeException {
		Class<?> classe = null;
		try {
			classe = Class.forName(chave);
		} catch (Exception e) {
			throw UtilComumRuntimeException.erroAoCriarInstancia(chave);
		}
		return classe;
	}

}
