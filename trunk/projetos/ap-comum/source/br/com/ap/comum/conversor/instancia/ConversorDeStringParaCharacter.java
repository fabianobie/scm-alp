/*
 * ConversorDeStringParaCharacter.java
 * 
 * Data de cria��o: 03/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.excecao.ConversorException;

/**
 * Conversor de String para character.
 * 
 * @author adrianop
 */
public class ConversorDeStringParaCharacter extends
		ConversorAbstrato<String, Character> {

	/**
	 * @param objeto Objeto
	 * @return Objeto resultado da compara��o
	 * @throws ConversorException Exce��o de convers�o
	 * @see br.com.ap.comum.conversor.instancia.IConversor#converter(java.lang.Object)
	 */
	public Character converter(String objeto) throws ConversorException {
		Character res = null;

		if (isReferencia(objeto)) {
			res = UtilConversorDeString.converterParaCharacter(objeto);
		}

		return res;
	}

}
