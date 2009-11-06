/*
 * ConversorDeStringParaDoubleTest.java
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
 * @see ConversorDeStringParaDouble
 */
public class ConversorDeStringParaDoubleTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaDouble#
	 * 		converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Double> c = getConversorFactory()
				.novoConversorDeStringParaDouble();
		String param = getStringFactory().novaString("35.44");

		Double res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Double.class);
		assertNotNull(res);
		assertEquals(getNumeroFactory().novoDouble(35.44), res);

		res = c.converter(null);
		assertNull(res);
	}

}
