/*
 * UtilValidadorDeEmailTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeEmail;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeEmail
 */
public class UtilValidadorDeEmailTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeEmail#validar(java.lang.String)}.
	 */
	@Test
	public final void testValidar() {
		String email = "xyz@gmail.com";
		boolean b = UtilValidadorDeEmail.validar(email);
		assertEquals(true, b);

		email = "xyz@abc";
		b = UtilValidadorDeEmail.validar(email);
		assertEquals(false, b);

		email = "xyz gmail.com";
		b = UtilValidadorDeEmail.validar(email);
		assertEquals(false, b);

		email = "xyz.gmail.com";
		b = UtilValidadorDeEmail.validar(email);
		assertEquals(false, b);

		email = "";
		b = UtilValidadorDeEmail.validar(email);
		assertEquals(false, b);

		email = null;
		b = UtilValidadorDeEmail.validar(email);
		assertEquals(false, b);
	}

}
