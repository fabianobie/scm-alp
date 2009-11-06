/*
 * UtilLog.java
 * 
 * Data de criação: 26/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.util;

import br.com.ap.arquitetura.constante.Constante;
import br.com.ap.comum.log.LogAbstrato;

/**
 * Classe utilitária responsável pelo log do sistema.
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
	 * Retorna instância única do log. Padrão singleton
	 * 
	 * @return instância do log.
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
