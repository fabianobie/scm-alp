/*
 * UtilReflexaoAnnotationTest.java
 * 
 * Data de criação: 12/08/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.lang.reflect.Method;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ap.reflexao.UtilReflexaoAnnotation;
import br.com.ap.reflexao.UtilReflexaoMetodo;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see UtilReflexaoAnnotation
 */
public class UtilReflexaoAnnotationTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoAnnotation#getAnotacaoDaClasse(java.lang.Object, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testGetAnotacaoDaClasse() {
		AlunoTO to = new AlunoTO();
		Ignore anotacao = UtilReflexaoAnnotation.getAnotacaoDaClasse(to,
				Ignore.class);
		assertNotNull(anotacao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoAnnotation#getAnotacaoDoMetodo(java.lang.Object, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testGetAnotacaoDoMetodo() {
		AlunoTO to = new AlunoTO();
		Ignore anotacao = UtilReflexaoAnnotation.getAnotacaoDoMetodo(to,
				"metodoComAnotacao", Ignore.class);
		assertNotNull(anotacao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoAnnotation#getAnotacaoDoMetodo(java.lang.Object, java.lang.reflect.Method, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testGetAnotacaoDoMetodo_ObjectMethodClass() {
		AlunoTO to = new AlunoTO();
		Class<?> classe = UtilObjeto.getClasse(to);
		Method metodo = UtilReflexaoMetodo.get(classe, "metodoComAnotacao");
		Ignore anotacao = UtilReflexaoAnnotation.getAnotacaoDoMetodo(to,
				metodo, Ignore.class);
		assertNotNull(anotacao);
	}
}
