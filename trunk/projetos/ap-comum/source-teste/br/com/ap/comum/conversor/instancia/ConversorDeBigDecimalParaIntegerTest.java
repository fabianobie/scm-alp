/*
 * ConversorDeBigDecimalParaIntegerTest.java
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
 * @see br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaInteger
 */
public class ConversorDeBigDecimalParaIntegerTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaInteger#
	 * 		converter(java.math.BigDecimal)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<BigDecimal, Integer> c = getConversorFactory()
				.novoConversorDeBigDecimalParaInteger();

		BigDecimal bd = getNumeroFactory().novoBigDecimal(44.35);
		Integer integer = c.converter(bd);
		assertEquals(c.getTipoDeOrigem(), BigDecimal.class);
		assertEquals(c.getTipoDeDestino(), Integer.class);
		assertNotNull(integer);
		assertEquals(getNumeroFactory().novoInteger(44), integer);

		integer = c.converter(null);
		assertNull(integer);
	}

}
