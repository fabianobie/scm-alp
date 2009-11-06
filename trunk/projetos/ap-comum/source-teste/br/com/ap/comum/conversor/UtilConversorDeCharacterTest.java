/*
 * UtilConversorDeCharacterTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeCharacter;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeCharacter
 */
public class UtilConversorDeCharacterTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeCharacter#converterParaPrimitivo(java.lang.Character)}.
	 */
	@Test
	public final void testConverterParaPrimitivo() {
		Character c = new Character('b');

		char _char = UtilConversorDeCharacter.converterParaPrimitivo(c);
		assertEquals('b', _char);

		c = null;
		_char = UtilConversorDeCharacter.converterParaPrimitivo(c);
		assertEquals('\u0000', _char);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeCharacter#converterParaCharacter(char)}.
	 */
	@Test
	public final void testConverterParaCharacter() {
		char c = 'b';

		Character _char = UtilConversorDeCharacter.converterParaCharacter(c);
		assertEquals(new Character('b'), _char);

		c = '\u0000';
		_char = UtilConversorDeCharacter.converterParaCharacter(c);
		assertEquals(new Character('\u0000'), _char);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeCharacter#converterParaString(java.lang.Character)}.
	 */
	@Test
	public final void testConverterParaStringCharacter() {
		Character i = new Character('f');
		String s = UtilConversorDeCharacter.converterParaString(i);
		assertNotNull(s);
		assertEquals(i.toString(), s);

		i = null;
		s = UtilConversorDeCharacter.converterParaString(i);
		assertNull(s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeCharacter#converterParaString(char)}.
	 */
	@Test
	public final void testConverterParaStringChar() {
		char i = 'f';
		String s = UtilConversorDeCharacter.converterParaString(i);
		assertNotNull(s);
		assertEquals(String.valueOf(i), s);
	}

}
