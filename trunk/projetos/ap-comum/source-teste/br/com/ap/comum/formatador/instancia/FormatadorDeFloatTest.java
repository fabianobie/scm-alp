/*
 * FormatadorDeFloatTest.java
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
 * @see FormatadorDeFloat
 */
public class FormatadorDeFloatTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeFloat#formatar(java.lang.Float)}.
	 * @throws FormatadorException Exceção de formatação 
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Float b = new Float(55.3f);
		IFormatador<Float> f = getFormatadorFactory().novoFormatadorDeFloat();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("55,30", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
