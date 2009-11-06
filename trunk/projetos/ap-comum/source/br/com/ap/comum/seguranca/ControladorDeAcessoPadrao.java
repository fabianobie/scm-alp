/*
 * ControladorDeAcessoThreadLocal.java
 * 
 * Data de criação: 25/06/2008
 *
 * 
 * 
 */
package br.com.ap.comum.seguranca;

/**
 * Implementação do controlador de acesso que mantêm o profile do usuário logado
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
	 * UserProfile da aplicação, armazena todas as informações referêntes ao
	 * usuário logado.
	 * 
	 * @author adrianop
	 */
	public class ProfilePadrao extends ProfileAbstrato {
		// classe
	}
}
