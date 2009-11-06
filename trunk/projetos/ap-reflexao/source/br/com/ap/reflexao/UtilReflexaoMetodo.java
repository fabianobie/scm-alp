/*
 * UtilReflexaoPropriedade.java
 * 
 * Data de cria��o: Jul 9, 2008
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
 * Classe respons�vel pela manipula��o dos m�todos de uma classe.
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
	 * Retorna o m�todo acess�vel solicitado, se o m�todo n�o for encontrado
	 * ser� retornado null.
	 * 
	 * @param classe
	 *            Classe
	 * @param nome
	 *            Nome do m�todo
	 * @param parametros
	 *            Par�metros do m�todo.
	 * @return m�todo solicitado
	 */
	public static Method get(Class<?> classe, String nome,
			Class<?>... parametros) {
		return getMetodoEngine().get(classe, nome, parametros);
	}

	/**
	 * Invoca o m�todo solicitado.
	 * 
	 * @param <T>
	 *            Tipo do resultado do m�todo executado.
	 * @param objeto
	 *            Objeto que sofrer� a chamada do m�todo.
	 * @param nome
	 *            Nome do m�todo.
	 * @param args
	 *            Par�metros do m�todo.
	 * @return Resultado da chamada do m�todo.
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
	 * Retorna o m�todo GET solicitado.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do m�todo.
	 * @return m�todo GET solicitado.
	 */
	public static Method getMetodoGet(Class<?> classe, String nome) {

		return getMetodoEngine().getMetodoGet(classe, nome);
	}

	/**
	 * Retorna o m�todo SET solicitado.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do m�todo.
	 * @param parametro
	 *            Par�metro do m�todo.
	 * @return m�todo GET solicitado.
	 */
	public static Method getMetodoSet(Class<?> classe, String nome,
			Class<?> parametro) {

		return getMetodoEngine().getMetodoSet(classe, nome, parametro);
	}

	/**
	 * Retorna o tipo de retorno do m�todo GET solicitado.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do m�todo.
	 * @return tipo de retorno do m�todo GET solicitado.
	 */
	public static Class<?> getTipoResultadoMetodoGet(Class<?> classe,
			String nome) {

		return getMetodoEngine().getTipoResultadoMetodoGet(classe, nome);
	}

	/**
	 * Retorna true se o m�todo solicitado existir.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do m�todo.
	 * @param parametro
	 *            Par�metro(s) do m�todo.
	 * @return true se o m�todo solicitado existir.
	 */
	public static boolean isExisteMetodo(Class<?> classe, String nome,
			Class<?>... parametro) {

		return getMetodoEngine().isExisteMetodo(classe, nome, parametro);
	}

	/**
	 * Retorna true se o m�todo GET solicitado existir.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do m�todo.
	 * @return true se o m�todo solicitado existir.
	 */
	public static boolean isExisteMetodoGet(Class<?> classe, String nome) {
		return getMetodoEngine().isExisteMetodoGet(classe, nome);
	}

	/**
	 * Retorna true se o m�todo SET solicitado existir.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do m�todo.
	 * @param parametro
	 *            Par�metro(s) do m�todo.
	 * @return true se o m�todo solicitado existir.
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
