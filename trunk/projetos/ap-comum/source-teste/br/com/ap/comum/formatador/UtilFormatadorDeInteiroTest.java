/*
 * UtilFormatadorDeInteiroTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeInteiro;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeInteiro
 */
public class UtilFormatadorDeInteiroTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeInteiro#formatar(java.lang.Integer)}.
	 */
	@Test
	public final void testFormatarInteger() {
		Integer i = new Integer(56);
		String _i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("56", _i);

		i = null;
		_i = UtilFormatadorDeInteiro.formatar(i);
		assertNull(_i);

		i = new Integer(56651981);
		_i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("56.651.981", _i);

		int i2 = 6514691;
		_i = UtilFormatadorDeInteiro.formatar(i2);

		assertNotNull(_i);
		assertEquals("6.514.691", _i);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeInteiro#formatar(java.lang.Short)}.
	 */
	@Test
	public final void testFormatarShort() {
		Short i = new Short("56");
		String _i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("56", _i);

		i = null;
		_i = UtilFormatadorDeInteiro.formatar(i);
		assertNull(_i);

		i = new Short("1560");
		_i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("1.560", _i);

		short i2 = 2356;
		_i = UtilFormatadorDeInteiro.formatar(i2);

		assertNotNull(_i);
		assertEquals("2.356", _i);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeInteiro#formatar(java.lang.Long)}.
	 */
	@Test
	public final void testFormatarLong() {
		Long i = new Long("56");
		String _i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("56", _i);

		i = null;
		_i = UtilFormatadorDeInteiro.formatar(i);
		assertNull(_i);

		i = new Long("8451664441");
		_i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("8.451.664.441", _i);

		long i2 = 651161148;
		_i = UtilFormatadorDeInteiro.formatar(i2);

		assertNotNull(_i);
		assertEquals("651.161.148", _i);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeInteiro#formatar(int)}.
	 */
	@Test
	public final void testFormatarInt() {
		int i = 56;
		String _i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("56", _i);

		i = 32500;
		_i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("32.500", _i);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeInteiro#formatar(short)}.
	 */
	@Test
	public final void testFormatarShort1() {
		short i = 56;
		String _i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("56", _i);

		i = 32500;
		_i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("32.500", _i);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeInteiro#formatar(long)}.
	 */
	@Test
	public final void testFormatarLong1() {
		long i = 56L;
		String _i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("56", _i);

		i = 8451664441L;
		_i = UtilFormatadorDeInteiro.formatar(i);

		assertNotNull(_i);
		assertEquals("8.451.664.441", _i);

		long i2 = 651161148;
		_i = UtilFormatadorDeInteiro.formatar(i2);

		assertNotNull(_i);
		assertEquals("651.161.148", _i);
	}

}
