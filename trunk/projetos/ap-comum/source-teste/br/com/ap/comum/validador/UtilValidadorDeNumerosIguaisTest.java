/*
 * UtilValidadorDeNumerosIguaisTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeNumerosIguais;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeNumerosIguais
 */
@SuppressWarnings("boxing")
public class UtilValidadorDeNumerosIguaisTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(java.lang.Number[])}.
	 */
	@Test
	public final void testValidarNumberArray() {
		int i = 1;
		int _i = 1;
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = 2;
		_i = 1;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(int, int)}.
	 */
	@Test
	public final void testValidarIntInt() {
		int i = 1;
		int _i = 1;
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = 2;
		_i = 1;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(byte, byte)}.
	 */
	@Test
	public final void testValidarByteByte() {
		byte i = 1;
		byte _i = 1;
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = 2;
		_i = 1;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(short, short)}.
	 */
	@Test
	public final void testValidarShortShort() {
		Short i = getNumeroFactory().novoShort("1");
		Short _i = getNumeroFactory().novoShort("1");
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = 2;
		_i = 1;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(long, long)}.
	 */
	@Test
	public final void testValidarLongLong() {
		Long i = getNumeroFactory().novoLong("1");
		Long _i = getNumeroFactory().novoLong("1");
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = getNumeroFactory().novoLong("2");
		_i = getNumeroFactory().novoLong("1");
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(float, float)}.
	 */
	@Test
	public final void testValidarFloatFloat() {
		Float i = getNumeroFactory().novoFloat("1");
		Float _i = getNumeroFactory().novoFloat("1");
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = getNumeroFactory().novoFloat("2");
		_i = getNumeroFactory().novoFloat("1");
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(double, double)}.
	 */
	@Test
	public final void testValidarDoubleDouble() {
		Double i = getNumeroFactory().novoDouble(55.3d);
		Double _i = getNumeroFactory().novoDouble(55.3d);
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		_i = getNumeroFactory().novoDouble(53.3d);
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(long, int)}.
	 */
	@Test
	public final void testValidarLongInt() {
		long i = 1;
		int _i = 1;
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = 2;
		_i = 1;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testValidarIntegerInteger() {
		Integer i = new Integer(1);
		Integer _i = new Integer(1);
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = new Integer(1);
		_i = new Integer(1);
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = new Integer(1);
		_i = new Integer(2);
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);

		i = null;
		_i = new Integer(1);
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);

		i = new Integer(1);
		_i = null;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);

		i = null;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeNumerosIguais#validar(java.lang.Integer, int)}.
	 */
	@Test
	public final void testValidarIntegerInt() {
		Integer i = new Integer(1);
		int _i = 1;
		boolean b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(true, b);

		i = new Integer(0);
		_i = 1;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);

		i = null;
		_i = 1;
		b = UtilValidadorDeNumerosIguais.validar(i, _i);
		assertEquals(false, b);
	}

}
