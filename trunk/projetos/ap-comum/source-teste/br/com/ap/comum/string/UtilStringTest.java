/*
 * UtilStringTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.string;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.string.UtilString;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilString
 */
public class UtilStringTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isVazio(java.lang.String)}.
	 */
	@Test
	public final void testIsVazioString() {
		String s = "abc";
		boolean b = UtilString.isVazio(s);
		assertEquals(false, b);

		s = "";
		b = UtilString.isVazio(s);
		assertEquals(true, b);

		s = "      ";
		b = UtilString.isVazio(s);
		assertEquals(true, b);

		s = null;
		b = UtilString.isVazio(s);
		assertEquals(true, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isVazio(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsVazioStringString() {
		String s = "abc";
		String s1 = "abc";
		boolean b = UtilString.isVazio(s, s1);
		assertEquals(false, b);

		s = "";
		s1 = "";
		b = UtilString.isVazio(s, s1);
		assertEquals(true, b);

		s = "      ";
		s1 = "       ";
		b = UtilString.isVazio(s, s1);
		assertEquals(true, b);

		s = null;
		s1 = null;
		b = UtilString.isVazio(s, s1);
		assertEquals(true, b);

		s = "abc";
		b = UtilString.isVazio(s, s1);
		assertEquals(true, b);

		s = "";
		s1 = "abc";
		b = UtilString.isVazio(s, s1);
		assertEquals(true, b);

		s = null;
		s1 = "";
		b = UtilString.isVazio(s, s1);
		assertEquals(true, b);

		s1 = "abc";
		b = UtilString.isVazio(s, s1);
		assertEquals(true, b);

		s = "abc";
		s1 = "             ";
		b = UtilString.isVazio(s, s1);
		assertEquals(true, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isVazio(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsVazioStringStringString() {
		String s = "abc";
		String s1 = "abc";
		String s2 = "abc";
		boolean b = UtilString.isVazio(s, s1, s2);
		assertEquals(false, b);

		s = "";
		s1 = "";
		s2 = "";
		b = UtilString.isVazio(s, s1, s2);
		assertEquals(true, b);

		s = "      ";
		s1 = "       ";
		s2 = "      ";
		b = UtilString.isVazio(s, s1, s2);
		assertEquals(true, b);

		s = null;
		s1 = null;
		s2 = null;
		b = UtilString.isVazio(s, s1, s2);
		assertEquals(true, b);

		s = "abc";
		s2 = "abc";
		b = UtilString.isVazio(s, s1, s2);
		assertEquals(true, b);

		s = "";
		s1 = "abc";
		s2 = "        ";
		b = UtilString.isVazio(s, s1, s2);
		assertEquals(true, b);

		s = null;
		s1 = "";
		s2 = null;
		b = UtilString.isVazio(s, s1, s2);
		assertEquals(true, b);

		s1 = "abc";
		s2 = "abc       ";
		b = UtilString.isVazio(s, s1, s2);
		assertEquals(true, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isVazioTodos(java.lang.String[])}.
	 */
	@Test
	public final void testIsVazioTodos() {
		String s = "abc";
		String s1 = "abc";
		String s2 = "abc";
		boolean b = UtilString.isVazioTodos(s, s1, s2);
		assertEquals(false, b);

		s = "";
		s1 = "";
		s2 = "";
		b = UtilString.isVazioTodos(s, s1, s2);
		assertEquals(true, b);

		s = "      ";
		s1 = "       ";
		s2 = "      ";
		b = UtilString.isVazioTodos(s, s1, s2);
		assertEquals(true, b);

		s = null;
		s1 = null;
		s2 = null;
		b = UtilString.isVazioTodos(s, s1, s2);
		assertEquals(true, b);

		s = "abc";
		s2 = "abc";
		b = UtilString.isVazioTodos(s, s1, s2);
		assertEquals(true, b);

		s = "";
		s1 = "abc";
		s2 = "        ";
		b = UtilString.isVazioTodos(s, s1, s2);
		assertEquals(true, b);

		s = null;
		s1 = "";
		s2 = null;
		b = UtilString.isVazioTodos(s, s1, s2);
		assertEquals(true, b);

		s1 = "abc";
		s2 = "abc       ";
		b = UtilString.isVazioTodos(s, s1, s2);
		assertEquals(true, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#maiuscula(java.lang.String)}.
	 */
	@Test
	public final void testMaiusculaString() {
		String s = "abc";
		String _s = UtilString.maiuscula(s);
		assertEquals("ABC", _s);

		s = "";
		_s = UtilString.maiuscula(s);
		assertEquals("", _s);

		s = null;
		_s = UtilString.maiuscula(s);
		assertNull(_s);

		s = "abc def ghi";
		_s = UtilString.maiuscula(s);
		assertEquals("ABC DEF GHI", _s);

		s = "         ";
		_s = UtilString.maiuscula(s);
		assertEquals("         ", _s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#maiuscula(char)}.
	 */
	@Test
	public final void testMaiusculaChar() {
		char s = 'a';
		String _s = UtilString.maiuscula(s);
		assertEquals('A', _s.charAt(0));

		s = '\u0000';
		_s = UtilString.maiuscula(s);
		assertEquals('\u0000', _s.charAt(0));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#minuscula(java.lang.String)}.
	 */
	@Test
	public final void testMinusculaString() {
		String s = "ABC";
		String _s = UtilString.minuscula(s);
		assertEquals("abc", _s);

		s = "";
		_s = UtilString.minuscula(s);
		assertEquals("", _s);

		s = null;
		_s = UtilString.minuscula(s);
		assertNull(_s);

		s = "ABC DEF GHI";
		_s = UtilString.minuscula(s);
		assertEquals("abc def ghi", _s);

		s = "         ";
		_s = UtilString.minuscula(s);
		assertEquals("         ", _s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#minuscula(char)}.
	 */
	@Test
	public final void testMinusculaChar() {
		char s = 'A';
		String _s = UtilString.minuscula(s);
		assertEquals('a', _s.charAt(0));

		s = '\u0000';
		_s = UtilString.minuscula(s);
		assertEquals('\u0000', _s.charAt(0));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#substituirString(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testSubstituirString() {
		String src = "atirei o pau no gato";
		String localizar = "o pau";
		String nova = "a pedra";

		String r = UtilString.substituirString(src, localizar, nova);
		assertNotNull(r);
		assertEquals("atirei a pedra no gato", r);

		src = "atirei o pau no gato";
		localizar = null;
		nova = "";

		r = UtilString.substituirString(src, localizar, nova);
		assertNotNull(r);
		assertEquals(src, r);

		src = "";
		localizar = "blabla";
		nova = "bla";

		r = UtilString.substituirString(src, localizar, nova);
		assertNotNull(r);
		assertEquals(src, r);

		src = null;
		localizar = "blabla";
		nova = "bla";

		r = UtilString.substituirString(src, localizar, nova);
		assertNull(r);

		src = "abc ddd abc ddd abc abc ddd ddd ddd abc";
		localizar = "abc";
		nova = "ddd";

		r = UtilString.substituirString(src, localizar, nova);
		assertNotNull(r);
		assertEquals("ddd ddd ddd ddd ddd ddd ddd ddd ddd ddd", r);

		src = "abcdddabcdddabcabcdddddddddabc";
		localizar = "abc";
		nova = "ddd";

		r = UtilString.substituirString(src, localizar, nova);
		assertNotNull(r);
		assertEquals("dddddddddddddddddddddddddddddd", r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#substituirStringSe(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testSubstituirStringSe() {
		String string = "a0b1c2d3";

		string = UtilString.substituirStringSe(true, string, "a", "A", "_");
		assertNotNull(string);
		assertEquals(string, "A0b1c2d3");

		string = UtilString.substituirStringSe(false, string, "A", "A", "_");
		assertNotNull(string);
		assertEquals(string, "_0b1c2d3");
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#remover(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRemover() {
		String src = "abcxxxdefxxxghixxxjlm";
		String remove = "xxx";

		String r = UtilString.remover(src, remove);
		assertNotNull(r);
		assertEquals("abcdefghijlm", r);

		src = "";
		remove = "xxx";

		r = UtilString.remover(src, remove);
		assertNotNull(r);
		assertEquals("", r);

		src = "abcdefghi";
		remove = "";

		r = UtilString.remover(src, remove);
		assertNotNull(r);
		assertEquals(src, r);

		src = null;
		remove = "";

		r = UtilString.remover(src, remove);
		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#split(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testSplitStringString() {
		String src = "abc|def|ghi";
		String token = "|";
		List<String> l = new ArrayList<String>();
		l.add("abc");
		l.add("def");
		l.add("ghi");

		List<String> _l = UtilString.split(src, token);
		assertNotNull(_l);
		for (int i = 0; i < _l.size(); i++) {
			assertEquals(l.get(i), _l.get(i));
		}

		src = "";
		token = "|";
		_l = UtilString.split(src, token);
		assertNotNull(_l);
		assertEquals(0, _l.size());

		src = "abc|def|ghi";
		token = "";
		_l = UtilString.split(src, token);
		assertNotNull(_l);
		assertEquals(0, _l.size());

		src = "abc|def|ghi";
		token = null;
		_l = UtilString.split(src, token);
		assertNotNull(_l);
		assertEquals(0, _l.size());

		src = null;
		token = "|";
		_l = UtilString.split(src, token);
		assertNotNull(_l);
		assertEquals(0, _l.size());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#split(java.lang.String, int)}.
	 */
	@Test
	public final void testSplitStringInt() {
		String string = "Adriano   Juliana   Fulano    ";
		int tamanho = 10;
		List<String> lista = UtilString.split(string, tamanho);
		assertNotNull(lista);
		assertTrue(lista.size() == 3);

		tamanho = 0;
		lista = UtilString.split(string, tamanho);
		assertNotNull(lista);
		assertTrue(lista.size() == string.length());

		string += "Didi";
		tamanho = 10;
		lista = UtilString.split(string, tamanho);
		assertNotNull(lista);
		assertTrue(lista.size() == 4);

		string = null;
		lista = UtilString.split(string, tamanho);
		assertNotNull(lista);
		assertTrue(lista.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isTemString(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsTemString() {
		String src = "abcdefghi";
		String localizar = "cde";
		boolean b = UtilString.isTemString(src, localizar);
		assertEquals(true, b);

		src = "abcdefghi";
		localizar = "x";
		b = UtilString.isTemString(src, localizar);
		assertEquals(false, b);

		src = "";
		localizar = "cde";
		b = UtilString.isTemString(src, localizar);
		assertEquals(false, b);

		src = null;
		localizar = "cde";
		b = UtilString.isTemString(src, localizar);
		assertEquals(false, b);

		src = "abcdefghi";
		localizar = "";
		b = UtilString.isTemString(src, localizar);
		assertEquals(false, b);

		src = "abcdefghi";
		localizar = null;
		b = UtilString.isTemString(src, localizar);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isNoTamanho(java.lang.String, int)}.
	 */
	@Test
	public final void testIsNoTamanho() {
		String s = "abcdefghij";
		int t = 10;
		boolean b = UtilString.isNoTamanho(s, t);
		assertEquals(true, b);

		s = "abcdefghij";
		t = 17;
		b = UtilString.isNoTamanho(s, t);
		assertEquals(false, b);

		s = "";
		t = 17;
		b = UtilString.isNoTamanho(s, t);
		assertEquals(false, b);

		s = null;
		t = 17;
		b = UtilString.isNoTamanho(s, t);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#repetir(java.lang.String, int)}.
	 */
	@Test
	public final void testRepetir() {
		String src = "abc";
		int i = 3;
		String s = UtilString.repetir(src, i);
		assertNotNull(s);
		assertEquals("abcabcabc", s);

		src = "abc";
		i = 0;
		s = UtilString.repetir(src, i);
		assertNotNull(s);
		assertEquals("", s);

		src = "";
		i = 0;
		s = UtilString.repetir(src, i);
		assertNotNull(s);
		assertEquals("", s);

		src = null;
		i = 0;
		s = UtilString.repetir(src, i);
		assertNotNull(s);
		assertEquals("", s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#completarAEsquerda(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testCompletarAEsquerda() {
		String src = "def";
		String nova = "x";
		int i = 3;
		String s = UtilString.completarAEsquerda(src, nova, i);
		assertNotNull(s);
		assertEquals("def", s);

		src = "";
		nova = "x";
		i = 3;
		s = UtilString.completarAEsquerda(src, nova, i);
		assertNotNull(s);
		assertEquals("xxx", s);

		src = "def";
		nova = "";
		i = 3;
		s = UtilString.completarAEsquerda(src, nova, i);
		assertNotNull(s);
		assertEquals("def", s);

		src = null;
		nova = "x";
		i = 3;
		s = UtilString.completarAEsquerda(src, nova, i);
		assertNotNull(s);
		assertEquals("xxx", s);

		src = "sdsf";
		nova = null;
		i = 3;
		s = UtilString.completarAEsquerda(src, nova, i);
		assertNotNull(s);
		assertEquals("sdsf", s);

		src = "def";
		nova = "x";
		i = 0;
		s = UtilString.completarAEsquerda(src, nova, i);
		assertNotNull(s);
		assertEquals(src, s);

		src = "3";
		nova = "0";
		i = 5;
		s = UtilString.completarAEsquerda(src, nova, i);
		assertNotNull(s);
		assertEquals("00003", s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#completarADireita(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testCompletarADireita() {
		String src = "abc";
		String nova = "x";
		int i = 3;
		String s = UtilString.completarADireita(src, nova, i);
		assertNotNull(s);
		assertEquals("abc", s);

		src = "";
		nova = "x";
		i = 3;
		s = UtilString.completarADireita(src, nova, i);
		assertNotNull(s);
		assertEquals("xxx", s);

		src = "def";
		nova = "";
		i = 3;
		s = UtilString.completarADireita(src, nova, i);
		assertNotNull(s);
		assertEquals("def", s);

		src = null;
		nova = "x";
		i = 3;
		s = UtilString.completarADireita(src, nova, i);
		assertNotNull(s);
		assertEquals("xxx", s);

		src = "sdsf";
		nova = null;
		i = 3;
		s = UtilString.completarADireita(src, nova, i);
		assertNotNull(s);
		assertEquals("sdsf", s);

		src = "def";
		nova = "x";
		i = 0;
		s = UtilString.completarADireita(src, nova, i);
		assertNotNull(s);
		assertEquals(src, s);

		src = "5";
		nova = "0";
		i = 5;
		s = UtilString.completarADireita(src, nova, i);
		assertNotNull(s);
		assertEquals("50000", s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#removerCaracteres(java.lang.String)}.
	 */
	@Test
	public final void testRemoverCaracteres() {
		String s = "abcd1234_=+]~[^^";
		String _s = UtilString.removerCaracteres(s);
		assertNotNull(_s);
		assertEquals("1234", _s);

		s = "";
		_s = UtilString.removerCaracteres(s);
		assertNotNull(_s);
		assertEquals(s, _s);

		s = null;
		_s = UtilString.removerCaracteres(s);
		assertNull(_s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#removerAcentuacao(java.lang.String)}.
	 */
	@Test
	public final void testRemoverAcentuacao() {
		String s = "áõíçÇÉüÜ~^´`¨";

		String r = UtilString.removerAcentuacao(s);
		assertNotNull(r);

		s = null;
		r = UtilString.removerAcentuacao(s);
		assertNull(r);

		s = "";
		r = UtilString.removerAcentuacao(s);
		assertNotNull(r);
		assertEquals("", r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#removerNumeros(java.lang.String)}.
	 */
	@Test
	public final void testRemoverNumeros() {
		String s = "abcd1234_=+]~[^^";
		String _s = UtilString.removerNumeros(s);
		assertNotNull(_s);
		assertEquals("abcd_=+]~[^^", _s);

		s = "";
		_s = UtilString.removerNumeros(s);
		assertNotNull(_s);
		assertEquals(s, _s);

		s = null;
		_s = UtilString.removerNumeros(s);
		assertNull(_s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#removerSufixo(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRemoverSufixo() {
		String string = "stringPreSufixo";
		String sufixo = "Sufixo";

		string = UtilString.removerSufixo(string, sufixo);
		assertNotNull(string);
		assertEquals(string, "stringPre");

		string = UtilString.removerSufixo(string, sufixo);
		assertNotNull(string);
		assertEquals(string, "stringPre");

		sufixo = null;
		string = UtilString.removerSufixo(string, sufixo);
		assertNotNull(string);
		assertEquals(string, "stringPre");
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#removerPrefixo(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRemoverPrefixo() {
		String string = "0051118";
		String prefixo = "0";

		string = UtilString.removerPrefixo(string, prefixo);
		assertNotNull(string);
		assertEquals(string, "51118");

		string = UtilString.removerPrefixo(string, prefixo);
		assertNotNull(string);
		assertEquals(string, "51118");

		prefixo = null;
		string = UtilString.removerPrefixo(string, prefixo);
		assertNotNull(string);
		assertEquals(string, "51118");
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#trim(java.lang.String)}.
	 */
	@Test
	public final void testTrim() {
		String s = "       slçfsjf     ";
		String _s = UtilString.trim(s);
		assertNotNull(_s);
		assertEquals("slçfsjf", _s);

		s = "";
		_s = UtilString.trim(s);
		assertNotNull(_s);
		assertEquals("", _s);

		s = null;
		_s = UtilString.trim(s);
		assertNull(_s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#substring(java.lang.String, int)}.
	 */
	@Test
	public final void testSubstringStringInt() {
		String string = "abcdefg";
		int indice = 0;

		String res = UtilString.substring(string, indice);
		assertNotNull(res);
		assertEquals(string, res);

		indice = 9;
		res = UtilString.substring(string, indice);
		assertNotNull(res);
		assertEquals(string, res);

		indice = 3;
		res = UtilString.substring(string, indice);
		assertNotNull(res);
		assertEquals(string.substring(3), res);

		string = null;
		indice = 9;
		res = UtilString.substring(string, indice);
		assertNull(res);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#substring(java.lang.String, int, int)}.
	 */
	@Test
	public final void testSubstringStringIntInt() {
		String string = "abcdefg";
		int inicio = 0;
		int fim = 0;
		String res = UtilString.substring(string, inicio, fim);
		assertNotNull(res);
		assertEquals(string.substring(inicio, fim), res);

		inicio = 9;
		fim = 10;
		res = UtilString.substring(string, inicio, fim);
		assertNotNull(res);
		assertEquals(string, res);

		inicio = 3;
		fim = 5;
		res = UtilString.substring(string, inicio, fim);
		assertNotNull(res);
		assertEquals(string.substring(inicio, fim), res);

		inicio = 2;
		fim = 1;
		res = UtilString.substring(string, inicio, fim);
		assertNotNull(res);
		assertEquals("", res);

		fim = 20;
		res = UtilString.substring(string, inicio, fim);
		assertNotNull(res);
		assertEquals(string.substring(inicio, string.length()), res);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#getNomeMetodo(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testGetNomeMetodo() {
		String nome = "algumNome";
		String prefixo = "get";
		String metodo = UtilString.getNomeMetodo(prefixo, nome);
		assertNotNull(metodo);
		assertEquals("getAlgumNome", metodo);

		nome = "";
		prefixo = "get";
		metodo = UtilString.getNomeMetodo(prefixo, nome);
		assertNotNull(metodo);
		assertEquals("", metodo);

		nome = "algumNome";
		prefixo = "";
		metodo = UtilString.getNomeMetodo(prefixo, nome);
		assertNotNull(metodo);
		assertEquals("", metodo);

		nome = null;
		prefixo = "get";
		metodo = UtilString.getNomeMetodo(prefixo, nome);
		assertNotNull(metodo);
		assertEquals("", metodo);

		nome = "algumNome";
		prefixo = null;
		metodo = UtilString.getNomeMetodo(prefixo, nome);
		assertNotNull(metodo);
		assertEquals("", metodo);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#getNomeDoAtributo(java.lang.String)}.
	 */
	@Test
	public final void testGetNomeDoAtributo() {
		String nome = "algumNome";
		String metodo = UtilString.getNomeDoAtributo(nome);
		assertNotNull(metodo);
		assertEquals("algumNome", metodo);

		nome = "";
		metodo = UtilString.getNomeDoAtributo(nome);
		assertNotNull(metodo);
		assertEquals("", metodo);

		nome = null;
		metodo = UtilString.getNomeDoAtributo(nome);
		assertNotNull(metodo);
		assertEquals("", metodo);

		nome = "getNome";
		metodo = UtilString.getNomeDoAtributo(nome);
		assertNotNull(metodo);
		assertEquals("nome", metodo);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#getQuantidadeDeCaracteres(java.lang.String, char)}.
	 */
	@Test
	public final void testGetQuantidadeDeCaracteres() {
		String string = "012305602";
		char caracter = '0';

		int quantidade = UtilString.getQuantidadeDeCaracteres(string, caracter);
		assertEquals(3, quantidade);

		caracter = 'b';
		quantidade = UtilString.getQuantidadeDeCaracteres(string, caracter);
		assertEquals(0, quantidade);

		string = null;
		caracter = '0';
		quantidade = UtilString.getQuantidadeDeCaracteres(string, caracter);
		assertEquals(0, quantidade);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#getString(java.lang.Object)}.
	 */
	@Test
	public final void testGetString() {
		Integer objeto = new Integer(35);

		String string = UtilString.getString(objeto);
		assertNotNull(string);

		objeto = null;
		string = UtilString.getString(objeto);
		assertNull(string);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#getBytes(java.lang.String)}.
	 */
	@Test
	public final void testGetBytes() {
		String string = "Adriano";

		byte[] bytes = UtilString.getBytes(string);
		assertNotNull(bytes);
		assertTrue(bytes.length == string.length());

		string = null;
		bytes = UtilString.getBytes(string);
		assertNull(bytes);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#getReader(java.lang.String)}.
	 */
	@Test
	public final void testGetReader() {
		String string = "Adriano";

		Reader r = UtilString.getReader(string);
		assertNotNull(r);

		string = null;
		r = UtilString.getReader(string);
		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isSomenteLetras(java.lang.String)}.
	 */
	@Test
	public final void testIsSomenteLetras() {
		String string = "abc";

		boolean b = UtilString.isSomenteLetras(string);
		assertTrue(b);

		string = null;
		b = UtilString.isSomenteLetras(string);
		assertFalse(b);

		string = "ae9.";
		b = UtilString.isSomenteLetras(string);
		assertFalse(b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#getTamanho(java.lang.String)}.
	 */
	@Test
	public final void testGetTamanho() {
		String s = new String("abcd");
		assertEquals(s.length(), UtilString.getTamanho(s));

		s = null;
		assertEquals(0, UtilString.getTamanho(s));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#getPrimeiraMaiuscula(java.lang.String)}.
	 */
	@Test
	public final void testGetPrimeiraMaiuscula() {
		String s = new String("aBcD");
		assertEquals(1, UtilString.getPrimeiraMaiuscula(s));
		
		s = null;
		assertEquals(-1, UtilString.getPrimeiraMaiuscula(s));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isStringsIguais(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsStringsIguais() {
		String origem = "xyz";
		String destino = "abc";

		boolean r = UtilString.isStringsIguais(origem, destino);
		assertFalse(r);

		destino = "xyz";
		r = UtilString.isStringsIguais(origem, destino);
		assertTrue(r);

		r = UtilString.isStringsIguais(null, null);
		assertFalse(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.string.UtilString#isStringsIguaisIgnoreCase(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsStringsIguaisIgnoreCase() {
		String origem = "xyz";
		String destino = "abc";

		boolean r = UtilString.isStringsIguaisIgnoreCase(origem, destino);
		assertFalse(r);

		destino = "xyZ";
		r = UtilString.isStringsIguaisIgnoreCase(origem, destino);
		assertTrue(r);

		r = UtilString.isStringsIguaisIgnoreCase(null, null);
		assertFalse(r);
	}

}
