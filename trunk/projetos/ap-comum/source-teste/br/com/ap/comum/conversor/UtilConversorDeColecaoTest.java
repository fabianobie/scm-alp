/*
 * UtilConversorDeColecaoTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.UtilConversorDeColecao;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.conversor.UtilConversorDeColecao
 */
public class UtilConversorDeColecaoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.conversor.UtilConversorDeColecao#converterSetParaList(java.util.Set)}.
	 */
	@Test
	public final void testConverterSetParaList() {
		Set<String> s = getColecaoFactory().novoLinkedHashSet();
		s.add("um");
		s.add("dois");
		s.add("três");

		List<String> l = UtilConversorDeColecao.converterSetParaList(s);
		assertTrue((UtilObjeto.isObjetoDoTipo(l, List.class)));
	}

}
