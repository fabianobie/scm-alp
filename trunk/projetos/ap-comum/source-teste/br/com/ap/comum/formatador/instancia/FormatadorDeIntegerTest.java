/*
 * FormatadorDeIntegerTest.java
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
 * @see FormatadorDeInteger
 */
public class FormatadorDeIntegerTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeInteger#formatar(java.lang.Integer)}.
	 * 
	 * @throws FormatadorException Exceção de formatação
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Integer b = new Integer(55);
		IFormatador<Integer> f = getFormatadorFactory()
				.novoFormatadorDeInteger();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("55", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
