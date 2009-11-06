/*
 * UtilValidadorDeAnoBissextoTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeAnoBissexto;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeAnoBissexto
 */
public class UtilValidadorDeAnoBissextoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeAnoBissexto#validar(java.util.Date)}.
	 */
	@Test
	public final void testValidar() {
		Date bissexto = getDataFactory().novoDate(17, 9, 2004);
		Date naoBissexto = getDataFactory().novoDate(17, 9, 2005);

		boolean b = UtilValidadorDeAnoBissexto.validar(naoBissexto);
		assertFalse(b);

		b = UtilValidadorDeAnoBissexto.validar(bissexto);
		assertEquals(true, b);

		bissexto = null;
		b = UtilValidadorDeAnoBissexto.validar(bissexto);
		assertEquals(false, b);
	}

}
