/*
 * UtilDivisoresDeNumeroTest.java
 * 
 * Data de cria��o: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.calculadores.UtilDivisoresDeNumero;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilDivisoresDeNumero
 */
@SuppressWarnings("boxing")
public class UtilDivisoresDeNumeroTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testDividirIntegerInteger() {
		Integer x = getNumeroFactory().novoInteger(10);
		Integer y = getNumeroFactory().novoInteger(2);

		double r = UtilDivisoresDeNumero.dividir(x, y);
		assertEquals(5.0, r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(java.lang.Integer, int)}.
	 */
	@Test
	public final void testDividirIntegerInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(int, int)}.
	 */
	@Test
	public final void testDividirIntInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(java.lang.Long, java.lang.Long)}.
	 */
	@Test
	public final void testDividirLongLong() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(java.lang.Long, long)}.
	 */
	@Test
	public final void testDividirLongLong1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(long, long)}.
	 */
	@Test
	public final void testDividirLongLong2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(java.lang.Double, java.lang.Double)}.
	 */
	@Test
	public final void testDividirDoubleDouble() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(java.lang.Double, double)}.
	 */
	@Test
	public final void testDividirDoubleDouble1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(double, double)}.
	 */
	@Test
	public final void testDividirDoubleDouble2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(java.lang.Float, java.lang.Float)}.
	 */
	@Test
	public final void testDividirFloatFloat() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(java.lang.Float, float)}.
	 */
	@Test
	public final void testDividirFloatFloat1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#dividir(float, float)}.
	 */
	@Test
	public final void testDividirFloatFloat2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testRestoIntegerInteger() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(java.lang.Integer, int)}.
	 */
	@Test
	public final void testRestoIntegerInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(int, int)}.
	 */
	@Test
	public final void testRestoIntInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(java.lang.Long, java.lang.Long)}.
	 */
	@Test
	public final void testRestoLongLong() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(java.lang.Long, long)}.
	 */
	@Test
	public final void testRestoLongLong1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(long, long)}.
	 */
	@Test
	public final void testRestoLongLong2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(java.lang.Double, java.lang.Double)}.
	 */
	@Test
	public final void testRestoDoubleDouble() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(java.lang.Double, double)}.
	 */
	@Test
	public final void testRestoDoubleDouble1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilDivisoresDeNumero#resto(double, double)}.
	 */
	@Test
	public final void testRestoDoubleDouble2() {
		// Desnecess�rio
	}

}
