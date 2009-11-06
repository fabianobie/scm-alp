/*
 * UtilValidadorDeDataTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeData;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeData
 */
public class UtilValidadorDeDataTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeData#validar(java.lang.String)}.
	 */
	@Test
	public final void testValidarString() {
		String data = "17/06/1986";
		boolean b = UtilValidadorDeData.validar(data);
		assertEquals(true, b);

		data = "17061986";
		b = UtilValidadorDeData.validar(data);
		assertEquals(false, b);

		data = "";
		b = UtilValidadorDeData.validar(data);
		assertEquals(false, b);

		data = null;
		b = UtilValidadorDeData.validar(data);
		assertEquals(false, b);

		data = "abc";
		b = UtilValidadorDeData.validar(data);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeData#validar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testValidarStringString() {
		String data = "17/06/1986 12:35";
		String pattern = "dd/MM/yyyy";
		boolean b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(true, b);

		data = "17/06/1986";
		pattern = "dd/MM/yyyy hh:mm";
		b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(false, b);

		data = "17/06/1986";
		pattern = "";
		b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(false, b);

		data = "17/06/1986";
		pattern = null;
		b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(false, b);

		data = "";
		pattern = "dd/MM/yyyy hh:mm";
		b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(false, b);

		data = null;
		pattern = "dd/MM/yyyy hh:mm";
		b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(false, b);

		data = "";
		pattern = "";
		b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(false, b);

		data = null;
		pattern = "";
		b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(false, b);

		data = "";
		pattern = null;
		b = UtilValidadorDeData.validar(data, pattern);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeData#validar_MMyyyy(java.lang.String)}.
	 */
	@Test
	public final void testValidar_MMyyyy() {
		String data = "06/1986";

		boolean b = UtilValidadorDeData.validar_MMyyyy(data);
		assertTrue(b);

		data = "25/2000";
		b = UtilValidadorDeData.validar_MMyyyy(data);
		assertFalse(b);

		data = "";
		b = UtilValidadorDeData.validar_MMyyyy(data);
		assertFalse(b);

		data = null;
		b = UtilValidadorDeData.validar_MMyyyy(data);
		assertFalse(b);
	}

}
