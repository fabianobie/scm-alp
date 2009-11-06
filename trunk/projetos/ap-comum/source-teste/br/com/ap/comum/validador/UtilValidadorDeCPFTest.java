/*
 * UtilValidadorDeCPFTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeCPF;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeCPF
 */
public class UtilValidadorDeCPFTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeCPF#validar(java.lang.String)}.
	 */
	@Test
	public final void testValidar() {
		String l = "01416355170";
		boolean b = UtilValidadorDeCPF.validar(l);
		assertEquals(true, b);

		l = "14344319168";
		b = UtilValidadorDeCPF.validar(l);
		assertEquals(true, b);

		l = "12345678912";
		b = UtilValidadorDeCPF.validar(l);
		assertEquals(false, b);

		l = "1234";
		b = UtilValidadorDeCPF.validar(l);
		assertEquals(false, b);

		l = null;
		b = UtilValidadorDeCPF.validar(l);
		assertEquals(false, b);

		l = "827.496.551-5";
		b = UtilValidadorDeCPF.validar(l);
		assertEquals(false, b);

		l = "775.677.811.15";
		b = UtilValidadorDeCPF.validar(l);
		assertEquals(true, b);
	}

}
