/*
 * UtilCarregarMapaDeCharsTest.java
 * 
 * Data de criação: 01/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import java.util.Map;
import java.util.Properties;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.arquivo.UtilCarregarMapaDeChars;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.arquivo.UtilCarregarMapaDeChars
 */
public class UtilCarregarMapaDeCharsTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilCarregarMapaDoProperties#getMapa(java.util.Properties)}.
	 */
	@Test
	public final void testGetMapaProperties() {
		Properties arquivo = novoProperties(getArquivo());

		UtilCarregarMapaDeChars util = new UtilCarregarMapaDeChars();
		Map<String, Character> m = util.getMapa(arquivo);
		assertNotNull(m);
		assertTrue(m.size() > 0);

		m = util.getMapa(null);
		assertNotNull(m);
		assertTrue(m.size() == 0);
	}

	/**
	 * @return arquivo teste.properties.
	 */
	private String getArquivo() {
		return "teste-string-char.properties";
	}
}
