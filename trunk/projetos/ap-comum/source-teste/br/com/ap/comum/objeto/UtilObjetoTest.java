/*
 * UtilObjetoTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.objeto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilObjeto
 */
public class UtilObjetoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#getNome(java.lang.Object)}.
	 */
	@Test
	public final void testGetNome() {
		Object objeto = new String();

		String s = UtilObjeto.getNome(objeto);
		assertNotNull(s);
		assertEquals(String.class.getName(), s);

		objeto = String.class;
		s = UtilObjeto.getNome(objeto);
		assertNotNull(s);
		assertEquals(String.class.getName(), s);

		objeto = String[].class;
		s = UtilObjeto.getNome(objeto);
		assertNotNull(s);
		assertEquals(String.class.getName() + "[]", s);

		objeto = new String[] {};
		s = UtilObjeto.getNome(objeto);
		assertNotNull(s);
		assertEquals(String.class.getName() + "[]", s);

		objeto = new String[][] {};
		s = UtilObjeto.getNome(objeto);
		assertNotNull(s);
		assertEquals(String.class.getName() + "[]", s);

		objeto = null;
		s = UtilObjeto.getNome(objeto);
		assertNull(s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#getNomeSemPacote(java.lang.Object)}.
	 */
	@Test
	public final void testGetNomeSemPacote() {
		Object objeto = new String();

		String s = UtilObjeto.getNomeSemPacote(objeto);
		assertNotNull(s);
		assertEquals("String", s);

		objeto = String.class;
		s = UtilObjeto.getNomeSemPacote(objeto);
		assertNotNull(s);
		assertEquals("String", s);

		objeto = String[].class;
		s = UtilObjeto.getNomeSemPacote(objeto);
		assertNotNull(s);
		assertEquals("String[]", s);

		objeto = new String[] {};
		s = UtilObjeto.getNomeSemPacote(objeto);
		assertNotNull(s);
		assertEquals("String[]", s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#getClasse(java.lang.Object)}.
	 */
	@Test
	public final void testGetClasse() {
		String x = "";
		Class<String> c = UtilObjeto.getClasse(x);
		assertNotNull(c);
		
		c = UtilObjeto.getClasse(null);
		assertNull(c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#getObjetoComReferencia(Object[])}.
	 */
	@Test
	public final void testGetObjetoComReferencia() {
		String um = "um";
		String dois = null;
		String tres = "três";
		
		String r = UtilObjeto.getObjetoComReferencia(um, dois, tres);
		assertSame(um, r);
		
		r = UtilObjeto.getObjetoComReferencia(null, null, null);
		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isReferencia(java.lang.Object)}.
	 */
	@Test
	public final void testIsReferenciaObject() {
		String s = "";
		boolean _s = UtilObjeto.isReferencia(s);
		assertEquals(true, _s);

		s = null;
		_s = UtilObjeto.isReferencia(s);
		assertEquals(false, _s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isReferencia(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public final void testIsReferenciaObjectObject() {
		String s = "";
		String s1 = "";
		boolean _s = UtilObjeto.isReferencia(s, s1);
		assertEquals(true, _s);

		s = null;
		_s = UtilObjeto.isReferencia(s, s1);
		assertEquals(false, _s);

		s1 = null;
		_s = UtilObjeto.isReferenciaTodos(s, s1);
		assertEquals(false, _s);
	}
	
	/**
	 * Test method for {@link br.com.ap.comum.objeto.UtilObjeto#isReferencia(java.lang.Object, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public final void testIsReferenciaObjectObjectObject() {
		String s = "";
		String s1 = "";
		String s2 = "";
		boolean _s = UtilObjeto.isReferencia(s, s1, s2);
		assertTrue(_s);

		s = null;
		_s = UtilObjeto.isReferencia(s, s1, s2);
		assertFalse(_s);

		s1 = null;
		_s = UtilObjeto.isReferencia(s, s1, s2);
		assertFalse(_s);
	}

	/**
	 * Test method for {@link br.com.ap.comum.objeto.UtilObjeto#isReferenciaTodos(java.lang.Object[])}.
	 */
	@Test
	public final void testIsReferenciaTodos() {
		String s = "";
		String s1 = "";
		String s2 = "";
		boolean _s = UtilObjeto.isReferenciaTodos(s, s1, s2);
		assertTrue(_s);
		
		s = null;
		_s = UtilObjeto.isReferenciaTodos(s, s1, s2);
		assertFalse(_s);
		
		s1 = null;
		_s = UtilObjeto.isReferenciaTodos(s, s1, s2);
		assertFalse(_s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isColecao(java.lang.Object)}.
	 */
	@Test
	public final void testIsColecaoObject() {
		Collection<Object> c = new ArrayList<Object>();

		boolean b = UtilObjeto.isColecao(c);
		assertEquals(true, b);

		b = UtilObjeto.isColecao("".getClass());
		assertEquals(false, b);

		b = UtilObjeto.isColecao(null);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isColecao(java.lang.Class)}.
	 */
	@Test
	public final void testIsColecaoClassOfQ() {
		assertFalse(UtilObjeto.isColecao(null));
		assertFalse(UtilObjeto.isColecao(Map.class));
		assertTrue(UtilObjeto.isColecao(Collection.class));
		assertTrue(UtilObjeto.isColecao(Vector.class));
		assertTrue(UtilObjeto.isColecao(ArrayList.class));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isComparable(java.lang.Object)}.
	 */
	@Test
	public final void testIsComparableObject() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isComparable(java.lang.Class)}.
	 */
	@Test
	public final void testIsComparableClassOfQ() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isMapa(java.lang.Object)}.
	 */
	@Test
	public final void testIsMapaObject() {
		assertFalse(UtilObjeto.isMapa(null));
		assertFalse(UtilObjeto.isMapa(new ArrayList<Object>()));
		assertTrue(UtilObjeto.isMapa(new HashMap<Object, Object>()));
		assertFalse(UtilObjeto.isMapa(new Vector<Object>()));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isMapa(java.lang.Class)}.
	 */
	@Test
	public final void testIsMapaClassOfQ() {
		assertFalse(UtilObjeto.isMapa(null));
		assertFalse(UtilObjeto.isMapa(Collection.class));
		assertTrue(UtilObjeto.isMapa(HashMap.class));
		assertFalse(UtilObjeto.isMapa(Vector.class));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isClasse(java.lang.Object)}.
	 */
	@Test
	public final void testIsClasse() {
		Object objeto = String.class;

		boolean b = UtilObjeto.isClasse(objeto);
		assertTrue(b);

		objeto = String[].class;
		b = UtilObjeto.isClasse(objeto);
		assertTrue(b);

		objeto = null;
		b = UtilObjeto.isClasse(objeto);
		assertFalse(b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isInteger(java.lang.Object)}.
	 */
	@Test
	public final void testIsInteger() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isLong(java.lang.Object)}.
	 */
	@Test
	public final void testIsLong() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isBoolean(java.lang.Object)}.
	 */
	@Test
	public final void testIsBoolean() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isByte(java.lang.Object)}.
	 */
	@Test
	public final void testIsByte() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isShort(java.lang.Object)}.
	 */
	@Test
	public final void testIsShort() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isCharacter(java.lang.Object)}.
	 */
	@Test
	public final void testIsCharacter() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isFloat(java.lang.Object)}.
	 */
	@Test
	public final void testIsFloat() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isDouble(java.lang.Object)}.
	 */
	@Test
	public final void testIsDouble() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isString(java.lang.Object)}.
	 */
	@Test
	public final void testIsString() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isDate(java.lang.Object)}.
	 */
	@Test
	public final void testIsDate() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isSqlDate(java.lang.Object)}.
	 */
	@Test
	public final void testIsSqlDate() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isTime(java.lang.Object)}.
	 */
	@Test
	public final void testIsTime() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isTimestamp(java.lang.Object)}.
	 */
	@Test
	public final void testIsTimestamp() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isReader(java.lang.Object)}.
	 */
	@Test
	public final void testIsReader() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isBigDecimal(java.lang.Object)}.
	 */
	@Test
	public final void testIsBigDecimal() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilObjeto#isObjetoDoTipo(java.lang.Object, java.lang.Class)}.
	 */
	@Test
	public final void testIsObjetoDoTipo() {
		Object objeto = new ArrayList<Object>();
		Class<?> tipo = List.class;

		boolean r = UtilObjeto.isObjetoDoTipo(objeto, tipo);
		assertTrue(r);

		tipo = Integer.class;
		r = UtilObjeto.isObjetoDoTipo(objeto, tipo);
		assertFalse(r);

		tipo = Collection.class;
		r = UtilObjeto.isObjetoDoTipo(objeto, tipo);
		assertTrue(r);

		tipo = ArrayList.class;
		r = UtilObjeto.isObjetoDoTipo(objeto, tipo);
		assertTrue(r);
	}

}
