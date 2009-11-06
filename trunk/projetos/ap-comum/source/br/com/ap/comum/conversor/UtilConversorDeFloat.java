/*
 * UtilConversorDeFloat.java
 * 
 * Data de cria��o: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos do tipo float.
 * 
 * @author adrianop
 */
public final class UtilConversorDeFloat extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeFloat() {
		// Construtor
	}

	/**
	 * Converte para o tipo primitivo, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param _float Objeto que ser� convertido.
	 * @return tipo primitivo.
	 */
	public static float converterParaPrimitivo(Float _float) {
		Float res = (Float) getValorDefault(Float.class);

		if (isReferencia(_float)) {
			res = _float;
		}

		return res.floatValue();
	}

	/**
	 * Converte para o tipo wrapper, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param _float Objeto que ser� convertido.
	 * @return tipo wrapper.
	 */
	public static Float converterParaFloatWrapper(float _float) {
		return getNumeroFactory().novoFloat(_float);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _float Objeto que ser� convertido.
	 * @return string
	 */
	public static String converterParaString(Float _float) {
		return UtilString.getString(_float);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _float Objeto que ser� convertido.
	 * @return string
	 */
	public static String converterParaString(float _float) {
		return String.valueOf(_float);
	}
}
