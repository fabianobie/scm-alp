/*
 * MetodoEngine.java
 * 
 * Data de criação: 09/07/2008
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
 * Classe responsável pela manipulação dos métodos de uma classe.
 * 
 * @author adrianop
 */
public class MetodoEngine extends EngineAbstrato {

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
	public Method get(Class<?> classe, String nome, Class<?>... parametros) {
		Method resultado = null;

		if (isReferencia(classe) && !isVazio(nome)) {
			resultado = MethodUtils.getAccessibleMethod(classe, nome,
					parametros);
		}

		return resultado;
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
	 * Retorna o método GET solicitado.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do método.
	 * @return método GET solicitado.
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
	public Method getMetodoSet(Class<?> classe, String nome, Class<?> parametro) {
		Method resultado = null;

		if (isReferencia(classe, parametro) && !isVazio(nome)) {
			nome = UtilString.getNomeMetodo(Metodo.getPrefixoSet(), nome);
			resultado = get(classe, nome, parametro);
		}
		return resultado;
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
	 * Retorna true se o método GET solicitado existir.
	 * 
	 * @param classe
	 *            Classe.
	 * @param nome
	 *            Nome do método.
	 * @return true se o método solicitado existir.
	 */
	public boolean isExisteMetodoGet(Class<?> classe, String nome) {
		return isReferencia(getMetodoGet(classe, nome));
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
	public boolean isExisteMetodoSet(Class<?> classe, String nome,
			Class<?> parametro) {
		return isReferencia(getMetodoSet(classe, nome, parametro));
	}
}
