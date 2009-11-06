/*
 * ConversorDeStringParaTimeTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Time;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeStringParaTime
 */
public class ConversorDeStringParaTimeTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaTime#converter(java.lang.String)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, Time> c = getConversorFactory()
				.novoConversorDeStringParaTime();
		String param = getStringFactory().novaString("06:35");

		Time res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), Time.class);
		assertNotNull(res);
		assertEquals(getDataFactory().novoTime(6, 35).toString(), res
				.toString());

		res = c.converter(null);
		assertNull(res);
	}

}
