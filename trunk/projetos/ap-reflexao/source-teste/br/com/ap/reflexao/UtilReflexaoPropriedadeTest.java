/*
 * UtilReflexaoPropriedadeTest.java
 * 
 * Data de criação: 09/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.util.Map;

import org.junit.Test;

import br.com.ap.reflexao.UtilReflexaoPropriedade;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * JUnit.
 * 
 * @author AdrianoP
 * @see UtilReflexaoPropriedade
 */
public class UtilReflexaoPropriedadeTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#get(java.lang.Object, java.lang.String)}.
	 */
	@Test
	public final void testGet() {
		String nome = "Fulano de Tal";
		AlunoTO to = novoAlunoTO();

		String r = null;
		try {
			r = UtilReflexaoPropriedade.get(to, "nome");
			assertEquals(nome, r);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			r = UtilReflexaoPropriedade.get(to, "alunoFilhoTO.nome");
			assertEquals(nome + " Filho", r);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			r = UtilReflexaoPropriedade.get(to, "x.y");
			fail("O erro deveria ser gerado ao tentar recuperar a propriedade x.y");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#getEmPropriedadeIndexada(java.lang.Object, java.lang.String, int)}.
	 */
	@Test
	public final void testGetEmPropriedadeIndexada() {
		AlunoTO to = novoAlunoTO();

		AlunoTO r = null;
		try {
			r = UtilReflexaoPropriedade.getEmPropriedadeIndexada(to,
					"listaDeAlunos", 2);
			assertNotNull(r);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			r = UtilReflexaoPropriedade.getEmPropriedadeIndexada(to,
					"listaDeAlunos", 20);
			fail("O erro deveria ser gerado ao tentar recuperar o índice 20");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}

		try {
			r = UtilReflexaoPropriedade.getEmPropriedadeIndexada(to, "x.y", 5);
			fail("O erro deveria ser gerado ao tentar recuperar a propriedade x.y");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#getEmPropriedadeMapeada(java.lang.Object, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testGetEmPropriedadeMapeada() {
		AlunoTO to = novoAlunoTO();

		AlunoTO r = null;
		try {
			r = UtilReflexaoPropriedade.getEmPropriedadeMapeada(to,
					"mapaDeAlunos", "105");
			assertNotNull(r);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			r = UtilReflexaoPropriedade.getEmPropriedadeMapeada(to,
					"mapaDeAlunos", "xxx");
			assertNull(r);
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}

		try {
			r = UtilReflexaoPropriedade.getEmPropriedadeMapeada(to, "x.y",
					"xxx");
			fail("O erro deveria ser gerado ao tentar recuperar a propriedade x.y");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#set(java.lang.Object, java.lang.String, java.lang.Object)}.
	 */
	@Test
	public final void testSet() {
		String nome = "Fulano de Tal";
		AlunoTO to = new AlunoTO();

		String r = null;
		try {
			UtilReflexaoPropriedade.set(to, "nome", nome);
			r = UtilReflexaoPropriedade.get(to, "nome");
			assertEquals(nome, r);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			UtilReflexaoPropriedade.set(to, "alunoFilhoTO.nome", nome);
			r = UtilReflexaoPropriedade.get(to, "alunoFilhoTO.nome");
			assertEquals(nome, r);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			UtilReflexaoPropriedade.set(to, "alunoFilhoTOxxxx.nome", nome);
			fail("O erro deveria ser gerado ao tentar recuperar a propriedade x.y");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#setEmPropriedadeIndexada(java.lang.Object, java.lang.String, int, java.lang.Object)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testSetEmPropriedadeIndexada() throws Exception {
		AlunoTO to = novoAlunoTO(101, "Fulano", "M");
		AlunoTO incluido = novoAlunoTO(102L, "Siclano", "M");
		to.getListaDeAlunos().add(incluido);
		AlunoTO alterado = novoAlunoTO(103L, "Beltrano", "M");

		AlunoTO r = null;
		try {
			UtilReflexaoPropriedade.setEmPropriedadeIndexada(to,
					"listaDeAlunos", 0, alterado);
			r = UtilReflexaoPropriedade.getEmPropriedadeIndexada(to,
					"listaDeAlunos", 0);
			assertSame(alterado, r);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			UtilReflexaoPropriedade.setEmPropriedadeIndexada(to,
					"listaDeAlunos", 55, alterado);
			fail("O erro deveria ser gerado ao tentar atribuir no indice 55");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}

		try {
			UtilReflexaoPropriedade.setEmPropriedadeIndexada(to,
					"listaDeAlunosxxx", 55, alterado);
			fail("O erro deveria ser gerado ao tentar recuperar a propriedade x.y");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#setEmPropriedadeMapeada(java.lang.Object, java.lang.String, java.lang.String, java.lang.Object)}.
	 */
	@Test
	public final void testSetEmPropriedadeMapeada() {
		AlunoTO to = novoAlunoTO(101L, "Fulano", "M");
		AlunoTO incluido = novoAlunoTO(102L, "Siclano", "M");
		to.getMapaDeAlunos().put(getString(incluido.getMatricula()), incluido);
		AlunoTO alterado = novoAlunoTO(103L, "Beltrano", "M");

		AlunoTO r = null;
		try {
			UtilReflexaoPropriedade.setEmPropriedadeMapeada(to, "mapaDeAlunos",
					"101", alterado);
			r = UtilReflexaoPropriedade.getEmPropriedadeMapeada(to,
					"mapaDeAlunos", "101");
			assertSame(alterado, r);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			UtilReflexaoPropriedade.setEmPropriedadeMapeada(to, "mapaDeAlunos",
					"555", alterado);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			UtilReflexaoPropriedade.setEmPropriedadeMapeada(to,
					"mapaDeAlunosxxxx", "555", alterado);
			fail("O erro deveria ser gerado ao tentar recuperar a propriedade x.y");
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#getTipoDaPropriedade(java.lang.Object, java.lang.String)}.
	 */
	@Test
	public final void testGetTipoDaPropriedade() {
		AlunoTO to = novoAlunoTO();
		Class<?> tipo = null;
		try {
			tipo = UtilReflexaoPropriedade.getTipoDaPropriedade(to, "nome");
			assertNotNull(tipo);
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		try {
			tipo = UtilReflexaoPropriedade.getTipoDaPropriedade(to, "nomeXXX");
			assertNull(tipo);
		} catch (ReflexaoException e) {
			assertNotNull(e);
		}

	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#limparCache()}.
	 */
	@Test
	public final void testLimparCache() {
		// desnecessário.
	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#copiarPropriedades(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public final void testCopiarPropriedades() {
		AlunoTO origem = novoAlunoTO();
		AlunoTO destino = new AlunoTO();

		try {
			UtilReflexaoPropriedade.copiarPropriedades(origem, destino);
			assertEquals(origem.getNome(), destino.getNome());
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

	}

	/**
	 * Test method for
	 * {@link br.com.ap.reflexao.UtilReflexaoPropriedade#getMapaDePropriedades(java.lang.Object)}.
	 * @throws ReflexaoException 
	 */
	@Test
	public final void testGetMapaDePropriedades() throws ReflexaoException {
		AlunoTO to = novoAlunoTO();
		Map<String, ?> m = null;

		try {
			m = UtilReflexaoPropriedade.getMapaDePropriedades(to);
			assertNotNull(m);
			assertNotNull(m.get("nome"));
		} catch (ReflexaoException e) {
			fail(e.getMessage());
		}

		m = UtilReflexaoPropriedade.getMapaDePropriedades(null);
		assertNotNull(m);
		assertTrue(m.size() == 0);
	}

}
