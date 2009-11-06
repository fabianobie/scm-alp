/*
 * UtilValidadorDeRealTest.java
 * 
 * Data de criação: Jul 4, 2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeReal;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilValidadorDeReal
 */
public class UtilValidadorDeRealTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeReal#validar(java.lang.String)}.
	 */
	@Test
	public final void testValidarString() {
		String i = "45.445,43";
		boolean b = UtilValidadorDeReal.validar(i);
		assertTrue(b);

		i = "45.9";
		b = UtilValidadorDeReal.validar(i);
		assertTrue(b);

		i = "ab";
		b = UtilValidadorDeReal.validar(i);
		assertEquals(false, b);

		i = "";
		b = UtilValidadorDeReal.validar(i);
		assertEquals(false, b);

		i = null;
		b = UtilValidadorDeReal.validar(i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeReal#validar(java.lang.String, int)}.
	 */
	@Test
	public final void testValidarStringInt() {
		String i = "45.445,43";
		boolean b = UtilValidadorDeReal.validar(i, 2);
		assertTrue(b);

		i = "45,334";
		b = UtilValidadorDeReal.validar(i, 2);
		assertFalse(b);

		i = "ab";
		b = UtilValidadorDeReal.validar(i, 2);
		assertEquals(false, b);

		i = "";
		b = UtilValidadorDeReal.validar(i, 2);
		assertEquals(false, b);

		i = null;
		b = UtilValidadorDeReal.validar(i, 2);
		assertEquals(false, b);
	}

}
