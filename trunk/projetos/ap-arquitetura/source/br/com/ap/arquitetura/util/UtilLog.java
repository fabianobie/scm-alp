/*
 * UtilLog.java
 * 
 * Data de cria��o: 26/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.util;

import br.com.ap.arquitetura.constante.Constante;
import br.com.ap.comum.log.LogAbstrato;

/**
 * Classe utilit�ria respons�vel pelo log do sistema.
 * 
 * @author adrianop
 */
public final class UtilLog extends LogAbstrato {

	private static UtilLog log = new UtilLog();

	/**
	 * Construtor.
	 */
	private UtilLog() {
		// Construtor.
	}

	/**
	 * Retorna inst�ncia �nica do log. Padr�o singleton
	 * 
	 * @return inst�ncia do log.
	 */
	public static UtilLog getLog() {
		return log;
	}

	/**
	 * @see br.com.ap.comum.log.LogAbstrato#getNomeDoLogger()
	 */
	protected String getNomeDoLogger() {
		return Constante.getAppenderDoLog();
	}

}
