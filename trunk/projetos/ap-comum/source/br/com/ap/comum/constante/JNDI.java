/*
 * JNDI.java
 * 
 * Data de criação: 30/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.constante;

/**
 * Constantes de endereços JNDI.
 * 
 * @author AdrianoP
 */
public final class JNDI {

	/**
	 * Construtor.
	 */
	private JNDI() {
		// Construtor.
	}

	/**
	 * Retorna o prefixo do contexto java.
	 * 
	 * @return 'java:'
	 */
	public static String getPrefixoContextoJava() {
		return "java:";
	}

	/**
	 * Retorna o contexto env.
	 * 
	 * @return java:comp/env
	 */
	public static String getContextoEnv() {
		return "java:comp/env";
	}
}
