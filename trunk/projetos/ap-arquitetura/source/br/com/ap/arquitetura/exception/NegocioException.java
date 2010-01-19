/*
 * NegocioException.java
 * 
 * Data de criação: 16/09/2008
 *
 * 
 * 
 */
package br.com.ap.arquitetura.exception;

import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;

/**
 * Exceções de negócio.
 * 
 * @author adrianop
 */
public class NegocioException extends RuntimeExceptionAbstrato {
	
	/**
	 * Construtor.
	 */
	public NegocioException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param mensagem Mensagem
	 */
	public NegocioException(String mensagem) {
		super(mensagem);
	}
}
