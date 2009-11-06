/*
 * UtilConversorDeStringTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.constante.pattern.PatternDeData;
import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.formatador.UtilFormatadorDeData;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeString
 */
public class UtilConversorDeStringTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterSimNaoParaBooleano(java.lang.String)}.
	 */
	@Test
	public final void testConverterSimNaoParaBooleano() {
		boolean res = UtilConversorDeString.converterSimNaoParaBooleano("Sim");
		assertTrue(res);

		res = UtilConversorDeString.converterSimNaoParaBooleano("Não");
		assertFalse(res);

		res = UtilConversorDeString.converterSimNaoParaBooleano(null);
		assertFalse(res);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaBigDecimal(java.lang.String, int)}.
	 */
	@Test
	public final void testConverterParaBigDecimal() {
		String valor = "2";
		int precisao = 2;
		BigDecimal bd = null;

		bd = UtilConversorDeString.converterParaBigDecimal(valor, precisao);
		assertEquals(new BigDecimal(new BigInteger(valor), precisao), bd);

		valor = "";
		bd = UtilConversorDeString.converterParaBigDecimal(valor, precisao);
		assertNull(bd);

		valor = "20";
		precisao = 3;
		bd = UtilConversorDeString.converterParaBigDecimal(valor, precisao);
		assertEquals(new BigDecimal(new BigInteger(valor), precisao), bd);

		valor = null;
		precisao = 2;
		bd = UtilConversorDeString.converterParaBigDecimal(valor, precisao);
		assertNull(bd);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaInt(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaInt() {
		String i = "34";
		int _i = UtilConversorDeString.converterParaInt(i);
		assertEquals(34, _i);

		i = null;
		_i = UtilConversorDeString.converterParaInt(i);
		assertEquals(0, _i);

		i = "";
		_i = UtilConversorDeString.converterParaInt(i);
		assertEquals(0, _i);

		i = "abc";
		_i = UtilConversorDeString.converterParaInt(i);
		assertEquals(0, _i);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaInteger(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaInteger() {
		String i = "56";
		Integer _i = UtilConversorDeString.converterParaInteger(i);
		assertEquals(new Integer(56), _i);

		i = "45.69";
		_i = UtilConversorDeString.converterParaInteger(i);
		assertNull(_i);

		i = null;
		_i = UtilConversorDeString.converterParaInteger(i);
		assertNull(_i);

		i = "";
		_i = UtilConversorDeString.converterParaInteger(i);
		assertNull(_i);

		i = "abc";
		_i = UtilConversorDeString.converterParaInteger(i);
		assertNull(_i);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaLong(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaLong() {
		String l = "67L";
		long _l = UtilConversorDeString.converterParaLong(l);
		assertEquals(0L, _l);

		l = "67";
		_l = UtilConversorDeString.converterParaLong(l);
		assertEquals(67L, _l);

		l = null;
		_l = UtilConversorDeString.converterParaLong(l);
		assertEquals(0L, _l);

		l = "";
		_l = UtilConversorDeString.converterParaLong(l);
		assertEquals(0L, _l);

		l = "abc";
		_l = UtilConversorDeString.converterParaLong(l);
		assertEquals(0L, _l);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaLongWrapper(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaLongWrapper() {
		String l = "56L";
		Long _l = UtilConversorDeString.converterParaLongWrapper(l);
		assertNull(_l);

		l = "56";
		_l = UtilConversorDeString.converterParaLongWrapper(l);
		assertEquals(new Long(56), _l);

		l = null;
		_l = UtilConversorDeString.converterParaLongWrapper(l);
		assertNull(_l);

		l = "";
		_l = UtilConversorDeString.converterParaLongWrapper(l);
		assertNull(_l);

		l = "abc";
		_l = UtilConversorDeString.converterParaLongWrapper(l);
		assertNull(_l);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaBoolean(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaBoolean() {
		String b = new String("true");

		boolean _boolean = UtilConversorDeString.converterParaBoolean(b);
		assertEquals(true, _boolean);

		b = null;
		_boolean = UtilConversorDeString.converterParaBoolean(b);
		assertEquals(false, _boolean);

		_boolean = UtilConversorDeString.converterParaBoolean("asdf");
		assertEquals(false, _boolean);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaBooleanWrapper(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaBooleanWrapper() {
		String b = new String("true");

		Boolean _boolean = UtilConversorDeString.converterParaBooleanWrapper(b);
		assertEquals(new Boolean(true), _boolean);

		b = null;
		_boolean = UtilConversorDeString.converterParaBooleanWrapper(b);
		assertNull(_boolean);

		_boolean = UtilConversorDeString.converterParaBooleanWrapper("asdf");
		assertEquals(new Boolean(false), _boolean);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaByte(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaByte() {
		String b = "15";

		byte _byte = UtilConversorDeString.converterParaByte(b);
		assertEquals((byte) 15, _byte);

		b = null;
		_byte = UtilConversorDeString.converterParaByte(b);
		assertEquals((byte) 0, _byte);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaByteWrapper(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaByteWrapper() {
		String b = "15";

		Byte _byte = UtilConversorDeString.converterParaByteWrapper(b);
		assertEquals(new Byte((byte) 15), _byte);

		b = null;
		_byte = UtilConversorDeString.converterParaByteWrapper(b);
		assertNull(_byte);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaByteArray(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaByteArray() {
		String string = "35";
		byte[] valor = UtilConversorDeString.converterParaByteArray(string);
		assertNotNull(valor);
		assertTrue(valor.length == string.length());

		string = "invalido";
		valor = UtilConversorDeString.converterParaByteArray(string);
		assertNotNull(valor);
		assertTrue(valor.length == string.length());

		string = null;
		valor = UtilConversorDeString.converterParaByteArray(string);
		assertNull(valor);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaShort(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaShort() {
		String s = "45";
		short _s = UtilConversorDeString.converterParaShort(s);
		assertEquals(45, _s);

		s = null;
		_s = UtilConversorDeString.converterParaShort(s);
		assertEquals(0, _s);

		s = "";
		_s = UtilConversorDeString.converterParaShort(s);
		assertEquals(0, _s);

		s = "abc";
		_s = UtilConversorDeString.converterParaShort(s);
		assertEquals(0, _s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaShortWrapper(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaShortWrapper() {
		String s = "45";
		Short _s = UtilConversorDeString.converterParaShortWrapper(s);
		assertEquals(45, _s.shortValue());

		s = null;
		_s = UtilConversorDeString.converterParaShortWrapper(s);
		assertNull(_s);

		s = "";
		_s = UtilConversorDeString.converterParaShortWrapper(s);
		assertNull(_s);

		s = "abc";
		_s = UtilConversorDeString.converterParaShortWrapper(s);
		assertNull(_s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaChar(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaChar() {
		String c = new String("b");

		char _char = UtilConversorDeString.converterParaChar(c);
		assertEquals('b', _char);

		c = null;
		_char = UtilConversorDeString.converterParaChar(c);
		assertEquals('\u0000', _char);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaCharacter(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaCharacter() {
		String c = "b";

		Character _char = UtilConversorDeString.converterParaCharacter(c);
		assertEquals(new Character('b'), _char);

		c = null;
		_char = UtilConversorDeString.converterParaCharacter(c);
		assertNull(_char);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaFloat(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaFloat() {
		String floatString = "48.56";
		float f = UtilConversorDeString.converterParaFloat(floatString);
		assertEquals(48.56f, f, Float.POSITIVE_INFINITY);

		floatString = null;
		f = UtilConversorDeString.converterParaFloat(floatString);
		assertEquals(0f, f, Float.POSITIVE_INFINITY);

		floatString = "";
		f = UtilConversorDeString.converterParaFloat(floatString);
		assertEquals(0f, f, Float.POSITIVE_INFINITY);

		floatString = "abc";
		f = UtilConversorDeString.converterParaFloat(floatString);
		assertEquals(0f, f, Float.POSITIVE_INFINITY);

		floatString = "15";
		f = UtilConversorDeString.converterParaFloat(floatString);
		assertEquals(15f, f, Float.POSITIVE_INFINITY);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaFloatWrapper(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaFloatWrapper() {
		String floatString = "48.56";
		Float wrapper = UtilConversorDeString
				.converterParaFloatWrapper(floatString);
		assertEquals(48.56f, wrapper.floatValue(), Float.POSITIVE_INFINITY);

		floatString = null;
		wrapper = UtilConversorDeString.converterParaFloatWrapper(floatString);
		assertNull(wrapper);

		floatString = "";
		wrapper = UtilConversorDeString.converterParaFloatWrapper(floatString);
		assertNull(wrapper);

		floatString = "abc";
		wrapper = UtilConversorDeString.converterParaFloatWrapper(floatString);
		assertNull(wrapper);

		floatString = "15";
		wrapper = UtilConversorDeString.converterParaFloatWrapper(floatString);
		assertEquals(15f, wrapper.floatValue(), Float.POSITIVE_INFINITY);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaDouble(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaDouble() {
		String d = "35.44";

		double _double = UtilConversorDeString.converterParaDouble(d);
		assertEquals(35.44d, _double, Double.POSITIVE_INFINITY);

		d = "35,44";
		_double = UtilConversorDeString.converterParaDouble(d);
		assertEquals(35.44d, _double, Double.POSITIVE_INFINITY);

		d = null;
		_double = UtilConversorDeString.converterParaDouble(d);
		assertEquals(0d, _double, Double.POSITIVE_INFINITY);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaDoubleWrapper(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaDoubleWrapper() {
		String d = "35.44";

		Double _double = UtilConversorDeString.converterParaDoubleWrapper(d);
		assertEquals(new Double(35.44), _double);

		d = null;
		_double = UtilConversorDeString.converterParaDoubleWrapper(d);
		assertEquals(new Double(0d), _double);

		d = "0,00";
		_double = UtilConversorDeString.converterParaDoubleWrapper(d);
		assertEquals(new Double(0.0), _double);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaReader(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaReader() {
		String string = "35";
		Reader valor = UtilConversorDeString.converterParaReader(string);
		assertNotNull(valor);

		string = null;
		valor = UtilConversorDeString.converterParaReader(string);
		assertNull(valor);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData() {
		String dt = getDataString();

		Date data = UtilConversorDeString.converterParaData(dt, "dd/MM/yyyy");
		assertNotNull(data);

		data = UtilConversorDeString.converterParaData(null, null);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData_ddMMyyyy(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData_ddMMyyyy() {
		Date data = getDate();
		String dataFormatada = UtilFormatadorDeData.formatar_ddMMyyyy(data);

		data = UtilConversorDeString.converterParaData_ddMMyyyy(dataFormatada);
		assertNotNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData_ddMMyyyyEspacohhmm(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData_ddMMyyyyEspacohhmm() {
		Date data = getDate();
		String dataFormatada = UtilFormatadorDeData
				.formatar_ddMMyyyyEspacohhmm(data);

		data = UtilConversorDeString
				.converterParaData_ddMMyyyyEspacohhmm(dataFormatada);
		assertNotNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData_ddMMyyyyEspacoHHmm(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData_ddMMyyyyEspacoHHmm() {
		Date data = getDate();
		String dataFormatada = UtilFormatadorDeData
				.formatar_ddMMyyyyEspacoHHmm(data);

		data = UtilConversorDeString
				.converterParaData_ddMMyyyyEspacoHHmm(dataFormatada);
		assertNotNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData_ddMMyyyyEspacohhmmss(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData_ddMMyyyyEspacohhmmss() {
		Date data = getDate();
		String dataFormatada = UtilFormatadorDeData
				.formatar_ddMMyyyyEspacohhmmss(data);

		data = UtilConversorDeString
				.converterParaData_ddMMyyyyEspacohhmmss(dataFormatada);
		assertNotNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData_ddMMyyyyEspacoHHmmss(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData_ddMMyyyyEspacoHHmmss() {
		Date data = getDate();
		String dataFormatada = UtilFormatadorDeData
				.formatar_ddMMyyyyEspacoHHmmss(data);

		data = UtilConversorDeString
				.converterParaData_ddMMyyyyEspacoHHmmss(dataFormatada);
		assertNotNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData_padraoIBM(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData_padraoIBM() {
		Date data = getDate();
		String dataFormatada = UtilFormatadorDeData.formatar(data,
				PatternDeData.getPadraoIBM());

		data = UtilConversorDeString.converterParaData_padraoIBM(dataFormatada);
		assertNotNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData_padraoDB2(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData_padraoDB2() {
		Date data = getDate();
		String dataFormatada = UtilFormatadorDeData.formatar(data,
				PatternDeData.getPadraoDB2());

		data = UtilConversorDeString.converterParaData_padraoDB2(dataFormatada);
		assertNotNull(data);

		data = UtilConversorDeString.converterParaData_padraoDB2(null);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaData_ddMMyyyySeparadoPorPonto(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaData_ddMMyyyySeparadoPorPonto() {
		Date data = getDate();
		String dataFormatada = UtilFormatadorDeData.formatar(data,
				PatternDeData.getddMMyyyySeparadoPorPonto());

		data = UtilConversorDeString
				.converterParaData_ddMMyyyySeparadoPorPonto(dataFormatada);
		assertNotNull(data);

		data = UtilConversorDeString
				.converterParaData_ddMMyyyySeparadoPorPonto(null);
		assertNull(data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaTime(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testConverterParaTime() {
		String time = "18:35:55";
		String pattern = "hh:mm:ss";
		Time _t = getDataFactory().novoTime(18, 35, 55);

		Time t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNotNull(t);
		assertEquals(t.toString(), _t.toString());

		time = null;
		t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNull(t);

		time = "";
		t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNull(t);

		time = "abc";
		t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNull(t);

		time = "18:35:55";
		pattern = null;
		t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNull(t);

		time = "18:35:55";
		pattern = "";
		t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNull(t);

		time = "18:35:55";
		pattern = "abc";
		t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNull(t);

		time = "";
		pattern = "";
		t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNull(t);

		time = null;
		pattern = null;
		t = UtilConversorDeString.converterParaTime(time, pattern);
		assertNull(t);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaTime_hhmmss(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaTime_hhmmss() {
		String t = "18:35:52";
		Time _t = UtilConversorDeString.converterParaTime_hhmmss(t);
		Time _t2 = getDataFactory().getInstancia().novoTime(18, 35, 52);

		assertNotNull(_t);
		assertEquals(_t.toString(), _t2.toString());

		t = null;
		_t = UtilConversorDeString.converterParaTime_hhmmss(t);
		assertNull(_t);

		t = "";
		_t = UtilConversorDeString.converterParaTime_hhmmss(t);
		assertNull(_t);

		t = "abc";
		_t = UtilConversorDeString.converterParaTime_hhmmss(t);
		assertNull(_t);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaTime_hhmm(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaTime_hhmm() {
		String t = "18:35";
		Time _t = UtilConversorDeString.converterParaTime_hhmm(t);
		Time _t2 = getDataFactory().getInstancia().novoTime(18, 35, 00);

		assertNotNull(_t);
		assertEquals(_t.toString(), _t2.toString());

		t = null;
		_t = UtilConversorDeString.converterParaTime_hhmm(t);
		assertNull(_t);

		t = "";
		_t = UtilConversorDeString.converterParaTime_hhmm(t);
		assertNull(_t);

		t = "abc";
		_t = UtilConversorDeString.converterParaTime_hhmm(t);
		assertNull(_t);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaTime_HHmm(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaTime_HHmm() {
		String t = "18:35";
		Time _t = UtilConversorDeString.converterParaTime_HHmm(t);
		Time _t2 = getDataFactory().getInstancia().novoTime(18, 35, 00);

		assertNotNull(_t);
		assertEquals(_t.toString(), _t2.toString());

		t = null;
		_t = UtilConversorDeString.converterParaTime_HHmm(t);
		assertNull(_t);

		t = "";
		_t = UtilConversorDeString.converterParaTime_HHmm(t);
		assertNull(_t);

		t = "abc";
		_t = UtilConversorDeString.converterParaTime_HHmm(t);
		assertNull(_t);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaTimestamp(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testConverterParaTimestamp() {
		String data = "17/06/1986";
		String pattern = "dd/MM/yyyy";
		Calendar c = new GregorianCalendar(1986, 5, 17);

		Timestamp t = UtilConversorDeString.converterParaTimestamp(data,
				pattern);
		assertNotNull(t);
		assertEquals(c.getTime().getTime(), t.getTime());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaTimestamp_ddMMyyyyEspacohhmmss(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaTimestamp_ddMMyyyyEspacohhmmss() {
		String data = "17/06/1986 18:30:17";
		Calendar c = new GregorianCalendar(1986, 5, 17, 18, 30, 17);

		Timestamp t = UtilConversorDeString
				.converterParaTimestamp_ddMMyyyyEspacohhmmss(data);
		assertNotNull(t);
		assertEquals(c.getTime().getTime(), t.getTime());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeString#converterParaTimestamp_ddMMyyyyEspacohhmm(java.lang.String)}.
	 */
	@Test
	public final void testConverterParaTimestamp_ddMMyyyyEspacohhmm() {
		String data = "17/06/1986 18:30";
		Calendar c = new GregorianCalendar(1986, 5, 17, 18, 30);

		Timestamp t = UtilConversorDeString
				.converterParaTimestamp_ddMMyyyyEspacohhmm(data);
		assertNotNull(t);
		assertEquals(c.getTime().getTime(), t.getTime());
	}

	/**
	 * @return Date
	 */
	private Date getDate() {
		return getDataFactory().novoDate(15, 4, 2007);
	}

	/**
	 * @return data
	 */
	private String getDataString() {
		return "15/04/2007";
	}
}
