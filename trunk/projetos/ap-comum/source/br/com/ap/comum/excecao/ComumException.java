/*
 * ComumException.java
 * 
 * Data de criação: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.excecao;

import br.com.ap.comum.constante.Mensagem;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.util.UtilMensagem;

/**
 * Classe que representa uma exceção lançada pela api.
 * 
 * @author AdrianoP
 */
public class ComumException extends RuntimeExceptionAbstrato {

	/**
	 * Construtor.
	 */
	public ComumException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exceção
	 */
	public ComumException(ExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exceção
	 */
	public ComumException(RuntimeExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 */
	public ComumException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 * @param args argumentos
	 */
	public ComumException(String key, String... args) {
		super(key, args);
	}

	/**
	 * @see br.com.ap.comum.excecao.RuntimeExceptionAbstrato#getKey()
	 */
	@Override
	public String getKey() {
		if (UtilString.isVazio(super.getKey())) {
			super.setKey(Mensagem.getErro());
		}
		return super.getKey();
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return getUtilMensagem().getMensagem(getKey(), getArgs());
	}

	/**
	 * Retorna utilMensagem.
	 * 
	 * @return UtilMensagem
	 * @see UtilMensagem
	 */
	private static UtilMensagem getUtilMensagem() {
		return UtilMensagem.getInstancia();
	}
}
