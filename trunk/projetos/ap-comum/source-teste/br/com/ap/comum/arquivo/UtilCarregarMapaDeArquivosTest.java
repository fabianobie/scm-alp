/*
 * UtilCarregarMapaDeArquivosTest.java
 * 
 * Data de criação: 01/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.arquivo;

import java.util.Map;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.arquivo.UtilCarregarMapaDeArquivos;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.arquivo.UtilCarregarMapaDeArquivos
 */
public class UtilCarregarMapaDeArquivosTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilCarregarMapaDeArquivos#getMapa(java.lang.String)}.
	 */
	@Test
	public final void testGetMapaString() {
		String path = getPathAtual();

		UtilCarregarMapaDeArquivos util = new UtilCarregarMapaDeArquivos();

		Map<String, String> m = util.getMapa(path);
		assertNotNull(m);
		assertTrue(m.size() > 0);

		m = util.getMapa("");
		assertNotNull(m);
		assertTrue(m.size() == 0);

		path = null;
		m = util.getMapa(path);
		assertNotNull(m);
		assertTrue(m.size() == 0);
	}

	/**
	 * @return path do arquivo teste.properties
	 */
	private String getPathAtual() {
		return this.getClass().getResource(".").getPath();
	}

}
