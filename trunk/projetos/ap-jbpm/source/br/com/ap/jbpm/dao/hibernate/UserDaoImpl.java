/**
 * UserDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import org.hibernate.Criteria;
import org.jbpm.api.identity.User;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.jbpm.dao.UserDao;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * DAO de acesso às informação de usuário.
 * 
 * @author adriano.pamplona
 */
@Repository
public class UserDaoImpl extends JBPMDaoAbstrato<UserImpl> implements UserDao {

	// @Resource
	// private IdentityService identityService;

	/**
	 * @see br.com.ap.jbpm.dao.UserDao#obterUsuarioPeloNome(br.com.ap.jbpm.decorator.UserDecorator)
	 */
	public UserDecorator obterUsuarioPeloNome(UserDecorator user) {

		Criteria criteria = novoCriteria();
		criteria.add(novoCriterioEQ("givenName", user.getGivenName()));
		User resultado = (User) criteria.uniqueResult();
		return getDecoratorFactory().novoUserDecorator(resultado);
	}
	
}
