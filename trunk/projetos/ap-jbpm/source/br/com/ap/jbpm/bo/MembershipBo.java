/**
 * MembershipBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import javax.annotation.Resource;

import org.jbpm.api.identity.Group;
import org.jbpm.api.identity.User;
import org.jbpm.pvm.internal.identity.impl.GroupImpl;
import org.jbpm.pvm.internal.identity.impl.MembershipImpl;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.springframework.stereotype.Component;

import br.com.ap.jbpm.dao.MembershipDao;
import br.com.ap.jbpm.decorator.GroupDecorator;
import br.com.ap.jbpm.decorator.MembershipDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * BO responsável pelas regras de negócio dos membership.
 * 
 * @author adriano.pamplona
 */
@Component
public class MembershipBo extends JBPMBoAbstrato<MembershipImpl> {

	@Resource(name = "membershipDaoImpl")
	private MembershipDao	membershipDao;

	@Resource
	private GroupBo			groupBo;

	@Resource
	private UserBo			userBo;

	/**
	 * Inclui usuário no grupo.
	 * 
	 * @param <R> Serializable
	 * @param decorator MembershipDecorator
	 * @return Serializable
	 */
	public void incluir(MembershipDecorator decorator) {
		if (isMembershipTemReferencia(decorator)) {
			MembershipImpl membership = decorator.getMembershipImpl();
			membership.setGroup(carregarGroup(membership.getGroup()));
			membership.setUser(carregarUser(membership.getUser()));

			super.incluir(membership);
		}
	}

	/**
	 * Exclui usuário do grupo.
	 * 
	 * @param decorator MembershipDecorator
	 */
	public void excluir(MembershipDecorator decorator) {
		if (isMembershipTemReferencia(decorator)) {
			MembershipImpl membership = decorator.getMembershipImpl();
			super.excluir(membership);
		}
	}

	/**
	 * Retorna o usuário pelo 'givenName'.
	 * 
	 * @param user Usuário com 'givenName' informado.
	 * @return usuário
	 */
	protected User carregarUser(User user) {
		UserImpl resultado = null;

		if (isVazio(user.getId())) {
			UserImpl userImpl = (UserImpl) user;
			UserDecorator userDecorator = userBo.obterPorGivenName(userImpl);
			resultado = (isReferencia(userDecorator) ? userDecorator.getUserImpl() : null);
		}
		return resultado;
	}

	/**
	 * Retonra o grupo pelo 'id'.
	 * 
	 * @param group Grupo com 'id' informado.
	 * @return grupo
	 */
	protected Group carregarGroup(Group group) {
		GroupImpl resultado = null;

		if (isVazio(group.getId())) {
			GroupImpl groupImpl = (GroupImpl) group;
			GroupDecorator groupDecorator = groupBo.obterPorName(groupImpl);
			resultado = (isReferencia(groupDecorator) ? groupDecorator.getGroupImpl() : null);
		}
		return resultado;
	}

	@Override
	protected MembershipDao getCrudDao() {
		return membershipDao;
	}
}
