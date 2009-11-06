/*
 * UtilValidadorDeStringsIguaisTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeStringsIguais;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilValidadorDeStringsIguais
 */
public class UtilValidadorDeStringsIguaisTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeStringsIguais#validar(java.lang.String[])}.
	 */
	@Test
	public final void testValidarStringArray() {
		String s = "abc";
		String _s = "abc";
		boolean b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(true, b);

		s = "abc";
		_s = "abc1";
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		s = "aBc";
		_s = "abC";
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		s = "abc";
		_s = "";
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		s = "";
		_s = "abc1";
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		s = "abc";
		_s = null;
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		s = null;
		_s = "abc1";
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		s = "";
		_s = "";
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		s = null;
		_s = null;
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeStringsIguais#validar(java.lang.Character[])}.
	 */
	@Test
	public final void testValidarCharacterArray() {
		Character s = getStringFactory().novoCharacter('A');
		Character _s = getStringFactory().novoCharacter('A');
		boolean b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(true, b);

		_s = getStringFactory().novoCharacter('B');
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		_s = null;
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);

		s = null;
		b = UtilValidadorDeStringsIguais.validar(s, _s);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeStringsIguais#validarIgnoreCase(java.lang.String[])}.
	 */
	@Test
	public final void testValidarIgnoreCaseStringArray() {
		String s = "abc";
		String _s = "abc";
		String _s2 = "abc";
		boolean b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s, _s2);
		assertEquals(true, b);

		s = "abc";
		_s = "abc";
		_s2 = "abc1";
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s, _s2);
		assertEquals(false, b);

		s = "aBc";
		_s = "abc";
		_s2 = "AbC";
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s, _s2);
		assertEquals(true, b);

		s = "abc";
		_s = "abc1";
		_s2 = "abc";
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s, _s2);
		assertEquals(false, b);

		s = "abc1";
		_s = "abc";
		_s2 = "abc";
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s, _s2);
		assertEquals(false, b);

		s = "abc";
		_s = "abc";
		_s2 = "";
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s, _s2);
		assertEquals(false, b);

		s = "abc";
		_s = "";
		_s2 = "abc1";
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s, _s2);
		assertEquals(false, b);

		s = "";
		_s = "abc";
		_s2 = "abc";
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s, _s2);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.validador.UtilValidadorDeStringsIguais#validarIgnoreCase(java.lang.Character[])}.
	 */
	@Test
	public final void testValidarIgnoreCaseCharacterArray() {
		Character s = getStringFactory().novoCharacter('A');
		Character _s = getStringFactory().novoCharacter('a');
		boolean b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s);
		assertEquals(true, b);

		_s = getStringFactory().novoCharacter('B');
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s);
		assertEquals(false, b);

		_s = null;
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s);
		assertEquals(false, b);

		s = null;
		b = UtilValidadorDeStringsIguais.validarIgnoreCase(s, _s);
		assertEquals(false, b);
	}

}
