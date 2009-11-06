/*
 * ConversorDeStringParaTimestampTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Timestamp;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeStringParaTimestamp
 */
public class ConversorDeStringParaTimestampTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaTimestamp#converter(java.lang.String)}.
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Timestamp> c = getConversorFactory()
				.novoConversorDeStringParaTimestamp();
		String param = getStringFactory().novaString("06/04/2008 16:30:35");

		Timestamp res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Timestamp.class);
		assertNotNull(res);

		res = c.converter(null);
		assertNull(res);
	}

}
