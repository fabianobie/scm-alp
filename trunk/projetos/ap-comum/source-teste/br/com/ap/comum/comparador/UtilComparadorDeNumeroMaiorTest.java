/*
 * UtilComparadorDeNumeroMaiorTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.comparador.UtilComparadorDeNumeroMaior;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilComparadorDeNumeroMaior
 */
public class UtilComparadorDeNumeroMaiorTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.comparador.UtilComparadorDeNumeroMaior#comparar(java.lang.Number[])}.
	 */
	@Test
	public final void testComparar() {
		Long d0 = getNumeroFactory().novoLong(1);
		Long d1 = getNumeroFactory().novoLong(2);

		Long r = UtilComparadorDeNumeroMaior.comparar(d0, d1);
		assertSame(r, d1);

		d1 = null;
		r = UtilComparadorDeNumeroMaior.comparar(d0, d1);
		assertNotNull(r);
		assertSame(r, d0);
	}

}
