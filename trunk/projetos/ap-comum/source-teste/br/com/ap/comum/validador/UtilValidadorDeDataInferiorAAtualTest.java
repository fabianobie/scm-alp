/*
 * UtilValidadorDeDataInferiorAAtualTest.java
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
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.validador.UtilValidadorDeDataInferiorAAtual;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeDataInferiorAAtual
 */
public class UtilValidadorDeDataInferiorAAtualTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeDataInferiorAAtual#validar(java.util.Date)}.
	 */
	@Test
	public final void testValidar() {
		Date data0 = DataFactory.getInstancia().novoDate(1, 1, 2005);
		Date data1 = DataFactory.getInstancia().novoDate(1, 1, 2020);

		boolean res = UtilValidadorDeDataInferiorAAtual.validar(data0);
		assertTrue(res);

		res = UtilValidadorDeDataInferiorAAtual.validar(data1);
		assertFalse(res);
	}

}
