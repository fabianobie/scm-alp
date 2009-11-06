/*
 * UtilArrayTest.java
 * 
 * Data de criação: 01/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.array;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.colecao.Alterador;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.array.UtilArray
 */
public class UtilArrayTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#isArray(java.lang.Object)}.
	 */
	@Test
	public final void testIsArrayObject() {
		String[] a = getArrayDeString();
		assertTrue(UtilArray.isArray(a));

		String b = getStringFactory().novaString();
		assertFalse(UtilArray.isArray(b));

		assertFalse(UtilArray.isArray(null));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#isArray(java.lang.String)}.
	 */
	@Test
	public final void testIsArrayString() {
		assertEquals(true, UtilArray.isArray(getArrayDeString()));
		assertEquals(false, UtilArray.isArray("xxx"));

		String array = null;
		assertEquals(false, UtilArray.isArray(array));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#isVazio(java.lang.Object[])}.
	 */
	@Test
	public final void testIsVazio() {
		String[] array = getArrayDeString();

		boolean resposta = UtilArray.isVazio(array);
		assertFalse(resposta);

		array = new String[] {};
		resposta = UtilArray.isVazio(array);
		assertTrue(resposta);

		array = null;
		resposta = UtilArray.isVazio(array);
		assertFalse(resposta);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#novaInstanciaDeArray(java.lang.String)}.
	 */
	@Test
	public final void testNovaInstanciaDeArrayString() {
		String string = "java.lang.String[]";
		String[] array = null;
		try {
			array = UtilArray.novaInstanciaDeArray(string);
			assertNotNull(array);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}

		string = null;
		try {
			array = UtilArray.novaInstanciaDeArray(string);
			assertNull(array);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#novaInstanciaDeArray(java.lang.String, int)}.
	 */
	@Test
	public final void testNovaInstanciaDeArrayStringInt() {
		String string = "java.lang.String[]";
		String[] array = null;

		try {
			array = UtilArray.novaInstanciaDeArray(string, 5);
			assertNotNull(array);
			assertEquals(5, array.length);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}

		string = null;
		try {
			array = UtilArray.novaInstanciaDeArray(string, 5);
			assertNull(array);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#novaInstanciaDeArray(java.lang.Class)}.
	 */
	@Test
	public final void testNovaInstanciaDeArrayClassOfQ() {
		Class<?> tipo = String[].class;

		try {
			String[] resposta = null;
			resposta = UtilArray.novaInstanciaDeArray(tipo);
			assertNotNull(resposta);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}

		try {
			Integer[] resposta = null;
			tipo = int[].class;
			resposta = UtilArray.novaInstanciaDeArray(tipo);
			assertNotNull(resposta);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}

		try {
			String[] resposta = null;
			tipo = null;
			resposta = UtilArray.novaInstanciaDeArray(tipo);
			assertNull(resposta);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#novaClasseDeArray(java.lang.String)}.
	 */
	@Test
	public final void testNovaClasseDeArray() {
		String string = "java.lang.String[]";
		Class<?> array = null;
		try {
			array = UtilArray.novaClasseDeArray(string);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}
		try {
			array = UtilArray.novaClasseDeArray(null);
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}
		assertNull(array);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#getTipoDoArray(java.lang.Class)}.
	 */
	@Test
	public final void testGetTipoDoArray() {
		Class<?> resultado = null;
		Class<?> array = Integer[].class;
		Class<?> nulo = null;

		resultado = UtilArray.getTipoDoArray(array);
		assertNotNull(resultado);
		assertEquals(Integer.class, resultado);

		resultado = UtilArray.getTipoDoArray(nulo);
		assertNull(resultado);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#getString(java.lang.Class)}.
	 */
	@Test
	public final void testGetString() {
		Class<?> classe = int[].class;
		String string = UtilArray.getString(classe);
		assertEquals("int[]", string);

		classe = int.class;
		string = UtilArray.getString(classe);
		assertNull(string);

		classe = int[][].class;
		string = UtilArray.getString(classe);
		assertEquals("int[]", string);
	}

	/**
	 * Test method for
	 * br.com.ap.comum.array.UtilArray#getElementoDoIndice(T[] array, int
	 * indice).
	 */
	@Test
	public final void testGetElementoDoIndice() {
		String[] a = getArrayDeString();

		String item = UtilArray.getElementoDoIndice(a, 2);
		assertNotNull(item);

		item = UtilArray.getElementoDoIndice(a, 20);
		assertNull(item);
	}

	/**
	 * Test method for br.com.ap.comum.array.UtilArray#getTamanho(T[]).
	 */
	@Test
	public final void testGetTamanho() {
		String[] array = getArrayDeString();
		assertEquals(array.length, UtilArray.getTamanho(array));

		assertEquals(0, UtilArray.getTamanho(null));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.array.UtilArray#isTipoArrayByte(java.lang.Object)}.
	 */
	@Test
	public final void testIsTipoArrayByte() {
		Byte[] objeto = new Byte[] { new Byte("5") };
		boolean res = UtilArray.isTipoArrayByte(objeto);
		assertTrue(res);

		Byte _byte = new Byte("5");
		res = UtilArray.isTipoArrayByte(_byte);
		assertFalse(res);

		res = UtilArray.isTipoArrayByte(null);
		assertFalse(res);
	}

	/**
	 * Test method for
	 * br.com.ap.comum.array.UtilArray#aplicarAlterador(T[],
	 * br.com.ap.comum.colecao.IAlterador).
	 */
	@Test
	public final void testAplicarAlterador() {
		String[] string = getArrayDeString();
		string[3] = null;

		Alterador<String> alterador = new Alterador<String>() {
			public String alterar(String objeto) {
				return (objeto == null ? "" : objeto);
			}
		};
		string = UtilArray.aplicarAlterador(string, alterador);
		assertNotNull(string);

		for (int i = 0; i < string.length; i++) {
			assertNotNull(string[i]);
		}
	}

	/**
	 * @return array de string.
	 */
	private String[] getArrayDeString() {
		String[] a = new String[5];
		a[0] = "um";
		a[1] = "dois";
		a[2] = "três";
		a[3] = "quatro";
		a[4] = "cinco";
		return a;
	}

}
