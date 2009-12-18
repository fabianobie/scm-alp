/**
 * MembershipDecorator.java
 *
 * Data: 18/12/2009
 */
package br.com.ap.jbpm.decorator;

import org.jbpm.api.identity.Group;
import org.jbpm.api.identity.User;
import org.jbpm.pvm.internal.identity.impl.MembershipImpl;

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
	public Group getGroup() {
		return getMembershipImpl().getGroup();
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
	public User getUser() {
		return getMembershipImpl().getUser();
	}

	/**
	 * @param group
	 * @see org.jbpm.pvm.internal.identity.impl.MembershipImpl#setGroup(org.jbpm.api.identity.Group)
	 */
	public void setGroup(Group group) {
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
	public void setUser(User user) {
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
}
