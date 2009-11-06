/*
 * UtilFormatadorDeDataTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.constante.Constante;
import br.com.ap.comum.constante.pattern.PatternDeData;
import br.com.ap.comum.formatador.UtilFormatadorDeData;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeData
 */
public class UtilFormatadorDeDataTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar(java.util.Date, java.lang.String)}
	 * .
	 */
	@Test
	public final void testFormatar() {
		Date data = new Date();
		String pattern = "dd/MM/yyyy";

		String dataAtual = getDataAtual(pattern);

		String _data = UtilFormatadorDeData.formatar(data, pattern);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		data = null;
		pattern = "dd/MM/yyyy";
		_data = UtilFormatadorDeData.formatar(data, pattern);
		assertNull(_data);

		pattern = null;
		_data = UtilFormatadorDeData.formatar(data, pattern);
		assertNull(_data);

		pattern = "";
		_data = UtilFormatadorDeData.formatar(data, pattern);
		assertNull(_data);

		pattern = "abc";
		_data = UtilFormatadorDeData.formatar(data, pattern);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_ddMMyyyy(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_ddMMyyyy() {
		Date data = new Date();
		String dataAtual = getDataAtual("dd/MM/yyyy");

		String _data = UtilFormatadorDeData.formatar_ddMMyyyy(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		data = null;
		_data = UtilFormatadorDeData.formatar_ddMMyyyy(data);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_ddHifenMMHifenyyyy(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_ddHifenMMHifenyyyy() {
		Date data = new Date();
		String dataAtual = getDataAtual("dd-MM-yyyy");

		String _data = UtilFormatadorDeData.formatar_ddHifenMMHifenyyyy(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		data = null;
		_data = UtilFormatadorDeData.formatar_ddHifenMMHifenyyyy(data);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_ddMMyyyyEspacoHHmm(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_ddMMyyyyEspacoHHmm() {
		Date data = new Date();
		String dataAtual = getDataAtual("dd/MM/yyyy HH:mm");

		String _data = UtilFormatadorDeData.formatar_ddMMyyyyEspacoHHmm(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		_data = UtilFormatadorDeData.formatar_ddMMyyyyEspacoHHmm(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_ddMMyyyyEspacohhmm(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_ddMMyyyyEspacohhmm() {
		Date data = new Date();
		String dataAtual = getDataAtual("dd/MM/yyyy hh:mm");

		String _data = UtilFormatadorDeData.formatar_ddMMyyyyEspacohhmm(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		_data = UtilFormatadorDeData.formatar_ddMMyyyyEspacohhmm(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_ddMMyyyyEspacoHHmmss(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_ddMMyyyyEspacoHHmmss() {
		Date data = new Date();
		String dataAtual = getDataAtual("dd/MM/yyyy HH:mm:ss");

		String _data = UtilFormatadorDeData
				.formatar_ddMMyyyyEspacoHHmmss(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		_data = UtilFormatadorDeData.formatar_ddMMyyyyEspacoHHmmss(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_ddMMyyyyEspacohhmmss(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_ddMMyyyyEspacohhmmss() {
		Date data = new Date();
		String dataAtual = getDataAtual("dd/MM/yyyy hh:mm:ss");

		String _data = UtilFormatadorDeData
				.formatar_ddMMyyyyEspacohhmmss(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		_data = UtilFormatadorDeData.formatar_ddMMyyyyEspacohhmmss(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_hhmm(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_hhmm() {
		Date data = new Date();
		String horaAtual = getDataAtual("hh:mm");

		String _data = UtilFormatadorDeData.formatar_hhmm(data);

		assertNotNull(_data);
		assertEquals(horaAtual, _data);

		_data = UtilFormatadorDeData.formatar_hhmm(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_hhmmss(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_hhmmss() {
		Date data = new Date();
		String horaAtual = getDataAtual("hh:mm:ss");

		String _data = UtilFormatadorDeData.formatar_hhmmss(data);

		assertNotNull(_data);
		assertEquals(horaAtual, _data);

		_data = UtilFormatadorDeData.formatar_hhmmss(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_HHmm(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_HHmm() {
		Date data = new Date();
		String horaAtual = getDataAtual("HH:mm");

		String _data = UtilFormatadorDeData.formatar_HHmm(data);

		assertNotNull(_data);
		assertEquals(horaAtual, _data);

		_data = UtilFormatadorDeData.formatar_HHmm(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_HHmmss(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_HHmmss() {
		Date data = new Date();
		String horaAtual = getDataFormatada(data, "HH:mm:ss");

		String _data = UtilFormatadorDeData.formatar_HHmmss(data);

		assertNotNull(_data);
		assertEquals(horaAtual, _data);

		_data = UtilFormatadorDeData.formatar_HHmmss(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_MMMyyyy(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_MMMyyyy() {
		Date data = new Date();
		String dataAtual = getDataAtual("MMM/yyyy");

		String _data = UtilFormatadorDeData.formatar_MMMyyyy(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		_data = UtilFormatadorDeData.formatar_MMMyyyy(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_MMyyyy(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_MMyyyy() {
		Date data = new Date();
		String dataAtual = getDataAtual("MM/yyyy");

		String _data = UtilFormatadorDeData.formatar_MMyyyy(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		_data = UtilFormatadorDeData.formatar_MMyyyy(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_padraoDB2(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_padraoDB2() {
		Date data = getDataFactory().novoDate(23, 10, 1978, 9, 35, 30);

		String _data = UtilFormatadorDeData.formatar_padraoDB2(data);

		SimpleDateFormat sdf = new SimpleDateFormat(PatternDeData
				.getPadraoDB2());

		assertNotNull(_data);
		assertEquals(sdf.format(data), _data);

		_data = UtilFormatadorDeData.formatar_padraoDB2(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatar_padraoDB2yyyyMMdd(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatar_padraoDB2yyyyMMdd() {
		Date data = getDataFactory().novoDate(23, 10, 1978, 9, 35, 30);

		String _data = UtilFormatadorDeData.formatar_padraoDB2yyyyMMdd(data);

		SimpleDateFormat sdf = new SimpleDateFormat(PatternDeData
				.getyyyyMMddSeparadoPorTraco());

		assertNotNull(_data);
		assertEquals(sdf.format(data), _data);

		_data = UtilFormatadorDeData.formatar_padraoDB2yyyyMMdd(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatarParaExtenso(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatarParaExtenso() {
		Date data = new Date();
		String dataAtual = getDataAtual("EEEE, dd 'de' MMMM 'de' yyyy");

		String _data = UtilFormatadorDeData.formatarParaExtenso(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		_data = UtilFormatadorDeData.formatarParaExtenso(null);
		assertNull(_data);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeData#formatarParaDiaDaSemana(java.util.Date)}
	 * .
	 */
	@Test
	public final void testFormatarParaDiaDaSemana() {
		Date data = new Date();
		String dataAtual = getDataAtual("EEEE");

		String _data = UtilFormatadorDeData.formatarParaDiaDaSemana(data);

		assertNotNull(_data);
		assertEquals(dataAtual, _data);

		_data = UtilFormatadorDeData.formatarParaDiaDaSemana(null);
		assertNull(_data);
	}

	/**
	 * Retorna a Data atual no formado definido
	 * 
	 * @param pattern Pattern
	 * @return Data atual no formado definido
	 */
	protected String getDataAtual(String pattern) {
		Locale locale = Constante.getLocaleBrasil();

		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		return sdf.format(data);
	}

	/**
	 * Retorna a Data atual no formado definido
	 * 
	 * @param data Data
	 * @param pattern Pattern
	 * @return Data atual no formado definido
	 */
	protected String getDataFormatada(Date data, String pattern) {
		Locale locale = Constante.getLocaleBrasil();

		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		return sdf.format(data);
	}
}
