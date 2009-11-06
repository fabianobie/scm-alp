/*
 * UtilConversorDeFloatTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeFloat;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeFloat
 */
public class UtilConversorDeFloatTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeFloat#converterParaPrimitivo(java.lang.Float)}.
	 */
	@Test
	public final void testConverterParaPrimitivo() {
		Float f = new Float(35.44);
		float _float = UtilConversorDeFloat.converterParaPrimitivo(f);
		assertEquals(35.44f, _float, Float.POSITIVE_INFINITY);

		f = null;
		_float = UtilConversorDeFloat.converterParaPrimitivo(f);
		assertEquals(0f, _float, Float.POSITIVE_INFINITY);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeFloat#converterParaFloatWrapper(float)}.
	 */
	@Test
	public final void testConverterParaFloatWrapper() {
		float f = 48.98f;
		Float wrapper = UtilConversorDeFloat.converterParaFloatWrapper(f);
		assertEquals(48.98f, wrapper.floatValue(), Float.POSITIVE_INFINITY);

		f = 0f;
		wrapper = UtilConversorDeFloat.converterParaFloatWrapper(f);
		assertEquals(0f, wrapper.floatValue(), Float.POSITIVE_INFINITY);

		f = 3;
		wrapper = UtilConversorDeFloat.converterParaFloatWrapper(f);
		assertEquals(3f, wrapper.floatValue(), Float.POSITIVE_INFINITY);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeFloat#converterParaString(java.lang.Float)}.
	 */
	@Test
	public final void testConverterParaStringFloat() {
		Float i = new Float(5f);
		String s = UtilConversorDeFloat.converterParaString(i);
		assertNotNull(s);
		assertEquals(i.toString(), s);

		i = null;
		s = UtilConversorDeFloat.converterParaString(i);
		assertNull(s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeFloat#converterParaString(float)}.
	 */
	@Test
	public final void testConverterParaStringFloat1() {
		float i = 5;
		String s = UtilConversorDeFloat.converterParaString(i);
		assertNotNull(s);
		assertEquals(String.valueOf(i), s);
	}

}
