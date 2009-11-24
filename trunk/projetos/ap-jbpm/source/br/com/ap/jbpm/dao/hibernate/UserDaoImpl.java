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

import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.jbpm.dao.UserDao;
import br.com.ap.jbpm.decorator.UserDecorator;
import br.com.ap.jbpm.factory.DecoratorFactory;

/**
 * @author adriano.pamplona
 * 
 */
@Repository
public class UserDaoImpl extends HibernateCrudDaoAbstrato<UserImpl> implements
		UserDao {

	// @Resource
	// private IdentityService identityService;

	@Override
	public UserDecorator obterUsuarioPeloNome(UserDecorator user) {

		Criteria criteria = novoCriteria();
		criteria.add(novoCriterioEQ("givenName", user.getGivenName()));
		User resultado = (User) criteria.uniqueResult();
		return getDecoratorFactory().novoUserDecorator(resultado);
	}

	/**
	 * @return DecoratorFactory
	 */
	private DecoratorFactory getDecoratorFactory() {
		return DecoratorFactory.getInstancia();
	}
}
