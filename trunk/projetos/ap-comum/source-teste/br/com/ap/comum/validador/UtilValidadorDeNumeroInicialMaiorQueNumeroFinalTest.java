/*
 * UtilValidadorDeNumeroInicialMaiorQueNumeroFinalTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeNumeroInicialMaiorQueNumeroFinal;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeNumeroInicialMaiorQueNumeroFinal
 */
public class UtilValidadorDeNumeroInicialMaiorQueNumeroFinalTest extends
		TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumeroInicialMaiorQueNumeroFinal#validar(java.lang.Number, java.lang.Number)}.
	 */
	@Test
	public final void testValidar() {
		Integer inicio = new Integer(5);
		Integer fim = new Integer(3);
		boolean resultado = false;

		resultado = UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.validar(
				inicio, fim);
		assertTrue(resultado);

		fim = new Integer(8);
		resultado = UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.validar(
				inicio, fim);

		inicio = null;
		fim = null;
		resultado = UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.validar(
				inicio, fim);
		assertFalse(resultado);
	}

}
