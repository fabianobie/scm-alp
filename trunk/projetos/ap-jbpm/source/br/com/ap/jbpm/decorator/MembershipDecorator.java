/**
 * MembershipDecorator.java
 *
 * Data: 18/12/2009
 */
package br.com.ap.jbpm.decorator;

import org.jbpm.pvm.internal.identity.impl.GroupImpl;
import org.jbpm.pvm.internal.identity.impl.MembershipImpl;
import org.jbpm.pvm.internal.identity.impl.UserImpl;

/**
 * Decorator da entidade Group.
 * 
 * @author adriano.pamplona
 */
public class MembershipDecorator extends JbpmDecoratorAbstrato {
	private MembershipImpl	membershipImpl;
	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.MembershipImpl#getGroup()
	 */
	public GroupImpl getGroup() {
		if (!isReferencia(getMembershipImpl().getGroup())) {
			GroupImpl group = getEntidadeFactory().novoGroup();
			getMembershipImpl().setGroup(group);
		}
		return (GroupImpl) getMembershipImpl().getGroup();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.MembershipImpl#getRole()
	 */
	public String getRole() {
		return getMembershipImpl().getRole();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.MembershipImpl#getUser()
	 */
	public UserImpl getUser() {
		if (!isReferencia(getMembershipImpl().getUser())) {
			UserImpl user = getEntidadeFactory().novoUser();
			getMembershipImpl().setUser(user);
		}
		return (UserImpl) getMembershipImpl().getUser();
	}

	/**
	 * @param group
	 * @see org.jbpm.pvm.internal.identity.impl.MembershipImpl#setGroup(org.jbpm.api.identity.Group)
	 */
	public void setGroup(GroupImpl group) {
		getMembershipImpl().setGroup(group);
	}

	/**
	 * @param role
	 * @see org.jbpm.pvm.internal.identity.impl.MembershipImpl#setRole(java.lang.String)
	 */
	public void setRole(String role) {
		getMembershipImpl().setRole(role);
	}

	/**
	 * @param user
	 * @see org.jbpm.pvm.internal.identity.impl.MembershipImpl#setUser(org.jbpm.api.identity.User)
	 */
	public void setUser(UserImpl user) {
		getMembershipImpl().setUser(user);
	}

	/**
	 * @return retorna membershipImpl.
	 */
	public MembershipImpl getMembershipImpl() {
		if (!isReferencia(membershipImpl)) {
			membershipImpl = getEntidadeFactory().novoMembership();
		}
		return membershipImpl;
	}

	/**
	 * @param membershipImpl Atribui membershipImpl.
	 */
	public void setMembershipImpl(MembershipImpl membershipImpl) {
		this.membershipImpl = membershipImpl;
	}

	/**
	 * @return groupName
	 */
	public String getGroupName() {
		return getGroup().getName();
	}

	/**
	 * @param groupName Atribui groupName
	 */
	public void setGroupName(String groupName) {
		getGroup().setName(groupName);
	}

	/**
	 * @return userGivenName
	 */
	public String getUserGivenName() {
		return getUser().getGivenName();
	}

	/**
	 * @param userGivenName Atribui userGivenName
	 */
	public void setUserGivenName(String userGivenName) {
		getUser().setGivenName(userGivenName);
	}
}
