/*
 * UtilReflexaoMetodoTest.java
 * 
 * Data de criação: 10/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.lang.reflect.Method;

import org.junit.Test;

import br.com.ap.reflexao.UtilReflexaoMetodo;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see UtilReflexaoPropriedade
 */
public class UtilReflexaoMetodoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoMetodo#get(java.lang.Class, java.lang.String, java.lang.Class[])}.
	 */
	@Test
	public final void testGet() {
		Class<?> classe = AlunoTO.class;
		Method m = UtilReflexaoMetodo.get(classe, "getNome");
		assertNotNull(m);

		m = UtilReflexaoMetodo.get(classe, "getNomeXXXX");
		assertNull(m);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoMetodo#invocar(java.lang.Object, java.lang.String, java.lang.Object[])}.
	 * 
	 * @throws ReflexaoException
	 */
	@Test
	public final void testInvocar() throws ReflexaoException {
		AlunoTO to = novoAlunoTO();

		String r = UtilReflexaoMetodo.invocar(to, "getNome");
		assertNotNull(r);

		r = UtilReflexaoMetodo.invocar(to, null);
		assertNull(r);

		try {
			r = UtilReflexaoMetodo.invocar(to, "getNomeXXXX");
			fail("Uma exceção deveria ter sido lançada.");
		} catch (ReflexaoException e) {
			assertNotNull(e.getMessage());
		}

	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoMetodo#getMetodoGet(java.lang.Class, java.lang.String)}.
	 */
	@Test
	public final void testGetMetodoGet() {
		Class<?> classe = AlunoTO.class;

		Method r = UtilReflexaoMetodo.getMetodoGet(classe, "nome");
		assertNotNull(r);

		r = UtilReflexaoMetodo.getMetodoGet(classe, null);
		assertNull(r);

		r = UtilReflexaoMetodo.getMetodoGet(classe, "nomeXXX");
		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoMetodo#getMetodoSet(java.lang.Class, java.lang.String, java.lang.Class)}.
	 */
	@Test
	public final void testGetMetodoSet() {
		Class<?> classe = AlunoTO.class;

		Method r = UtilReflexaoMetodo.getMetodoSet(classe, "nome", String.class);
		assertNotNull(r);

		r = UtilReflexaoMetodo.getMetodoSet(classe, null, null);
		assertNull(r);

		r = UtilReflexaoMetodo.getMetodoSet(classe, "nomeXXX", String.class);
		assertNull(r);

		r = UtilReflexaoMetodo.getMetodoSet(classe, "nome", Integer.class);
		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoMetodo#getTipoResultadoMetodoGet(java.lang.Class, java.lang.String)}.
	 */
	@Test
	public final void testGetTipoResultadoMetodoGet() {
		Class<?> classe = AlunoTO.class;

		Class<?> r = UtilReflexaoMetodo.getTipoResultadoMetodoGet(classe, "nome");
		assertNotNull(r);

		r = UtilReflexaoMetodo.getTipoResultadoMetodoGet(classe, null);
		assertNull(r);

		r = UtilReflexaoMetodo.getTipoResultadoMetodoGet(classe, "nomeXXX");
		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoMetodo#isExisteMetodo(java.lang.Class, java.lang.String, java.lang.Class[])}.
	 */
	@Test
	public final void testIsExisteMetodo() {
		Class<?> classe = AlunoTO.class;

		boolean r = UtilReflexaoMetodo.isExisteMetodo(classe, "getNome");
		assertTrue(r);

		r = UtilReflexaoMetodo.isExisteMetodo(classe, "setNome", String.class);
		assertTrue(r);

		r = UtilReflexaoMetodo.isExisteMetodo(classe, null);
		assertFalse(r);

		r = UtilReflexaoMetodo.isExisteMetodo(classe, "setNome");
		assertFalse(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoMetodo#isExisteMetodoGet(java.lang.Class, java.lang.String)}.
	 */
	@Test
	public final void testIsExisteMetodoGet() {
		Class<?> classe = AlunoTO.class;

		boolean r = UtilReflexaoMetodo.isExisteMetodoGet(classe, "nome");
		assertTrue(r);

		r = UtilReflexaoMetodo.isExisteMetodoGet(classe, "getNome");
		assertTrue(r);

		r = UtilReflexaoMetodo.isExisteMetodoGet(classe, "nomeXXX");
		assertFalse(r);

		r = UtilReflexaoMetodo.isExisteMetodoGet(classe, null);
		assertFalse(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoMetodo#isExisteMetodoSet(java.lang.Class, java.lang.String, java.lang.Class)}.
	 */
	@Test
	public final void testIsExisteMetodoSet() {
		Class<?> classe = AlunoTO.class;

		boolean r = UtilReflexaoMetodo.isExisteMetodoSet(classe, "nome", String.class);
		assertTrue(r);

		r = UtilReflexaoMetodo.isExisteMetodoSet(classe, "setNome", String.class);
		assertTrue(r);

		r = UtilReflexaoMetodo.isExisteMetodoSet(classe, "nomeXXX", String.class);
		assertFalse(r);

		r = UtilReflexaoMetodo.isExisteMetodoSet(classe, null, String.class);
		assertFalse(r);
	}

}
