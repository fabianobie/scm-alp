/*
 * UtilEstrategiaDeConversoresTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.estrategia;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.estrategia.UtilEstrategiaDeConversores;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilEstrategiaDeConversores
 */
public class UtilEstrategiaDeConversoresTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaDeConversores#recuperar(java.lang.Class)}.
	 */
	@Test
	public final void testRecuperarClassOfQ() {
		Class<?> classe = Double.class;

		UtilEstrategiaDeConversores util = getUtilEstrategiaDeConversores();
		IConversor<?, ?> c = util.recuperar(classe);
		assertNotNull(c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#adicionar(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public final void testAdicionar() {
		IConversor<BigDecimal, Double> c = getConversorFactory()
				.novoConversorDeBigDecimalParaDouble();
		String chave = "BigDecimal_Double";

		UtilEstrategiaDeConversores util = getUtilEstrategiaDeConversores();
		util.adicionar(chave, c);

		IConversor<?, ?> conversor = util.recuperar(chave);
		assertNotNull(conversor);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#alterar(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public final void testAlterar() {
		IConversor<BigDecimal, Double> c = getConversorFactory()
				.novoConversorDeBigDecimalParaDouble();
		String chave = "BigDecimal";

		UtilEstrategiaDeConversores util = getUtilEstrategiaDeConversores();
		util.adicionar(chave, c);

		IConversor<?, ?> conversor = util.recuperar(chave);
		assertNotNull(conversor);

		assertSame(c, conversor);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#remover(java.lang.Object)}.
	 */
	@Test
	public final void testRemover() {
		String chave = "BigDecimal";

		UtilEstrategiaDeConversores util = getUtilEstrategiaDeConversores();
		IConversor<?, ?> removido = util.remover(chave);
		assertNotNull(removido);

		IConversor<?, ?> conversor = util.recuperar(chave);
		assertTrue(UtilObjeto.isObjetoDoTipo(conversor, getConversorPadrao()
				.getClass()));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#recuperar(java.lang.Object)}.
	 */
	@Test
	public final void testRecuperarK() {
		String tipo = "long";

		UtilEstrategiaDeConversores util = getUtilEstrategiaDeConversores();
		IConversor<?, ?> c = util.recuperar(tipo);
		assertNotNull(c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#isExiste(java.lang.Object)}.
	 */
	@Test
	public final void testIsExiste() {
		String tipo = "java.lang.Integer";

		UtilEstrategiaDeConversores util = getUtilEstrategiaDeConversores();
		boolean c = util.isExiste(tipo);
		assertTrue(c);

		tipo = "inexistente";
		c = util.isExiste(tipo);
		assertFalse(c);
	}

	/**
	 * @return instância de UtilEstrategiaDeConversores
	 */
	private UtilEstrategiaDeConversores getUtilEstrategiaDeConversores() {
		return UtilEstrategiaDeConversores.getInstancia();
	}

	/**
	 * @return conversor padrão.
	 */
	private IConversor<?, ?> getConversorPadrao() {
		return getConversorFactory().novoConversorDeStringParaString();
	}
}
