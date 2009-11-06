/*
 * UtilRuntimeExcecaoAbstrato.java
 * 
 * Data de cria��o: 27/07/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe utilit�ria para montagem das exce��es.
 * 
 * @author adrianop
 */
public class UtilRuntimeExcecaoAbstrato {

	/**
	 * Construtor
	 */
	protected UtilRuntimeExcecaoAbstrato() {
		// Construtor.
	}

	/**
	 * Retorna ExceptionAbstrato.
	 * 
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao() {
		return new RuntimeExceptionAbstrato() {

			@Override
			public String getMessage() {
				return null;
			}
		};
	}

	/**
	 * Cria uma exce��o da aplica��o.
	 * 
	 * @param key chave da mensagem de exce��o.
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao(String key) {
		RuntimeExceptionAbstrato e = novaExcecao();
		e.setKey(key);
		return e;
	}

	/**
	 * Cria uma exce��o da aplica��o.
	 * 
	 * @param key chave da mensagem de exce��o.
	 * @param args argumentos da mensagem.
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao(String key,
			String... args) {
		RuntimeExceptionAbstrato e = novaExcecao(key);
		e.setArgs(args);

		return e;
	}

	/**
	 * Retorna RuntimeExceptionAbstrato.
	 * 
	 * @param excecao Exce��o causadora.
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao(Throwable excecao) {
		RuntimeExceptionAbstrato e = novaExcecao();
		e.initCause(excecao);

		return e;
	}

	/**
	 * Cria uma exce��o da aplica��o.
	 * 
	 * @param excecao Exce��o causadora.
	 * @param key chave da mensagem de exce��o.
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao(Throwable excecao,
			String key) {
		RuntimeExceptionAbstrato e = novaExcecao(excecao);
		e.setKey(key);

		return e;
	}

	/**
	 * Cria uma exce��o da aplica��o.
	 * 
	 * @param excecao Throwable Exce��o causadora.
	 * @param key chave da mensagem de exce��o.
	 * @param args argumentos da mensagem.
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao(Throwable excecao,
			String key, String... args) {
		RuntimeExceptionAbstrato e = novaExcecao(excecao, key);
		e.setArgs(args);

		return e;
	}

	/**
	 * Recupera a mensagem de uma exce��o.
	 * 
	 * @param e Throwable
	 * @return String da mensagem.
	 */
	protected static String getMensagem(Throwable e) {
		return UtilExcecao.getMensagem(e);
	}

	/**
	 * Retorna uma String do valor do objeto.
	 * 
	 * @param objeto Objeto
	 * @return String do valor do objeto.
	 */
	protected static String getString(Object objeto) {
		return UtilString.getString(objeto);
	}

	/**
	 * Retorna true se o objeto tiver uma refer�ncia.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto tiver uma refer�ncia.
	 */
	protected static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se a string for vazia.
	 * 
	 * @param string String validada.
	 * @return true se a string for vazia.
	 */
	protected static boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

}
