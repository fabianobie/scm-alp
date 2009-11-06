/*
 * UtilMultiplicadoresDeNumeroTest.java
 * 
 * Data de cria��o: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilMultiplicadoresDeNumero
 */
@SuppressWarnings("boxing")
public class UtilMultiplicadoresDeNumeroTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testMultiplicarIntegerInteger() {
		Integer x = getNumeroFactory().novoInteger(10);
		Integer y = getNumeroFactory().novoInteger(2);

		double r = UtilMultiplicadoresDeNumero.multiplicar(x, y);
		assertEquals(20.0, r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(java.lang.Integer, int)}.
	 */
	@Test
	public final void testMultiplicarIntegerInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(int, int)}.
	 */
	@Test
	public final void testMultiplicarIntInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(java.lang.Long, java.lang.Long)}.
	 */
	@Test
	public final void testMultiplicarLongLong() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(java.lang.Long, long)}.
	 */
	@Test
	public final void testMultiplicarLongLong1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(long, long)}.
	 */
	@Test
	public final void testMultiplicarLongLong2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(java.lang.Double, java.lang.Double)}.
	 */
	@Test
	public final void testMultiplicarDoubleDouble() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(java.lang.Double, double)}.
	 */
	@Test
	public final void testMultiplicarDoubleDouble1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(double, double)}.
	 */
	@Test
	public final void testMultiplicarDoubleDouble2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(java.lang.Float, java.lang.Float)}.
	 */
	@Test
	public final void testMultiplicarFloatFloat() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(java.lang.Float, float)}.
	 */
	@Test
	public final void testMultiplicarFloatFloat1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilMultiplicadoresDeNumero#multiplicar(float, float)}.
	 */
	@Test
	public final void testMultiplicarFloatFloat2() {
		// Desnecess�rio
	}

}
