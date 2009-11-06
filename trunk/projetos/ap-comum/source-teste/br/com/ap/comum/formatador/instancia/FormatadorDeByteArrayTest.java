/*
 * FormatadorDeByteArrayTest.java
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
 * @see FormatadorDeByteArray
 */
public class FormatadorDeByteArrayTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeByteArray#formatar(java.lang.Byte[])}.
	 * 
	 * @throws FormatadorException Exceção de formatação
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Byte[] b = new Byte[] { new Byte("97"), new Byte("98") };
		IFormatador<Byte[]> f = getFormatadorFactory()
				.novoFormatadorDeByteArray();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("ab", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
