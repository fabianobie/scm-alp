/*
 * ConversorDeSqlDateParaUtilDateTest.java
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
import br.com.ap.comum.data.UtilData;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeSqlDateParaUtilDate
 */
public class ConversorDeSqlDateParaUtilDateTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeSqlDateParaUtilDate#
	 * 		converter(java.sql.Date)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<java.sql.Date, java.util.Date> c = getConversorFactory()
				.novoConversorDeSqlDateParaUtilDate();
		java.sql.Date param = getDataFactory().novoSqlDate(10, 05, 2008);

		java.util.Date res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), java.sql.Date.class);
		assertEquals(c.getTipoDeDestino(), Date.class);
		assertNotNull(res);
		assertEquals(UtilData.getDiasDoMes(param), UtilData.getDiasDoMes(res));

		res = c.converter(null);
		assertNull(res);
	}

}
