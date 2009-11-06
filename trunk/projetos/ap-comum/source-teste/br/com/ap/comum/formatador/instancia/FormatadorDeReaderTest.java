/*
 * FormatadorDeReaderTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.io.Reader;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.instancia.IFormatador;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see FormatadorDeReader
 */
public class FormatadorDeReaderTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeReader#formatar(java.io.Reader)}.
	 * 
	 * @throws FormatadorException Exceção de formatação
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Reader b = getArquivoFactory().novoBufferedReader("/br/com/ap/comum/formatador/instancia/texto.txt");
		IFormatador<Reader> f = getFormatadorFactory().novoFormatadorDeReader();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("teste\n\r", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
