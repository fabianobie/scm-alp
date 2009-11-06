/*
 * ControladorDeAcessoThreadLocal.java
 * 
 * Data de cria��o: 25/06/2008
 *
 * 
 * 
 */
package br.com.ap.comum.seguranca;

/**
 * Implementa��o do controlador de acesso que mant�m o profile do usu�rio logado
 * em uma thread local.
 * 
 * @author adrianop
 * @see ControladorDeAcesso
 */
public class ControladorDeAcessoPadrao extends ControladorDeAcessoAbstrato {
	private static ThreadLocal<Profile> threadLocal = new ThreadLocal<Profile>();

	/**
	 * @see br.com.ap.comum.seguranca.ControladorDeAcesso#getProfile()
	 */
	public Profile getProfile() {
		return getThreadLocal().get();
	}

	/**
	 * @see br.com.ap.comum.seguranca.ControladorDeAcesso#isExisteProfile()
	 */
	public boolean isExisteProfile() {
		return isReferencia(getProfile());
	}

	/**
	 * @see br.com.ap.comum.seguranca.ControladorDeAcesso#setProfile(br.com.ap.comum.seguranca.Profile)
	 */
	public void setProfile(Profile profile) {
		getThreadLocal().set(profile);
	}

	/**
	 * Retorna a thread local onde o profile se encontra.
	 * 
	 * @return threadLocal
	 */
	public static ThreadLocal<Profile> getThreadLocal() {
		return threadLocal;
	}

	/**
	 * UserProfile da aplica��o, armazena todas as informa��es refer�ntes ao
	 * usu�rio logado.
	 * 
	 * @author adrianop
	 */
	public class ProfilePadrao extends ProfileAbstrato {
		// classe
	}
}
