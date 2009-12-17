/**
 * UserBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import javax.annotation.Resource;

import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.springframework.stereotype.Component;

import br.com.ap.jbpm.dao.UserDao;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * BO responsável pelas regras de negócio de usuário.
 * 
 * @author adriano.pamplona
 */
@Component
public class UserBo extends JBPMBoAbstrato<UserImpl> {
	@Resource(name = "userDaoImpl")
	private UserDao	userDao;

	/**
	 * Retorna true se o usuário existir.
	 * 
	 * @param user Usuário com givenName informado
	 * @return true se o usuário existir.
	 */
	public boolean isUsuarioExiste(UserDecorator user) {
		boolean resultado = false;

		if (isReferencia(user)) {
			UserDecorator userDecorator = obterUsuarioPeloNome(user);
			resultado = isReferencia(userDecorator) && isReferencia(userDecorator.getGivenName());
		}
		return resultado;
	}

	/**
	 * Consulta o usuário pelo givenName.
	 * 
	 * @param user Usuário com givenName informado
	 * @return Usuário recuperado
	 */
	public UserDecorator obterUsuarioPeloNome(UserDecorator user) {
		UserDecorator resultado = null;

		if (isReferencia(user)) {
			UserDecorator temp = getCrudDao().obterUsuarioPeloNome(user);

			if (isReferencia(temp) && isReferencia(temp.getGivenName())) {
				resultado = temp;
			}
		}
		return resultado;
	}

	@Override
	protected UserDao getCrudDao() {
		return userDao;
	}
}
