/*
 * UtilNumeroTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.numerico;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.numerico.UtilNumero;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilNumero
 */
public class UtilNumeroTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.numerico.UtilNumero#isInteiro(java.lang.String)}.
	 */
	@Test
	public final void testIsInteiro() {
		String s = "45";
		boolean _s = UtilNumero.isInteiro(s);

		assertTrue(_s);

		s = "45.5";
		_s = UtilNumero.isInteiro(s);
		assertFalse(_s);

		s = null;
		_s = UtilNumero.isInteiro(s);
		assertFalse(_s);

		s = "";
		_s = UtilNumero.isInteiro(s);
		assertFalse(_s);

		s = "aa";
		_s = UtilNumero.isInteiro(s);
		assertFalse(_s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.numerico.UtilNumero#isReal(java.lang.String)}.
	 */
	@Test
	public final void testIsReal() {
		String s = "45";
		boolean _s = UtilNumero.isReal(s);

		assertTrue(_s);

		s = "45,5";
		_s = UtilNumero.isReal(s);
		assertTrue(_s);

		s = null;
		_s = UtilNumero.isReal(s);
		assertFalse(_s);

		s = "";
		_s = UtilNumero.isReal(s);
		assertFalse(_s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.numerico.UtilNumero#getAleatorio(int)}.
	 */
	@Test
	public final void testGetAleatorioInt() {
		int faixaFinal = 10;
		int valor = 0;

		for (int i = 0; i < 300; i++) {
			valor = UtilNumero.getAleatorio(faixaFinal);
			assertTrue(valor >= 0);
			assertTrue(valor < 30);
		}

		faixaFinal = 0;
		valor = UtilNumero.getAleatorio(faixaFinal);
		assertEquals(0, valor);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.numerico.UtilNumero#getAleatorio(int, int)}.
	 */
	@Test
	public final void testGetAleatorioIntInt() {
		int faixaInicial = 5;
		int faixaFinal = 10;
		int valor = 0;

		for (int i = 0; i < 300; i++) {
			valor = UtilNumero.getAleatorio(faixaInicial, faixaFinal);
			assertTrue(valor > faixaInicial);
			assertTrue(valor <= faixaFinal);
		}

		faixaInicial = 10;
		faixaFinal = 5;
		valor = UtilNumero.getAleatorio(faixaInicial, faixaFinal);
		assertEquals(0, valor);
	}

}
