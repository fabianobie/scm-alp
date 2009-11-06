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
import java.lang.reflect.Method;

import br.com.ap.reflexao.engine.MetodoEngine;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * Classe responsável pela manipulação dos métodos de uma classe.
 * 
 * @author adrianop
 */
public final class UtilReflexaoMetodo extends UtilReflexaoAbstrato {
	private static MetodoEngine	metodoEngine;

	/**
	 * Construtor.
	 */
	private UtilReflexaoMetodo() {
		// Construtor.
	}

	/**
	 * Retorna o método acessível solicitado, se o método não for encontrado
	 * será retornado null.
	 * 
	 * @param classe
	 *            Classe
	 * @param nome
	 *            Nome do método
	 * @param parametros
	 *            Parâmetros do método.
	 * @return método solicitado
	 */
	public static Method get(Class<?> classe, String nome,
			Class<?>... parametros) {
		return getMetodoEngine().get(classe, nome, parametros);
	}

	/**
	 * Invoca o método solicitado.
	 * 
	 * @param <T>
	 *            Tipo do resultado do método executado.
	 * @param objeto
	 *            Objeto que sofrerá a chamada do método.
	 * @param nome
	 *            Nome do método.
	 * @param args
	 *            Parâmetros do método.
	 * @return Resultado da chamada do método.
	 * @throws ReflexaoException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T invocar(Object objeto, String nome, Object... args)
			throws ReflexaoException {
		T resultado = null;

		try {
			resultado = (T) getMetodoEngine().invocar(objeto, nome, args);
		} catch (IllegalAccessException e) {
			throw acessoNegadoAoMetodo(nome, e);
		} catch (InvocationTargetException e) {
			throw erroAoInvocarMetodo(nome, e);
		} catch (NoSuchMethodException e) {
			throw metodoNaoEncontrado(objeto, nome);
		}

		return resultado;
	}

	/**
	 * Retorna o método GET solicitado.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do método.
	 * @return método GET solicitado.
	 */
	public static Method getMetodoGet(Class<?> classe, String nome) {

		return getMetodoEngine().getMetodoGet(classe, nome);
	}

	/**
	 * Retorna o método SET solicitado.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do método.
	 * @param parametro
	 *            Parâmetro do método.
	 * @return método GET solicitado.
	 */
	public static Method getMetodoSet(Class<?> classe, String nome,
			Class<?> parametro) {

		return getMetodoEngine().getMetodoSet(classe, nome, parametro);
	}

	/**
	 * Retorna o tipo de retorno do método GET solicitado.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do método.
	 * @return tipo de retorno do método GET solicitado.
	 */
	public static Class<?> getTipoResultadoMetodoGet(Class<?> classe,
			String nome) {

		return getMetodoEngine().getTipoResultadoMetodoGet(classe, nome);
	}

	/**
	 * Retorna true se o método solicitado existir.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do método.
	 * @param parametro
	 *            Parâmetro(s) do método.
	 * @return true se o método solicitado existir.
	 */
	public static boolean isExisteMetodo(Class<?> classe, String nome,
			Class<?>... parametro) {

		return getMetodoEngine().isExisteMetodo(classe, nome, parametro);
	}

	/**
	 * Retorna true se o método GET solicitado existir.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do método.
	 * @return true se o método solicitado existir.
	 */
	public static boolean isExisteMetodoGet(Class<?> classe, String nome) {
		return getMetodoEngine().isExisteMetodoGet(classe, nome);
	}

	/**
	 * Retorna true se o método SET solicitado existir.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do método.
	 * @param parametro
	 *            Parâmetro(s) do método.
	 * @return true se o método solicitado existir.
	 */
	public static boolean isExisteMetodoSet(Class<?> classe, String nome,
			Class<?> parametro) {
		return getMetodoEngine().isExisteMetodoSet(classe, nome, parametro);
	}

	/**
	 * @return metodoEngine
	 */
	private static MetodoEngine getMetodoEngine() {
		if (!isReferencia(metodoEngine)) {
			metodoEngine = new MetodoEngine();
		}
		return metodoEngine;
	}
}
