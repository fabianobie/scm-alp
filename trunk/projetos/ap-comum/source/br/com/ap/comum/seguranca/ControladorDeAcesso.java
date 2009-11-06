/*
 * IControladorDeAcesso.java
 * 
 * Data de cria��o: 25/06/2008
 *
 * 
 * 
 */
package br.com.ap.comum.seguranca;

import java.io.Serializable;

/**
 * Classe respons�vel em solicitar recursos do usu�rio logado.
 * 
 * @author adrianop
 */
public interface ControladorDeAcesso extends Serializable {
	/**
	 * Atribui o Profile.
	 * 
	 * @param profile Profile
	 */
	public void setProfile(Profile profile);

	/**
	 * Retorna o Profile .
	 * 
	 * @return UserProfile
	 */
	public Profile getProfile();

	/**
	 * @return true se o profile existir.
	 */
	public boolean isExisteProfile();
}
