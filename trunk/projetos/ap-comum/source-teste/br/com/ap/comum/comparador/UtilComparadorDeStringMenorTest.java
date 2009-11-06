/*
 * UtilComparadorDeStringMenorTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.comparador.UtilComparadorDeStringMenor;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilComparadorDeStringMenor
 */
public class UtilComparadorDeStringMenorTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.comparador.UtilComparadorDeStringMenor#comparar(java.lang.String[])}.
	 */
	@Test
	public final void testComparar() {
		String d0 = getStringFactory().novaString("xxx");
		String d1 = getStringFactory().novaString("yyyy");

		String r = UtilComparadorDeStringMenor.comparar(d0, d1);
		assertSame(r, d0);

		d1 = null;
		r = UtilComparadorDeStringMenor.comparar(d0, d1);
		assertNotNull(r);
		assertSame(r, d0);
	}

}
