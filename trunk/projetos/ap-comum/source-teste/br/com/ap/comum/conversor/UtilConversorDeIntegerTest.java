/*
 * UtilConversorDeIntegerTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeInteger;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeInteger
 */
public class UtilConversorDeIntegerTest extends TesteAbstrato{

	/**
	 * Test method for {@link br.com.ap.comum.conversor.UtilConversorDeInteger#converterParaPrimitivo(java.lang.Integer)}.
	 */
	@Test
	public final void testConverterParaPrimitivo() {
		Integer i = new Integer(15);
		int _i = UtilConversorDeInteger.converterParaPrimitivo(i);
		assertEquals(15, _i);
		
		i = null;
		_i = UtilConversorDeInteger.converterParaPrimitivo(i);
		assertEquals(0, _i);
	}

	/**
	 * Test method for {@link br.com.ap.comum.conversor.UtilConversorDeInteger#converterParaInteger(int)}.
	 */
	@Test
	public final void testConverterParaInteger() {
		int i = 89;
		Integer _i = UtilConversorDeInteger.converterParaInteger(i);
		assertEquals(new Integer(89), _i);
		
		i = 0;
		_i = UtilConversorDeInteger.converterParaInteger(i);
		assertEquals(new Integer(0), _i);
	}

	/**
	 * Test method for {@link br.com.ap.comum.conversor.UtilConversorDeInteger#converterParaCharacter(int)}.
	 */
	@Test
	public final void testConverterParaCharacter() {
		int i = 97;
		Character s = UtilConversorDeInteger.converterParaCharacter(i);
		assertNotNull(s);
		assertEquals("a", s.toString());
	}

	/**
	 * Test method for {@link br.com.ap.comum.conversor.UtilConversorDeInteger#converterParaLong(java.lang.Integer)}.
	 */
	@Test
	public final void testConverterParaLong() {
		Integer i = getNumeroFactory().novoInteger(97);
		long s = UtilConversorDeInteger.converterParaLong(i);
		assertEquals(s, i.longValue());
	}

	/**
	 * Test method for {@link br.com.ap.comum.conversor.UtilConversorDeInteger#converterParaString(java.lang.Integer)}.
	 */
	@Test
	public final void testConverterParaStringInteger() {
		Integer i = new Integer(5);
		String s = UtilConversorDeInteger.converterParaString(i);
		assertNotNull(s);
		assertEquals(i.toString(), s);
		
		i = null;
		s = UtilConversorDeInteger.converterParaString(i);
		assertNull(s);
	}

	/**
	 * Test method for {@link br.com.ap.comum.conversor.UtilConversorDeInteger#converterParaString(int)}.
	 */
	@Test
	public final void testConverterParaStringInt() {
		int i = 5;
		String s = UtilConversorDeInteger.converterParaString(i);
		assertNotNull(s);
		assertEquals(String.valueOf(i), s);
	}

}
