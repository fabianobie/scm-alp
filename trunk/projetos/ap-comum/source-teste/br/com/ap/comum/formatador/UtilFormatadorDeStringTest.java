/*
 * UtilFormatadorDeStringTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeString;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeString
 */
public class UtilFormatadorDeStringTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeString#formatarSemEspacos(java.lang.String)}.
	 */
	@Test
	public final void testFormatarSemEspacos() {
		String s = "       Atirei o pau no gato to to            ";
		String _s = UtilFormatadorDeString.formatarSemEspacos(s);

		assertNotNull(_s);
		assertEquals("Atirei o pau no gato to to", _s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeString#formatar(java.lang.Object)}.
	 */
	@Test
	public final void testFormatar() {
		String s = "xxx";
		String _s = UtilFormatadorDeString.formatar(s);

		assertNotNull(_s);
		assertEquals(s, _s);
	}

}
