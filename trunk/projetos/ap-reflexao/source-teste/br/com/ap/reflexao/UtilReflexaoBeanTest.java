/*
 * UtilReflexaoBeanTest.java
 * 
 * Data de criação: 10/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import org.junit.Test;

import br.com.ap.reflexao.UtilReflexaoBean;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see UtilReflexaoBean
 */
public class UtilReflexaoBeanTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoBean#clonar(java.lang.Object)}.
	 * 
	 * @throws ReflexaoException
	 */
	@Test
	public final void testClonar() throws ReflexaoException {
		AlunoTO to = novoAlunoTO();

		AlunoTO r = UtilReflexaoBean.clonar(to);
		assertNotNull(r);
		assertEquals(to.getNome(), r.getNome());

		r = UtilReflexaoBean.clonar(null);
		assertNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoBean#novaClasse(java.lang.String)}.
	 * 
	 * @throws ReflexaoException
	 */
	@Test
	public final void testNovaClasse() throws ReflexaoException {
		Class<?> r = UtilReflexaoBean.novaClasse("br.com.ap.reflexao.AlunoTO");
		assertNotNull(r);
		assertEquals(r, AlunoTO.class);

		r = UtilReflexaoBean.clonar(null);
		assertNull(r);
	}
}
