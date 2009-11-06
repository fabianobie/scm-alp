/*
 * UtilConversorDeLongTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeLong;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeLong
 */
public class UtilConversorDeLongTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeLong#converterParaPrimitivo(java.lang.Long)}.
	 */
	@Test
	public final void testConverterParaPrimitivo() {
		Long l = new Long(45);
		long _l = UtilConversorDeLong.converterParaPrimitivo(l);
		assertEquals(45L, _l);

		l = null;
		_l = UtilConversorDeLong.converterParaPrimitivo(l);
		assertEquals(0L, _l);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeLong#converterParaLongWrapper(long)}.
	 */
	@Test
	public final void testConverterParaLongWrapper() {
		long l = 56L;
		Long _l = UtilConversorDeLong.converterParaLongWrapper(l);
		assertEquals(new Long(56L), _l);

		l = 0;
		_l = UtilConversorDeLong.converterParaLongWrapper(l);
		assertEquals(new Long(0), _l);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeLong#converterParaInteger(long)}.
	 */
	@Test
	public final void testConverterParaInteger() {
		long l = 35L;
		Integer i = UtilConversorDeLong.converterParaInteger(l);
		assertEquals(l, i.longValue());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeLong#converterParaString(java.lang.Long)}.
	 */
	@Test
	public final void testConverterParaStringLong() {
		Long i = new Long(5L);
		String s = UtilConversorDeLong.converterParaString(i);
		assertNotNull(s);
		assertEquals(i.toString(), s);

		i = null;
		s = UtilConversorDeLong.converterParaString(i);
		assertNull(s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeLong#converterParaString(long)}.
	 */
	@Test
	public final void testConverterParaStringLong1() {
		long i = 5L;
		String s = UtilConversorDeLong.converterParaString(i);
		assertNotNull(s);
		assertEquals(String.valueOf(i), s);
	}

}
