/*
 * UtilConversorDeLong.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos do tipo long.
 * 
 * @author adrianop
 */
public final class UtilConversorDeLong extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeLong() {
		// Construtor
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param _long Objeto que será convertido.
	 * @return tipo primitivo.
	 */
	public static long converterParaPrimitivo(Long _long) {
		Long res = (Long) getValorDefault(Long.class);

		if (isReferencia(_long)) {
			res = _long;
		}

		return res.longValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param _long Objeto que será convertido.
	 * @return tipo wrapper.
	 */
	public static Long converterParaLongWrapper(long _long) {
		return getNumeroFactory().novoLong(_long);
	}

	/**
	 * Converte para o integer
	 * 
	 * @param _long Long que será convertido
	 * @return integer.
	 */
	public static Integer converterParaInteger(long _long) {
		return getNumeroFactory().novoInteger((int) _long);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _long Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(Long _long) {
		return UtilString.getString(_long);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _long Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(long _long) {
		return String.valueOf(_long);
	}
}
