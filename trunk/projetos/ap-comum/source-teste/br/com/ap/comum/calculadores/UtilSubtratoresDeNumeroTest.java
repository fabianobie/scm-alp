/*
 * UtilSubtratoresDeNumeroTest.java
 * 
 * Data de cria��o: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.calculadores.UtilSubtratoresDeNumero;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilSubtratoresDeNumero
 */
public class UtilSubtratoresDeNumeroTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testSubtrairIntegerInteger() {
		Integer x = getNumeroFactory().novoInteger(5);
		Integer y = getNumeroFactory().novoInteger(2);

		int r = UtilSubtratoresDeNumero.subtrair(x, y);
		assertEquals(3, r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(java.lang.Integer, int)}.
	 */
	@Test
	public final void testSubtrairIntegerInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(int, int)}.
	 */
	@Test
	public final void testSubtrairIntInt() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(java.lang.Long, java.lang.Long)}.
	 */
	@Test
	public final void testSubtrairLongLong() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(java.lang.Long, long)}.
	 */
	@Test
	public final void testSubtrairLongLong1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(long, long)}.
	 */
	@Test
	public final void testSubtrairLongLong2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(java.lang.Double, java.lang.Double)}.
	 */
	@Test
	public final void testSubtrairDoubleDouble() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(java.lang.Double, double)}.
	 */
	@Test
	public final void testSubtrairDoubleDouble1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(double, double)}.
	 */
	@Test
	public final void testSubtrairDoubleDouble2() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(java.lang.Float, java.lang.Float)}.
	 */
	@Test
	public final void testSubtrairFloatFloat() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(java.lang.Float, float)}.
	 */
	@Test
	public final void testSubtrairFloatFloat1() {
		// Desnecess�rio
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeNumero#subtrair(float, float)}.
	 */
	@Test
	public final void testSubtrairFloatFloat2() {
		// Desnecess�rio
	}

}
