/*
 * ConversorDeBigDecimalParaDoubleTest.java
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
 * @see ConversorDeBigDecimalParaDouble
 */
public class ConversorDeBigDecimalParaDoubleTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaDouble#
	 * 		converter(java.math.BigDecimal)}
	 * .
	 * 
	 * @throws ConversorException Erro de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<BigDecimal, Double> c = getConversorFactory()
				.novoConversorDeBigDecimalParaDouble();

		BigDecimal bd = getNumeroFactory().novoBigDecimal(44.35);
		Double _double = c.converter(bd);
		assertEquals(c.getTipoDeOrigem(), BigDecimal.class);
		assertEquals(c.getTipoDeDestino(), Double.class);
		assertNotNull(_double);
		assertEquals(getNumeroFactory().novoDouble(44.35), _double);

		_double = c.converter(null);
		assertNull(_double);
	}

}
