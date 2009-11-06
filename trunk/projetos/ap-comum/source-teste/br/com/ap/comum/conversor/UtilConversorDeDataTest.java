/*
 * UtilConversorDeDataTest.java
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
import br.com.ap.comum.conversor.UtilConversorDeData;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeData
 */
public class UtilConversorDeDataTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeData#converterParaUtilDate(java.sql.Date)}.
	 */
	@Test
	public final void testConverterParaUtilDate() {
		java.sql.Date dt = getSQLData();

		Date data = UtilConversorDeData.converterParaUtilDate(dt);
		assertNotNull(data);

		data = UtilConversorDeData.converterParaUtilDate(null);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeData#converterParaSqlDate(java.util.Date)}.
	 */
	@Test
	public final void testConverterParaSqlDate() {
		Date dt = getDate();

		java.sql.Date data = UtilConversorDeData.converterParaSqlDate(dt);
		assertNotNull(data);

		data = UtilConversorDeData.converterParaSqlDate(null);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeData#converterParaTimestamp(java.util.Date)}.
	 */
	@Test
	public final void testConverterParaTimestamp() {
		Date dt = getDate();

		Timestamp data = UtilConversorDeData.converterParaTimestamp(dt);
		assertNotNull(data);

		data = UtilConversorDeData.converterParaTimestamp(null);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeData#converterParaTime(java.util.Date)}.
	 */
	@Test
	public final void testConverterParaTime() {
		Date dt = getDate();

		Time data = UtilConversorDeData.converterParaTime(dt);
		assertNotNull(data);

		data = UtilConversorDeData.converterParaTime(null);
		assertNull(data);
	}

	/**
	 * @return Date
	 */
	private Date getDate() {
		return getDataFactory().novoDate(15, 4, 2007);
	}

	/**
	 * @return java.sql.Data
	 */
	private java.sql.Date getSQLData() {
		return getDataFactory().novoSqlDate(15, 4, 2007);
	}
}
