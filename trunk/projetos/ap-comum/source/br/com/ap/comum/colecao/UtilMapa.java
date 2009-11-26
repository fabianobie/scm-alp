/*
 * UtilMapa.java
 * 
 * Data de criação: Jun 29, 2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.util.Iterator;
import java.util.Map;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe utilitária que provê recursos comuns no tratamento de mapas.
 * 
 * @author adrianop
 */
public final class UtilMapa {

	/**
	 * Construtor.
	 */
	private UtilMapa() {
		// Construtor.
	}

	/**
	 * Aplica um alterador no mapa. Tanto a chave quanto o valor poderão ser
	 * alterados.
	 * 
	 * @param <K> Tipo do objeto da chave do mapa.
	 * @param <V> Tipo do objeto do mapa.
	 * @param mapa Mapa de objetos.
	 * @param alterador Alterador de objetos
	 * @return Novo mapa com novos valores.
	 * @see AlteradorMapa
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> aplicarAlterador(Map<K, V> mapa,
			AlteradorMapa<K, V> alterador) {
		Map<K, V> resultado = getColecaoFactory().novoHashMap();

		if (isReferencia(mapa, alterador)) {
			Iterator<K> iterator = mapa.keySet().iterator();
			while (iterator.hasNext()) {
				K chave = (K) alterador.alterarChave(iterator.next());
				V valor = (V) alterador.alterarValor(mapa.get(chave));

				resultado.put(chave, valor);
			}
		}

		return resultado;
	}

	/**
	 * Filtra o mapa com base no filtro passado por parâmetro.
	 * 
	 * @param <K> Tipo do objeto da chave do mapa.
	 * @param <V> Tipo do objeto do mapa.
	 * @param mapa Mapa
	 * @param filtro Filtro que será aplicado no mapa.
	 * @return Mapa filtrado.
	 * @see FiltroMapa
	 */
	public static <K, V> Map<K, V> aplicarFiltro(Map<K, V> mapa,
			FiltroMapa<K, V> filtro) {
		if (isReferencia(mapa, filtro)) {
			Iterator<K> iterator = mapa.keySet().iterator();
			while (iterator.hasNext()) {
				K chave = iterator.next();
				V valor = mapa.get(chave);

				if (!filtro.isFiltrado(chave, valor)) {
					iterator.remove();
				}
			}
		}
		return mapa;
	}

	/**
	 * Aplica um filtro e um alterador no mapa.
	 * 
	 * @param <K> Tipo do objeto da chave do mapa.
	 * @param <V> Tipo do objeto do mapa.
	 * @param mapa Mapa que sofrerá a filtragem e a alteração.
	 * @param filtro Filtro
	 * @param alterador Alterador
	 * @return Novo mapa filtrado e alterado
	 * @see FiltroMapa
	 * @see AlteradorMapa
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> aplicarFiltroEAlterador(Map<K, V> mapa,
			FiltroMapa<K, V> filtro, AlteradorMapa<K, V> alterador) {
		Map<K, V> resultado = getColecaoFactory().novoHashMap();

		if (isReferencia(mapa, filtro, alterador)) {
			Iterator<K> iterator = mapa.keySet().iterator();

			while (iterator.hasNext()) {
				K chave = iterator.next();
				V valor = mapa.get(chave);

				if (filtro.isFiltrado(chave, valor)) {
					chave = (K) alterador.alterarChave(chave);
					valor = (V) alterador.alterarValor(valor);

					resultado.put(chave, valor);
				}
			}
		}
		return resultado;
	}
	
	/**
	 * Retorna true se a coleção estiver vazia.
	 * 
	 * @param colecao Collection
	 * @return true se a coleção estiver vazia.
	 */
	public static <K, V> boolean isVazio(Map<K, V> mapa) {
		return (!isReferencia(mapa) || mapa.size() == 0);
	}

	/**
	 * Retorna true se os objetos tiverem referência.
	 * 
	 * @param objeto0 Objeto validado
	 * @param objeto1 Objeto validado
	 * @return true se o objeto tiver referência.
	 */
	private static boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
