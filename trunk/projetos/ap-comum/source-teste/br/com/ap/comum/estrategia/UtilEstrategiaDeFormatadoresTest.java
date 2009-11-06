/*
 * UtilEstrategiaDeFormatadoresTest.java
 * 
 * Data de criação: 03/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.estrategia;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.formatador.instancia.IFormatador;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilEstrategiaDeFormatadores
 */
public class UtilEstrategiaDeFormatadoresTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaDeFormatadores#recuperar(java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRecuperarClassOfQ() {
		Class<?> classe = Double.class;

		UtilEstrategiaDeFormatadores util = getUtilEstrategiaDeFormatadores();
		IFormatador<?> c = util.recuperar(classe);
		assertNotNull(c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#adicionar(
	 * 		java.lang.Object, java.lang.Object)}
	 * .
	 */
	@Test
	public final void testAdicionar() {
		IFormatador<Double> c = getFormatadorFactory()
				.novoFormatadorDeDoubleParaMonetario();
		String chave = "BigDecimal_Double";

		UtilEstrategiaDeFormatadores util = getUtilEstrategiaDeFormatadores();
		util.adicionar(chave, c);

		IFormatador<?> conversor = util.recuperar(chave);
		assertNotNull(conversor);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#alterar(
	 * java.lang.Object, java.lang.Object)}
	 */
	@Test
	public final void testAlterar() {
		IFormatador<Double> c = getFormatadorFactory()
				.novoFormatadorDeDoubleParaMonetario();
		String chave = "Double";

		UtilEstrategiaDeFormatadores util = getUtilEstrategiaDeFormatadores();
		util.alterar(chave, c);

		IFormatador<?> conversor = util.recuperar(chave);
		assertNotNull(conversor);

		assertSame(c, conversor);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#remover(java.lang.Object)}
	 * .
	 */
	@Test
	public final void testRemover() {
		String chave = "int";

		UtilEstrategiaDeFormatadores util = getUtilEstrategiaDeFormatadores();
		IFormatador<?> removido = util.remover(chave);
		assertNotNull(removido);

		IFormatador<?> conversor = util.recuperar(chave);
		assertTrue(UtilObjeto.isObjetoDoTipo(conversor, getConversorPadrao()
				.getClass()));
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#recuperar(java.lang.Object)}
	 * .
	 */
	@Test
	public final void testRecuperarK() {
		String tipo = "long";

		UtilEstrategiaDeFormatadores util = getUtilEstrategiaDeFormatadores();
		IFormatador<?> c = util.recuperar(tipo);
		assertNotNull(c);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.estrategia.UtilEstrategiaAbstrata#isExiste(java.lang.Object)}
	 * .
	 */
	@Test
	public final void testIsExiste() {
		String tipo = "java.lang.Integer";

		UtilEstrategiaDeFormatadores util = getUtilEstrategiaDeFormatadores();
		boolean c = util.isExiste(tipo);
		assertTrue(c);

		tipo = "inexistente";
		c = util.isExiste(tipo);
		assertFalse(c);
	}

	/**
	 * @return instância de UtilEstrategiaDeConversores
	 */
	private UtilEstrategiaDeFormatadores getUtilEstrategiaDeFormatadores() {
		return UtilEstrategiaDeFormatadores.getInstancia();
	}

	/**
	 * @return conversor padrão.
	 */
	private IFormatador<?> getConversorPadrao() {
		return getFormatadorFactory().novoFormatadorDeString();
	}
}
