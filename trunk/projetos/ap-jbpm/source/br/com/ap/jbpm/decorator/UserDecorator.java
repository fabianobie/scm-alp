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
		return getUser().getGivenName();
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
