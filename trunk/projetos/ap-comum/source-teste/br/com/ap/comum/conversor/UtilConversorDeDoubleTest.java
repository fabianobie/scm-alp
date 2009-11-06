/*
 * UtilConversorDeDoubleTest.java
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
import br.com.ap.comum.conversor.UtilConversorDeDouble;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeDouble
 */
public class UtilConversorDeDoubleTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeDouble#converterParaPrimitivo(java.lang.Double)}.
	 */
	@Test
	public final void testConverterParaPrimitivo() {
		Double d = new Double(35.44);

		double _double = UtilConversorDeDouble.converterParaPrimitivo(d);
		assertEquals(35.44d, _double, Double.POSITIVE_INFINITY);

		d = null;
		_double = UtilConversorDeDouble.converterParaPrimitivo(d);
		assertEquals(0d, _double, Double.POSITIVE_INFINITY);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeDouble#converterParaDoubleWrapper(double)}.
	 */
	@Test
	public final void testConverterParaDoubleWrapper() {
		double d = 35.44d;

		Double _double = UtilConversorDeDouble.converterParaDoubleWrapper(d);
		assertEquals(new Double(35.44), _double);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeDouble#converterParaBigDecimal(java.lang.Double)}.
	 */
	@Test
	public final void testConverterParaBigDecimalDouble() {
		Double d = new Double(35.6d);
		BigDecimal bd = UtilConversorDeDouble.converterParaBigDecimal(d);
		assertNotNull(bd);

		assertEquals(d.doubleValue(), bd.doubleValue(), Double.MAX_VALUE);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeDouble#converterParaBigDecimal(double)}.
	 */
	@Test
	public final void testConverterParaBigDecimalDouble1() {
		double d = 35.6d;
		BigDecimal bd = UtilConversorDeDouble.converterParaBigDecimal(d);
		assertNotNull(bd);

		assertEquals(d, bd.doubleValue(), Double.MAX_VALUE);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeDouble#converterParaString(java.lang.Double)}.
	 */
	@Test
	public final void testConverterParaStringDouble() {
		Double i = new Double(3.5);
		String s = UtilConversorDeDouble.converterParaString(i);
		assertNotNull(s);
		assertEquals(i.toString(), s);

		i = null;
		s = UtilConversorDeDouble.converterParaString(i);
		assertNull(s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeDouble#converterParaString(double)}.
	 */
	@Test
	public final void testConverterParaStringDouble1() {
		double i = 3.5;
		String s = UtilConversorDeDouble.converterParaString(i);
		assertNotNull(s);
		assertEquals(String.valueOf(i), s);
	}

}
