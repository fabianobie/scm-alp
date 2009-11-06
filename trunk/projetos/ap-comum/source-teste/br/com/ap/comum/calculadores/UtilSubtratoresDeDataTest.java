/*
 * UtilSubtratoresDeDataTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.calculadores.UtilSubtratoresDeData;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilSubtratoresDeData
 */
public class UtilSubtratoresDeDataTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeData#getMinutosEntreDatas(java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testGetMinutosEntreDatas() {
		Calendar c = new GregorianCalendar(1986, Calendar.JUNE, 17, 18, 30, 27);
		Calendar _c = new GregorianCalendar(1986, Calendar.JUNE, 17, 18, 55, 27);
		long m = UtilSubtratoresDeData.getMinutosEntreDatas(c.getTime(), _c
				.getTime());

		assertEquals(25, m);

		m = UtilSubtratoresDeData.getMinutosEntreDatas(null, _c.getTime());

		assertEquals(0, m);

		m = UtilSubtratoresDeData.getMinutosEntreDatas(c.getTime(), null);

		assertEquals(0, m);

		m = UtilSubtratoresDeData.getMinutosEntreDatas(null, null);

		assertEquals(0, m);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeData#getDiasEntreDatas(java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testGetDiasEntreDatas() {
		Calendar c = new GregorianCalendar(1986, Calendar.JUNE, 17, 18, 30, 27);
		Calendar _c = new GregorianCalendar(1986, Calendar.JUNE, 28, 18, 30, 27);
		long m = UtilSubtratoresDeData.getDiasEntreDatas(c.getTime(), _c
				.getTime());

		assertEquals(11, m);

		m = UtilSubtratoresDeData.getDiasEntreDatas(null, _c.getTime());

		assertEquals(0, m);

		m = UtilSubtratoresDeData.getDiasEntreDatas(c.getTime(), null);

		assertEquals(0, m);

		m = UtilSubtratoresDeData.getDiasEntreDatas(null, null);

		assertEquals(0, m);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeData#getMesesEntreDatas(java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testGetMesesEntreDatas() {
		Calendar c = new GregorianCalendar(1986, Calendar.JUNE, 17, 18, 30, 27);
		Calendar _c = new GregorianCalendar(1986, Calendar.NOVEMBER, 17, 18,
				30, 27);
		long m = UtilSubtratoresDeData.getMesesEntreDatas(c.getTime(), _c
				.getTime());

		assertEquals(5, m);

		m = UtilSubtratoresDeData.getMesesEntreDatas(null, _c.getTime());

		assertEquals(0, m);

		m = UtilSubtratoresDeData.getMesesEntreDatas(c.getTime(), null);

		assertEquals(0, m);

		m = UtilSubtratoresDeData.getMesesEntreDatas(null, null);

		assertEquals(0, m);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeData#getAnosEntreDatas(java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testGetAnosEntreDatas() {
		Calendar c = new GregorianCalendar(1986, Calendar.JUNE, 17, 18, 30, 27);
		Calendar _c = new GregorianCalendar(1998, Calendar.JUNE, 17, 18, 30, 27);
		long m = UtilSubtratoresDeData.getAnosEntreDatas(c.getTime(), _c
				.getTime());

		assertEquals(12, m);

		m = UtilSubtratoresDeData.getAnosEntreDatas(null, _c.getTime());

		assertEquals(0, m);

		m = UtilSubtratoresDeData.getAnosEntreDatas(c.getTime(), null);

		assertEquals(0, m);

		m = UtilSubtratoresDeData.getAnosEntreDatas(null, null);

		assertEquals(0, m);
	}


	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSubtratoresDeData#isDataFinalMaiorQueDataInicial(java.util.Date, java.util.Date)}.
	 */
	@Test
	public final void testIsDataFinalMaiorQueDataInicial() {
		Date d0 = getDataFactory().novoDate(15, 05, 2000);
		Date d1 = getDataFactory().novoDate(15, 05, 2006);
		
		boolean r = UtilSubtratoresDeData.isDataFinalMaiorQueDataInicial(d0, d1);
		assertTrue(r);
		
		r = UtilSubtratoresDeData.isDataFinalMaiorQueDataInicial(null, null);
		assertFalse(r);
		
		
	}

}
