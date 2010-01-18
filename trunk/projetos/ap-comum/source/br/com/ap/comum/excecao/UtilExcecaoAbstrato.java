/*
 * UtilExcecaoAbstrato.java
 * 
 * Data de criação: 24/04/2007
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
public abstract class UtilExcecaoAbstrato {

	/**
	 * Construtor
	 */
	protected UtilExcecaoAbstrato() {
		// Construtor.
	}

	/**
	 * Retorna ExceptionAbstrato.
	 * 
	 * @return ExceptionAbstrato
	 */
	protected static ExceptionAbstrato novaExcecao() {
		return new ExceptionAbstrato() {

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
	 * @return ExceptionAbstrato
	 */
	protected static ExceptionAbstrato novaExcecao(String key) {
		ExceptionAbstrato e = novaExcecao();
		e.setKey(key);
		return e;
	}

	/**
	 * Cria uma exceção da aplicação.
	 * 
	 * @param key chave da mensagem de exceção.
	 * @param args argumentos da mensagem.
	 * @return ExceptionAbstrato
	 */
	protected static ExceptionAbstrato novaExcecao(String key, String... args) {
		ExceptionAbstrato e = novaExcecao(key);
		e.setArgs(args);

		return e;
	}

	/**
	 * Retorna ExceptionAbstrato.
	 * 
	 * @param excecao Exceção causadora.
	 * @return ExceptionAbstrato
	 */
	protected static ExceptionAbstrato novaExcecao(Throwable excecao) {
		return new ExceptionAbstrato(excecao) {

			@Override
			public String getMessage() {
				return null;
			}
		};
	}

	/**
	 * Cria uma exceção da aplicação.
	 * 
	 * @param excecao Exceção causadora.
	 * @param key chave da mensagem de exceção.
	 * @return ExceptionAbstrato
	 */
	protected static ExceptionAbstrato novaExcecao(Throwable excecao,
			String key) {
		ExceptionAbstrato e = novaExcecao(excecao);
		e.setKey(key);

		return e;
	}

	/**
	 * Cria uma exceção da aplicação.
	 * 
	 * @param excecao Throwable Exceção causadora.
	 * @param key chave da mensagem de exceção.
	 * @param args argumentos da mensagem.
	 * @return ExceptionAbstrato
	 */
	protected static ExceptionAbstrato novaExcecao(Throwable excecao,
			String key, String... args) {
		ExceptionAbstrato e = novaExcecao(excecao, key);
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
