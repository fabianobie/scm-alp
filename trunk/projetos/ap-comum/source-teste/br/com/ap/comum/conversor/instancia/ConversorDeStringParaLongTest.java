/*
 * ConversorDeStringParaLongTest.java
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
 * @see ConversorDeStringParaLong
 */
public class ConversorDeStringParaLongTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaLong#
	 * 		converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exce��o de convers�o
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Long> c = getConversorFactory()
				.novoConversorDeStringParaLong();
		String param = getStringFactory().novaString("35");

		Long res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Long.class);
		assertNotNull(res);
		assertEquals(getNumeroFactory().novoLong(35), res);

		res = c.converter(null);
		assertNull(res);
	}

}
