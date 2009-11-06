/*
 * FormatadorDeTimestampTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.sql.Timestamp;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.instancia.IFormatador;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see FormatadorDeTimestamp
 */
public class FormatadorDeTimestampTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeTimestamp#
	 * 		formatar(java.sql.Timestamp)}
	 * .
	 * 
	 * @throws FormatadorException Exceção de formatação erro de formatação
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Timestamp b = getDataFactory().novoTimestamp(23, 10, 1978, 15, 30, 35);
		IFormatador<Timestamp> f = getFormatadorFactory()
				.novoFormatadorDeTimestamp();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("23/10/1978 15:30:35", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
