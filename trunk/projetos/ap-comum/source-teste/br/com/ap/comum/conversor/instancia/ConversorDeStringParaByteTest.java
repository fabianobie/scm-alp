/*
 * ConversorDeStringParaByteTest.java
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
 * @see ConversorDeStringParaByte
 */
public class ConversorDeStringParaByteTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaByte#
	 * 		converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Byte> c = getConversorFactory()
				.novoConversorDeStringParaByte();
		String param = getStringFactory().novaString("97");

		Byte res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Byte.class);
		assertNotNull(res);
		assertEquals(getNumeroFactory().novoByte("97"), res);

		res = c.converter(null);
		assertNull(res);
	}

}
