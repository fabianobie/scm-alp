/*
 * UtilConversorDeDouble.java
 * 
 * Data de criação: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.math.BigDecimal;

import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos do tipo double.
 * 
 * @author adrianop
 */
public final class UtilConversorDeDouble extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeDouble() {
		// Construtor.
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param _double Objeto que será convertido.
	 * @return tipo primitivo.
	 */
	public static double converterParaPrimitivo(Double _double) {
		Double res = (Double) getValorDefault(Double.class);

		if (isReferencia(_double)) {
			res = _double;
		}

		return res.doubleValue();
	}

	/**
	 * Converte para o tipo wrapper, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param _double Objeto que será convertido.
	 * @return tipo wrapper.
	 */
	public static Double converterParaDoubleWrapper(double _double) {
		return new Double(_double);
	}

	/**
	 * Converte o double para big decimal.
	 * 
	 * @param _double valor que será convertido.
	 * @return novo bigdecimal
	 */
	public static BigDecimal converterParaBigDecimal(Double _double) {
		BigDecimal res = null;

		if (isReferencia(_double)) {
			res = getNumeroFactory().novoBigDecimal(_double);
		}
		return res;
	}

	/**
	 * Converte o double para big decimal.
	 * 
	 * @param _double valor que será convertido.
	 * @return novo bigdecimal
	 */
	public static BigDecimal converterParaBigDecimal(double _double) {
		return getNumeroFactory().novoBigDecimal(_double);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _double Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(Double _double) {
		return UtilString.getString(_double);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _double Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(double _double) {
		return String.valueOf(_double);
	}

}
