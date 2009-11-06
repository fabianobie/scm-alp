/*
 * UtilCarregarMapaDoPropertiesTest.java
 * 
 * Data de criação: 01/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import java.util.Map;
import java.util.Properties;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.arquivo.UtilCarregarMapaDoProperties;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.arquivo.UtilCarregarMapaDoProperties
 */
public class UtilCarregarMapaDoPropertiesTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilCarregarMapaDoProperties#getMapa(java.util.Properties)}.
	 */

	public final void testGetMapaProperties() {
		Properties arquivo = novoProperties(getArquivo());

		UtilCarregarMapaDoProperties<String, String> util = new UtilCarregarMapaDoProperties<String, String>();
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
