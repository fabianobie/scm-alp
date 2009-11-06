/*
 * UtilValidadorDeCNPJTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeCNPJ;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeCNPJ
 */
public class UtilValidadorDeCNPJTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeCNPJ#validar(java.lang.Number)}.
	 */
	@Test
	public final void testValidarNumber() {
		Long l = new Long("57694506367549");
		boolean b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(true, b);

		l = new Long("72979363082004");
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(true, b);

		l = new Long("12345678912345");
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);

		l = new Long("12345");
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);

		l = null;
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeCNPJ#validar(long)}.
	 */
	@Test
	public final void testValidarLong() {
		long l = 57694506367549L;
		boolean b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(true, b);

		l = 72979363082004L;
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(true, b);

		l = 12345678912345L;
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);

		l = 12345L;
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);

		l = 0;
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeCNPJ#validar(java.lang.String)}.
	 */
	@Test
	public final void testValidarString() {
		String l = "57694506367549";
		boolean b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(true, b);

		l = "72979363082004";
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(true, b);

		l = "12345678912345";
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);

		l = "12345";
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);

		l = null;
		b = UtilValidadorDeCNPJ.validar(l);
		assertEquals(false, b);
	}

}
