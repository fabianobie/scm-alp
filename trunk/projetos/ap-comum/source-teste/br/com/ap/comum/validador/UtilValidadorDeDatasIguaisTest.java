/*
 * UtilValidadorDeDatasIguaisTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeDatasIguais;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeDatasIguais
 */
public class UtilValidadorDeDatasIguaisTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeDatasIguais#validar(java.util.Date[])}.
	 */
	@Test
	public final void testValidar() {
		Date d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		Date d2 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		Date d3 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		boolean b = UtilValidadorDeDatasIguais.validar(d1, d2, d3);
		assertEquals(true, b);

		d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		d2 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		d3 = new GregorianCalendar(2008, Calendar.OCTOBER, 19).getTime();
		b = UtilValidadorDeDatasIguais.validar(d1, d2, d3);
		assertEquals(false, b);

		d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		d2 = new GregorianCalendar(2008, Calendar.JULY, 17).getTime();
		d3 = new GregorianCalendar(2008, Calendar.OCTOBER, 19).getTime();
		b = UtilValidadorDeDatasIguais.validar(d1, d2, d3);
		assertEquals(false, b);

		d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		d2 = new GregorianCalendar(2008, Calendar.JULY, 17).getTime();
		d3 = null;
		b = UtilValidadorDeDatasIguais.validar(d1, d2, d3);
		assertEquals(false, b);
	}

}
