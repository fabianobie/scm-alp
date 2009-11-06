/*
 * ConversorDeStringParaByteArrayTest.java
 * 
 * Data de cria��o: 03/07/2008
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
 * @see ConversorDeStringParaByteArray
 */
public class ConversorDeStringParaByteArrayTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaByteArray#
	 * 		converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exce��o de convers�o
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, byte[]> c = getConversorFactory()
				.novoConversorDeStringParaByteArray();
		String param = getStringFactory().novaString("texto");

		byte[] res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), byte[].class);
		assertNotNull(res);
		assertEquals(getStringFactory().novaString(res), "texto");

		res = c.converter(null);
		assertNull(res);
	}

}
