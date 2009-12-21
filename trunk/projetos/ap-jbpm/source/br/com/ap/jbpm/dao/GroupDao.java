/**
 * GroupDao.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao;

import java.util.Collection;

import org.jbpm.pvm.internal.identity.impl.GroupImpl;
import org.jbpm.pvm.internal.identity.impl.UserImpl;

import br.com.ap.arquitetura.dao.CrudDao;

/**
 * DAO de acesso às informação do grupo.
 * 
 * @author adriano.pamplona
 */
public interface GroupDao extends CrudDao<GroupImpl> {

	/**
	 * Consulta os grupos do usuário.
	 * 
	 * @param user Usuário com ID
	 * @return grupos do usuário
	 */
	public Collection<GroupImpl> consultar(UserImpl user);

	/**
	 * Consultar os grupos por usuário e tipo de grupo.
	 * 
	 * @param user Usuário com ID.
	 * @param group Grupo com tipo.
	 * @return grupos
	 */
	public Collection<GroupImpl> consultarPorUsuarioTipoGrupo(UserImpl user,
			GroupImpl group);

	/**
	 * Obtem o grupo pelo nome.
	 * 
	 * @param group Group com o name informado.
	 * @return group localizado
	 */
	public GroupImpl obterPorName(GroupImpl group);
}
