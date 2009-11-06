/*
 * UtilValidadorDeDatasDoMesmoDiaTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeDatasDoMesmoDia;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeDatasDoMesmoDia
 */
public class UtilValidadorDeDatasDoMesmoDiaTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeDatasDoMesmoDia#validar(java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testValidar() {
		Date data0 = getDataFactory().novoDate(5, 5, 2005);
		Date data1 = getDataFactory().novoDate(5, 5, 2006);
		Date data2 = getDataFactory().novoDate(4, 5, 2005);

		boolean res = UtilValidadorDeDatasDoMesmoDia.validar(data0, data1);
		assertEquals(true, res);

		res = UtilValidadorDeDatasDoMesmoDia.validar(data0, data2);
		assertEquals(false, res);

		res = UtilValidadorDeDatasDoMesmoDia.validar(null, null);
		assertEquals(false, res);
	}

}
