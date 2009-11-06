/*
 * FormatadorDeTime_HHmmTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.sql.Time;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.instancia.IFormatador;


/**
 * JUnit.
 * 
 * @author adrianop
 * @see FormatadorDeTime_HHmm
 */
public class FormatadorDeTime_HHmmTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeTime_HHmm#formatar(java.sql.Time)}.
	 * @throws FormatadorException Exceção de formatação 
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Time b = getDataFactory().novoTime(6, 30);
		IFormatador<Time> f = getFormatadorFactory().novoFormatadorDeTime();

		String string = f.formatar(b);
		assertNotNull(string);
		assertEquals("06:30", string);

		b = null;
		string = f.formatar(b);
		assertNotNull(string);
		assertEquals("", string);
	}

}
