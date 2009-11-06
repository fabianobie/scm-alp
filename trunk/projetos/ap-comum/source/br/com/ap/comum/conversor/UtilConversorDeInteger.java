/*
 * UtilConversorDeInteger.java
 * 
 * Data de cria��o: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos do tipo integer.
 * 
 * @author adrianop
 */
public final class UtilConversorDeInteger extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeInteger() {
		// Construtor.
	}

	/**
	 * Converte para o tipo primitivo, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param integer Objeto que ser� convertido.
	 * @return tipo primitivo.
	 */
	public static int converterParaPrimitivo(Integer integer) {
		Integer res = (Integer) getValorDefault(Integer.class);

		if (isReferencia(integer)) {
			res = integer;
		}

		return res.intValue();
	}

	/**
	 * Converte para o tipo wrapper, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param _int Objeto que ser� convertido.
	 * @return tipo wrapper.
	 */
	public static Integer converterParaInteger(int _int) {
		return getNumeroFactory().novoInteger(_int);
	}

	/**
	 * Converte para o tipo wrapper, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param _int Objeto que ser� convertido.
	 * @return tipo wrapper.
	 */
	public static Character converterParaCharacter(int _int) {
		return getStringFactory().novoCharacter((char) _int);
	}

	/**
	 * Converte para o tipo primitivo.
	 * 
	 * @param integer Inteiro que ser� convertida.
	 * @return tipo primitivo.
	 */
	public static long converterParaLong(Integer integer) {
		Long res = (Long) getValorDefault(Long.class);

		if (isReferencia(integer)) {
			res = getNumeroFactory().novoLong(integer.longValue());
		}
		return res.longValue();
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param integer Objeto que ser� convertido.
	 * @return string
	 */
	public static String converterParaString(Integer integer) {
		return UtilString.getString(integer);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _int Objeto que ser� convertido.
	 * @return string
	 */
	public static String converterParaString(int _int) {
		return String.valueOf(_int);
	}
}
