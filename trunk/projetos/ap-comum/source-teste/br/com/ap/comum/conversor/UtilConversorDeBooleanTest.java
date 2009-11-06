/*
 * UtilConversorDeBooleanTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.constante.Booleano;
import br.com.ap.comum.conversor.UtilConversorDeBoolean;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeBoolean
 */
public class UtilConversorDeBooleanTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBoolean#converterParaPrimitivo(java.lang.Boolean)}.
	 */
	@Test
	public final void testConverterParaPrimitivo() {
		Boolean b = new Boolean(true);

		boolean _boolean = UtilConversorDeBoolean.converterParaPrimitivo(b);
		assertEquals(true, _boolean);

		b = null;
		_boolean = UtilConversorDeBoolean.converterParaPrimitivo(b);
		assertEquals(false, _boolean);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBoolean#converterParaBooleanWrapper(boolean)}.
	 */
	@Test
	public final void testConverterParaBooleanWrapper() {
		boolean b = true;

		Boolean _boolean = UtilConversorDeBoolean
				.converterParaBooleanWrapper(b);
		assertEquals(new Boolean(true), _boolean);

		b = false;
		_boolean = UtilConversorDeBoolean.converterParaBooleanWrapper(b);
		assertEquals(new Boolean(false), _boolean);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBoolean#converterParaSimNao(boolean)}.
	 */
	@Test
	public final void testConverterParaSimNao() {
		String sim = UtilConversorDeBoolean.converterParaSimNao(true);
		assertEquals(Booleano.getSim(), sim);

		String nao = UtilConversorDeBoolean.converterParaSimNao(false);
		assertEquals(Booleano.getNao(), nao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBoolean#converterParaCodigoSimNao(boolean)}.
	 */
	@Test
	public final void testConverterParaCodigoSimNao() {
		String sim = UtilConversorDeBoolean.converterParaCodigoSimNao(true);
		assertEquals(Booleano.getCodigoSim(), sim);

		String nao = UtilConversorDeBoolean.converterParaCodigoSimNao(false);
		assertEquals(Booleano.getCodigoNao(), nao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBoolean#converterParaOnOff(boolean)}.
	 */
	@Test
	public final void testConverterParaOnOff() {
		String sim = UtilConversorDeBoolean.converterParaOnOff(true);
		assertEquals(Booleano.getOn(), sim);

		String nao = UtilConversorDeBoolean.converterParaOnOff(false);
		assertEquals(Booleano.getOff(), nao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBoolean#converterParaString(java.lang.Boolean)}.
	 */
	@Test
	public final void testConverterParaStringBoolean() {
		Boolean i = new Boolean(true);
		String s = UtilConversorDeBoolean.converterParaString(i);
		assertNotNull(s);
		assertEquals(i.toString(), s);

		i = null;
		s = UtilConversorDeBoolean.converterParaString(i);
		assertNull(s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeBoolean#converterParaString(boolean)}.
	 */
	@Test
	public final void testConverterParaStringBoolean1() {
		boolean i = true;
		String s = UtilConversorDeBoolean.converterParaString(i);
		assertNotNull(s);
		assertEquals(String.valueOf(i), s);
	}

}
