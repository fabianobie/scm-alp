/*
 * UtilSomadoresDeDataTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.calculadores;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.calculadores.UtilSomadoresDeData;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilSomadoresDeData
 */
public class UtilSomadoresDeDataTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeData#adicionarDias(java.util.Date, int)}.
	 */
	@Test
	public final void testAdicionarDias() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.DAY_OF_MONTH, 10);

		Date _data = UtilSomadoresDeData.adicionarDias(data, 10);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		c.setTime(data);
		c.add(Calendar.DAY_OF_MONTH, -10);

		_data = UtilSomadoresDeData.adicionarDias(data, -10);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		_data = UtilSomadoresDeData.adicionarDias(null, 10);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeData#adicionarMeses(java.util.Date, int)}.
	 */
	@Test
	public final void testAdicionarMeses() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.MONTH, 3);

		Date _data = UtilSomadoresDeData.adicionarMeses(data, 3);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		c.setTime(data);
		c.add(Calendar.MONTH, -3);

		_data = UtilSomadoresDeData.adicionarMeses(data, -3);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		_data = UtilSomadoresDeData.adicionarMeses(null, 3);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeData#adicionarAnos(java.util.Date, int)}.
	 */
	@Test
	public final void testAdicionarAnos() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.YEAR, 15);

		Date _data = UtilSomadoresDeData.adicionarAnos(data, 15);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		c.setTime(data);
		c.add(Calendar.YEAR, -15);

		_data = UtilSomadoresDeData.adicionarAnos(data, -15);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		_data = UtilSomadoresDeData.adicionarAnos(null, 15);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeData#adicionarHoras(java.util.Date, int)}.
	 */
	@Test
	public final void testAdicionarHoras() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.HOUR_OF_DAY, 6);

		Date _data = UtilSomadoresDeData.adicionarHoras(data, 6);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		c.setTime(data);
		c.add(Calendar.HOUR_OF_DAY, -6);
		_data = UtilSomadoresDeData.adicionarHoras(data, -6);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		_data = UtilSomadoresDeData.adicionarHoras(null, 6);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeData#adicionarMinutos(java.util.Date, int)}.
	 */
	@Test
	public final void testAdicionarMinutos() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.MINUTE, 23);

		Date _data = UtilSomadoresDeData.adicionarMinutos(data, 23);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		c.setTime(data);
		c.add(Calendar.MINUTE, -23);
		_data = UtilSomadoresDeData.adicionarMinutos(data, -23);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		_data = UtilSomadoresDeData.adicionarMinutos(null, 23);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.calculadores.UtilSomadoresDeData#adicionarSegundos(java.util.Date, int)}.
	 */
	@Test
	public final void testAdicionarSegundos() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.SECOND, 33);

		Date _data = UtilSomadoresDeData.adicionarSegundos(data, 33);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		c.setTime(data);
		c.add(Calendar.SECOND, -25);
		_data = UtilSomadoresDeData.adicionarSegundos(data, -25);
		assertNotNull(_data);
		assertEquals(c.getTimeInMillis(), _data.getTime());

		_data = UtilSomadoresDeData.adicionarSegundos(null, 33);
		assertNull(_data);
	}

}
