/*
 * UtilFormatadorDeCEPTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeCEP;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeCEP
 */
public class UtilFormatadorDeCEPTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeCEP#formatar(java.lang.String)}.
	 */
	@Test
	public final void testFormatar() {
		String cep = "70740776";
		String _cep = UtilFormatadorDeCEP.formatar(cep);

		assertNotNull(_cep);
		assertEquals("70.740-776", _cep);

		_cep = UtilFormatadorDeCEP.formatar(null);
		assertNull(_cep);

		_cep = UtilFormatadorDeCEP.formatar("");
		assertEquals("", _cep);
	}

}
