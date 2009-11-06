/*
 * UtilFormatadorDeCNPJTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeCNPJ;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeCNPJ
 */
public class UtilFormatadorDeCNPJTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeCNPJ#formatar(java.lang.String)}.
	 */
	@Test
	public final void testFormatar() {
		String cnpj = "12345678912345";
		String _cnpj = UtilFormatadorDeCNPJ.formatar(cnpj);

		assertNotNull(_cnpj);
		assertEquals("12.345.678/9123-45", _cnpj);

		_cnpj = UtilFormatadorDeCNPJ.formatar(null);
		assertNull(_cnpj);

		_cnpj = UtilFormatadorDeCNPJ.formatar("");
		assertEquals("", _cnpj);
	}

}
