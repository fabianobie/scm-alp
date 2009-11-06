/*
 * UtilColecao.java
 * 
 * Data de criação: 24/05/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.colecao;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import br.com.ap.comum.calculadores.UtilSomadoresDeNumero;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.formatador.instancia.IFormatador;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.util.UtilLog;

/**
 * Classe utilitária que provê recursos comuns no tratamento de coleções.
 * 
 * @author AdrianoP
 */
public final class UtilColecao {

	/**
	 * Construtor.
	 */
	private UtilColecao() {
		// Construtor.
	}

	/**
	 * Aplica um alterador em cada objeto da coleção.
	 * 
	 * @param <T> Tipo de objeto que sofrerá a alteração.
	 * @param colecao Coleção de objetos.
	 * @param alterador Alterador de objetos
	 * @return Coleção com os objetos alterados.
	 */
	public static <T extends Object> Collection<T> aplicarAlterador(
			Collection<T> colecao, Alterador<T> alterador) {
		if (isReferencia(colecao, alterador)) {
			for (T objeto : colecao) {
				alterador.alterar(objeto);
			}
		}

		return colecao;
	}

	/**
	 * Aplica um conversor em cada objeto da coleção.
	 * 
	 * @param <O> Tipo do objeto de origem.
	 * @param <D> Tipo do objeto de destino
	 * @param colecao Coleção de objetos.
	 * @param conversor Conversor de objetos
	 * @return Coleção com os objetos convertidos.
	 */
	public static <O, D extends Object> Collection<D> aplicarConversor(
			Collection<O> colecao, IConversor<O, D> conversor) {
		Collection<D> resultado = getColecaoFactory().novoArrayList();

		if (isReferencia(colecao, conversor)) {
			for (O objeto : colecao) {
				resultado.add(conversor.converter(objeto));
			}
		}
		return resultado;
	}

	/**
	 * Aplica um filtro em uma coleção.
	 * 
	 * @param <T> Tipo do objeto que a coleção possui.
	 * @param colecao Coleção de objetos.
	 * @param filtro Filtro que será aplicado na coleção.
	 * @return Coleção filtrada.
	 * @see Filtro
	 */
	public static <T> Collection<T> aplicarFiltro(Collection<T> colecao,
			Filtro<T> filtro) {
		if (isReferencia(colecao, filtro)) {
			Iterator<T> iterator = novoIterator(colecao);
			while (iterator.hasNext()) {
				if (!filtro.isFiltrado(iterator.next())) {
					iterator.remove();
				}
			}
		}
		return colecao;
	}

	/**
	 * Filtra a coleção removendo todos os objetos existentes na coleção de
	 * elementos que não satisfaçam o comparador passado por parâmetro.
	 * 
	 * @param <T1> Tipo do objeto que servirá como parâmetro da comparação.
	 * @param <T2> Tipo de objeto contido na coleção.
	 * @param colecao Coleção de objetos.
	 * @param objeto Objeto contendo os parâmetros necessários ao comparador.
	 * @param comparador Comparador.
	 * @return Coleção filtrada.
	 * @see Comparador
	 */
	public static <T1, T2> Collection<T2> aplicarFiltro(
			Collection<T2> colecao, T1 objeto, Comparador<T1, T2> comparador) {
		if (isReferencia(colecao, objeto, comparador)) {
			Iterator<T2> iterator = novoIterator(colecao);
			while (iterator.hasNext()) {
				if (comparador.isIguais(objeto, iterator.next())) {
					iterator.remove();
				}
			}
		}
		return colecao;
	}

	/**
	 * Filtra a coleção removendo todos os objetos existentes que não satisfaçam
	 * o comparador passado por parâmetro.
	 * 
	 * @param <T1> Tipo de objeto da coleção filtrada.
	 * @param <T2> Tipo do objeto da coleção que será usada como filtro.
	 * @param colecao Coleção de objetos.
	 * @param objetos Objetos que serão removidos da coleção original.
	 * @param comparador Comparador.
	 * @return Coleção filtrada.
	 * @see Comparador
	 */
	public static <T1, T2> Collection<T1> aplicarFiltro(
			Collection<T1> colecao, Collection<T2> objetos,
			Comparador<T1, T2> comparador) {
		if (isReferencia(colecao, objetos, comparador)) {
			Iterator<T1> iterator = novoIterator(colecao);
			while (iterator.hasNext()) {
				if (!isContemElemento(objetos, iterator.next(), comparador)) {
					iterator.remove();
				}
			}
		}
		return colecao;
	}

	/**
	 * Retorna a soma de um critério definido pelo ISomador.
	 * 
	 * @param <T> Tipo de objeto que possui o atributo que será usado na soma.
	 * @param colecao Coleção de objetos.
	 * @param somador ISomador
	 * @return double resultado da soma
	 * @see Somador
	 */
	public static <T> double aplicarSomador(Collection<T> colecao,
			Somador<T> somador) {
		double resultado = 0.0d;

		if (isReferencia(colecao, somador)) {
			for (T objeto : colecao) {
				double valor = somador.getValor(objeto);
				resultado = UtilSomadoresDeNumero.somar(resultado, valor);
			}
		}

		return resultado;
	}

	/**
	 * Retorna a soma de um critério definido pelo ISomador.
	 * 
	 * @param <T> Tipo de objeto que possui o atributo que será usado na soma.
	 * @param colecao Coleção de objetos.
	 * @param somador ISomador
	 * @param formatador IFormatador que formatará o resultado da soma.
	 * @return resultado da soma formatado.
	 * @throws FormatadorException Exceção de formatação
	 * @see Somador
	 */
	public static <T> String aplicarSomador(Collection<T> colecao,
			Somador<T> somador, IFormatador<Double> formatador)
			throws FormatadorException {

		String resultado = null;

		if (isReferencia(colecao, somador, formatador)) {
			double soma = aplicarSomador(colecao, somador);
			Double somaDouble = getNumeroFactory().novoDouble(soma);
			resultado = formatador.formatar(somaDouble);
		}

		return resultado;
	}

	/**
	 * Ordena os objetos da coleção. Os objetos deverão implementar Comparable
	 * para que a ordenação seja feita.
	 * 
	 * @param <T> Tipo do objeto que a coleção possui.
	 * @param colecao Coleção de objetos.
	 * @return Coleção ordenada.
	 * @see Comparable
	 */
	public static <T extends Comparable<? super T>> Collection<T> ordenar(
			Collection<T> colecao) {
		List<T> resultado = null;
		if (isReferencia(colecao)) {
			resultado = getColecaoFactory().novoList(colecao);
			Collections.sort(resultado);
		}
		return resultado;
	}

	/**
	 * Ordena os objetos da coleção com base no Comparator passado por
	 * parâmetro.
	 * 
	 * @param <T> Tipo do objeto que a coleção possui.
	 * @param colecao Coleção de objetos.
	 * @param comparator Comparator.
	 * @return Coleção ordenada
	 * @see Comparator
	 */
	public static <T> Collection<T> ordenar(Collection<T> colecao,
			Comparator<? super T> comparator) {
		if (isReferencia(colecao, comparator)) {
			Collections.sort((List<T>) colecao, comparator);
		}
		return colecao;
	}

	/**
	 * Completa a coleção com a instância do objeto definido no 'tipo'.
	 * 
	 * @param <T> Tipo do objeto que a coleção possui.
	 * @param colecao Coleção de objetos
	 * @param total total de objetos que deverá haver na coleção.
	 * @param tipo Tipo do objeto que completará a coleção.
	 */
	public static <T> void completarColecao(Collection<T> colecao, int total,
			Class<T> tipo) {

		if (isReferencia(colecao, tipo)) {
			while (colecao.size() < total) {
				try {
					colecao.add(tipo.newInstance());
				} catch (Exception e) {
					getLog().warn(e);
				}
			}
		}
	}

	/**
	 * Retorna uma cópia de uma nova coleção.
	 * 
	 * @param <T> Tipo do objeto que a coleção possui.
	 * @param colecao Coleção
	 * @return nova coleção
	 */
	public static <T> Collection<T> copiarColecao(Collection<T> colecao) {
		Collection<T> resultado = getColecaoFactory().novoArrayList();

		if (isReferencia(colecao)) {
			for (T objeto : colecao) {
				resultado.add(objeto);
			}
		}

		return resultado;
	}

	/**
	 * Recupera um elemento da coleção que satisfaça o respectivo filtro.
	 * 
	 * @param <T> Tipo do objeto que a coleção possui.
	 * @param colecao Coleção de objetos.
	 * @param filtro Filtro com o critério da busca.
	 * @return Objeto que satisfaça o critério da busca.
	 * @see Filtro
	 */
	public static <T> T getElemento(Collection<T> colecao, Filtro<T> filtro) {
		T resultado = null;

		if (isReferencia(colecao, filtro)) {
			Iterator<T> iterator = novoIterator(colecao);
			while (iterator.hasNext() && !isReferencia(resultado)) {
				T objeto = iterator.next();
				if (filtro.isFiltrado(objeto)) {
					resultado = objeto;
				}
			}
		}

		return resultado;
	}

	/**
	 * Recupera um elemento da coleção que satisfaça o respectivo comparador.
	 * 
	 * @param <T1> Tipo do objeto que a coleção possui.
	 * @param <T2> Tipo do objeto que será usado como parâmetro da comparação.
	 * @param colecao Coleção de objetos.
	 * @param objeto Objeto contendo os parâmetros usados pelo comparador.
	 * @param comparador Compara cada objeto da coleção com o objeto passado por
	 *            parâmetro.
	 * @return Objeto que satisfaça o critério da busca.
	 */
	public static <T1, T2> T2 getElemento(Collection<T2> colecao, T1 objeto,
			Comparador<T1, T2> comparador) {
		T2 resultado = null;

		if (isReferencia(colecao, objeto, comparador)) {
			Iterator<T2> iterator = novoIterator(colecao);
			while (iterator.hasNext() && !isReferencia(resultado)) {
				T2 objetoDaColecao = iterator.next();
				if (comparador.isIguais(objeto, objetoDaColecao)) {
					resultado = objetoDaColecao;
				}
			}
		}

		return resultado;
	}

	/**
	 * Recupera o elemento do índice solicitado.
	 * 
	 * @param <T> Tipo do objeto da lista.
	 * @param lista Lista de objetos.
	 * @param indice índice desejado.
	 * @return Objeto do índice
	 */
	public static <T> T getElementoDoIndice(List<T> lista, int indice) {
		T resultado = null;

		if (!isVazio(lista) && indice >= 0 && indice < lista.size()) {
			resultado = lista.get(indice);
		}
		return resultado;
	}

	/**
	 * Recupera o elemento do índice solicitado.
	 * 
	 * @param <T> Tipo do objeto da lista.
	 * @param colecao Coleção de objetos.
	 * @param indice índice desejado.
	 * @return Objeto do índice
	 */
	public static <T> T getElementoDoIndice(Collection<T> colecao, int indice) {
		List<T> lista = getColecaoFactory().novoList(colecao);
		return getElementoDoIndice(lista, indice);
	}

	/**
	 * Recupera o elemento do índice solicitado.
	 * 
	 * @param <T> Tipo do objeto da lista.
	 * @param colecao Coleção de objetos.
	 * @return Objeto do índice
	 */
	public static <T> T getElementoDoUltimoIndice(Collection<T> colecao) {
		List<T> lista = getColecaoFactory().novoList(colecao);
		int indice = (lista.size() - 1);
		return getElementoDoIndice(lista, indice);
	}

	/**
	 * Retorna uma coleção com o merge das duas coleções passadas por parâmetro.
	 * 
	 * @param <T1> Tipo do objeto da coleção original
	 * @param <T2> Tipo do objeto da coleção usada como parâmetro da comparação.
	 * @param colecao Coleção original
	 * @param elementos Coleção com os objetos que serão verificados na original
	 * @param comparador Comparador de objetos.
	 * @return Coleção com os elementos iguais entre as duas coleções.
	 */
	public static <T1, T2> Collection<T1> getElementosIguais(
			Collection<T1> colecao, Collection<T2> elementos,
			Comparador<T1, T2> comparador) {
		if (isReferencia(colecao, elementos, comparador)) {
			Iterator<T1> iterator = novoIterator(colecao);
			while (iterator.hasNext()) {
				if (!isContemElemento(elementos, iterator.next(), comparador)) {
					iterator.remove();
				}
			}
		}

		return colecao;
	}

	/**
	 * Retorna o tamanho da coleção.
	 * 
	 * @param colecao Coleção
	 * @return tamanho da coleção
	 */
	public static int getTamanho(Collection<?> colecao) {
		int resultado = 0;
		if (isReferencia(colecao)) {
			resultado = colecao.size();
		}
		return resultado;
	}

	/**
	 * Retorna true se existir um objeto que preencha os requisitos definidos
	 * pelo filtro.
	 * 
	 * @param <T> Tipo do objeto da coleção.
	 * @param colecao Coleção de objetos.
	 * @param filtro Filtro que define o critério da busca.
	 * @return true se existir um objeto que preencha os requisitos definidos
	 *         pelo filtro.
	 * @see Filtro
	 */
	public static <T> boolean isContemElemento(Collection<T> colecao,
			Filtro<T> filtro) {
		boolean resultado = false;

		if (isReferencia(colecao, filtro)) {
			Iterator<T> iterator = novoIterator(colecao);
			while (iterator.hasNext() && resultado == false) {
				resultado = filtro.isFiltrado(iterator.next());
			}
		}
		return resultado;
	}

	/**
	 * Retorna true se existir um objeto do tipo informado no comparador.
	 * 
	 * @param <T1> Tipo de objeto que será usado como parâmetro da comparação.
	 * @param <T2> Tipo do objeto da coleção.
	 * @param colecao Coleção de objetos.
	 * @param elemento Elemento que possui os parâmetros necessários para o
	 *            comparador.
	 * @param comparador Comparador.
	 * @return true se existir um objeto do tipo informado no comparador.
	 */
	public static <T1, T2> boolean isContemElemento(Collection<T2> colecao,
			T1 elemento, Comparador<T1, T2> comparador) {
		boolean resultado = false;

		if (isReferencia(colecao, elemento, comparador)) {
			Iterator<T2> iterator = novoIterator(colecao);
			while (iterator.hasNext() && resultado == false) {
				resultado = comparador.isIguais(elemento, iterator.next());
			}
		}
		return resultado;
	}

	/**
	 * Retorna true se existir algum elemento em comum entre as duas coleções.
	 * 
	 * @param <T1> Tipo de objeto da coleção de origem.
	 * @param <T2> Tipo de objeto da coleção secundária.
	 * @param colecao Coleção de objetos.
	 * @param elementos Coleção de elementos que será verificado se existe na
	 *            coleção de objetos.
	 * @param comparador Comparador.
	 * @return true se existir algum objeto em comum entre as coleções.
	 */
	public static <T1, T2> boolean isContemElementoEmComum(
			Collection<T2> colecao, Collection<T1> elementos,
			Comparador<T1, T2> comparador) {
		boolean resultado = false;

		if (isReferencia(colecao, elementos, comparador)) {
			Iterator<T1> iterator = novoIterator(elementos);
			while (iterator.hasNext() && resultado == false) {
				T1 objeto = iterator.next();
				resultado = isContemElemento(colecao, objeto, comparador);
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
	public static boolean isVazio(Collection<?> colecao) {
		return (getTamanho(colecao) == 0);
	}

	/**
	 * Cria uma nova coleção com os objetos filtrados da coleção original.
	 * 
	 * @param <T> Tipo de objeto da coleção.
	 * @param colecao Coleção de objetos.
	 * @param filtro Filtro que será aplicado na coleção.
	 * @return nova coleção.
	 * @see Filtro
	 */
	public static <T> Collection<T> novaColecao(Collection<T> colecao,
			Filtro<T> filtro) {
		Collection<T> resultado = getColecaoFactory().novoArrayList();

		if (isReferencia(colecao, filtro)) {
			for (T objeto : colecao) {
				if (filtro.isFiltrado(objeto)) {
					resultado.add(objeto);
				}
			}
		}
		return resultado;
	}

	/**
	 * Filtra a coleção removendo todos os objetos existentes na coleção de
	 * elementos que satisfaçam o comparador passado por parâmetro.
	 * 
	 * @param <T1> Tipo de objeto usado pela comparação.
	 * @param <T2> Tipo de objeto da coleção.
	 * @param colecao Coleção de objetos.
	 * @param parametro Objeto contendo os parâmetros necessários ao comparador.
	 * @param comparador Comparador.
	 * @return Coleção filtrada.
	 * @see Comparador
	 */
	public static <T1, T2> Collection<T2> novaColecao(Collection<T2> colecao,
			T1 parametro, Comparador<T1, T2> comparador) {
		Collection<T2> resultado = getColecaoFactory().novoArrayList();

		if (isReferencia(colecao, parametro, comparador)) {
			for (T2 objeto : colecao) {
				if (comparador.isIguais(parametro, objeto)) {
					resultado.add(objeto);
				}
			}
		}
		return resultado;
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna NumeroFactory.
	 * 
	 * @return NumeroFactory
	 */
	private static NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	private static LogAbstrato getLog() {
		return UtilLog.getLog();
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto tiver referência.
	 */
	private static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se os objetos tiverem referência.
	 * 
	 * @param objeto0 Objeto validado
	 * @param objeto1 Objeto validado
	 * @return true se o objeto tiver referência.
	 */
	private static boolean isReferencia(Object objeto0, Object objeto1) {
		return UtilObjeto.isReferencia(objeto0, objeto1);
	}

	/**
	 * Retorna true se os objetos tiverem referência.
	 * 
	 * @param objeto0 Objeto validado
	 * @param objeto1 Objeto validado
	 * @param objeto2 Objeto validado
	 * @return true se o objeto tiver referência.
	 */
	private static boolean isReferencia(Object objeto0, Object objeto1,
			Object objeto2) {
		return UtilObjeto.isReferencia(objeto0, objeto1, objeto2);
	}

	/**
	 * Retorna o iterator da coleção.
	 * 
	 * @param <T> Tipo de objeto
	 * @param colecao Coleção
	 * @return Iterator
	 */
	private static <T> Iterator<T> novoIterator(Collection<T> colecao) {
		return getColecaoFactory().novoIterator(colecao);
	}
}
