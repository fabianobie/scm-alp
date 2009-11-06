/*
 * MetodoEngine.java
 * 
 * Data de cria��o: 09/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao.engine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.MethodUtils;

import br.com.ap.comum.constante.Metodo;
import br.com.ap.comum.string.UtilString;

/**
 * Classe respons�vel pela manipula��o dos m�todos de uma classe.
 * 
 * @author adrianop
 */
public class MetodoEngine extends EngineAbstrato {

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
	public Method get(Class<?> classe, String nome, Class<?>... parametros) {
		Method resultado = null;

		if (isReferencia(classe) && !isVazio(nome)) {
			resultado = MethodUtils.getAccessibleMethod(classe, nome,
					parametros);
		}

		return resultado;
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
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings("unchecked")
	public <T> T invocar(Object objeto, String nome, Object... args)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		T resultado = null;

		if (isReferencia(objeto) && !isVazio(nome)) {
			resultado = (T) MethodUtils.invokeMethod(objeto, nome, args);
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
	public Method getMetodoGet(Class<?> classe, String nome) {
		Method resultado = null;

		if (isReferencia(classe) && !isVazio(nome)) {
			nome = UtilString.getNomeMetodo(Metodo.getPrefixoGet(), nome);
			resultado = get(classe, nome);
			if (!isReferencia(resultado)) {
				nome = UtilString.getNomeMetodo(Metodo.getPrefixoIs(), nome);
				resultado = get(classe, nome);
			}
		}
		return resultado;
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
	public Method getMetodoSet(Class<?> classe, String nome, Class<?> parametro) {
		Method resultado = null;

		if (isReferencia(classe, parametro) && !isVazio(nome)) {
			nome = UtilString.getNomeMetodo(Metodo.getPrefixoSet(), nome);
			resultado = get(classe, nome, parametro);
		}
		return resultado;
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
	public Class<?> getTipoResultadoMetodoGet(Class<?> classe, String nome) {
		Class<?> resultado = null;

		if (isReferencia(classe) && !isVazio(nome)) {
			Method metodo = getMetodoGet(classe, nome);
			if (isReferencia(metodo)) {
				resultado = metodo.getReturnType();
			}
		}
		return resultado;
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
	public boolean isExisteMetodo(Class<?> classe, String nome,
			Class<?>... parametro) {
		boolean resultado = false;

		if (isReferencia(classe) && !isVazio(nome)) {
			Method metodo = get(classe, nome, parametro);
			resultado = isReferencia(metodo);
		}
		return resultado;
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
	public boolean isExisteMetodoGet(Class<?> classe, String nome) {
		return isReferencia(getMetodoGet(classe, nome));
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
	public boolean isExisteMetodoSet(Class<?> classe, String nome,
			Class<?> parametro) {
		return isReferencia(getMetodoSet(classe, nome, parametro));
	}
}
