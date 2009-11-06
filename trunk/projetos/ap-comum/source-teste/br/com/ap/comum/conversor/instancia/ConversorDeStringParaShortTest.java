/*
 * ConversorDeStringParaShortTest.java
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
 * @see ConversorDeStringParaShort
 */
public class ConversorDeStringParaShortTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaShort#converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Short> c = getConversorFactory()
				.novoConversorDeStringParaShort();
		String param = getStringFactory().novaString("35");

		Short res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Short.class);
		assertNotNull(res);
		assertEquals(getNumeroFactory().novoShort("35"), res);

		res = c.converter(null);
		assertNull(res);
	}

}
