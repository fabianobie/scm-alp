/*
 * UtilValidadorDeDataSuperiorAAtualTest.java
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
import br.com.ap.comum.validador.UtilValidadorDeDataSuperiorAAtual;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeDataSuperiorAAtual
 */
public class UtilValidadorDeDataSuperiorAAtualTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeDataSuperiorAAtual#validar(java.util.Date)}.
	 */
	@Test
	public final void testValidar() {
		Date data0 = getDataFactory().novoDate(1, 1, 2005);
		Date data1 = getDataFactory().novoDate(1, 1, 2020);

		boolean res = UtilValidadorDeDataSuperiorAAtual.validar(data0);
		assertFalse(res);

		res = UtilValidadorDeDataSuperiorAAtual.validar(data1);
		assertTrue(res);
	}

}
