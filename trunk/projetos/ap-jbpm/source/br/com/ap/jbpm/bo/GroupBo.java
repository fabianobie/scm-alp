/**
 * GroupBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.pvm.internal.identity.impl.GroupImpl;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.springframework.stereotype.Component;

import br.com.ap.arquitetura.util.CRUD;
import br.com.ap.jbpm.dao.GroupDao;
import br.com.ap.jbpm.decorator.GroupDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * BO responsável pelas regras de negócio do grupo.
 * 
 * @author adriano.pamplona
 */
@Component
public class GroupBo extends JBPMBoAbstrato<GroupImpl> {

	@Resource(name = "groupDaoImpl")
	private GroupDao	groupDao;

	/**
	 * @param <R> Serializable
	 * @param decorator GroupDecorator
	 * @return Serializable
	 * @see CRUD#incluir(Object)
	 */
	public <R extends Serializable> R incluir(GroupDecorator decorator) {
		R resultado = null;

		if (isGrupoTemReferencia(decorator)) {
			GroupImpl group = decorator.getGroupImpl();
			super.incluir(group);
		}
		return resultado;
	}

	/**
	 * @param decorator GroupDecorator
	 * @see CRUD#alterar(Object)
	 */
	public void alterar(GroupDecorator decorator) {
		if (isGrupoTemReferencia(decorator)) {
			GroupImpl group = decorator.getGroupImpl();
			super.alterar(group);
			decorator.setGroupImpl(group);
		}
	}

	/**
	 * @param decorator GroupDecorator
	 * @see CRUD#excluir(Object)
	 */
	public void excluir(GroupDecorator decorator) {
		if (isGrupoTemReferencia(decorator)) {
			GroupImpl group = decorator.getGroupImpl();
			super.excluir(group);
		}
	}

	/**
	 * Retorna o grupo pelo ID.
	 * 
	 * @param decorator GroupDecorator com ID informado.
	 * @return usuário
	 */
	public GroupDecorator obterPorId(GroupDecorator decorator) {
		GroupDecorator resultado = null;

		if (isReferencia(decorator) && isReferencia(decorator.getId())) {
			GroupImpl group = super.obter(decorator.getId());
			resultado = getDecoratorFactory().novoGroupDecorator(group);
		}
		return resultado;
	}

	/**
	 * Retorna true se o grupo existir.
	 * 
	 * @param group Grupo com Id.
	 * @return true se o grupo existir.
	 */
	public boolean isGrupoExiste(GroupDecorator decorator) {
		GroupDecorator resultado = obterPorId(decorator);
		return isReferencia(resultado) && isReferencia(resultado.getId());
	}

	/**
	 * Consulta os grupos do usuário.
	 * 
	 * @param user Usuário com ID
	 * @return grupos do usuário
	 */
	public Collection<GroupImpl> consultar(UserDecorator decorator) {
		Collection<GroupImpl> resultado = null;

		if (isUsuarioTemReferencia(decorator)) {
			UserImpl user = decorator.getUserImpl();
			resultado = getCrudDao().consultar(user);
		}
		return resultado;
	}

	/**
	 * Consultar os grupos por usuário e tipo de grupo.
	 * 
	 * @param user Usuário com ID.
	 * @param group Grupo com tipo.
	 * @return grupos
	 */
	public Collection<GroupImpl> consultarPorUsuarioTipoGrupo(
			UserDecorator userDecorator, GroupDecorator groupDecorator) {
		Collection<GroupImpl> resultado = null;

		if (isUsuarioTemReferencia(userDecorator)
				&& isGrupoTemReferencia(groupDecorator)) {
			UserImpl user = userDecorator.getUserImpl();
			GroupImpl group = groupDecorator.getGroupImpl();
			resultado = getCrudDao().consultarPorUsuarioTipoGrupo(user, group);
		}
		return resultado;
	}

	@Override
	protected GroupDao getCrudDao() {
		return groupDao;
	}
}
