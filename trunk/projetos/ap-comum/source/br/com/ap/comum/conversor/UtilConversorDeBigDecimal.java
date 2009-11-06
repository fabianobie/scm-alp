/*
 * UtilConversorDeBigDecimal.java
 * 
 * Data de cria��o: 18/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.math.BigDecimal;

/**
 * Conversor de objetos do tipo BigDecimal.
 * 
 * @author adrianop
 */
public final class UtilConversorDeBigDecimal extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeBigDecimal() {
		// Construtor.
	}

	/**
	 * Converte para o tipo int, se n�o for poss�vel efetuar a convers�o o valor
	 * default do tipo ser� retornado.
	 * 
	 * @param bigDecimal BigDecimal que ser� convertido.
	 * @return tipo int.
	 */
	public static int converterParaInt(BigDecimal bigDecimal) {
		Integer res = (Integer) getValorDefault(Integer.class);

		if (isReferencia(bigDecimal)) {
			res = novoInteger(bigDecimal.intValue());
		}

		return res.intValue();
	}

	/**
	 * Converte para o tipo Integer, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param bigDecimal BigDecimal que ser� convertido.
	 * @return tipo Integer.
	 */
	public static Integer converterParaInteger(BigDecimal bigDecimal) {
		Integer res = (Integer) getValorDefault(Integer.class);

		if (isReferencia(bigDecimal)) {
			res = novoInteger(bigDecimal.intValue());
		}

		return res;
	}

	/**
	 * Converte para o tipo long, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param bigDecimal BigDecimal que ser� convertido.
	 * @return tipo long.
	 */
	public static long converterParaLong(BigDecimal bigDecimal) {
		Long res = (Long) getValorDefault(Long.class);

		if (isReferencia(bigDecimal)) {
			res = novoLong(bigDecimal.longValue());
		}

		return res.longValue();
	}

	/**
	 * Converte para o tipo Long, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param bigDecimal BigDecimal que ser� convertido.
	 * @return tipo Long.
	 */
	public static Long converterParaLongWrapper(BigDecimal bigDecimal) {
		Long res = (Long) getValorDefault(Long.class);

		if (isReferencia(bigDecimal)) {
			res = novoLong(bigDecimal.longValue());
		}

		return res;
	}

	/**
	 * Converte para o tipo float, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param bigDecimal BigDecimal que ser� convertido.
	 * @return tipo float.
	 */
	public static float converterParaFloat(BigDecimal bigDecimal) {
		Float res = (Float) getValorDefault(Float.class);

		if (isReferencia(bigDecimal)) {
			res = novoFloat(bigDecimal.floatValue());
		}

		return res.floatValue();
	}

	/**
	 * Converte para o tipo Float, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param bigDecimal BigDecimal que ser� convertido.
	 * @return tipo Float.
	 */
	public static Float converterParaFloatWrapper(BigDecimal bigDecimal) {
		Float res = (Float) getValorDefault(Float.class);

		if (isReferencia(bigDecimal)) {
			res = novoFloat(bigDecimal.floatValue());
		}

		return res;
	}

	/**
	 * Converte para o tipo double, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param bigDecimal BigDecimal que ser� convertido.
	 * @return tipo double.
	 */
	public static double converterParaDouble(BigDecimal bigDecimal) {
		Double res = (Double) getValorDefault(Double.class);

		if (isReferencia(bigDecimal)) {
			res = novoDouble(bigDecimal.doubleValue());
		}

		return res.doubleValue();
	}

	/**
	 * Converte para o tipo Double, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param bigDecimal BigDecimal que ser� convertido.
	 * @return tipo Double.
	 */
	public static Double converterParaDoubleWrapper(BigDecimal bigDecimal) {
		Double res = (Double) getValorDefault(Double.class);

		if (isReferencia(bigDecimal)) {
			res = novoDouble(bigDecimal.doubleValue());
		}

		return res;
	}
}
