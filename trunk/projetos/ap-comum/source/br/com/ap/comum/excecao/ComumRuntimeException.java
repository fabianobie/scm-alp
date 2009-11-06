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
 * Classe que representa uma exceção de runtime lançada pela api.
 * 
 * @author AdrianoP
 */
public class ComumRuntimeException extends RuntimeExceptionAbstrato {

	/**
	 * Construtor.
	 */
	public ComumRuntimeException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exceção
	 */
	public ComumRuntimeException(RuntimeExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 */
	public ComumRuntimeException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 * @param args Parâmetros da mensagem
	 */
	public ComumRuntimeException(String key, String... args) {
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
