/*
 * UtilCalculadoresAbstrato.java
 * 
 * Data de criação: 29/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.objeto.UtilPrimitivo;

/**
 * Classe abstrata que provê recursos às classes que manipulam calculo.
 * 
 * @author AdrianoP
 */
public abstract class UtilCalculadoresAbstrato {

	/**
	 * Retorna o int do objeto Integer.
	 * 
	 * @param valor Integer
	 * @return int
	 */
	protected static int getInt(Integer valor) {
		return (isReferencia(valor) ? valor.intValue() : 0);
	}

	/**
	 * Retorna o long do objeto Long.
	 * 
	 * @param valor Long
	 * @return long
	 */
	protected static long getLong(Long valor) {
		return (isReferencia(valor) ? valor.longValue() : 0L);
	}

	/**
	 * Retorna o double do objeto Double.
	 * 
	 * @param valor Double
	 * @return double
	 */
	protected static double getDouble(Double valor) {
		return (isReferencia(valor) ? valor.doubleValue() : 0.0d);
	}

	/**
	 * Retorna a string do double.
	 * 
	 * @param valor Valor
	 * @return string do valor.
	 */
	protected static String getString(double valor) {
		return String.valueOf(valor);
	}

	/**
	 * Retorna a string do float.
	 * 
	 * @param valor Valor
	 * @return string do valor.
	 */
	protected static String getString(float valor) {
		return String.valueOf(valor);
	}

	/**
	 * Retorna a string do double.
	 * 
	 * @param valor Valor
	 * @return string do valor.
	 */
	protected static String getString(Double valor) {
		if (!isReferencia(valor)) {
			valor = (Double) getValorDefault(Double.class);
		}
		return String.valueOf(valor);
	}

	/**
	 * Retorna a string do double.
	 * 
	 * @param valor Valor
	 * @return string do valor.
	 */
	protected static String getString(Float valor) {
		if (!isReferencia(valor)) {
			valor = (Float) getValorDefault(Float.class);
		}
		return String.valueOf(valor);
	}

	/**
	 * Retorna novo bigdecimal.
	 * 
	 * @param valor Valor
	 * @return big decimal.
	 */
	protected static BigDecimal novoBigDecimal(double valor) {
		String string = getString(valor);
		return getNumeroFactory().novoBigDecimal(string);
	}

	/**
	 * Retorna novo bigdecimal.
	 * 
	 * @param valor Valor
	 * @return big decimal.
	 */
	protected static BigDecimal novoBigDecimal(float valor) {
		String string = getString(valor);
		return getNumeroFactory().novoBigDecimal(string);
	}

	/**
	 * Retorna novo bigdecimal.
	 * 
	 * @param valor Valor
	 * @return big decimal.
	 */
	protected static BigDecimal novoBigDecimal(Double valor) {
		String string = getString(valor);
		return getNumeroFactory().novoBigDecimal(string);
	}

	/**
	 * Retorna novo bigdecimal.
	 * 
	 * @param valor Valor
	 * @return big decimal.
	 */
	protected static BigDecimal novoBigDecimal(Float valor) {
		String string = getString(valor);
		return getNumeroFactory().novoBigDecimal(string);
	}

	/**
	 * Retorna novo double.
	 * 
	 * @param valor Valor
	 * @return double
	 */
	protected static Double novoDouble(double valor) {
		return getNumeroFactory().novoDouble(valor);
	}

	/**
	 * Retorna novo float.
	 * 
	 * @param valor Valor
	 * @return float
	 */
	protected static Float novoFloat(float valor) {
		return getNumeroFactory().novoFloat(valor);
	}

	/**
	 * Retorna novo long.
	 * 
	 * @param valor Valor
	 * @return long
	 */
	@SuppressWarnings("boxing")
	protected static Long novoLong(Number valor) {
		Long resultado = getNumeroFactory().novoLong(0);
		if (isReferencia(valor)) {
			resultado = valor.longValue();
		}
		return resultado;
	}

	/**
	 * Retorna o valor default do tipo passado por parâmetro.
	 * 
	 * @param tipo Tipo de objeto.
	 * @return valor default do tipo passado por parâmetro.
	 * @see UtilPrimitivo#getValorDefault(Class)
	 */
	protected static Object getValorDefault(Class<?> tipo) {
		return UtilPrimitivo.getValorDefault(tipo);
	}

	/**
	 * @return fábrica de números.
	 */
	protected static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * @param data Data que atualizará o calendar.
	 * @return novo calendar.
	 * @see DataFactory#novoCalendar(Date)
	 */
	protected static Calendar novoCalendar(Date data) {
		return getDataFactory().novoCalendar(data);
	}

	/**
	 * @return intância de DataFactory.
	 */
	protected static DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto tiver referência.
	 */
	protected static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto0 Objeto validado.
	 * @param objeto1 Objeto validado.
	 * @return true se o objeto tiver referência.
	 */
	protected static boolean isReferencia(Object objeto0, Object objeto1) {
		return UtilObjeto.isReferencia(objeto0, objeto1);
	}
}
