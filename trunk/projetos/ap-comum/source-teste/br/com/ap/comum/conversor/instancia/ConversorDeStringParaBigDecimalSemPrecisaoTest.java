/*
 * ConversorDeStringParaBigDecimalSemPrecisaoTest.java
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
 * @see ConversorDeStringParaBigDecimalSemPrecisao
 */
public class ConversorDeStringParaBigDecimalSemPrecisaoTest extends
		TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeStringParaBigDecimalSemPrecisao#
	 * 		converter(java.lang.String)}.
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<String, BigDecimal> c = getConversorFactory()
				.novoConversorDeStringParaBigDecimalSemPrecisao();
		String param = getStringFactory().novaString("35");

		BigDecimal res = c.converter(param);
		assertEquals(c.getTipoDeOrigem(), String.class);
		assertEquals(c.getTipoDeDestino(), BigDecimal.class);
		assertNotNull(res);
		assertEquals(getNumeroFactory().novoBigDecimal(35d), res);

		res = c.converter(null);
		assertNull(res);
	}

}
