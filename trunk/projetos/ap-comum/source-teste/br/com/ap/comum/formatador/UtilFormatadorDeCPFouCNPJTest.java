/*
 * UtilFormatadorDeCPFouCNPJTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeCPFouCNPJ;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeCPFouCNPJTest
 */
public class UtilFormatadorDeCPFouCNPJTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeCPFouCNPJ#formatar(java.lang.String)}.
	 */
	@Test
	public final void testFormatar() {
		String valor = "82749655153";
		String r = UtilFormatadorDeCPFouCNPJ.formatar(valor);

		assertNotNull(r);
		assertEquals("827.496.551-53", r);

		r = UtilFormatadorDeCPFouCNPJ.formatar(null);
		assertNull(r);

		r = UtilFormatadorDeCPFouCNPJ.formatar("");
		assertEquals("", r);

		valor = "07452169000121";
		r = UtilFormatadorDeCPFouCNPJ.formatar(valor);
		assertEquals("07.452.169/0001-21", r);
		
		valor = "80324681100";
		r = UtilFormatadorDeCPFouCNPJ.formatar(valor);
		assertEquals("803.246.811-00", r);
	}

}
