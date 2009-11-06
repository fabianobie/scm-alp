/*
 * UtilSomadoresDeNumeroTest.java
 * 
 * Data de cria��o: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.calculadores.UtilSomadoresDeNumero;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilSomadoresDeNumero
 */
public class UtilSomadoresDeNumeroTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testSomarIntegerInteger() {
		Integer x = getNumeroFactory().novoInteger(5);
		Integer y = getNumeroFactory().novoInteger(2);

		int r = UtilSomadoresDeNumero.somar(x, y);
		assertEquals(7, r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(java.lang.Integer, int)}.
	 */
	@Test
	public final void testSomarIntegerInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(int, int)}.
	 */
	@Test
	public final void testSomarIntInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(java.lang.Long, java.lang.Long)}.
	 */
	@Test
	public final void testSomarLongLong() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(java.lang.Long, long)}.
	 */
	@Test
	public final void testSomarLongLong1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(long, long)}.
	 */
	@Test
	public final void testSomarLongLong2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(java.lang.Double, java.lang.Double)}.
	 */
	@Test
	public final void testSomarDoubleDouble() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(java.lang.Double, double)}.
	 */
	@Test
	public final void testSomarDoubleDouble1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(double, double)}.
	 */
	@Test
	public final void testSomarDoubleDouble2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(java.lang.Float, java.lang.Float)}.
	 */
	@Test
	public final void testSomarFloatFloat() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(java.lang.Float, float)}.
	 */
	@Test
	public final void testSomarFloatFloat1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(float, float)}.
	 */
	@Test
	public final void testSomarFloatFloat2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeNumero#somar(Number, Number)}.
	 */
	@Test
	public final void testSomarNumberNumber() {
		Integer x = getNumeroFactory().novoInteger(345);
		Long y = getNumeroFactory().novoLong(5);
		long r = UtilSomadoresDeNumero.somar(x, y);
		assertEquals(r, 350L);
	}

}
