/*
 * ConversorDeTimestampParaUtilDateTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeTimestampParaUtilDate
 */
public class ConversorDeTimestampParaUtilDateTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeTimestampParaUtilDate#
	 * 		converter(java.sql.Timestamp)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<Timestamp, Date> c = getConversorFactory()
				.novoConversorDeTimestampParaUtilDate();
		Timestamp param = getDataFactory().novoTimestamp(23, 10, 1978, 15, 30,
				44, 0);

		Date res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), Timestamp.class);
		assertEquals(c.getTipoDeDestino(), Date.class);
		assertNotNull(res);

		res = c.converter(null);
		assertNull(res);
	}

}
