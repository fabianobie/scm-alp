/*
 * UtilRuntimeExcecaoAbstrato.java
 * 
 * Data de criação: 27/07/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe utilitária para montagem das exceções.
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
	 * Cria uma exceção da aplicação.
	 * 
	 * @param key chave da mensagem de exceção.
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao(String key) {
		RuntimeExceptionAbstrato e = novaExcecao();
		e.setKey(key);
		return e;
	}

	/**
	 * Cria uma exceção da aplicação.
	 * 
	 * @param key chave da mensagem de exceção.
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
	 * @param excecao Exceção causadora.
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao(Throwable excecao) {
		RuntimeExceptionAbstrato e = novaExcecao();
		e.initCause(excecao);

		return e;
	}

	/**
	 * Cria uma exceção da aplicação.
	 * 
	 * @param excecao Exceção causadora.
	 * @param key chave da mensagem de exceção.
	 * @return RuntimeExceptionAbstrato
	 */
	protected static RuntimeExceptionAbstrato novaExcecao(Throwable excecao,
			String key) {
		RuntimeExceptionAbstrato e = novaExcecao(excecao);
		e.setKey(key);

		return e;
	}

	/**
	 * Cria uma exceção da aplicação.
	 * 
	 * @param excecao Throwable Exceção causadora.
	 * @param key chave da mensagem de exceção.
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
	 * Recupera a mensagem de uma exceção.
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
	 * Retorna true se o objeto tiver uma referência.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto tiver uma referência.
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
