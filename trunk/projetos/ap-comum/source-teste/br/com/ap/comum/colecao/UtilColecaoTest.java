/*
 * UtilColecaoTest.java
 * 
 * Data de criação: 01/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.conversor.instancia.ConversorAbstrato;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.ConversorException;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.formatador.instancia.FormatadorDeDoubleParaMonetario;
import br.com.ap.comum.formatador.instancia.IFormatador;
import br.com.ap.comum.string.UtilString;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.colecao.UtilColecao
 */
public class UtilColecaoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#aplicarAlterador(java.util.Collection, br.com.ap.comum.colecao.Alterador)}
	 * .
	 */
	@Test
	public final void testAplicarAlterador() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		Alterador<UsuarioTO> a = new Alterador<UsuarioTO>() {
			public UsuarioTO alterar(UsuarioTO objeto) {
				String data = objeto.getData();
				data = UtilString.substituirString(data, "[.]", "/");

				objeto.setData(data);
				return objeto;
			}
		};
		UtilColecao.aplicarAlterador(colecao, a);

		assertNotNull(colecao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#aplicarConversor(java.util.Collection, br.com.ap.comum.conversor.instancia.IConversor)}
	 * .
	 */
	@Test
	public final void testAplicarConversor() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		IConversor<UsuarioTO, String> c = new ConversorAbstrato<UsuarioTO, String>() {
			public String converter(UsuarioTO objeto) throws ConversorException {
				return objeto.getNome();
			}
		};

		Collection<String> r = UtilColecao.aplicarConversor(colecao, c);
		assertNotNull(r);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#aplicarFiltro(java.util.Collection, br.com.ap.comum.colecao.Filtro)}
	 * .
	 */
	@Test
	public final void testAplicarFiltro_CollectionIFiltro() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();

		Filtro<UsuarioTO> f = new Filtro<UsuarioTO>() {
			public boolean isFiltrado(UsuarioTO objeto) {
				return (objeto.getIdentidade() != 222);
			}
		};
		UtilColecao.aplicarFiltro(colecao, f);

		assertNotNull(colecao);
		assertTrue(colecao.size() == 3);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#aplicarFiltro(java.util.Collection, java.lang.Object, br.com.ap.comum.colecao.Comparador)}
	 * .
	 */
	@Test
	public final void testAplicarFiltro_CollectionIComparador() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		UsuarioTO param = new UsuarioTO();
		param.setIdentidade(111);

		Comparador<UsuarioTO, UsuarioTO> c = novoComparadorDeUsuariosDiferentes();
		UtilColecao.aplicarFiltro(colecao, param, c);

		assertNotNull(colecao);
		assertTrue(colecao.size() == 1);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#aplicarFiltro(java.util.Collection, java.util.Collection, br.com.ap.comum.colecao.Comparador)}
	 * .
	 */
	@Test
	public final void testAplicarFiltro_CollectionCollectionIComparador() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		Collection<UsuarioTO> removidos = novaColecaoDeUsuarioTO();
		((List<UsuarioTO>) removidos).remove(0);
		((List<UsuarioTO>) removidos).remove(0);

		Comparador<UsuarioTO, UsuarioTO> c = novoComparadorDeUsuariosIguais();
		colecao = UtilColecao.aplicarFiltro(colecao, removidos, c);

		assertNotNull(colecao);
		assertTrue(colecao.size() == 2);

		colecao = UtilColecao.aplicarFiltro(null, removidos, c);
		assertNull(colecao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#aplicarSomador(java.util.Collection, br.com.ap.comum.colecao.Somador)}
	 * .
	 */
	@Test
	public final void testAplicarSomador_CollectionISomador() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		Somador<UsuarioTO> i = novoSomadorDePeso();
		double soma = UtilColecao.aplicarSomador(colecao, i);

		assertEquals(269.4d, soma, 0.0d);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#aplicarSomador(java.util.Collection, br.com.ap.comum.colecao.Somador, br.com.ap.comum.formatador.instancia.IFormatador)}
	 * .
	 * 
	 * @throws FormatadorException
	 *             Exceção de formatação
	 */
	@Test
	public final void testAplicarSomador_CollectionISomadorIFormatador()
			throws FormatadorException {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		IFormatador<Double> formatador = new FormatadorDeDoubleParaMonetario();

		Somador<UsuarioTO> i = novoSomadorDePeso();
		String soma = UtilColecao.aplicarSomador(colecao, i, formatador);

		assertNotNull(soma);
		assertEquals("R$ 269,40", soma);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#ordenar(java.util.Collection)}
	 * .
	 */
	@Test
	public final void testOrdenarCollection() {
		Collection<UsuarioTOOrdenado> colecao = novaColecaoDeUsuarioTOOrdenado();
		UtilColecao.ordenar(colecao);
		assertNotNull(colecao);

		UsuarioTOOrdenado to = ((List<UsuarioTOOrdenado>) colecao).get(0);
		assertNotNull(to);
		assertEquals(111, to.getIdentidade());

		colecao = null;
		UtilColecao.ordenar(colecao);
		assertNull(colecao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#ordenar(java.util.Collection, java.util.Comparator)}
	 * .
	 */
	@Test
	public final void testOrdenar_CollectionComparator() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		UtilColecao.ordenar(colecao, novoComparatorParaUsuarioTO());

		assertNotNull(colecao);
		assertTrue(colecao.size() > 0);
		UsuarioTO to = ((ArrayList<UsuarioTO>) colecao).get(0);
		assertNotNull(to);
		assertEquals(111, to.getIdentidade());

		UtilColecao.ordenar(colecao, null);
		assertNotNull(colecao);
		assertTrue(colecao.size() > 0);
		to = ((ArrayList<UsuarioTO>) colecao).get(0);
		assertNotNull(to);
		assertEquals(111, to.getIdentidade());

		colecao = null;
		UtilColecao.ordenar(colecao, novoComparatorParaUsuarioTO());
		assertNull(colecao);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#completarColecao(java.util.Collection, int, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testCompletarColecao() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		UtilColecao.completarColecao(colecao, 10, UsuarioTO.class);
		assertNotNull(colecao);
		assertTrue(colecao.size() == 10);

		UtilColecao.completarColecao(colecao, 3, UsuarioTO.class);
		assertNotNull(colecao);
		assertTrue(colecao.size() == 10);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#copiarColecao(java.util.Collection)}
	 * .
	 */
	@Test
	public final void testCopiarColecao() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		Collection<UsuarioTO> colecao2 = UtilColecao.copiarColecao(colecao);

		assertNotSame(colecao, colecao2);
		colecao2 = UtilColecao.copiarColecao(null);
		assertNotNull(colecao2);
		assertTrue(colecao2.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#getElemento(java.util.Collection, br.com.ap.comum.colecao.Filtro)}
	 * .
	 */
	@Test
	public final void testGetElemento_CollectionIFiltro() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		final UsuarioTO param = new UsuarioTO(111, null, null, 0.0d);

		UsuarioTO res = null;
		Filtro<UsuarioTO> f = novoFiltroDeUsuariosIguais(param);
		res = UtilColecao.getElemento(colecao, f);

		assertNotNull(res);
		assertEquals(111, res.getIdentidade());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#getElemento(java.util.Collection, java.lang.Object, br.com.ap.comum.colecao.Comparador)}
	 * .
	 */
	@Test
	public final void testGetElemento_CollectionIComparador() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		UsuarioTO to = new UsuarioTO(111, null, null, 0.0d);

		Comparador<UsuarioTO, UsuarioTO> c = novoComparadorDeUsuariosIguais();
		UsuarioTO res = UtilColecao.getElemento(colecao, to, c);

		assertNotNull(res);
		assertEquals(to.getIdentidade(), res.getIdentidade());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#getElementoDoIndice(java.util.List, int)}
	 * .
	 */
	@Test
	public final void testGetElementoDoIndice_ListInt() {
		List<UsuarioTO> lista = (List<UsuarioTO>) novaColecaoDeUsuarioTO();
		int indice = 2;

		Object objeto = UtilColecao.getElementoDoIndice(lista, indice);
		assertNotNull(objeto);

		indice = -5;
		objeto = UtilColecao.getElementoDoIndice(lista, indice);
		assertNull(objeto);

		indice = 5;
		objeto = UtilColecao.getElementoDoIndice(lista, indice);
		assertNull(objeto);

		lista = null;
		indice = 1;
		objeto = UtilColecao.getElementoDoIndice(lista, indice);
		assertNull(objeto);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#getElementoDoIndice(java.util.Collection, int)}
	 * .
	 */
	@Test
	public final void testGetElementoDoIndiceCollectionOfTInt() {
		Collection<UsuarioTO> c = novaColecaoDeUsuarioTO();
		UsuarioTO to = UtilColecao.getElementoDoIndice(c, 2);

		assertNotNull(to);

		to = UtilColecao.getElementoDoIndice(c, 20);
		assertNull(to);

		to = UtilColecao.getElementoDoIndice(null, 2);
		assertNull(to);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#getElementoDoUltimoIndice(java.util.Collection)}
	 * .
	 */
	@Test
	public final void testGetElementoDoUltimoIndice() {
		Collection<UsuarioTO> c = novaColecaoDeUsuarioTO();
		UsuarioTO to = UtilColecao.getElementoDoUltimoIndice(c);
		assertNotNull(to);

		to = UtilColecao.getElementoDoUltimoIndice(null);
		assertNull(to);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#getElementosIguais(java.util.Collection, java.util.Collection, br.com.ap.comum.colecao.Comparador)}
	 * .
	 */
	@Test
	public final void testGetElementosIguais() {
		Collection<UsuarioTO> colecao0 = novaColecaoDeUsuarioTO();
		Collection<UsuarioTO> colecao1 = novaColecaoDeUsuarioTO();
		((ArrayList<UsuarioTO>) colecao1).remove(0);
		((ArrayList<UsuarioTO>) colecao1).remove(0);
		((ArrayList<UsuarioTO>) colecao1).remove(0);

		Comparador<UsuarioTO, UsuarioTO> c = novoComparadorDeUsuariosIguais();
		colecao0 = UtilColecao.getElementosIguais(colecao0, colecao1, c);
		assertNotNull(colecao0);
		assertTrue(colecao0.size() == 1);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#getTamanho(java.util.Collection)}
	 * .
	 */
	@Test
	public final void testGetTamanho() {
		Collection<UsuarioTO> c = novaColecaoDeUsuarioTO();
		assertEquals(c.size(), UtilColecao.getTamanho(c));
		assertEquals(0, UtilColecao.getTamanho(null));

	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#isContemElemento(java.util.Collection, br.com.ap.comum.colecao.Filtro)}
	 * .
	 */
	@Test
	public final void testIsContemElemento_CollectionIFiltro() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		final int identidade = 111;
		final int naoExistente = 234;

		Filtro<UsuarioTO> f = new Filtro<UsuarioTO>() {
			public boolean isFiltrado(UsuarioTO objeto) {
				return objeto.getIdentidade() == identidade;
			}
		};
		boolean resultado = UtilColecao.isContemElemento(colecao, f);
		assertEquals(true, resultado);

		resultado = UtilColecao.isContemElemento(null, null);
		assertEquals(false, resultado);

		Filtro<UsuarioTO> f1 = new Filtro<UsuarioTO>() {

			public boolean isFiltrado(UsuarioTO objeto) {
				return objeto.getIdentidade() == naoExistente;
			}
		};
		resultado = UtilColecao.isContemElemento(colecao, f1);
		assertEquals(false, resultado);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#isContemElemento(java.util.Collection, java.lang.Object, br.com.ap.comum.colecao.Comparador)}
	 * .
	 */
	@Test
	public final void testIsContemElemento_CollectionIComparador() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();
		UsuarioTO to = new UsuarioTO(111, null, null, 0.0d);

		Comparador<UsuarioTO, UsuarioTO> c = novoComparadorDeUsuariosIguais();
		boolean resultado = UtilColecao.isContemElemento(colecao, to, c);
		assertEquals(true, resultado);

		resultado = UtilColecao.isContemElemento(null, null, null);
		assertEquals(false, resultado);

		to.setIdentidade(234);
		resultado = UtilColecao.isContemElemento(colecao, to, c);
		assertEquals(false, resultado);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#isContemElementoEmComum(java.util.Collection, java.util.Collection, br.com.ap.comum.colecao.Comparador)}
	 * .
	 */
	@Test
	public final void testIsContemElementoEmComum() {
		Collection<String> origem = new ArrayList<String>();
		origem.add("um");
		origem.add("dois");
		origem.add("três");

		Collection<String> localizar = new ArrayList<String>();
		localizar.add("quatro");
		localizar.add("cinco");

		Comparador<String, String> c = new Comparador<String, String>() {

			public boolean isIguais(String objeto0, String objeto1) {
				return objeto0.equals(objeto1);
			}
		};

		boolean res = false;
		res = UtilColecao.isContemElementoEmComum(origem, localizar, c);
		assertFalse(res);

		localizar.add("três");
		res = UtilColecao.isContemElementoEmComum(origem, localizar, c);
		assertTrue(res);

		res = UtilColecao.isContemElementoEmComum(null, null, c);
		assertFalse(res);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#isVazio(java.util.Collection)}
	 * .
	 */
	@Test
	public final void testIsVazio() {
		List<String> c = new ArrayList<String>();
		boolean b = UtilColecao.isVazio(c);

		assertEquals(true, b);

		c.add("sdf");
		b = UtilColecao.isVazio(c);
		assertEquals(false, b);

		c = null;
		b = UtilColecao.isVazio(c);
		assertEquals(true, b);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#novaColecao(java.util.Collection, br.com.ap.comum.colecao.Filtro)}
	 * .
	 */
	@Test
	public final void testNovaColecao_CollectionIFiltro() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();

		Filtro<UsuarioTO> f = novoFiltroDeIdentidadeDiferente(222);
		Collection<UsuarioTO> c = UtilColecao.novaColecao(colecao, f);

		assertNotNull(c);
		assertNotSame(c, colecao);

		c = UtilColecao.novaColecao(null, f);
		assertNotNull(c);
		assertTrue(c.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilColecao#novaColecao(java.util.Collection, java.lang.Object, br.com.ap.comum.colecao.Comparador)}
	 * .
	 */
	@Test
	public final void testNovaColecao_CollectionIComparador() {
		Collection<UsuarioTO> colecao = novaColecaoDeUsuarioTO();

		Comparador<UsuarioTO, UsuarioTO> comp = novoComparadorDeUsuariosDiferentes();
		UsuarioTO to = new UsuarioTO();
		to.setIdentidade(222);
		Collection<UsuarioTO> c = UtilColecao.novaColecao(colecao, to, comp);

		assertNotNull(c);
		assertNotSame(c, colecao);

		c = UtilColecao.novaColecao(null, to, comp);
		assertNotNull(c);
	}

	/**
	 * Retorna Nova coleção de UsuarioTO.
	 * 
	 * @return Nova coleção de UsuarioTO.
	 */
	private Collection<UsuarioTO> novaColecaoDeUsuarioTO() {
		Collection<UsuarioTO> colecao = getColecaoFactory().novoArrayList();
		colecao.add(new UsuarioTO(333, "Cristiano", "15/02/2004", 75.4));
		colecao.add(new UsuarioTO(111, "Luciano", "16.02.2004", 61.4));
		colecao.add(new UsuarioTO(222, "Adriano", "17.02.2004", 77.8));
		colecao.add(new UsuarioTO(444, "Juliana", "18/02/2004", 54.8));
		return colecao;
	}

	/**
	 * Retorna Nova coleção de UsuarioTOOrdenado.
	 * 
	 * @return Nova coleção de UsuarioTOOrdenado.
	 */
	private Collection<UsuarioTOOrdenado> novaColecaoDeUsuarioTOOrdenado() {
		Collection<UsuarioTOOrdenado> colecao = getColecaoFactory()
				.novoArrayList();
		colecao
				.add(new UsuarioTOOrdenado(333, "Cristiano", "15/02/2004", 75.4));
		colecao.add(new UsuarioTOOrdenado(111, "Luciano", "16/02/2004", 61.4));
		colecao.add(new UsuarioTOOrdenado(222, "Adriano", "17/02/2004", 77.8));
		colecao.add(new UsuarioTOOrdenado(444, "Juliana", "18/02/2004", 54.8));
		return colecao;
	}

	/**
	 * Retorna novo Comparator para UsuarioTO.
	 * 
	 * @return novo Comparator
	 */
	private Comparator<UsuarioTO> novoComparatorParaUsuarioTO() {
		return new Comparator<UsuarioTO>() {

			public int compare(UsuarioTO to1, UsuarioTO to2) {
				int resultado = 0;
				int id1 = to1.getIdentidade();
				int id2 = to2.getIdentidade();
				Integer identidade1 = getNumeroFactory().novoInteger(id1);
				Integer identidade2 = getNumeroFactory().novoInteger(id2);

				resultado = identidade1.compareTo(identidade2);
				return resultado;
			}
		};
	}

	/**
	 * @return comparador de usuários diferentes.
	 */
	private Comparador<UsuarioTO, UsuarioTO> novoComparadorDeUsuariosDiferentes() {
		Comparador<UsuarioTO, UsuarioTO> c = new Comparador<UsuarioTO, UsuarioTO>() {
			public boolean isIguais(UsuarioTO objeto0, UsuarioTO objeto1) {
				return objeto0.getIdentidade() != objeto1.getIdentidade();
			}
		};
		return c;
	}

	/**
	 * @return comparador de usuários iguais.
	 */
	private Comparador<UsuarioTO, UsuarioTO> novoComparadorDeUsuariosIguais() {
		Comparador<UsuarioTO, UsuarioTO> c = new Comparador<UsuarioTO, UsuarioTO>() {
			public boolean isIguais(UsuarioTO objeto0, UsuarioTO objeto1) {
				return objeto0.getIdentidade() == objeto1.getIdentidade();
			}
		};
		return c;
	}

	/**
	 * @return novo somador de peso do usuário
	 */
	private Somador<UsuarioTO> novoSomadorDePeso() {
		Somador<UsuarioTO> i = new Somador<UsuarioTO>() {
			public double getValor(UsuarioTO objeto) {
				return objeto.getPeso();
			}
		};
		return i;
	}

	/**
	 * @param param
	 * @return filtro de usuários iguais.
	 */
	private Filtro<UsuarioTO> novoFiltroDeUsuariosIguais(final UsuarioTO param) {
		Filtro<UsuarioTO> f = new Filtro<UsuarioTO>() {
			public boolean isFiltrado(UsuarioTO objeto) {
				return param.getIdentidade() == objeto.getIdentidade();
			}
		};
		return f;
	}

	/**
	 * @param param
	 * @return filtro de usuários iguais.
	 */
	private Filtro<UsuarioTO> novoFiltroDeIdentidadeDiferente(
			final int identidade) {
		Filtro<UsuarioTO> f = new Filtro<UsuarioTO>() {
			public boolean isFiltrado(UsuarioTO objeto) {
				return objeto.getIdentidade() != identidade;
			}
		};
		return f;
	}
}
