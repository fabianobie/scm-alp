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
 * DAO de acesso �s informa��o do grupo.
 * 
 * @author adriano.pamplona
 */
public interface GroupDao extends CrudDao<GroupImpl> {

	/**
	 * Consulta os grupos do usu�rio.
	 * 
	 * @param user Usu�rio com ID
	 * @return grupos do usu�rio
	 */
	public Collection<GroupImpl> consultar(UserImpl user);

	/**
	 * Consultar os grupos por usu�rio e tipo de grupo.
	 * 
	 * @param user Usu�rio com ID.
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
