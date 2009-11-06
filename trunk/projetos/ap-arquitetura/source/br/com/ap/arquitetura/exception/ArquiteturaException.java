/*
 * InfraException.java
 * 
 * Data de criação: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.exception;

import br.com.ap.arquitetura.util.UtilMensagem;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;

/**
 * Classe que representa uma exceção lançada pela infra estrutura.
 * 
 * @author adrianop
 */
public class ArquiteturaException extends RuntimeExceptionAbstrato {

	/**
	 * Construtor.
	 */
	public ArquiteturaException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param excecao Exceção
	 */
	public ArquiteturaException(RuntimeExceptionAbstrato excecao) {
		super(excecao);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 */
	public ArquiteturaException(String key) {
		super(key);
	}

	/**
	 * Construtor.
	 * 
	 * @param key chave
	 * @param args argumentos
	 */
	public ArquiteturaException(String key, String... args) {
		super(key, args);
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return getUtilMensagem().getMensagem(getKey(), getArgs());
	}

	/**
	 * Retorna UtilMensagem.
	 * 
	 * @return UtilMensagem
	 */
	private UtilMensagem getUtilMensagem() {
		return UtilMensagem.getInstancia();
	}
}
