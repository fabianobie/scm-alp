/**
 * MembershipDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.io.Serializable;

import javax.annotation.Resource;

import org.jbpm.api.IdentityService;
import org.jbpm.pvm.internal.identity.impl.MembershipImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.MembershipDao;

/**
 * DAO de acesso às informação do membership.
 * 
 * @author adriano.pamplona
 */
@Repository
public class MembershipDaoImpl extends JBPMDaoAbstrato<MembershipImpl>
		implements MembershipDao {

	@Resource
	private IdentityService	identityService;

	@SuppressWarnings("unchecked")
	@Override
	public <R extends Serializable> R incluir(MembershipImpl entidade) {
		String resultado = null;

		String userId = entidade.getUser().getId();
		String groupId = entidade.getGroup().getId();
		String role = entidade.getRole();

		if (!isVazio(role)) {
			identityService.createMembership(userId, groupId, role);
		} else {
			identityService.createMembership(userId, groupId);
		}
		return (R) resultado;
	}

	@Override
	public void excluir(MembershipImpl entidade) {
		String userId = entidade.getUser().getId();
		String groupId = entidade.getGroup().getId();
		String role = entidade.getRole();
		identityService.deleteMembership(userId, groupId, role);
	}

	@Override
	public MembershipImpl obter(Serializable pk) {
		String chave = UtilString.getString(pk);
		return super.obter(chave);
	}
}
