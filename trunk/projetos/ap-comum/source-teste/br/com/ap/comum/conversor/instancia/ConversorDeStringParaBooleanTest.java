/*
 * ConversorDeStringParaBooleanTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeStringParaBoolean
 */
public class ConversorDeStringParaBooleanTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaBoolean#
	 * 		converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Boolean> c = getConversorFactory()
				.novoConversorDeStringParaBoolean();
		String param = getStringFactory().novaString("false");

		Boolean res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Boolean.class);
		assertNotNull(res);
		assertEquals(new Boolean(false), res);

		res = c.converter(null);
		assertNull(res);
	}

}
