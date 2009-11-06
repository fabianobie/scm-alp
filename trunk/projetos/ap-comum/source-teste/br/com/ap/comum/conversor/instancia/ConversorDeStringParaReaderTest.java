/*
 * ConversorDeStringParaReaderTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.io.Reader;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeStringParaReader
 */
public class ConversorDeStringParaReaderTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaReader#
	 * 		converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {

		IConversor<String, Reader> c = getConversorFactory()
				.novoConversorDeStringParaReader();
		String param = getStringFactory().novaString("texto");

		Reader res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Reader.class);
		assertNotNull(res);

		res = c.converter(null);
		assertNull(res);
	}

}
