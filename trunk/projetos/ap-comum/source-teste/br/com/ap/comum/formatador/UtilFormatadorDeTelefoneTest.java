/*
 * UtilFormatadorDeTelefoneTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeTelefone;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeString
 */
public class UtilFormatadorDeTelefoneTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeTelefone#
	 * 		formatar(java.lang.String)}.
	 */
	@Test
	public final void testFormatarString() {
		String t = "33510000";
		String r = UtilFormatadorDeTelefone.formatar(t);
		assertEquals("3351-0000", r);

		t = null;
		r = UtilFormatadorDeTelefone.formatar(t);
		assertNull(r);

		t = "";
		r = UtilFormatadorDeTelefone.formatar(t);
		assertEquals("", r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeTelefone#
	 * 		formatar(java.lang.Number)}.
	 */
	@Test
	public final void testFormatarNumber() {
		Integer t = new Integer("33510000");
		String r = UtilFormatadorDeTelefone.formatar(t);
		assertEquals("3351-0000", r);

		t = null;
		r = UtilFormatadorDeTelefone.formatar(t);
		assertNull(r);

		t = new Integer("0");
		r = UtilFormatadorDeTelefone.formatar(t);
		assertEquals("0", r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeTelefone#formatar(int)}.
	 */
	@Test
	public final void testFormatarInt() {
		int t = 33510000;
		String r = UtilFormatadorDeTelefone.formatar(t);
		assertEquals("3351-0000", r);

		t = 0;
		r = UtilFormatadorDeTelefone.formatar(t);
		assertEquals("0", r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeTelefone#formatar(long)}.
	 */
	@Test
	public final void testFormatarLong() {
		long t = 33510000L;
		String r = UtilFormatadorDeTelefone.formatar(t);
		assertEquals("3351-0000", r);

		t = 0L;
		r = UtilFormatadorDeTelefone.formatar(t);
		assertEquals("0", r);
	}

}
