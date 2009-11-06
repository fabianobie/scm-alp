/*
 * UtilDataTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.constante.Data;
import br.com.ap.comum.data.UtilData;
import br.com.ap.comum.fabrica.DataFactory;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilData
 */
public class UtilDataTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getDiasDoAno(java.util.Date)}.
	 */
	@Test
	public final void testGetDiasDoAnoDate() {
		Calendar c = new GregorianCalendar(1986, 6, 17);
		int diasDoAno = UtilData.getDiasDoAno(c.getTime());

		assertEquals(c.getActualMaximum(Calendar.DAY_OF_YEAR), diasDoAno);

		diasDoAno = UtilData.getDiasDoAno(null);
		assertEquals(0, diasDoAno);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getDiasDoAno(int)}.
	 */
	@Test
	public final void testGetDiasDoAnoInt() {
		Calendar c = new GregorianCalendar(1986, 6, 17);
		int diasDoAno = UtilData.getDiasDoAno(1986);

		assertEquals(c.getActualMaximum(Calendar.DAY_OF_YEAR), diasDoAno);

		diasDoAno = UtilData.getDiasDoAno(-52);
		assertEquals(0, diasDoAno);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getDiasDoMes(java.util.Date)}.
	 */
	@Test
	public final void testGetDiasDoMesDate() {
		Calendar c = new GregorianCalendar(1986, Calendar.OCTOBER, 17);
		int diasDoMes = UtilData.getDiasDoMes(c.getTime());

		assertEquals(c.getActualMaximum(Calendar.DAY_OF_MONTH), diasDoMes);

		diasDoMes = UtilData.getDiasDoMes(null);
		assertEquals(0, diasDoMes);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getDiasDoMes(int)}.
	 */
	@Test
	public final void testGetDiasDoMesInt() {
		Calendar c = new GregorianCalendar(1986, Calendar.OCTOBER, 17);
		int diasDoMes = UtilData.getDiasDoMes(10);

		assertEquals(c.getActualMaximum(Calendar.DAY_OF_MONTH), diasDoMes);

		diasDoMes = UtilData.getDiasDoMes(-52);
		assertEquals(0, diasDoMes);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getDiaDaSemana(java.util.Date)}.
	 */
	@Test
	public final void testGetDiaDaSemana() {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		int diaSemana = UtilData.getDiaDaSemana(d);
		assertEquals(c.get(Calendar.DAY_OF_WEEK), diaSemana);

		diaSemana = UtilData.getDiaDaSemana(null);
		assertEquals(0, diaSemana);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getHoraNoFormatoDe12(java.util.Date)}.
	 */
	@Test
	public final void testGetHoraNoFormatoDe12() {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		int hora = UtilData.getHoraNoFormatoDe12(d);
		assertEquals(c.get(Calendar.HOUR), hora);

		hora = UtilData.getDiaDaSemana(null);
		assertEquals(0, hora);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getHoraNoFormatoDe24(java.util.Date)}.
	 */
	@Test
	public final void testGetHoraNoFormatoDe24() {
		Date d = getDataFactory().novoDate(23, 10, 2000, 14, 35);
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		int hora = UtilData.getHoraNoFormatoDe12(d);
		assertEquals(c.get(Calendar.HOUR), hora);

		hora = UtilData.getDiaDaSemana(null);
		assertEquals(0, hora);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#parse(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testParseStringString() {
		String data = "17/06/1986";
		String pattern = "dd/MM/yyyy";
		Calendar c = new GregorianCalendar(1986, 05, 17);

		Date _data = UtilData.parse(data, pattern);

		assertNotNull(_data);
		assertEquals(_data.getTime(), c.getTimeInMillis());

		data = null;
		pattern = "dd/MM/yyyy";
		_data = UtilData.parse(data, pattern);
		assertNull(_data);

		data = "";
		pattern = "dd/MM/yyyy";
		_data = UtilData.parse(data, pattern);
		assertNull(_data);

		data = "abc";
		pattern = "dd/MM/yyyy";
		_data = UtilData.parse(data, pattern);
		assertNull(_data);

		data = "17/06/1986";
		pattern = null;
		_data = UtilData.parse(data, pattern);
		assertNull(_data);

		data = "17/06/1986";
		pattern = "";
		_data = UtilData.parse(data, pattern);
		assertNull(_data);

		data = "17/06/1986";
		pattern = "abc";
		_data = UtilData.parse(data, pattern);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#parse(java.lang.String, java.lang.String, boolean)}.
	 */
	@Test
	public final void testParseStringStringBoolean() {
		String data = "17/06/1986";
		String pattern = "dd/MM/yyyy";
		Calendar c = new GregorianCalendar(1986, 05, 17);

		Date _data = UtilData.parse(data, pattern, false);

		assertNotNull(_data);
		assertEquals(_data.getTime(), c.getTimeInMillis());

		data = null;
		pattern = "dd/MM/yyyy";
		_data = UtilData.parse(data, pattern, false);
		assertNull(_data);

		data = "";
		pattern = "dd/MM/yyyy";
		_data = UtilData.parse(data, pattern, false);
		assertNull(_data);

		data = "abc";
		pattern = "dd/MM/yyyy";
		_data = UtilData.parse(data, pattern, false);
		assertNull(_data);

		data = "17/06/1986";
		pattern = null;
		_data = UtilData.parse(data, pattern, false);
		assertNull(_data);

		data = "17/06/1986";
		pattern = "";
		_data = UtilData.parse(data, pattern, false);
		assertNull(_data);

		data = "50/06/1986";
		pattern = "dd/MM/yyyy";
		_data = UtilData.parse(data, pattern, false);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getAno(java.util.Date)}.
	 */
	@Test
	public final void testGetAno() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		int ano = UtilData.getAno(calendario.getTime());
		assertEquals(calendario.get(Calendar.YEAR), ano);

		ano = UtilData.getAno(null);
		assertEquals(Data.getPrimeiroAnoDefault(), ano);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getMes(java.util.Date)}.
	 */
	@Test
	public final void testGetMes() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		int mes = UtilData.getMes(calendario.getTime());
		assertEquals(calendario.get(Calendar.MONTH) + 1, mes);

		mes = UtilData.getMes(null);
		assertEquals(Data.getPrimeiroMesDefault(), mes);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getDia(java.util.Date)}.
	 */
	@Test
	public final void testGetDia() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		int dia = UtilData.getDia(calendario.getTime());
		assertEquals(calendario.get(Calendar.DAY_OF_MONTH), dia);

		dia = UtilData.getDia(null);
		assertEquals(Data.getPrimeiroDiaDoMesDefault(), dia);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getUltimoDiaDoMes(java.util.Date)}.
	 */
	@Test
	public final void testGetUltimoDiaDoMesDate() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		int dia = UtilData.getUltimoDiaDoMes(calendario.getTime());
		assertEquals(calendario.getActualMaximum(Calendar.DAY_OF_MONTH), dia);

		dia = UtilData.getUltimoDiaDoMes(null);
		assertEquals(0, dia);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getUltimoDiaDoMes(int)}.
	 */
	@Test
	public final void testGetUltimoDiaDoMesInt() {
		int dia = UtilData.getUltimoDiaDoMes(1);
		assertEquals(dia, 31);

		dia = UtilData.getUltimoDiaDoMes(12);
		assertEquals(dia, 31);

		dia = UtilData.getUltimoDiaDoMes(40);
		assertEquals(dia, 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getUltimoDiaDoMes()}.
	 */
	@Test
	public final void testGetUltimoDiaDoMes() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		int dia = UtilData.getUltimoDiaDoMes();
		assertEquals(calendario.getActualMaximum(Calendar.DAY_OF_MONTH), dia);

		dia = UtilData.getUltimoDiaDoMes(null);
		assertEquals(0, dia);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarData(java.util.Date, int, int, int)}.
	 */
	@Test
	public final void testAjustarDataDateIntIntInt() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		Date data = UtilData.ajustarData(calendario.getTime(), 1, 1, 1);
		assertNotNull(data);

		calendario.setTime(data);
		assertEquals(calendario.get(Calendar.HOUR), 1);

		data = UtilData.ajustarData(null, 1, 1, 1);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarData(java.util.Date, java.sql.Time)}.
	 */
	@Test
	public final void testAjustarDataDateTime() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());
		Date data = calendario.getTime();
		Time hora = DataFactory.getInstancia().novoTime(15, 30, 35);

		Date novaData = UtilData.ajustarData(data, hora);
		assertNotNull(novaData);

		data = null;
		hora = null;
		novaData = UtilData.ajustarData(data, hora);
		assertNull(novaData);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarDataParaHora(java.util.Date, int)}.
	 */
	@Test
	public final void testAjustarDataParaHora() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		Date data = UtilData.ajustarDataParaHora(calendario.getTime(), 4);
		assertNotNull(data);

		calendario.setTime(data);
		assertEquals(calendario.get(Calendar.HOUR_OF_DAY), 4);

		data = UtilData.ajustarDataParaHora(calendario.getTime(), 200);
		assertNotNull(data);

		data = UtilData.ajustarDataParaHora(null, 1);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarDataParaMinuto(java.util.Date, int)}.
	 */
	@Test
	public final void testAjustarDataParaMinuto() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		Date data = UtilData.ajustarDataParaMinuto(calendario.getTime(), 4);
		assertNotNull(data);

		calendario.setTime(data);
		assertEquals(calendario.get(Calendar.MINUTE), 4);

		data = UtilData.ajustarDataParaMinuto(calendario.getTime(), 200);
		assertNotNull(data);

		data = UtilData.ajustarDataParaMinuto(null, 1);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarDataParaSegundos(java.util.Date, int)}.
	 */
	@Test
	public final void testAjustarDataParaSegundos() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		Date data = UtilData.ajustarDataParaSegundos(calendario.getTime(), 4);
		assertNotNull(data);

		calendario.setTime(data);
		assertEquals(calendario.get(Calendar.SECOND), 4);

		data = UtilData.ajustarDataParaSegundos(calendario.getTime(), 200);
		assertNotNull(data);

		data = UtilData.ajustarDataParaSegundos(null, 1);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarDataParaDia(java.util.Date, int)}.
	 */
	@Test
	public final void testAjustarDataParaDia() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		Date data = UtilData.ajustarDataParaDia(calendario.getTime(), 1);
		assertNotNull(data);

		calendario.setTime(data);
		assertEquals(calendario.get(Calendar.DAY_OF_MONTH), 1);

		data = UtilData.ajustarDataParaDia(calendario.getTime(), 200);
		assertNotNull(data);

		data = UtilData.ajustarDataParaDia(null, 1);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarDataParaMes(java.util.Date, int)}.
	 */
	@Test
	public final void testAjustarDataParaMes() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		Date data = UtilData.ajustarDataParaMes(calendario.getTime(), 1);
		assertNotNull(data);

		calendario.setTime(data);
		assertEquals(calendario.get(Calendar.MONTH), 0);

		data = UtilData.ajustarDataParaMes(calendario.getTime(), 200);
		assertNotNull(data);

		data = UtilData.ajustarDataParaMes(null, 1);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarDataParaAno(java.util.Date, int)}.
	 */
	@Test
	public final void testAjustarDataParaAno() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());

		Date data = UtilData.ajustarDataParaAno(calendario.getTime(), 1915);
		assertNotNull(data);

		calendario.setTime(data);
		assertEquals(calendario.get(Calendar.YEAR), 1915);

		data = UtilData.ajustarDataParaMes(null, 1915);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarDataParaMilisegundo(java.util.Date, int)}.
	 */
	@Test
	public final void testAjustarDataParaMilisegundo() {
		Timestamp ts = getDataFactory().novoTimestamp(23, 10, 1978, 04, 35, 30, 355);
		assertNotNull(ts);
		assertTrue((ts.getNanos() == 355));
		ts = UtilData.ajustarDataParaMilisegundo(ts, 455);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#ajustarTimeZone(java.lang.String)}.
	 */
	@Test
	public final void testAjustarTimeZone() {
		// desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.data.UtilData#getDataNula()}.
	 */
	@Test
	public final void testGetDataNula() {
		Date d = UtilData.getDataNula();
		Date dN = getDataFactory().novoDate(Data.getPrimeiroDiaDoMesDefault(),
				Data.getPrimeiroMesDefault(), Data.getPrimeiroAnoDefault());

		assertEquals(UtilData.getDia(d), UtilData.getDia(dN));
		assertEquals(UtilData.getMes(d), UtilData.getMes(dN));
		assertEquals(UtilData.getAno(d), UtilData.getAno(dN));
	}

}
