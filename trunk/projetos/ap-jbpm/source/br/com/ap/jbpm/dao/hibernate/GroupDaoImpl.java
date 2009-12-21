/**
 * GroupDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.jbpm.api.IdentityService;
import org.jbpm.api.identity.Group;
import org.jbpm.pvm.internal.identity.impl.GroupImpl;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.GroupDao;

/**
 * DAO de acesso às informação do grupo.
 * 
 * @author adriano.pamplona
 */
@Repository
public class GroupDaoImpl extends JBPMDaoAbstrato<GroupImpl> implements GroupDao {

	@Resource
	private IdentityService	identityService;

	@SuppressWarnings("unchecked")
	@Override
	public <R extends Serializable> R incluir(GroupImpl entidade) {
		String resultado = null;

		String groupName = entidade.getName();
		String groupType = entidade.getType();
		GroupImpl parent = entidade.getParent();

		if (isReferencia(parent)) {
			String parentId = parent.getId();
			resultado = identityService.createGroup(groupName, groupType, parentId);
		} else {
			resultado = identityService.createGroup(groupName, groupType);
		}
		return (R) resultado;
	}

	@Override
	public void excluir(GroupImpl entidade) {
		identityService.deleteGroup(entidade.getId());
	}

	@Override
	public GroupImpl obter(Serializable pk) {
		String chave = UtilString.getString(pk);
		return (GroupImpl) identityService.findGroupById(chave);
	}

	@Override
	public Collection<GroupImpl> consultar(UserImpl user) {

		String userId = user.getId();
		List<Group> grupos = identityService.findGroupsByUser(userId);
		return converter(grupos);
	}

	@Override
	public Collection<GroupImpl> consultarPorUsuarioTipoGrupo(UserImpl user, GroupImpl group) {

		String userId = user.getId();
		String groupType = group.getType();
		List<Group> grupos = identityService.findGroupsByUserAndGroupType(userId, groupType);
		return converter(grupos);
	}

	@Override
	public GroupImpl obterPorName(GroupImpl group) {

		Criteria criteria = novoCriteria();
		criteria.add(novoCriterioEQ("name", group.getName()));
		return (GroupImpl) criteria.uniqueResult();
	}

	/**
	 * converte uma lista de group para uma collection de groupimpl.
	 * 
	 * @param groups Lista de group
	 * @return coleção de groupimpl
	 */
	@SuppressWarnings("unchecked")
	protected Collection<GroupImpl> converter(List<Group> groups) {
		Collection<GroupImpl> resultado = getColecaoFactory().novoArrayList();
		if (isReferencia(groups)) {
			resultado.addAll((Collection<? extends GroupImpl>) groups);
		}
		return resultado;
	}

}
