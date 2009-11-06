/*
 * UtilFormatadorDeCPFTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeCPF;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeCPF
 */
public class UtilFormatadorDeCPFTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeCPF#formatar(java.lang.String)}.
	 */
	@Test
	public final void testFormatar() {
		String cpf = "01416355170";
		String _cpf = UtilFormatadorDeCPF.formatar(cpf);

		assertNotNull(_cpf);
		assertEquals("014.163.551-70", _cpf);

		cpf = null;
		_cpf = UtilFormatadorDeCPF.formatar(cpf);
		assertNull(_cpf);

		_cpf = UtilFormatadorDeCPF.formatar("");
		assertEquals("", _cpf);
		
		_cpf = UtilFormatadorDeCPF.formatar("80324681100");
		assertEquals("803.246.811-00", _cpf);
	}

}
