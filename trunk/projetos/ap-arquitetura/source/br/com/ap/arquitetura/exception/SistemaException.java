/*
 * NegocioException.java
 * 
 * Data de cria��o: 16/09/2008
 *
 * 
 * 
 */
package br.com.ap.arquitetura.exception;

import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;

/**
 * Exce��es de neg�cio.
 * 
 * @author adrianop
 */
public class SistemaException extends RuntimeExceptionAbstrato {
	
	/**
	 * Construtor.
	 */
	public SistemaException() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param mensagem Mensagem
	 */
	public SistemaException(String mensagem) {
		super(mensagem);
	}
}
