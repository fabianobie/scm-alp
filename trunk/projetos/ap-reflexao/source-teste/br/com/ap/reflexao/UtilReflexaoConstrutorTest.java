/*
 * UtilReflexaoConstrutorTest.java
 * 
 * Data de criação: 10/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import org.junit.Test;

import br.com.ap.reflexao.UtilReflexaoConstrutor;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see UtilReflexaoConstrutor
 */
public class UtilReflexaoConstrutorTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoConstrutor#invocar(java.lang.Class, java.lang.Object[])}.
	 * 
	 * @throws ReflexaoException
	 */
	@Test
	public final void testInvocar() throws ReflexaoException {

		AlunoTO r = UtilReflexaoConstrutor.invocar(AlunoTO.class);
		assertNotNull(r);

		r = UtilReflexaoConstrutor.invocar(AlunoTO.class, "Fulano de Tal");
		assertNotNull(r);
		assertEquals("Fulano de Tal", r.getNome());

		try {
			r = UtilReflexaoConstrutor.invocar(AlunoTO.class, new Integer(5));
			fail("Uma exceção deveria ser gerada.");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}
		
		r = UtilReflexaoConstrutor.invocar(null);
		assertNull(r);
	}

}
