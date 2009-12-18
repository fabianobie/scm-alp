/**
 * UserDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.jbpm.api.IdentityService;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.UserDao;

/**
 * DAO de acesso às informação de usuário.
 * 
 * @author adriano.pamplona
 */
@Repository
public class UserDaoImpl extends JBPMDaoAbstrato<UserImpl> implements UserDao {

	@Resource
	private IdentityService	identityService;

	@SuppressWarnings("unchecked")
	@Override
	public <R extends Serializable> R incluir(UserImpl entidade) {
		String userId = entidade.getId();
		String givenName = entidade.getGivenName();
		String familyName = entidade.getFamilyName();
		String businessEmail = entidade.getBusinessEmail();

		identityService
				.createUser(userId, givenName, familyName, businessEmail);
		return (R) userId;
	}

	@Override
	public void excluir(UserImpl entidade) {
		identityService.deleteUser(entidade.getId());
	}

	@Override
	public UserImpl obter(Serializable pk) {
		String chave = UtilString.getString(pk);
		return (UserImpl) identityService.findUserById(chave);
	}

	/**
	 * @see br.com.ap.jbpm.dao.UserDao#obterPeloNome(br.com.ap.jbpm.decorator.UserDecorator)
	 */
	public UserImpl obterPeloNome(UserImpl user) {

		Criteria criteria = novoCriteria();
		criteria.add(novoCriterioEQ("givenName", user.getGivenName()));
		return (UserImpl) criteria.uniqueResult();
	}

}
