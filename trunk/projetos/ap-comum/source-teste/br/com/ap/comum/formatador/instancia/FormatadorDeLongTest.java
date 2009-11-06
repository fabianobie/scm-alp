/*
 * FormatadorDeLongTest.java
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
 * @see FormatadorDeLong
 */
public class FormatadorDeLongTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeLong#formatar(java.lang.Long)}.
	 * @throws FormatadorException Exceção de formatação 
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Long b = new Long(55L);
		IFormatador<Long> f = getFormatadorFactory().novoFormatadorDeLong();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("55", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
