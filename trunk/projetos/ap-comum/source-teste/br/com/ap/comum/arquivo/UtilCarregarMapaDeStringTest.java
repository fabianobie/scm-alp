/*
 * UtilCarregarMapaDeStringTest.java
 * 
 * Data de criação: 01/07/2008
 */
package br.com.ap.comum.arquivo;

import java.util.Map;
import java.util.Properties;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.arquivo.UtilCarregarMapaDeChars
 */
public class UtilCarregarMapaDeStringTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilCarregarMapaDoProperties#getMapa(java.util.Properties)}.
	 */
	@Test
	public final void testGetMapaProperties() {
		Properties arquivo = novoProperties(getArquivo());

		UtilCarregarMapaDeString util = new UtilCarregarMapaDeString();
		Map<String, String> m = util.getMapa(arquivo);
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
