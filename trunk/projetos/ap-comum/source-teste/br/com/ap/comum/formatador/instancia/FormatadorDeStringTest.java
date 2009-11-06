/*
 * FormatadorDeStringTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.instancia.IFormatador;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see FormatadorDeString
 */
public class FormatadorDeStringTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeString#formatar(java.lang.String)}.
	 * 
	 * @throws FormatadorException Exceção de formatação
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		String b = new String(" x ");
		IFormatador<String> f = getFormatadorFactory().novoFormatadorDeString();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("x", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
