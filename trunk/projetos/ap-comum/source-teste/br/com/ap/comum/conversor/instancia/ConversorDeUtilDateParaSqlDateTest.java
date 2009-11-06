/*
 * ConversorDeUtilDateParaSqlDateTest.java
 * 
 * Data de criação: 03/07/2008
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
 * @see br.com.ap.comum.conversor.instancia.
 *      ConversorDeUtilDateParaSqlDate
 */
public class ConversorDeUtilDateParaSqlDateTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaSqlDate#
	 * 		converter(java.util.Date)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<Date, java.sql.Date> conversor = getConversorFactory()
				.novoConversorDeUtilDateParaSqlDate();

		Date dt = getDataFactory().novoDate();
		java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
		java.sql.Date resultado = conversor.converter(dt);
		assertEquals(conversor.getTipoDeOrigem(), Date.class);
		assertEquals(conversor.getTipoDeDestino(), java.sql.Date.class);
		assertNotNull(resultado);
		assertEquals(resultado, sqlDate);

		resultado = conversor.converter(null);
		assertNull(resultado);
	}

}
