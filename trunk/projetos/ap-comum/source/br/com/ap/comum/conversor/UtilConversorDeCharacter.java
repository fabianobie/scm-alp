/*
 * UtilConversorDeCharacter.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos do tipo Character.
 * 
 * @author adrianop
 */
public final class UtilConversorDeCharacter extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeCharacter() {
		// Construtor
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param character Objeto que será convertido.
	 * @return tipo primitivo.
	 */
	public static char converterParaPrimitivo(Character character) {
		Character res = (Character) getValorDefault(Character.class);

		if (isReferencia(character)) {
			res = character;
		}

		return res.charValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param _char Objeto que será convertido.
	 * @return tipo wrapper.
	 */
	public static Character converterParaCharacter(char _char) {
		return new Character(_char);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param character Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(Character character) {
		return UtilString.getString(character);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _char Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(char _char) {
		return String.valueOf(_char);
	}
}
