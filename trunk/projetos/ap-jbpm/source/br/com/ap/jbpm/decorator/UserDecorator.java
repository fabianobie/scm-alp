/**
 * UserDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import org.jbpm.pvm.internal.identity.impl.UserImpl;

/**
 * Decorator da entidade User.
 * 
 * @author adriano.pamplona
 * 
 */
public class UserDecorator extends JbpmDecoratorAbstrato {
	private UserImpl	userImpl;

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#getBusinessEmail()
	 */
	public String getBusinessEmail() {
		return getUserImpl().getBusinessEmail();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#getFamilyName()
	 */
	public String getFamilyName() {
		return getUserImpl().getFamilyName();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#getGivenName()
	 */
	public String getGivenName() {
		return getUserImpl().getGivenName();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#getId()
	 */
	public String getId() {
		return getUserImpl().getId();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#getPassword()
	 */
	public String getPassword() {
		return getUserImpl().getPassword();
	}

	/**
	 * @param emailAddress
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#setBusinessEmail(java.lang.String)
	 */
	public void setBusinessEmail(String emailAddress) {
		getUserImpl().setBusinessEmail(emailAddress);
	}

	/**
	 * @param familyName
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#setFamilyName(java.lang.String)
	 */
	public void setFamilyName(String familyName) {
		getUserImpl().setFamilyName(familyName);
	}

	/**
	 * @param givenName
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#setGivenName(java.lang.String)
	 */
	public void setGivenName(String givenName) {
		getUserImpl().setGivenName(givenName);
	}

	/**
	 * @param id
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#setId(java.lang.String)
	 */
	public void setId(String id) {
		getUserImpl().setId(id);
	}

	/**
	 * @param password
	 * @see org.jbpm.pvm.internal.identity.impl.UserImpl#setPassword(java.lang.String)
	 */
	public void setPassword(String password) {
		getUserImpl().setPassword(password);
	}

	/**
	 * @return retorna user.
	 */
	public UserImpl getUserImpl() {
		if (!isReferencia(userImpl)) {
			userImpl = getEntidadeFactory().novoUser();
		}
		return userImpl;
	}

	/**
	 * @param user Atribui user.
	 */
	public void setUserImpl(UserImpl userImpl) {
		this.userImpl = userImpl;
	}
}
