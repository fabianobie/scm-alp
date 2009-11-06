/*
 * FormatadorDeDoubleParaMonetarioTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.UtilFormatadorDeReal;
import br.com.ap.comum.formatador.instancia.IFormatador;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see FormatadorDeDoubleParaMonetario
 */
public class FormatadorDeDoubleParaMonetarioTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeDoubleParaMonetario#formatar(java.lang.Double)}.
	 * 
	 * @throws FormatadorException Exceção de formatação
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Double valor = new Double(35909.33d);
		IFormatador<Double> f = getFormatadorFactory()
				.novoFormatadorDeDoubleParaMonetario();

		String res = f.formatar(valor);
		assertNotNull(res);
		assertEquals(UtilFormatadorDeReal.formatarParaMonetario(valor), res);

		res = f.formatar(null);
		assertEquals("", res);
	}

}
