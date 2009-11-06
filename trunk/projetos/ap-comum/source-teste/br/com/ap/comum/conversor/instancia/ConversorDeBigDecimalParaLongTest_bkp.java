/*
 * ConversorDeBigDecimalParaLongTest.java
 * 
 * Data de criação: 21/04/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.math.BigDecimal;

import junit.framework.TestCase;
import br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaLong;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.instancia.
 *      ConversorDeBigDecimalParaLong
 */
public class ConversorDeBigDecimalParaLongTest_bkp extends TestCase {

	/**
	 * Test method for 'br.com.ap.comum.conversor.instancia.
	 * ConversorDeBigDecimalParaLong.converter(Object)'
	 * @throws ConversorException Exceção de conversão
	 */
	public void testConverter() throws ConversorException {
		ConversorDeBigDecimalParaLong c = null;
		c = new ConversorDeBigDecimalParaLong();

		BigDecimal bd = new BigDecimal(44.35);
		Long _long = c.converter(bd);
		assertEquals(c.getTipoDeOrigem(), BigDecimal.class);
		assertEquals(c.getTipoDeDestino(), Long.class);
		assertNotNull(_long);
		assertEquals(new Long(44), _long);

		_long = c.converter(null);
		assertNull(_long);
	}
}
