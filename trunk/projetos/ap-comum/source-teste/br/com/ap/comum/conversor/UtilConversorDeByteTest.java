/*
 * UtilConversorDeByteTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeByte;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeByte
 */
public class UtilConversorDeByteTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeByte#converterParaPrimitivo(java.lang.Byte)}.
	 */
	@Test
	public final void testConverterParaPrimitivo() {
		Byte b = new Byte((byte) 15);

		byte _byte = UtilConversorDeByte.converterParaPrimitivo(b);
		assertEquals((byte) 15, _byte);

		b = null;
		_byte = UtilConversorDeByte.converterParaPrimitivo(b);
		assertEquals((byte) 0, _byte);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeByte#converterParaByteWrapper(byte)}.
	 */
	@Test
	public final void testConverterParaByteWrapper() {
		byte b = (byte) 15;

		Byte _byte = UtilConversorDeByte.converterParaByteWrapper(b);
		assertEquals(new Byte((byte) 15), _byte);

		b = 0;
		_byte = UtilConversorDeByte.converterParaByteWrapper(b);
		assertEquals(new Byte((byte) 0), _byte);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeByte#converterParaString(java.lang.Byte)}.
	 */
	@Test
	public final void testConverterParaStringByte() {
		Byte i = new Byte((byte) 5);
		String s = UtilConversorDeByte.converterParaString(i);
		assertNotNull(s);
		assertEquals(i.toString(), s);

		i = null;
		s = UtilConversorDeByte.converterParaString(i);
		assertNull(s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeByte#converterParaString(byte)}.
	 */
	@Test
	public final void testConverterParaStringByte1() {
		byte i = 5;
		String s = UtilConversorDeByte.converterParaString(i);
		assertNotNull(s);
		assertEquals(String.valueOf(i), s);
	}

}
