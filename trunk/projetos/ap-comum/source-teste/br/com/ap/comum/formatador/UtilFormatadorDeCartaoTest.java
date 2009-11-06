/*
 * UtilFormatadorDeCartaoTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeCartao;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeCartao
 */
public class UtilFormatadorDeCartaoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeCartao#formatar(java.lang.String)}.
	 */
	@Test
	public final void testFormatarString() {
		String cep = "1234123412341234";
		String _cep = UtilFormatadorDeCartao.formatar(cep);

		assertNotNull(_cep);
		assertEquals("1234.1234.1234.1234", _cep);

		cep = null;
		_cep = UtilFormatadorDeCartao.formatar(cep);
		assertNull(_cep);

		_cep = UtilFormatadorDeCartao.formatar("");
		assertNull(_cep);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeCartao#formatar(java.lang.Number)}.
	 */
	@Test
	public final void testFormatarNumber() {
		Long cep = getNumeroFactory().novoLong("1234123412341234");
		String _cep = UtilFormatadorDeCartao.formatar(cep);

		assertNotNull(_cep);
		assertEquals("1234.1234.1234.1234", _cep);

		cep = null;
		_cep = UtilFormatadorDeCartao.formatar(cep);
		assertNull(_cep);

		_cep = UtilFormatadorDeCartao.formatar("");
		assertNull(_cep);
	}

}
