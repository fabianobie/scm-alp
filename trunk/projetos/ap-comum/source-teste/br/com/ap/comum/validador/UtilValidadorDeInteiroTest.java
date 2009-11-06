/*
 * UtilValidadorDeInteiroTest.java
 * 
 * Data de criação: Jul 4, 2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeInteiro;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeInteiro
 */
public class UtilValidadorDeInteiroTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeInteiro#validar(java.lang.String)}.
	 */
	@Test
	public final void testValidar() {
		String i = "45";
		boolean b = UtilValidadorDeInteiro.validar(i);
		assertEquals(true, b);

		i = "45.9";
		b = UtilValidadorDeInteiro.validar(i);
		assertEquals(false, b);

		i = "ab";
		b = UtilValidadorDeInteiro.validar(i);
		assertEquals(false, b);

		i = "";
		b = UtilValidadorDeInteiro.validar(i);
		assertEquals(false, b);

		i = null;
		b = UtilValidadorDeInteiro.validar(i);
		assertEquals(false, b);
	}

}
