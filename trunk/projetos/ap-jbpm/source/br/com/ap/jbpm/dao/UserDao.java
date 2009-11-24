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
 * @author adriano.pamplona
 * 
 */
public interface UserDao extends CrudDao<UserImpl> {

	public UserDecorator obterUsuarioPeloNome(UserDecorator user);
}
