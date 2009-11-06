/*
 * UtilConversorDeBigDecimalTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeBigDecimal;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeBigDecimal
 */
public class UtilConversorDeBigDecimalTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBigDecimal#converterParaInt(java.math.BigDecimal)}.
	 */
	@Test
	public final void testConverterParaInt() {
		BigDecimal bd = new BigDecimal(35.44);

		int _int = UtilConversorDeBigDecimal.converterParaInt(bd);
		assertEquals(35, _int);

		_int = UtilConversorDeBigDecimal.converterParaInt(null);
		assertEquals(0, _int);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBigDecimal#converterParaInteger(java.math.BigDecimal)}.
	 */
	@Test
	public final void testConverterParaInteger() {
		BigDecimal bd = new BigDecimal(35.44);

		Integer integer = UtilConversorDeBigDecimal.converterParaInteger(bd);
		assertEquals(new Integer(35), integer);

		integer = UtilConversorDeBigDecimal.converterParaInteger(null);
		assertEquals(new Integer(0), integer);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBigDecimal#converterParaLong(java.math.BigDecimal)}.
	 */
	@Test
	public final void testConverterParaLong() {
		BigDecimal bd = new BigDecimal(35.44);

		long _long = UtilConversorDeBigDecimal.converterParaLong(bd);
		assertEquals(35L, _long);

		_long = UtilConversorDeBigDecimal.converterParaLong(null);
		assertEquals(0L, _long);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBigDecimal#converterParaLongWrapper(java.math.BigDecimal)}.
	 */
	@Test
	public final void testConverterParaLongWrapper() {
		BigDecimal bd = new BigDecimal(35.44);

		Long _long = UtilConversorDeBigDecimal.converterParaLongWrapper(bd);
		assertEquals(new Long(35), _long);

		_long = UtilConversorDeBigDecimal.converterParaLongWrapper(null);
		assertEquals(new Long(0), _long);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBigDecimal#converterParaFloat(java.math.BigDecimal)}.
	 */
	@Test
	public final void testConverterParaFloat() {
		BigDecimal bd = new BigDecimal(35.44);

		float _float = UtilConversorDeBigDecimal.converterParaFloat(bd);
		assertEquals(35f, _float, Float.POSITIVE_INFINITY);

		_float = UtilConversorDeBigDecimal.converterParaFloat(null);
		assertEquals(0f, _float, Float.POSITIVE_INFINITY);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBigDecimal#converterParaFloatWrapper(java.math.BigDecimal)}.
	 */
	@Test
	public final void testConverterParaFloatWrapper() {
		BigDecimal bd = new BigDecimal(35.44);

		Float _float = UtilConversorDeBigDecimal.converterParaFloatWrapper(bd);
		assertEquals(new Float(35.44f), _float);

		_float = UtilConversorDeBigDecimal.converterParaFloatWrapper(null);
		assertEquals(new Float(0f), _float);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBigDecimal#converterParaDouble(java.math.BigDecimal)}.
	 */
	@Test
	public final void testConverterParaDouble() {
		BigDecimal bd = new BigDecimal(35.44);

		double _double = UtilConversorDeBigDecimal.converterParaDouble(bd);
		assertEquals(35.44d, _double, Double.POSITIVE_INFINITY);

		_double = UtilConversorDeBigDecimal.converterParaDouble(bd);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBigDecimal#converterParaDoubleWrapper(java.math.BigDecimal)}.
	 */
	@Test
	public final void testConverterParaDoubleWrapper() {
		BigDecimal bd = new BigDecimal(35.44);

		Double _double = UtilConversorDeBigDecimal
				.converterParaDoubleWrapper(bd);
		assertEquals(new Double(35.44d), _double);

		_double = UtilConversorDeBigDecimal.converterParaDoubleWrapper(null);
		assertEquals(new Double(0d), _double);
	}

}
