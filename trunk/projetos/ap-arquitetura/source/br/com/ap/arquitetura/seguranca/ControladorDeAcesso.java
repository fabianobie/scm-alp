/*
 * ControladorDeAcesso.java
 * 
 * Data de cria��o: 24/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.seguranca;

import java.io.Serializable;

import br.com.ap.arquitetura.util.UtilLog;
import br.com.ap.arquitetura.util.excecao.UtilArquiteturaException;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Controlador de acesso do sistema, representa a interface para a solicita��o
 * de recursos do sistema.<br>
 * Possui um atributo java.lang.ThreadLocal que armazena o UserProfile da
 * aplica��o, o user profile � atribuido quando o usu�rio loga no sistema.
 * 
 * @author adrianop
 */
public abstract class ControladorDeAcesso implements Serializable {

	// classe que armazena o UserProfile.
	private static ThreadLocal<Profile> threadLocal = new ThreadLocal<Profile>();

	/**
	 * Atribui o Profile no threadLocal.
	 * 
	 * @param profile
	 */
	public void setProfile(Profile profile) {
		getThreadLocal().set(profile);
	}

	/**
	 * @return true se o profile existir.
	 */
	public boolean isExisteProfile() {
		boolean existe = false;

		try {
			Profile profile = (Profile) getThreadLocal().get();
			existe = (UtilObjeto.isReferencia(profile));
		} catch (Exception e) {
			getLog().warn(e);
		}
		return existe;
	}

	/**
	 * Retorna o Profile da thread.
	 * 
	 * @return UserProfile
	 */
	protected Profile getProfile() {
		Profile profile = (Profile) getThreadLocal().get();

		if (!UtilObjeto.isReferencia(profile)) {
			throw UtilArquiteturaException.profileInexistente();
		}

		return profile;
	}

	/**
	 * Retorna log.
	 * 
	 * @return log
	 */
	protected LogAbstrato getLog() {
		return UtilLog.getLog();
	}

	/**
	 * @return ThreadLocal
	 */
	private ThreadLocal<Profile> getThreadLocal() {
		return threadLocal;
	}

	/**
	 * UserProfile da aplica��o, armazena todas as informa��es refer�ntes ao
	 * usu�rio logado.
	 * 
	 * @author adrianop
	 */
	public abstract class Profile implements Serializable {
		// classe
	}
}
