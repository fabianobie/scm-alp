/*
 * UtilComparadorDeDataMaiorTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.comparador;

import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.comparador.UtilComparadorDeDataMaior;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilComparadorDeDataMaior
 */
public class UtilComparadorDeDataMaiorTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.comparador.UtilComparadorDeDataMaior#comparar(java.util.Date[])}.
	 */
	@Test
	public final void testComparar() {
		Date d0 = getDataFactory().novoDate(1, 5, 2008);
		Date d1 = getDataFactory().novoDate(2, 5, 2008);

		Date r = UtilComparadorDeDataMaior.comparar(d0, d1);
		assertSame(r, d1);

		r = UtilComparadorDeDataMaior.comparar(d0, null);
		assertNotNull(r);
		assertSame(r, d0);
	}

}
