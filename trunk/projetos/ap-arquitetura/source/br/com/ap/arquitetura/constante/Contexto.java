/*
 * Contexto.java
 * 
 * Data de criação: 18/06/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.constante;


/**
 * Constantes dos contextos JNDI.
 * 
 * @author adrianop
 */
public final class Contexto {

	/**
	 * Construtor.
	 */
	private Contexto() {
		//Construtor.
	}
	
	/**
	 * Retorna o contexto das variáveis de ambiente.
	 * 
	 * @return Contexto "java:comp/env"
	 */
	public static String getContextoEnv() {
		return "java:comp/env";
	}

	/**
	 * Retorna o prefixo do contexto.
	 * 
	 * @return Contexto "java:"
	 */
	public static String getPrefixoContexto() {
		return "java:";
	}
}
