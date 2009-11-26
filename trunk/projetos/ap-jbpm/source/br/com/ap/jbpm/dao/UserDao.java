/**
 * UserDao.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao;

import org.jbpm.pvm.internal.identity.impl.UserImpl;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * DAO de acesso �s informa��o da task.
 * 
 * @author adriano.pamplona
 */
public interface UserDao extends CrudDao<UserImpl> {
	
	/**
	 * Consulta o usu�rio pelo givenName.
	 * 
	 * @param user Usu�rio com givenName informado
	 * @return Usu�rio recuperado
	 */
	public UserDecorator obterUsuarioPeloNome(UserDecorator user);
}
