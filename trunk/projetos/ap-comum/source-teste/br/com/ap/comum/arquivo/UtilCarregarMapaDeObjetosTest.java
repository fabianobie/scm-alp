/*
 * UtilCarregarMapaDeObjetosTest.java
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
import br.com.ap.comum.arquivo.UtilCarregarMapaDeObjetos;
import br.com.ap.comum.formatador.instancia.IFormatador;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.arquivo.UtilCarregarMapaDeObjetos
 */
public class UtilCarregarMapaDeObjetosTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.arquivo.UtilCarregarMapaDeObjetos#getMapa(java.util.Properties)}.
	 */
	@Test
	public final void testGetMapaProperties() {
		Properties arquivo = novoProperties(getArquivo());

		UtilCarregarMapaDeObjetos<IFormatador<?>> util = 
			new UtilCarregarMapaDeObjetos<IFormatador<?>>();
		Map<String, IFormatador<?>> m = util.getMapa(arquivo);
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
		return "teste-class-objeto.properties";
	}
}
