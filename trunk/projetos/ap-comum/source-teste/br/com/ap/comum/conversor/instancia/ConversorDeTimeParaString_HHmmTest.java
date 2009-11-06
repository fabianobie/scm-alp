/*
 * ConversorDeTimeParaString_HHmmTest.java
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
 * @see ConversorDeTimeParaString_HHmm
 */
public class ConversorDeTimeParaString_HHmmTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeTimeParaString_HHmm#
	 * 		converter(java.sql.Time)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<Time, String> c = getConversorFactory()
				.novoConversorDeTimeParaString_HHmm();
		Time param = getDataFactory().novoTime(6, 35, 30);

		String res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), Time.class);
		assertEquals(c.getTipoDeDestino(), String.class);
		assertNotNull(res);

		res = c.converter(null);
		assertNull(res);
	}

}
