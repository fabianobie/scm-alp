/*
 * UtilReflexaoGenericTest.java
 * 
 * Data de criação: 12/08/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ap.reflexao.UtilReflexaoGeneric;
import br.com.ap.comum.conversor.instancia.ConversorDeBigDecimalParaLong;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see UtilReflexaoGeneric
 */
public class UtilReflexaoGenericTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoGeneric#getClasseDoTipo(java.lang.Object)}.
	 */
	@Test
	public final void testGetClasseDoTipo() {
		ConversorDeBigDecimalParaLong c = new ConversorDeBigDecimalParaLong();
		Class<?> classe = UtilReflexaoGeneric.getClasseDoTipo(c);
		assertEquals(classe, BigDecimal.class);
		
		classe = UtilReflexaoGeneric.getClasseDoTipo(null);
		assertNull(classe);
	}
	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoGeneric#getClasseDoTipo(java.lang.Object, int)}.
	 */
	@Test
	public final void testGetClasseDoTipo_Object_Int() {
		ConversorDeBigDecimalParaLong c = new ConversorDeBigDecimalParaLong();
		Class<?> classe = UtilReflexaoGeneric.getClasseDoTipo(c, 0);
		assertEquals(classe, BigDecimal.class);
		
		classe = UtilReflexaoGeneric.getClasseDoTipo(null);
		assertNull(classe);
	}

}
