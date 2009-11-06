/*
 * UtilValidadorDeStringComNumerosELetrasTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeStringComNumerosELetras;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeStringComNumerosELetras
 */
public class UtilValidadorDeStringComNumerosELetrasTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeStringComNumerosELetras#validar(java.lang.String)}.
	 */
	@Test
	public final void testValidar() {
		String s = null;

		boolean b = UtilValidadorDeStringComNumerosELetras.validar(s);
		assertFalse(b);

		s = "aa";
		b = UtilValidadorDeStringComNumerosELetras.validar(s);
		assertFalse(b);

		s = "99";
		b = UtilValidadorDeStringComNumerosELetras.validar(s);
		assertFalse(b);

		s = "a9";
		b = UtilValidadorDeStringComNumerosELetras.validar(s);
		assertTrue(b);
	}

}
