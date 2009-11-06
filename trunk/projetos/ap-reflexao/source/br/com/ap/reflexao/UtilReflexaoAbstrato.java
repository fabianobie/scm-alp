/*
 * UtilReflexaoAbstrato.java
 * 
 * Data de criação: 30/05/2007
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.lang.reflect.InvocationTargetException;

import br.com.ap.reflexao.excecao.ReflexaoException;
import br.com.ap.reflexao.util.UtilLog;
import br.com.ap.reflexao.util.UtilReflexaoException;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que provê recursos aos utilitários da reflexão.
 * 
 * @author Adrianop
 */
public abstract class UtilReflexaoAbstrato {

	/**
	 * @param strings
	 *            Strings que serão verificadas.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazioTodos(String[])
	 */
	protected static boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * @param objetos
	 *            Objetos que serão validados.
	 * @return true se o objeto tiver referência.
	 * @see UtilObjeto#isReferenciaTodos(Object[])
	 */
	protected static boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	protected static LogAbstrato getLog() {
		return UtilLog.getLog();
	}

	/**
	 * @param mensagem
	 *            Mensagem
	 * @see LogAbstrato#debug(Object)
	 */
	protected static void debug(String mensagem) {
		getLog().debug(mensagem);
	}

	/**
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	protected static ReflexaoException naoFoiPossivelClonarObjeto(Exception e) {
		return UtilReflexaoException.naoFoiPossivelClonarObjeto(e);
	}

	/**
	 * @param pathMetodos
	 *            Método invocado.
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	protected static ReflexaoException acessoNegadoAoMetodo(String pathMetodos,
			IllegalAccessException e) {
		return UtilReflexaoException.acessoNegadoAoMetodo(pathMetodos, e);
	}

	/**
	 * @param classe
	 *            nome da classe.
	 * @param e
	 *            Exceção.
	 * @return ReflexaoException
	 */
	protected static ReflexaoException classeNaoInstanciada(Class<?> classe,
			Exception e) {
		return UtilReflexaoException.classeNaoInstanciada(classe, e);
	}

	/**
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	protected static ReflexaoException erro(Throwable e) {
		return UtilReflexaoException.erro(e);
	}

	/**
	 * @param pathMetodos
	 *            Método invocado.
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	protected static ReflexaoException erroAoInvocarMetodo(String pathMetodos,
			InvocationTargetException e) {
		return UtilReflexaoException.erroAoInvocarMetodo(pathMetodos, e);
	}

	/**
	 * @param objeto
	 *            Objeto.
	 * @param nomeDoMetodo
	 *            nome do método.
	 * @return ReflexaoException
	 */
	protected static ReflexaoException metodoNaoEncontrado(Object objeto,
			String nomeDoMetodo) {
		return UtilReflexaoException.metodoNaoEncontrado(objeto, nomeDoMetodo);
	}

	/**
	 * @param objeto
	 *            Objeto
	 * @param propriedade
	 *            propriedade
	 * @param indice
	 *            Índice da coleção
	 * @return ReflexaoException
	 */
	protected static ReflexaoException indiceNaoEncontradoNaColecao(
			Object objeto, String propriedade, int indice) {
		return UtilReflexaoException.indiceNaoEncontradoNaColecao(objeto,
				propriedade, indice);
	}
}
