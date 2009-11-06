/*
 * UtilConversorDeShortTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeShort;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeShort
 */
public class UtilConversorDeShortTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeShort#converterParaPrimitivo(java.lang.Short)}.
	 */
	@Test
	public final void testConverterParaPrimitivo() {
		Short s = new Short("45");
		short _s = UtilConversorDeShort.converterParaPrimitivo(s);
		assertEquals(45, _s);

		s = null;
		_s = UtilConversorDeShort.converterParaPrimitivo(s);
		assertEquals(0, _s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeShort#converterParaShortWrapper(short)}.
	 */
	@Test
	public final void testConverterParaShortWrapper() {
		short s = 45;
		Short _s = UtilConversorDeShort.converterParaShortWrapper(s);
		assertEquals(45, _s.shortValue());

		s = 0;
		_s = UtilConversorDeShort.converterParaShortWrapper(s);
		assertEquals(0, _s.shortValue());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeShort#converterParaString(java.lang.Short)}.
	 */
	@Test
	public final void testConverterParaStringShort() {
		Short i = new Short((short) 5);
		String s = UtilConversorDeShort.converterParaString(i);
		assertNotNull(s);
		assertEquals(i.toString(), s);

		i = null;
		s = UtilConversorDeShort.converterParaString(i);
		assertNull(s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeShort#converterParaString(short)}.
	 */
	@Test
	public final void testConverterParaStringShort1() {
		short i = 5;
		String s = UtilConversorDeShort.converterParaString(i);
		assertNotNull(s);
		assertEquals(String.valueOf(i), s);
	}

}
