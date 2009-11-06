/*
 * FormatadorDeDataParaPadraoTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.UtilFormatadorDeData;
import br.com.ap.comum.formatador.instancia.IFormatador;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see FormatadorDeDataParaPadrao
 */
public class FormatadorDeDataParaPadraoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.instancia.FormatadorDeDataParaPadrao#formatar(java.util.Date)}.
	 * 
	 * @throws FormatadorException Exceção de formatação
	 */
	@Test
	public final void testFormatar() throws FormatadorException {
		Date data = new Date();
		IFormatador<Date> f = getFormatadorFactory()
				.novoFormatadorDeDataParaPadrao();
		String res = f.formatar(data);
		assertNotNull(res);
		assertEquals(UtilFormatadorDeData.formatar_ddMMyyyy(data), res);

		res = f.formatar(null);
		assertEquals("", res);
	}

}
