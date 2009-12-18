/**
 * GroupDecorator.java
 *
 * Data: 18/12/2009
 */
package br.com.ap.jbpm.decorator;

import org.jbpm.pvm.internal.identity.impl.GroupImpl;

/**
 * Decorator da entidade Group.
 * 
 * @author adriano.pamplona
 */
public class GroupDecorator extends JbpmDecoratorAbstrato {
	private GroupImpl	groupImpl;

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.GroupImpl#getId()
	 */
	public String getId() {
		return getGroupImpl().getId();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.GroupImpl#getName()
	 */
	public String getName() {
		return getGroupImpl().getName();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.GroupImpl#getParent()
	 */
	public GroupImpl getParent() {
		return getGroupImpl().getParent();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.identity.impl.GroupImpl#getType()
	 */
	public String getType() {
		return getGroupImpl().getType();
	}

	/**
	 * @param id
	 * @see org.jbpm.pvm.internal.identity.impl.GroupImpl#setId(java.lang.String)
	 */
	public void setId(String id) {
		getGroupImpl().setId(id);
	}

	/**
	 * @param name
	 * @see org.jbpm.pvm.internal.identity.impl.GroupImpl#setName(java.lang.String)
	 */
	public void setName(String name) {
		getGroupImpl().setName(name);
	}

	/**
	 * @param parent
	 * @see org.jbpm.pvm.internal.identity.impl.GroupImpl#setParent(org.jbpm.pvm.internal.identity.impl.GroupImpl)
	 */
	public void setParent(GroupImpl parent) {
		getGroupImpl().setParent(parent);
	}

	/**
	 * @param type
	 * @see org.jbpm.pvm.internal.identity.impl.GroupImpl#setType(java.lang.String)
	 */
	public void setType(String type) {
		getGroupImpl().setType(type);
	}

	/**
	 * @return retorna group.
	 */
	public GroupImpl getGroupImpl() {
		if (!isReferencia(groupImpl)) {
			groupImpl = getEntidadeFactory().novoGroup();
		}
		return groupImpl;
	}

	/**
	 * @param group Atribui group.
	 */
	public void setGroupImpl(GroupImpl groupImpl) {
		this.groupImpl = groupImpl;
	}
}
