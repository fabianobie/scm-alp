/*
 * ConversorDeSqlDateParaUtilDateTest.java
 * 
 * Data de criação: 21/04/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.util.Date;

import junit.framework.TestCase;
import br.com.ap.comum.conversor.instancia.ConversorDeSqlDateParaUtilDate;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.instancia.
 *      ConversorDeSqlDateParaUtilDate
 */
public class ConversorDeSqlDateParaUtilDateTest_bkp extends TestCase {

	/**
	 * Test method for 'br.com.ap.comum.conversor.instancia.
	 * ConversorDeSqlDateParaUtilDate.converter(Object)'
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	public void testConverter() throws ConversorException {
		ConversorDeSqlDateParaUtilDate conversor = null;
		conversor = new ConversorDeSqlDateParaUtilDate();

		Date data = new Date();
		java.sql.Date dt = new java.sql.Date(data.getTime());
		Date resultado = conversor.converter(dt);
		assertEquals(conversor.getTipoDeOrigem(), java.sql.Date.class);
		assertEquals(conversor.getTipoDeDestino(), Date.class);
		assertNotNull(resultado);
		assertEquals(data, resultado);

		resultado = conversor.converter(null);
		assertNull(resultado);
	}

}
