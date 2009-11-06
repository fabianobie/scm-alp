/*
 * UtilValidadorDeDataFinalMaiorQueDataInicialTest.java
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
import br.com.ap.comum.validador.UtilValidadorDeDataFinalMaiorQueDataInicial;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeDataFinalMaiorQueDataInicial
 */
public class UtilValidadorDeDataFinalMaiorQueDataInicialTest extends
		TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeDataFinalMaiorQueDataInicial#validar(java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testValidar() {
		Date d1 = new GregorianCalendar(2006, Calendar.OCTOBER, 17).getTime();
		Date d2 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		boolean b = UtilValidadorDeDataFinalMaiorQueDataInicial.validar(d1, d2);
		assertEquals(true, b);

		d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		d2 = new GregorianCalendar(2006, Calendar.OCTOBER, 17).getTime();
		b = UtilValidadorDeDataFinalMaiorQueDataInicial.validar(d1, d2);
		assertEquals(false, b);

		d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 19).getTime();
		d2 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		b = UtilValidadorDeDataFinalMaiorQueDataInicial.validar(d1, d2);
		assertEquals(false, b);

		d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		d2 = new GregorianCalendar(2008, Calendar.OCTOBER, 19).getTime();
		b = UtilValidadorDeDataFinalMaiorQueDataInicial.validar(d1, d2);
		assertEquals(true, b);

		d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		d2 = new GregorianCalendar(2008, Calendar.JUNE, 17).getTime();
		b = UtilValidadorDeDataFinalMaiorQueDataInicial.validar(d1, d2);
		assertEquals(false, b);

		d1 = new GregorianCalendar(2008, Calendar.JUNE, 17).getTime();
		d2 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		b = UtilValidadorDeDataFinalMaiorQueDataInicial.validar(d1, d2);
		assertEquals(true, b);

		d1 = null;
		d2 = new GregorianCalendar(2008, Calendar.JUNE, 17).getTime();
		b = UtilValidadorDeDataFinalMaiorQueDataInicial.validar(d1, d2);
		assertEquals(false, b);

		d1 = new GregorianCalendar(2008, Calendar.OCTOBER, 17).getTime();
		d2 = null;
		b = UtilValidadorDeDataFinalMaiorQueDataInicial.validar(d1, d2);
		assertEquals(false, b);
	}

}
