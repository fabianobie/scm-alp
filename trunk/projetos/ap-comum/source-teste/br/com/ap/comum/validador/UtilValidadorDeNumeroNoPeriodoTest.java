/*
 * UtilValidadorDeNumeroNoPeriodoTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeNumeroNoPeriodo;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeNumeroNoPeriodo
 */
public class UtilValidadorDeNumeroNoPeriodoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumeroNoPeriodo#validar(java.lang.Number, java.lang.Number, java.lang.Number)}.
	 */
	@Test
	public final void testValidar() {
		boolean b = UtilValidadorDeNumeroNoPeriodo.validar(new Integer(5),
				new Integer(2), new Integer(9));
		assertTrue(b);

		b = UtilValidadorDeNumeroNoPeriodo.validar(new Integer(5), new Integer(
				2), new Integer(4));
		assertFalse(b);
	}

}
