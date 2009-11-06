/*
 * ConversorDeUtilDateParaTimestampTest.java
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
import br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaTimestamp;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaTimestamp
 */
public class ConversorDeUtilDateParaTimestampTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaTimestamp#
	 * 		converter(java.util.Date)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<Date, Timestamp> conversor = null;
		conversor = new ConversorDeUtilDateParaTimestamp();

		Date dt = new Date();
		Timestamp ts = new Timestamp(dt.getTime());
		Timestamp resultado = conversor.converter(dt);
		assertEquals(conversor.getTipoDeOrigem(), Date.class);
		assertEquals(conversor.getTipoDeDestino(), Timestamp.class);
		assertNotNull(resultado);
		assertEquals(resultado, ts);

		resultado = conversor.converter(null);
		assertNull(resultado);
	}

}
