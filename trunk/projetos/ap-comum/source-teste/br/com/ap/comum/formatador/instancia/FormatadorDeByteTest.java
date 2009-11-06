/*
 * FormatadorDeByteTest.java
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
 * @see FormatadorDeByte
 */
public class FormatadorDeByteTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeByte#formatar(java.lang.Byte)}.
	 * 
	 * @throws FormatadorException Exceção de formatação
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Byte b = new Byte("98");
		IFormatador<Byte> f = getFormatadorFactory().novoFormatadorDeByte();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("98", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
