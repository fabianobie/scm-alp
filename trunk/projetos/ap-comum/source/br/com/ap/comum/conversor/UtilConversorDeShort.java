/*
 * UtilConversorDeShort.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos do tipo short.
 * 
 * @author adrianop
 */
public final class UtilConversorDeShort extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeShort() {
		// Construtor
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param _short Objeto que será convertido.
	 * @return tipo primitivo.
	 */
	public static short converterParaPrimitivo(Short _short) {
		Short res = (Short) getValorDefault(Short.class);

		if (isReferencia(_short)) {
			res = _short;
		}

		return res.shortValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param _short Objeto que será convertido.
	 * @return tipo wrapper.
	 */
	public static Short converterParaShortWrapper(short _short) {
		return getNumeroFactory().novoShort(_short);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _short Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(Short _short) {
		return UtilString.getString(_short);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _short Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(short _short) {
		return String.valueOf(_short);
	}
}
