/*
 * UtilFormatadorDeRealTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.UtilFormatadorDeReal;
import br.com.ap.comum.string.UtilString;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilFormatadorDeReal
 */
public class UtilFormatadorDeRealTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeReal#formatar(java.lang.Number)}.
	 */
	@Test
	public final void testFormatarNumber() {
		Float f = new Float(16618.545);
		String _r = UtilFormatadorDeReal.formatar(f);

		assertNotNull(_r);
		assertEquals("16.618,545", _r);

		f = null;
		_r = UtilFormatadorDeReal.formatar(f);
		assertNull(_r);

		Double d = new Double(4916514.458);
		_r = UtilFormatadorDeReal.formatar(d);

		assertNotNull(_r);
		assertEquals("4.916.514,458", _r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeReal#formatar(java.lang.Number, int)}.
	 */
	@Test
	public final void testFormatarNumberInt() {
		Float f = new Float(16618.545);
		String _r = UtilFormatadorDeReal.formatar(f, 2);

		assertNotNull(_r);
		assertEquals("16.618,54", _r);

		f = null;
		_r = UtilFormatadorDeReal.formatar(f, 5);
		assertNull(_r);

		Double d = new Double(4916514.458);
		_r = UtilFormatadorDeReal.formatar(d, 5);

		assertNotNull(_r);
		assertEquals("4.916.514,45800", _r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeReal#formatar(double)}.
	 */
	@Test
	public final void testFormatarDouble() {
		double d = 4916514.458;

		String _r = UtilFormatadorDeReal.formatar(d);
		assertNotNull(_r);
		assertEquals("4.916.514,458", _r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeReal#formatar(double, int)}.
	 */
	@Test
	public final void testFormatarDoubleInt() {
		double d = 020000000021d;

		String _r = UtilFormatadorDeReal.formatar(d, 8);
		assertNotNull(_r);
		assertEquals("20.000.000.021,00000000", _r);

		d = 020000000021d;
		_r = UtilFormatadorDeReal.formatar(d, 20);
		assertNotNull(_r);
		//assertEquals(_r, UtilString.removerPrefixo(d, "0"));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeReal#formatar(java.lang.String, int)}.
	 */
	@Test
	public final void testFormatarStringInt() {
		String d = "020000000021";

		String _r = UtilFormatadorDeReal.formatar(d, 8);
		assertNotNull(_r);
		assertEquals("200,00000021", _r);

		d = null;
		_r = UtilFormatadorDeReal.formatar(d, 8);
		assertNull(_r);

		d = "020000000021";
		_r = UtilFormatadorDeReal.formatar(d, 20);
		assertNotNull(_r);
		assertEquals(_r, UtilString.removerPrefixo(d, "0"));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeReal#formatarParaMonetario(double)}.
	 */
	@Test
	public final void testFormatarParaMonetarioDouble() {
		double d = 4916514.458d;
		String _r = UtilFormatadorDeReal.formatarParaMonetario(d);

		assertNotNull(_r);
		assertEquals("R$ 4.916.514,458", _r);

		_r = UtilFormatadorDeReal.formatarParaMonetario(0.0d);
		assertNotNull(_r);
		assertEquals("R$ 0,00", _r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeReal#formatarParaMonetario(java.lang.Number)}.
	 */
	@Test
	public final void testFormatarParaMonetarioNumber() {
		Double d = new Double(4916514.458d);
		String _r = UtilFormatadorDeReal.formatarParaMonetario(d);

		assertNotNull(_r);
		assertEquals("R$ 4.916.514,458", _r);

		d = null;
		_r = UtilFormatadorDeReal.formatarParaMonetario(d);
		assertNull(_r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.formatador.UtilFormatadorDeReal#formatarParaMonetarioSemPrefixo(java.lang.Number)}.
	 */
	@Test
	public final void testFormatarParaMonetarioSemPrefixo() {
		BigDecimal d = new BigDecimal(4916514.458d);
		String _r = UtilFormatadorDeReal.formatarParaMonetarioSemPrefixo(d);

		assertNotNull(_r);
		assertEquals("4.916.514,458", _r);

		d = null;
		_r = UtilFormatadorDeReal.formatarParaMonetarioSemPrefixo(d);
		assertNull(_r);
	}

}
