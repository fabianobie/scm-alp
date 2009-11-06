/*
 * ConversorDeStringParaDateTest.java
 * 
 * Data de cria��o: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeStringParaDate
 */
public class ConversorDeStringParaDateTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaDate#
	 * 		converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exce��o de convers�o
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Date> c = getConversorFactory()
				.novoConversorDeStringParaDate();
		String param = getStringFactory().novaString("23/10/1978");

		Date res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Date.class);
		assertNotNull(res);
		assertEquals(getDataFactory().novoDate(23, 10, 1978, 0, 0, 0), res);

		res = c.converter(null);
		assertNull(res);
	}

}
