/*
 * UtilReflexaoPropriedade.java
 * 
 * Data de criação: Jul 9, 2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import br.com.ap.reflexao.engine.PropriedadeEngine;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * Classe responsável pela manipulação dos atributos de uma classe.
 * 
 * @author adrianop
 */
public final class UtilReflexaoPropriedade extends UtilReflexaoAbstrato {
	private static PropriedadeEngine	propriedadeEngine;

	/**
	 * Construtor.
	 */
	private UtilReflexaoPropriedade() {
		// Construtor.
	}

	/**
	 * Retorna o valor de uma propriedade do objeto passado por parâmetro.
	 * 
	 * @param <T>
	 *            Objeto resultado da propriedade solicitada.
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade solicitada.
	 * @return valor de uma propriedade do objeto passado por parâmetro.
	 * @throws ReflexaoException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(Object objeto, String propriedade)
			throws ReflexaoException {
		T resultado = null;
		try {
			resultado = (T) getPropriedadeEngine().get(objeto, propriedade);
		} catch (IllegalAccessException e) {
			throw acessoNegadoAoMetodo(propriedade, e);
		} catch (InvocationTargetException e) {
			throw erroAoInvocarMetodo(propriedade, e);
		} catch (NoSuchMethodException e) {
			throw metodoNaoEncontrado(objeto, propriedade);
		} catch (SecurityException e) {
			throw erro(e);
		} catch (NoSuchFieldException e) {
			throw erro(e);
		}
		return resultado;
	}

	/**
	 * Retorna o valor de uma propriedade do objeto passado por parâmetro. A
	 * propriedade deverá ser uma lista.
	 * 
	 * @param <T>
	 *            Objeto resultado da propriedade solicitada.
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade solicitada.
	 * @param indice
	 *            Índice da lista.
	 * @return valor de uma propriedade do objeto passado por parâmetro.
	 * @throws ReflexaoException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getEmPropriedadeIndexada(Object objeto,
			String propriedade, int indice) throws ReflexaoException {
		T resultado = null;
		try {
			resultado = (T) getPropriedadeEngine().getEmPropriedadeIndexada(
					objeto, propriedade, indice);
		} catch (IllegalAccessException e) {
			throw acessoNegadoAoMetodo(propriedade, e);
		} catch (InvocationTargetException e) {
			throw erroAoInvocarMetodo(propriedade, e);
		} catch (NoSuchMethodException e) {
			throw metodoNaoEncontrado(objeto, propriedade);
		} catch (IndexOutOfBoundsException e) {
			throw indiceNaoEncontradoNaColecao(objeto, propriedade, indice);
		}
		return resultado;
	}

	/**
	 * Retorna o valor de uma propriedade do objeto passado por parâmetro. A
	 * propriedade deverá ser um mapa.
	 * 
	 * @param <T>
	 *            Objeto resultado da propriedade solicitada.
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade solicitada.
	 * @param chave
	 *            Chave do mapa.
	 * @return valor de uma propriedade do objeto passado por parâmetro.
	 * @throws ReflexaoException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getEmPropriedadeMapeada(Object objeto,
			String propriedade, String chave) throws ReflexaoException {
		T resultado = null;
		try {
			resultado = (T) getPropriedadeEngine().getEmPropriedadeMapeada(
					objeto, propriedade, chave);
		} catch (IllegalAccessException e) {
			throw acessoNegadoAoMetodo(propriedade, e);
		} catch (InvocationTargetException e) {
			throw erroAoInvocarMetodo(propriedade, e);
		} catch (NoSuchMethodException e) {
			throw metodoNaoEncontrado(objeto, propriedade);
		}
		return resultado;
	}

	/**
	 * Atribui um valor à propriedade do objeto.
	 * 
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade na qual o valor será atribuído.
	 * @param valor
	 *            Objeto que será atribuído na propriedade.
	 * @throws ReflexaoException
	 */
	public static void set(Object objeto, String propriedade, Object valor)
			throws ReflexaoException {
		try {
			getPropriedadeEngine().set(objeto, propriedade, valor);
		} catch (IllegalAccessException e) {
			throw acessoNegadoAoMetodo(propriedade, e);
		} catch (InvocationTargetException e) {
			throw erroAoInvocarMetodo(propriedade, e);
		} catch (NoSuchMethodException e) {
			throw metodoNaoEncontrado(objeto, propriedade);
		} catch (SecurityException e) {
			erro(e);
		} catch (NoSuchFieldException e) {
			erro(e);
		}
	}

	/**
	 * Atribui um objeto ao indice da lista.
	 * 
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade na qual o valor será atribuído.
	 * @param indice
	 *            Índice da lista da propriedade.
	 * @param valor
	 *            Valor que será adicionado na lista.
	 * @throws ReflexaoException
	 */
	public static void setEmPropriedadeIndexada(Object objeto,
			String propriedade, int indice, Object valor)
			throws ReflexaoException {
		try {
			getPropriedadeEngine().setEmPropriedadeIndexada(objeto,
					propriedade, indice, valor);
		} catch (IllegalAccessException e) {
			throw acessoNegadoAoMetodo(propriedade, e);
		} catch (InvocationTargetException e) {
			throw erroAoInvocarMetodo(propriedade, e);
		} catch (NoSuchMethodException e) {
			throw metodoNaoEncontrado(objeto, propriedade);
		} catch (IndexOutOfBoundsException e) {
			throw indiceNaoEncontradoNaColecao(objeto, propriedade, indice);
		}
	}

	/**
	 * Atribui um objeto à chave do mapa.
	 * 
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade na qual o valor será atribuído.
	 * @param chave
	 *            Chave do mapa.
	 * @param valor
	 *            Valor que será adicionado no mapa.
	 * @throws ReflexaoException
	 */
	public static void setEmPropriedadeMapeada(Object objeto,
			String propriedade, String chave, Object valor)
			throws ReflexaoException {
		try {
			getPropriedadeEngine().setEmPropriedadeMapeada(objeto, propriedade,
					chave, valor);
		} catch (IllegalAccessException e) {
			throw acessoNegadoAoMetodo(propriedade, e);
		} catch (InvocationTargetException e) {
			throw erroAoInvocarMetodo(propriedade, e);
		} catch (NoSuchMethodException e) {
			throw metodoNaoEncontrado(objeto, propriedade);
		}
	}

	/**
	 * Retorna o tipo da propriedade solicitada.
	 * 
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            Propriedade solicitada.
	 * @return tipo da propriedade solicitada.
	 * @throws ReflexaoException
	 */
	public static Class<?> getTipoDaPropriedade(Object objeto,
			String propriedade) throws ReflexaoException {
		try {
			return getPropriedadeEngine().getTipoDaPropriedade(objeto,
					propriedade);
		} catch (IllegalAccessException e) {
			throw acessoNegadoAoMetodo(propriedade, e);
		} catch (InvocationTargetException e) {
			throw erroAoInvocarMetodo(propriedade, e);
		} catch (NoSuchMethodException e) {
			throw metodoNaoEncontrado(objeto, propriedade);
		}
	}

	/**
	 * Limpa o cache de metodos.
	 */
	public static void limparCache() {
		getPropriedadeEngine().limparCache();
	}

	/**
	 * Copia as propriedades de um objeto para outro.
	 * 
	 * @param origem
	 *            Objeto de origem.
	 * @param destino
	 *            Objeto de destino.
	 * @throws ReflexaoException
	 */
	public static void copiarPropriedades(Object origem, Object destino)
			throws ReflexaoException {
		try {
			getPropriedadeEngine().copiarPropriedades(origem, destino);
		} catch (IllegalAccessException e) {
			throw erro(e);
		} catch (InvocationTargetException e) {
			throw erro(e);
		} catch (NoSuchMethodException e) {
			throw erro(e);
		}
	}

	/**
	 * Retorna o mapa de propriedades/objetos do objeto solicitado.
	 * 
	 * @param objeto
	 *            Objeto.
	 * @return Mapa contendo as propriedades e objetos.
	 * @throws ReflexaoException
	 */
	public static Map<String, ?> getMapaDePropriedades(Object objeto)
			throws ReflexaoException {
		Map<String, ?> resultado = null;
		try {
			resultado = getPropriedadeEngine().getMapaDePropriedades(objeto);
		} catch (IllegalAccessException e) {
			throw erro(e);
		} catch (InvocationTargetException e) {
			throw erro(e);
		} catch (NoSuchMethodException e) {
			throw erro(e);
		} catch (IllegalArgumentException e) {
			throw erro(e);
		}
		return resultado;
	}

	/**
	 * @return propriedadeEngine
	 */
	private static PropriedadeEngine getPropriedadeEngine() {
		if (!isReferencia(propriedadeEngine)) {
			propriedadeEngine = new PropriedadeEngine();
		}
		return propriedadeEngine;
	}
}
