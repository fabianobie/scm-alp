/**
 * UserDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import org.jbpm.api.identity.User;

/**
 * @author adriano.pamplona
 *
 */
public class UserDecorator extends JbpmDecoratorAbstrato {
	private User user;
	private String givenName;

	/**
	 * @return
	 * @see org.jbpm.api.identity.User#getBusinessEmail()
	 */
	public String getBusinessEmail() {
		return getUser().getBusinessEmail();
	}

	/**
	 * @return
	 * @see org.jbpm.api.identity.User#getFamilyName()
	 */
	public String getFamilyName() {
		return getUser().getFamilyName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.identity.User#getGivenName()
	 */
	public String getGivenName() {
		String resultado = getUser().getGivenName();
		if (isVazio(resultado)) {
			resultado = givenName;
		}
		return resultado;
	}
	
	/**
	 * @param givenName Atribui givenName.
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * @return
	 * @see org.jbpm.api.identity.User#getId()
	 */
	public String getId() {
		return getUser().getId();
	}

	/**
	 * @return retorna user.
	 */
	public User getUser() {
		if (!isReferencia(user)) {
			user = getEntidadeFactory().novoUser();
		}
		return user;
	}

	/**
	 * @param user Atribui user.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	

}
