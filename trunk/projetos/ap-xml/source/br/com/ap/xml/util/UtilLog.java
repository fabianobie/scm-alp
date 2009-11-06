/*
 * UtilLog.java
 * 
 * Data de cria��o: 27/04/2007
 *
 * 
 *
 */
package br.com.ap.xml.util;

import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.xml.constante.Constante;

/**
 * Classe respons�vel pela gera��o do log da api.
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
	return Constante.getNomeDoLogger();
    }

}
