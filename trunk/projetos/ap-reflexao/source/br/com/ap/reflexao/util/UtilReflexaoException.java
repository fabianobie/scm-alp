/*
 * UtilReflexaoException.java
 * 
 * Data de criação: 23/02/2007
 * 
 *
 *
 */
package br.com.ap.reflexao.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.ap.reflexao.constante.Mensagem;
import br.com.ap.reflexao.excecao.ReflexaoException;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.comum.excecao.UtilRuntimeExcecaoAbstrato;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe responsável em centralizar o tratamento das mensagens de exceção.
 * 
 * @author AdrianoP
 */
public final class UtilReflexaoException extends UtilRuntimeExcecaoAbstrato {

	/**
	 * Construtor.
	 */
	private UtilReflexaoException() {
		// Construtor.
	}

	/**
	 * @param classe
	 *            nome da classe.
	 * @param e
	 *            Exceção.
	 * @return ReflexaoException
	 */
	public static ReflexaoException classeNaoInstanciada(Class<?> classe,
			Exception e) {
		String chave = Mensagem.getClasseNaoInstanciada();
		String msg = getMensagem(e);
		String nome = classe.getName();

		return converter(novaExcecao(e, chave, nome, msg));
	}

	/**
	 * @param objeto
	 *            Objeto.
	 * @param nomeDoMetodo
	 *            nome do método.
	 * @return ReflexaoException
	 */
	public static ReflexaoException metodoNaoEncontrado(Object objeto,
			String nomeDoMetodo) {
		String chave = Mensagem.getMetodoNaoEncontrado();
		String nome = UtilObjeto.getNome(objeto);

		return converter(novaExcecao(chave, nome, nomeDoMetodo));
	}

	/**
	 * @param metodo
	 *            Método invocado.
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	public static ReflexaoException acessoNegadoAoMetodo(String metodo,
			IllegalAccessException e) {
		String chave = Mensagem.getAcessoNegadoAoMetodo();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, metodo, erro));
	}

	/**
	 * @param metodo
	 *            Método invocado.
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	public static ReflexaoException erroAoInvocarMetodo(Method metodo,
			InvocationTargetException e) {
		String chave = Mensagem.getErroAoInvocarMetodo();
		String nomeDoMetodo = metodo.getName();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, nomeDoMetodo, erro));
	}

	/**
	 * @param metodo
	 *            Método invocado.
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	public static ReflexaoException erroAoInvocarMetodo(String metodo,
			InvocationTargetException e) {
		String chave = Mensagem.getErroAoInvocarMetodo();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, metodo, erro));
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
	public static ReflexaoException indiceNaoEncontradoNaColecao(Object objeto,
			String propriedade, int indice) {
		String chave = Mensagem.getIndiceNaoEncontradoNaColecao();
		String indiceStr = String.valueOf(indice);
		String obj = UtilObjeto.getNome(objeto);

		return converter(novaExcecao(chave, indiceStr, obj, propriedade));
	}

	/**
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	public static ReflexaoException naoFoiPossivelClonarObjeto(Exception e) {
		String chave = Mensagem.getNaoFoiPossivelClonarObjeto();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e
	 *            Exceção
	 * @return ReflexaoException
	 */
	public static ReflexaoException erro(Throwable e) {
		ReflexaoException excecao = null;
		if (e instanceof ReflexaoException) {
			excecao = (ReflexaoException) e;
		} else {
			String chave = Mensagem.getErro();
			String erro = getMensagem(e);

			excecao = converter(novaExcecao(e, chave, erro));
		}

		return excecao;
	}

	/**
	 * Converte uma ExceptionAbstrato em um ReflectionException.
	 * 
	 * @param e
	 *            ExceptionAbstrato
	 * @return nova ReflectionException
	 */
	private static ReflexaoException converter(RuntimeExceptionAbstrato e) {
		ReflexaoException excecao = new ReflexaoException(e);
		getLog().error("Ocorreu um erro.", excecao);
		return excecao;
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	private static LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
