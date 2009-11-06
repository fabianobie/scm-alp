/*
 * UtilValidadorDeHoraTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeHora;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeHora
 */
public class UtilValidadorDeHoraTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeHora#validar(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testValidarStringString() {
		String hora = "12:35:55";
		String pattern = "hh:mm:ss";
		boolean b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(true, b);

		hora = "12:35";
		pattern = "hh:mm:ss";
		b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(false, b);

		hora = "12:35:33";
		pattern = "hh:mm";
		b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(true, b);

		hora = "";
		pattern = "hh:mm:ss";
		b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(false, b);

		hora = "12:35";
		pattern = "";
		b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(false, b);

		hora = null;
		pattern = "hh:mm:ss";
		b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(false, b);

		hora = "12:35";
		pattern = null;
		b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(false, b);

		hora = "";
		pattern = "";
		b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(false, b);

		hora = null;
		pattern = null;
		b = UtilValidadorDeHora.validar(hora, pattern);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeHora#validar(java.lang.String)}.
	 */
	@Test
	public final void testValidarString() {
		String hora = "12:35";
		boolean b = UtilValidadorDeHora.validar(hora);
		assertEquals(true, b);

		hora = "1235";
		b = UtilValidadorDeHora.validar(hora);
		assertEquals(false, b);

		hora = "28:46";
		b = UtilValidadorDeHora.validar(hora);
		assertEquals(false, b);

		hora = "28:35";
		b = UtilValidadorDeHora.validar(hora);
		assertEquals(false, b);

		hora = "12:99";
		b = UtilValidadorDeHora.validar(hora);
		assertEquals(false, b);

		hora = "abc";
		b = UtilValidadorDeHora.validar(hora);
		assertEquals(false, b);

		hora = "";
		b = UtilValidadorDeHora.validar(hora);
		assertEquals(false, b);

		hora = null;
		b = UtilValidadorDeHora.validar(hora);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeHora#validar_HHmm(java.lang.String)}.
	 */
	@Test
	public final void testValidar_HHmm() {
		String hora = "14:35";
		boolean b = UtilValidadorDeHora.validar_HHmm(hora);
		assertEquals(true, b);

		hora = "1235";
		b = UtilValidadorDeHora.validar_HHmm(hora);
		assertEquals(false, b);

		hora = "28:46";
		b = UtilValidadorDeHora.validar_HHmm(hora);
		assertEquals(false, b);

		hora = "28:35";
		b = UtilValidadorDeHora.validar_HHmm(hora);
		assertEquals(false, b);

		hora = "15:99";
		b = UtilValidadorDeHora.validar_HHmm(hora);
		assertEquals(false, b);

		hora = "abc";
		b = UtilValidadorDeHora.validar_HHmm(hora);
		assertEquals(false, b);

		hora = "";
		b = UtilValidadorDeHora.validar_HHmm(hora);
		assertEquals(false, b);

		hora = null;
		b = UtilValidadorDeHora.validar_HHmm(hora);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeHora#validar_hhmmss(java.lang.String)}.
	 */
	@Test
	public final void testValidar_hhmmss() {
		String hora = "10:35:16";
		boolean b = UtilValidadorDeHora.validar_hhmmss(hora);
		assertEquals(true, b);

		hora = "123516";
		b = UtilValidadorDeHora.validar_hhmmss(hora);
		assertEquals(false, b);

		hora = "28:46:16";
		b = UtilValidadorDeHora.validar_hhmmss(hora);
		assertEquals(false, b);

		hora = "28:35:16";
		b = UtilValidadorDeHora.validar_hhmmss(hora);
		assertEquals(false, b);

		hora = "10:99:16";
		b = UtilValidadorDeHora.validar_hhmmss(hora);
		assertEquals(false, b);

		hora = "abc";
		b = UtilValidadorDeHora.validar_hhmmss(hora);
		assertEquals(false, b);

		hora = "";
		b = UtilValidadorDeHora.validar_hhmmss(hora);
		assertEquals(false, b);

		hora = null;
		b = UtilValidadorDeHora.validar_hhmmss(hora);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeHora#validar_HHmmss(java.lang.String)}.
	 */
	@Test
	public final void testValidar_HHmmss() {
		String hora = "14:35:16";
		boolean b = UtilValidadorDeHora.validar_HHmmss(hora);
		assertEquals(true, b);

		hora = "123516";
		b = UtilValidadorDeHora.validar_HHmmss(hora);
		assertEquals(false, b);

		hora = "28:46:16";
		b = UtilValidadorDeHora.validar_HHmmss(hora);
		assertEquals(false, b);

		hora = "28:35:16";
		b = UtilValidadorDeHora.validar_HHmmss(hora);
		assertEquals(false, b);

		hora = "14:99:16";
		b = UtilValidadorDeHora.validar_HHmmss(hora);
		assertEquals(false, b);

		hora = "abc";
		b = UtilValidadorDeHora.validar_HHmmss(hora);
		assertEquals(false, b);

		hora = "";
		b = UtilValidadorDeHora.validar_HHmmss(hora);
		assertEquals(false, b);

		hora = null;
		b = UtilValidadorDeHora.validar_HHmmss(hora);
		assertEquals(false, b);
	}

}
