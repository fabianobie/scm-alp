/*
 * ConversorDeDoubleParaBigDecimalTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see ConversorDeDoubleParaBigDecimal
 */
public class ConversorDeDoubleParaBigDecimalTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeDoubleParaBigDecimal#
	 * 		converter(java.lang.Double)}.
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<Double, BigDecimal> c = getConversorFactory()
				.novoConversorDeDoubleParaBigDecimal();
		Double param = getNumeroFactory().novoDouble(35.44);

		BigDecimal res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), Double.class);
		assertEquals(c.getTipoDeDestino(), BigDecimal.class);
		assertNotNull(res);
		assertEquals(getNumeroFactory().novoBigDecimal(35.44), res);

		res = c.converter(null);
		assertNull(res);
	}

}
