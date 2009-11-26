/*
 * UtilMapaTest.java
 * 
 * Data de criação: 02/07/2008
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.ap.comum.TesteAbstrato;
import br.com.ap.comum.colecao.AlteradorMapa;
import br.com.ap.comum.colecao.FiltroMapa;
import br.com.ap.comum.colecao.UtilMapa;
import br.com.ap.comum.string.UtilString;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see br.com.ap.comum.colecao.UtilMapa
 */
public class UtilMapaTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilMapa#aplicarAlterador(java.util.Map, br.com.ap.comum.colecao.AlteradorMapa)}.
	 */
	@Test
	public final void testAplicarAlterador() {
		Map<String, String> mapa = getColecaoFactory().novoHashMap();
		mapa.put("semana", "segunda,terça,quarta");
		mapa.put("mes", "janeiro,fevereiro,março");

		AlteradorMapa<String, String> a = new AlteradorMapa<String, String>() {
			public Object alterarChave(String objeto) {
				return objeto + "-alterado";
			}

			public Object alterarValor(String objeto) {
				return UtilString.split(objeto, ",");
			}
		};
		mapa = UtilMapa.aplicarAlterador(mapa, a);

		assertNotNull(mapa);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilMapa#aplicarFiltro(java.util.Map, br.com.ap.comum.colecao.FiltroMapa)}.
	 */
	@Test
	public final void testAplicarFiltro() {
		Map<String, UsuarioTO> mapa = novoMapaDeUsuarioTO();
		FiltroMapa<String, UsuarioTO> f = novoFiltroDeChaveIgual(111);
		UtilMapa.aplicarFiltro(mapa, f);

		assertNotNull(mapa);
		assertTrue(mapa.size() == 1);

		mapa = null;
		UtilMapa.aplicarFiltro(mapa, f);
		assertNull(mapa);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.comum.colecao.UtilMapa#aplicarFiltroEAlterador(java.util.Map, br.com.ap.comum.colecao.FiltroMapa, br.com.ap.comum.colecao.AlteradorMapa)}.
	 */
	@Test
	public final void testAplicarFiltroEAlterador() {
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("semana", "segunda,terça,quarta");
		mapa.put("mes", "janeiro,fevereiro,março");

		FiltroMapa<String, String> f = new FiltroMapa<String, String>() {
			public boolean isFiltrado(String chave, String valor) {
				return chave.equals("mes");
			}
		};

		AlteradorMapa<String, String> a = new AlteradorMapa<String, String>() {
			public Object alterarChave(String objeto) {
				return objeto + "-alterado";
			}

			public Object alterarValor(String objeto) {
				return UtilString.split(objeto, ",");
			}
		};
		mapa = UtilMapa.aplicarFiltroEAlterador(mapa, f, a);

		assertNotNull(mapa);
	}

	public void testIsVazio() {
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("semana", "segunda,terça,quarta");
		mapa.put("mes", "janeiro,fevereiro,março");
		
		assertTrue(UtilMapa.isVazio(null));
		assertFalse(UtilMapa.isVazio(mapa));
		mapa.clear();
		assertTrue(UtilMapa.isVazio(mapa));
	}
	/**
	 * @return novo filtro de chave igual
	 */
	private FiltroMapa<String, UsuarioTO> novoFiltroDeChaveIgual(
			final int chaveFiltrada) {
		return new FiltroMapa<String, UsuarioTO>() {
			public boolean isFiltrado(String chave, UsuarioTO valor) {
				return (valor.getIdentidade() == chaveFiltrada);
			}
		};
	}

	/**
	 * Retorna Novo mapa de UsuarioTO.
	 * 
	 * @return Novo mapa de UsuarioTO.
	 */
	protected Map<String, UsuarioTO> novoMapaDeUsuarioTO() {
		Map<String, UsuarioTO> mapa = getColecaoFactory().novoHashMap();
		mapa.put("333", new UsuarioTO(333, "Cristiano", "15/02/2004", 75.4));
		mapa.put("111", new UsuarioTO(111, "Luciano", "16.02.2004", 61.4));
		mapa.put("222", new UsuarioTO(222, "Adriano", "17.02.2004", 77.8));
		mapa.put("444", new UsuarioTO(444, "Juliana", "18/02/2004", 54.8));

		return mapa;
	}
}
