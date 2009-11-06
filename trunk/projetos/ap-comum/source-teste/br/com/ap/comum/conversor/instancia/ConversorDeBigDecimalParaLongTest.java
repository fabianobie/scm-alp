/*
 * ConversorDeBigDecimalParaLongTest.java
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
 * @see ConversorDeBigDecimalParaLong
 */
public class ConversorDeBigDecimalParaLongTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaLong#
	 * 		converter(java.math.BigDecimal)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<BigDecimal, Long> c = getConversorFactory()
				.novoConversorDeBigDecimalParaLong();
		BigDecimal param = getNumeroFactory().novoBigDecimal(35.44);

		Long res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), BigDecimal.class);
		assertEquals(c.getTipoDeDestino(), Long.class);
		assertNotNull(res);
		assertEquals(getNumeroFactory().novoLong(35), res);

		res = c.converter(null);
		assertNull(res);
	}

}
