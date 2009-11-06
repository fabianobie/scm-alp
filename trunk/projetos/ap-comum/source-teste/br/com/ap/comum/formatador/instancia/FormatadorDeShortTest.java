/*
 * FormatadorDeShortTest.java
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
 * @see FormatadorDeShort
 */
public class FormatadorDeShortTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeShort#formatar(java.lang.Short)}.
	 * @throws FormatadorException Exceção de formatação 
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Short b = new Short("3");
		IFormatador<Short> f = getFormatadorFactory().novoFormatadorDeShort();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("3", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
