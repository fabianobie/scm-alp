/*
 * UtilColecao.java
 * 
 * Data de cria��o: 24/05/2007
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
 * Classe utilit�ria que prov� recursos comuns no tratamento de cole��es.
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
	 * Aplica um alterador em cada objeto da cole��o.
	 * 
	 * @param <T> Tipo de objeto que sofrer� a altera��o.
	 * @param colecao Cole��o de objetos.
	 * @param alterador Alterador de objetos
	 * @return Cole��o com os objetos alterados.
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
	 * Aplica um conversor em cada objeto da cole��o.
	 * 
	 * @param <O> Tipo do objeto de origem.
	 * @param <D> Tipo do objeto de destino
	 * @param colecao Cole��o de objetos.
	 * @param conversor Conversor de objetos
	 * @return Cole��o com os objetos convertidos.
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
	 * Aplica um filtro em uma cole��o.
	 * 
	 * @param <T> Tipo do objeto que a cole��o possui.
	 * @param colecao Cole��o de objetos.
	 * @param filtro Filtro que ser� aplicado na cole��o.
	 * @return Cole��o filtrada.
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
	 * Filtra a cole��o removendo todos os objetos existentes na cole��o de
	 * elementos que n�o satisfa�am o comparador passado por par�metro.
	 * 
	 * @param <T1> Tipo do objeto que servir� como par�metro da compara��o.
	 * @param <T2> Tipo de objeto contido na cole��o.
	 * @param colecao Cole��o de objetos.
	 * @param objeto Objeto contendo os par�metros necess�rios ao comparador.
	 * @param comparador Comparador.
	 * @return Cole��o filtrada.
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
	 * Filtra a cole��o removendo todos os objetos existentes que n�o satisfa�am
	 * o comparador passado por par�metro.
	 * 
	 * @param <T1> Tipo de objeto da cole��o filtrada.
	 * @param <T2> Tipo do objeto da cole��o que ser� usada como filtro.
	 * @param colecao Cole��o de objetos.
	 * @param objetos Objetos que ser�o removidos da cole��o original.
	 * @param comparador Comparador.
	 * @return Cole��o filtrada.
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
	 * Retorna a soma de um crit�rio definido pelo ISomador.
	 * 
	 * @param <T> Tipo de objeto que possui o atributo que ser� usado na soma.
	 * @param colecao Cole��o de objetos.
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
	 * Retorna a soma de um crit�rio definido pelo ISomador.
	 * 
	 * @param <T> Tipo de objeto que possui o atributo que ser� usado na soma.
	 * @param colecao Cole��o de objetos.
	 * @param somador ISomador
	 * @param formatador IFormatador que formatar� o resultado da soma.
	 * @return resultado da soma formatado.
	 * @throws FormatadorException Exce��o de formata��o
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
	 * Ordena os objetos da cole��o. Os objetos dever�o implementar Comparable
	 * para que a ordena��o seja feita.
	 * 
	 * @param <T> Tipo do objeto que a cole��o possui.
	 * @param colecao Cole��o de objetos.
	 * @return Cole��o ordenada.
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
	 * Ordena os objetos da cole��o com base no Comparator passado por
	 * par�metro.
	 * 
	 * @param <T> Tipo do objeto que a cole��o possui.
	 * @param colecao Cole��o de objetos.
	 * @param comparator Comparator.
	 * @return Cole��o ordenada
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
	 * Completa a cole��o com a inst�ncia do objeto definido no 'tipo'.
	 * 
	 * @param <T> Tipo do objeto que a cole��o possui.
	 * @param colecao Cole��o de objetos
	 * @param total total de objetos que dever� haver na cole��o.
	 * @param tipo Tipo do objeto que completar� a cole��o.
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
	 * Retorna uma c�pia de uma nova cole��o.
	 * 
	 * @param <T> Tipo do objeto que a cole��o possui.
	 * @param colecao Cole��o
	 * @return nova cole��o
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
	 * Recupera um elemento da cole��o que satisfa�a o respectivo filtro.
	 * 
	 * @param <T> Tipo do objeto que a cole��o possui.
	 * @param colecao Cole��o de objetos.
	 * @param filtro Filtro com o crit�rio da busca.
	 * @return Objeto que satisfa�a o crit�rio da busca.
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
	 * Recupera um elemento da cole��o que satisfa�a o respectivo comparador.
	 * 
	 * @param <T1> Tipo do objeto que a cole��o possui.
	 * @param <T2> Tipo do objeto que ser� usado como par�metro da compara��o.
	 * @param colecao Cole��o de objetos.
	 * @param objeto Objeto contendo os par�metros usados pelo comparador.
	 * @param comparador Compara cada objeto da cole��o com o objeto passado por
	 *            par�metro.
	 * @return Objeto que satisfa�a o crit�rio da busca.
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
	 * Recupera o elemento do �ndice solicitado.
	 * 
	 * @param <T> Tipo do objeto da lista.
	 * @param lista Lista de objetos.
	 * @param indice �ndice desejado.
	 * @return Objeto do �ndice
	 */
	public static <T> T getElementoDoIndice(List<T> lista, int indice) {
		T resultado = null;

		if (!isVazio(lista) && indice >= 0 && indice < lista.size()) {
			resultado = lista.get(indice);
		}
		return resultado;
	}

	/**
	 * Recupera o elemento do �ndice solicitado.
	 * 
	 * @param <T> Tipo do objeto da lista.
	 * @param colecao Cole��o de objetos.
	 * @param indice �ndice desejado.
	 * @return Objeto do �ndice
	 */
	public static <T> T getElementoDoIndice(Collection<T> colecao, int indice) {
		List<T> lista = getColecaoFactory().novoList(colecao);
		return getElementoDoIndice(lista, indice);
	}

	/**
	 * Recupera o elemento do �ndice solicitado.
	 * 
	 * @param <T> Tipo do objeto da lista.
	 * @param colecao Cole��o de objetos.
	 * @return Objeto do �ndice
	 */
	public static <T> T getElementoDoUltimoIndice(Collection<T> colecao) {
		List<T> lista = getColecaoFactory().novoList(colecao);
		int indice = (lista.size() - 1);
		return getElementoDoIndice(lista, indice);
	}

	/**
	 * Retorna uma cole��o com o merge das duas cole��es passadas por par�metro.
	 * 
	 * @param <T1> Tipo do objeto da cole��o original
	 * @param <T2> Tipo do objeto da cole��o usada como par�metro da compara��o.
	 * @param colecao Cole��o original
	 * @param elementos Cole��o com os objetos que ser�o verificados na original
	 * @param comparador Comparador de objetos.
	 * @return Cole��o com os elementos iguais entre as duas cole��es.
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
	 * Retorna o tamanho da cole��o.
	 * 
	 * @param colecao Cole��o
	 * @return tamanho da cole��o
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
	 * @param <T> Tipo do objeto da cole��o.
	 * @param colecao Cole��o de objetos.
	 * @param filtro Filtro que define o crit�rio da busca.
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
	 * @param <T1> Tipo de objeto que ser� usado como par�metro da compara��o.
	 * @param <T2> Tipo do objeto da cole��o.
	 * @param colecao Cole��o de objetos.
	 * @param elemento Elemento que possui os par�metros necess�rios para o
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
	 * Retorna true se existir algum elemento em comum entre as duas cole��es.
	 * 
	 * @param <T1> Tipo de objeto da cole��o de origem.
	 * @param <T2> Tipo de objeto da cole��o secund�ria.
	 * @param colecao Cole��o de objetos.
	 * @param elementos Cole��o de elementos que ser� verificado se existe na
	 *            cole��o de objetos.
	 * @param comparador Comparador.
	 * @return true se existir algum objeto em comum entre as cole��es.
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
	 * Retorna true se a cole��o estiver vazia.
	 * 
	 * @param colecao Collection
	 * @return true se a cole��o estiver vazia.
	 */
	public static boolean isVazio(Collection<?> colecao) {
		return (getTamanho(colecao) == 0);
	}

	/**
	 * Cria uma nova cole��o com os objetos filtrados da cole��o original.
	 * 
	 * @param <T> Tipo de objeto da cole��o.
	 * @param colecao Cole��o de objetos.
	 * @param filtro Filtro que ser� aplicado na cole��o.
	 * @return nova cole��o.
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
	 * Filtra a cole��o removendo todos os objetos existentes na cole��o de
	 * elementos que satisfa�am o comparador passado por par�metro.
	 * 
	 * @param <T1> Tipo de objeto usado pela compara��o.
	 * @param <T2> Tipo de objeto da cole��o.
	 * @param colecao Cole��o de objetos.
	 * @param parametro Objeto contendo os par�metros necess�rios ao comparador.
	 * @param comparador Comparador.
	 * @return Cole��o filtrada.
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
	 * Retorna true se o objeto tiver refer�ncia.
	 * 
	 * @param objeto Objeto validado
	 * @return true se o objeto tiver refer�ncia.
	 */
	private static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se os objetos tiverem refer�ncia.
	 * 
	 * @param objeto0 Objeto validado
	 * @param objeto1 Objeto validado
	 * @return true se o objeto tiver refer�ncia.
	 */
	private static boolean isReferencia(Object objeto0, Object objeto1) {
		return UtilObjeto.isReferencia(objeto0, objeto1);
	}

	/**
	 * Retorna true se os objetos tiverem refer�ncia.
	 * 
	 * @param objeto0 Objeto validado
	 * @param objeto1 Objeto validado
	 * @param objeto2 Objeto validado
	 * @return true se o objeto tiver refer�ncia.
	 */
	private static boolean isReferencia(Object objeto0, Object objeto1,
			Object objeto2) {
		return UtilObjeto.isReferencia(objeto0, objeto1, objeto2);
	}

	/**
	 * Retorna o iterator da cole��o.
	 * 
	 * @param <T> Tipo de objeto
	 * @param colecao Cole��o
	 * @return Iterator
	 */
	private static <T> Iterator<T> novoIterator(Collection<T> colecao) {
		return getColecaoFactory().novoIterator(colecao);
	}
}
