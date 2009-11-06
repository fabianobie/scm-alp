/*
 * UtilPrimitivoTest.java
 * 
 * Data de criação: 04/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.objeto;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.objeto.UtilPrimitivo;

/**
 * JUnit.
 * 
 * @author adrianop
 * @see UtilPrimitivo
 */
public class UtilPrimitivoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#isPrimitivo(java.lang.String)}.
	 */
	@Test
	public final void testIsPrimitivoString() {
		String p = "int";
		boolean b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(true, b);

		p = "float";
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(true, b);

		p = "double";
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(true, b);

		p = "short";
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(true, b);

		p = "";
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(false, b);

		p = null;
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(false, b);

		p = "abc";
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#isPrimitivo(java.lang.Class)}.
	 */
	@Test
	public final void testIsPrimitivoClassOfQ() {
		Class<?> p = int.class;
		boolean b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(true, b);

		p = float.class;
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(true, b);

		p = double.class;
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(true, b);

		p = short.class;
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(true, b);

		p = "".getClass();
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(false, b);

		p = null;
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(false, b);

		p = "abc".getClass();
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(false, b);

		p = new Integer("3").getClass();
		b = UtilPrimitivo.isPrimitivo(p);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#isWrapper(java.lang.Class)}.
	 */
	@Test
	public final void testIsWrapperClassOfQ() {
		Class<?> c = Integer.class;
		boolean b = UtilPrimitivo.isWrapper(c);
		assertEquals(true, b);

		c = Float.class;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(true, b);

		c = Double.class;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(true, b);

		c = Short.class;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(true, b);

		c = String.class;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);

		c = null;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);

		c = int.class;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);

		c = float.class;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);

		c = short.class;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#isWrapper(java.lang.String)}.
	 */
	@Test
	public final void testIsWrapperString() {
		String c = "java.lang.Integer";
		boolean b = UtilPrimitivo.isWrapper(c);
		assertEquals(true, b);

		c = "java.lang.Float";
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(true, b);

		c = "java.lang.Double";
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(true, b);

		c = "java.lang.Short";
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(true, b);

		c = "java.lang.String";
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);

		c = null;
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);

		c = "int";
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);

		c = "float";
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);

		c = "short";
		b = UtilPrimitivo.isWrapper(c);
		assertEquals(false, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getClasseWrapperDoPrimitivo(java.lang.Class)}.
	 */
	@Test
	public final void testGetClasseWrapperDoPrimitivoClassOfQ() {
		Class<?> c = int.class;
		Class<?> _c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNotNull(_c);
		assertEquals(Integer.class, _c);

		c = float.class;
		_c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNotNull(_c);
		assertEquals(Float.class, _c);

		c = double.class;
		_c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNotNull(_c);
		assertEquals(Double.class, _c);

		c = Short.class;
		_c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNull(_c);

		c = null;
		_c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNull(_c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getClasseWrapperDoPrimitivo(java.lang.String)}.
	 */
	@Test
	public final void testGetClasseWrapperDoPrimitivoString() {
		String c = "int";
		Class<?> _c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNotNull(_c);
		assertEquals(Integer.class, _c);

		c = "float";
		_c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNotNull(_c);
		assertEquals(Float.class, _c);

		c = "double";
		_c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNotNull(_c);
		assertEquals(Double.class, _c);

		c = "Short";
		_c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNull(_c);

		c = null;
		_c = UtilPrimitivo.getClasseWrapperDoPrimitivo(c);
		assertNull(_c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getClassePrimitivoDoWrapper(java.lang.String)}.
	 */
	@Test
	public final void testGetClassePrimitivoDoWrapperString() {
		String c = "java.lang.Integer";
		Class<?> _c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNotNull(_c);
		assertEquals(int.class, _c);

		c = "java.lang.Float";
		_c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNotNull(_c);
		assertEquals(float.class, _c);

		c = "java.lang.Double";
		_c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNotNull(_c);
		assertEquals(double.class, _c);

		c = "short";
		_c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNull(_c);

		c = null;
		_c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNull(_c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getClassePrimitivoDoWrapper(java.lang.Class)}.
	 */
	@Test
	public final void testGetClassePrimitivoDoWrapperClassOfQ() {
		Class<?> c = Integer.class;
		Class<?> _c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNotNull(_c);
		assertEquals(int.class, _c);

		c = Float.class;
		_c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNotNull(_c);
		assertEquals(float.class, _c);

		c = Double.class;
		_c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNotNull(_c);
		assertEquals(double.class, _c);

		c = short.class;
		_c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNull(_c);

		c = null;
		_c = UtilPrimitivo.getClassePrimitivoDoWrapper(c);
		assertNull(_c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getNomeDaClasseDoWrapper(java.lang.String)}.
	 */
	@Test
	public final void testGetNomeDaClasseDoWrapper() {
		String s = "int";
		String _s = UtilPrimitivo.getNomeDaClasseDoWrapper(s);
		assertNotNull(_s);
		assertEquals("java.lang.Integer", _s);

		s = "float";
		_s = UtilPrimitivo.getNomeDaClasseDoWrapper(s);
		assertNotNull(_s);
		assertEquals("java.lang.Float", _s);

		s = "short";
		_s = UtilPrimitivo.getNomeDaClasseDoWrapper(s);
		assertNotNull(_s);
		assertEquals("java.lang.Short", _s);

		s = "Double";
		_s = UtilPrimitivo.getNomeDaClasseDoWrapper(s);
		assertNull(_s);

		s = "";
		_s = UtilPrimitivo.getNomeDaClasseDoWrapper(s);
		assertNull(_s);

		s = null;
		_s = UtilPrimitivo.getNomeDaClasseDoWrapper(s);
		assertNull(_s);

		s = "abc";
		_s = UtilPrimitivo.getNomeDaClasseDoWrapper(s);
		assertNull(_s);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getTipoAlternativo(java.lang.Class)}.
	 */
	@Test
	public final void testGetTipoAlternativo() {
		Class<?> c = int.class;
		Class<?> _c = UtilPrimitivo.getTipoAlternativo(c);
		assertNotNull(_c);
		assertEquals(Integer.class, _c);

		c = float.class;
		_c = UtilPrimitivo.getTipoAlternativo(c);
		assertNotNull(_c);
		assertEquals(Float.class, _c);

		c = Short.class;
		_c = UtilPrimitivo.getTipoAlternativo(c);
		assertNotNull(_c);
		assertEquals(short.class, _c);

		c = String.class;
		_c = UtilPrimitivo.getTipoAlternativo(c);
		assertNull(_c);

		c = this.getClass();
		_c = UtilPrimitivo.getTipoAlternativo(c);
		assertNull(_c);

		c = null;
		_c = UtilPrimitivo.getTipoAlternativo(c);
		assertNull(_c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefault(java.lang.Class)}.
	 */
	@Test
	public final void testGetValorDefault() {
		Class<?> c = int.class;
		Object o = UtilPrimitivo.getValorDefault(c);
		assertNotNull(o);
		assertEquals(new Integer(0), o);

		c = float.class;
		o = UtilPrimitivo.getValorDefault(c);
		assertNotNull(o);
		assertEquals(new Float(0), o);

		c = Double.class;
		o = UtilPrimitivo.getValorDefault(c);
		assertNotNull(o);
		assertEquals(new Double(0), o);

		c = Short.class;
		o = UtilPrimitivo.getValorDefault(c);
		assertNotNull(o);
		assertEquals(new Short("0"), o);

		c = null;
		o = UtilPrimitivo.getValorDefault(c);
		assertNull(o);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefaultByte()}.
	 */
	@Test
	public final void testGetValorDefaultByte() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefaultShort()}.
	 */
	@Test
	public final void testGetValorDefaultShort() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefaultInt()}.
	 */
	@Test
	public final void testGetValorDefaultInt() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefaultLong()}.
	 */
	@Test
	public final void testGetValorDefaultLong() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefaultChar()}.
	 */
	@Test
	public final void testGetValorDefaultChar() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefaultFloat()}.
	 */
	@Test
	public final void testGetValorDefaultFloat() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefaultDouble()}.
	 */
	@Test
	public final void testGetValorDefaultDouble() {
		// Desnecessário
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.objeto.UtilPrimitivo#getValorDefaultBoolean()}.
	 */
	@Test
	public final void testGetValorDefaultBoolean() {
		// Desnecessário
	}

}
