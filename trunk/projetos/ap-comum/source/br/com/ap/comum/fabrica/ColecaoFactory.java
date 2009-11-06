/*
 * ColecaoFactory.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Fábrica de coleções, cria a instância de objetos descendentes de
 * java.util.Collection.<br>
 * Padrão Factory Method e Singleton.
 * 
 * @author adrianop
 */
public final class ColecaoFactory extends FactoryAbstrata {

	private static ColecaoFactory	instancia	= new ColecaoFactory();

	/**
	 * Construtor.
	 */
	private ColecaoFactory() {
		// Construtor.
	}

	/**
	 * Retorna a instância da fábrica.
	 * 
	 * @return instância da fábrica.
	 */
	public static ColecaoFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna novo ArrayList.
	 * 
	 * @param <T> Tipo de retorno
	 * @return novo ArrayList.
	 */
	public <T> List<T> novoArrayList() {
		return new ArrayList<T>();
	}

	/**
	 * Retorna novo HashMap.
	 * 
	 * @param <K> Tipo da chave
	 * @param <V> Tipo do objeto
	 * @return novo HashMap.
	 */
	public <K, V> Map<K, V> novoHashMap() {
		return new HashMap<K, V>();
	}

	/**
	 * Retorna novo LinkedList.
	 * 
	 * @param <T> Tipo de retorno
	 * @return novo LinkedList.
	 */
	public <T> List<T> novoLinkedList() {
		return new LinkedList<T>();
	}

	/**
	 * Retorna novo LinkedHashSet.
	 * 
	 * @param <T> Tipo de retorno
	 * @return novo LinkedHashSet.
	 */
	public <T> Set<T> novoLinkedHashSet() {
		return new LinkedHashSet<T>();
	}

	/**
	 * Retorna novo Vector.
	 * 
	 * @param <T> Tipo de retorno
	 * @return novo Vector.
	 */
	public <T> List<T> novoVector() {
		return new Vector<T>();
	}

	/**
	 * Retorna nova lista da coleção.
	 * 
	 * @param <T> Tipo de retorno
	 * @param colecao Collection
	 * @return Nova lista da Coleção.
	 */
	public <T> List<T> novoList(Collection<T> colecao) {
		List<T> resultado = novoArrayList();

		if (isReferencia(colecao)) {
			if (colecao instanceof List) {
				resultado = (List<T>) colecao;
			} else {
				resultado.addAll(colecao);
			}
		}

		return resultado;
	}

	/**
	 * Retorna nova lista do iterator.
	 * 
	 * @param <T> Tipo de retorno
	 * @param iterator Iterator
	 * @return Nova lista da iteração.
	 */
	public <T> List<T> novoList(Iterator<T> iterator) {
		List<T> resultado = novoArrayList();

		if (isReferencia(iterator)) {
			while (iterator.hasNext()) {
				resultado.add(iterator.next());
			}
		}

		return resultado;
	}

	/**
	 * Retorna novo iterator da coleção.
	 * 
	 * @param <T> Tipo de retorno
	 * @param colecao Collection
	 * @return novo iterator da coleção.
	 */
	public <T> Iterator<T> novoIterator(Collection<T> colecao) {
		Iterator<T> resultado = null;

		if (isReferencia(colecao)) {
			resultado = colecao.iterator();
		} else {
			List<T> lista = novoArrayList();
			resultado = lista.iterator();
		}

		return resultado;
	}

	/**
	 * Retorna o list de valores do mapa. Uma nova referência será criada e
	 * retornada.
	 * 
	 * @param <K> Tipo da chave
	 * @param <Y> Tipo do objeto
	 * @param mapa Mapa de valores.
	 * @return lista de valores do mapa.
	 */
	public <K, Y> List<Y> novoList(Map<K, Y> mapa) {
		List<Y> resultado = novoArrayList();

		if (isReferencia(mapa)) {
			Collection<Y> valores = mapa.values();
			resultado = novoList(valores);
		}

		return resultado;
	}

	/**
	 * @param <T> Tipo de retorno
	 * @return novo HashSet
	 */
	public <T> Set<T> novoHashSet() {
		return new HashSet<T>();
	}

	/**
	 * @param <T> Tipo de retorno
	 * @param colecao Coleção
	 * @return novo HashSet
	 */
	public <T> Set<T> novoHashSet(Collection<T> colecao) {
		Set<T> resultado = novoHashSet();
		resultado.addAll(colecao);

		return resultado;
	}

	/**
	 * Retorna novo TreeMap.
	 * 
	 * @param <K> Tipo da chave
	 * @param <Y> Tipo do objeto
	 * @return novo TreeMap
	 */
	public <K, Y> Map<K, Y> novoTreeMap() {
		return new TreeMap<K, Y>();
	}

	/**
	 * Retorna novo TreeMap.
	 * 
	 * @param <K> Tipo da chave
	 * @param <Y> Tipo do objeto
	 * @param mapa Mapa que será carregado no novo treemap.
	 * @return novo TreeMap
	 */
	public <K, Y> Map<K, Y> novoTreeMap(Map<K, Y> mapa) {
		Map<K, Y> tree = novoTreeMap();
		tree.putAll(mapa);

		return tree;
	}
}
