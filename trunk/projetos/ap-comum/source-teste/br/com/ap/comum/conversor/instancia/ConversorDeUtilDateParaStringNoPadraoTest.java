/*
 * ConversorDeUtilDateParaStringNoPadraoTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;
import br.com.ap.comum.formatador.UtilFormatadorDeData;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.instancia.
 *      ConversorDeUtilDateParaStringNoPadrao
 */
public class ConversorDeUtilDateParaStringNoPadraoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.instancia.ConversorDeUtilDateParaStringNoPadrao#converter(java.util.Date)}.
	 * 
	 * @throws ConversorException Exceção de conversão
	 */
	@Test
	public final void testConverter() throws ConversorException {
		IConversor<Date, String> conversor = getConversorFactory()
				.novoConversorDeUtilDateParaStringNoPadrao();

		Date dt = new Date();
		String resultado = conversor.converter(dt);
		assertEquals(conversor.getTipoDeOrigem(), Date.class);
		assertEquals(conversor.getTipoDeDestino(), String.class);
		assertNotNull(resultado);
		assertEquals(UtilFormatadorDeData.formatar_ddMMyyyy(dt), resultado);

		resultado = conversor.converter(null);
		assertNull(resultado);
	}

}
