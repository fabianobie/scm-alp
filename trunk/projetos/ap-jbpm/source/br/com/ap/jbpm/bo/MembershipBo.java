/**
 * MembershipBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.io.Serializable;

import javax.annotation.Resource;

import org.jbpm.pvm.internal.identity.impl.MembershipImpl;
import org.springframework.stereotype.Component;

import br.com.ap.arquitetura.util.CRUD;
import br.com.ap.jbpm.dao.MembershipDao;
import br.com.ap.jbpm.decorator.MembershipDecorator;

/**
 * BO responsável pelas regras de negócio dos membership.
 * 
 * @author adriano.pamplona
 */
@Component
public class MembershipBo extends JBPMBoAbstrato<MembershipImpl> {

	@Resource(name = "membershipDaoImpl")
	private MembershipDao	membershipDao;

	/**
	 * @param <R> Serializable
	 * @param decorator MembershipDecorator
	 * @return Serializable
	 * @see CRUD#incluir(Object)
	 */
	public <R extends Serializable> R incluir(MembershipDecorator decorator) {
		R resultado = null;

		if (isMembershipTemReferencia(decorator)) {
			MembershipImpl membership = decorator.getMembershipImpl();
			super.incluir(membership);
		}
		return resultado;
	}

	/**
	 * @param decorator MembershipDecorator
	 * @see CRUD#excluir(Object)
	 */
	public void excluir(MembershipDecorator decorator) {
		if (isMembershipTemReferencia(decorator)) {
			MembershipImpl membership = decorator.getMembershipImpl();
			super.excluir(membership);
		}
	}

	@Override
	protected MembershipDao getCrudDao() {
		return membershipDao;
	}
}
