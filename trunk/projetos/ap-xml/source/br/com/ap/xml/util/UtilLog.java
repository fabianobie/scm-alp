/*
 * UtilLog.java
 * 
 * Data de criação: 27/04/2007
 *
 * 
 *
 */
package br.com.ap.xml.util;

import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.xml.constante.Constante;

/**
 * Classe responsável pela geração do log da api.
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
	return Constante.getNomeDoLogger();
    }

}
