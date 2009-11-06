/*
 * UtilValidadorDeDatasDoMesmoAnoTest.java
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
import br.com.ap.comum.validador.UtilValidadorDeDatasDoMesmoAno;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeDatasDoMesmoAno
 */
public class UtilValidadorDeDatasDoMesmoAnoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeDatasDoMesmoAno#validar(java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testValidar() {
		Date data0 = getDataFactory().novoDate(5, 5, 2005);
		Date data1 = getDataFactory().novoDate(5, 5, 2006);
		Date data2 = getDataFactory().novoDate(4, 5, 2005);

		boolean res = UtilValidadorDeDatasDoMesmoAno.validar(data0, data1);
		assertEquals(false, res);

		res = UtilValidadorDeDatasDoMesmoAno.validar(data0, data2);
		assertEquals(true, res);

		res = UtilValidadorDeDatasDoMesmoAno.validar(null, null);
		assertEquals(false, res);
	}

}
