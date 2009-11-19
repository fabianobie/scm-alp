/*
 * Constante.java
 * 
 * Data de criação: 26/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.constante;

/**
 * Classe de constantes.
 * 
 * @author adrianop
 */
public final class Constante {

	/**
	 * Construtor.
	 */
	private Constante() {
		// Construtor.
	}
	
	/**
	 * Retorna Appender do log.
	 * 
	 * @return Appender do log
	 */
	public static String getAppenderDoLog() {
		return "br.com.ap.arquitetura";
	}
	
	/**
	 * Retorna a quantidade de registros por página.
	 * 
	 * @return quantidade de registros.
	 */
	public static int getQuantidadeDeRegistrosPorPagina() {
		return 10;
	}
}
