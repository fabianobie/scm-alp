/*
 * UtilConversorDeTimestampTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeTimestamp;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeTimestamp
 */
public class UtilConversorDeTimestampTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeTimestamp#converterParaTime(java.sql.Timestamp)}.
	 */
	@Test
	public final void testConverterParaTime() {
		Timestamp ts = getDataFactory().novoTimestamp();

		Time t = UtilConversorDeTimestamp.converterParaTime(ts);
		assertNotNull(t);
		assertEquals(new Time(ts.getTime()), t);

		ts = null;
		t = UtilConversorDeTimestamp.converterParaTime(ts);
		assertNull(t);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeTimestamp#converterParaDate(java.sql.Timestamp)}.
	 */
	@Test
	public final void testConverterParaDate() {
		Timestamp ts = getDataFactory().novoTimestamp();

		Date t = UtilConversorDeTimestamp.converterParaDate(ts);
		assertNotNull(t);
		assertEquals(new Date(ts.getTime()), t);

		ts = null;
		t = UtilConversorDeTimestamp.converterParaDate(ts);
		assertNull(t);
	}

}
