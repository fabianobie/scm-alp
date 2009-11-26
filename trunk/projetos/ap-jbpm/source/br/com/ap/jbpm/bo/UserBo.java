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
 * BO respons�vel pelas regras de neg�cio de usu�rio.
 * 
 * @author adriano.pamplona
 */
@Component
public class UserBo extends CrudBoAbstrato<UserImpl> {
	@Resource(name = "userDaoImpl")
	private UserDao	userDao;

	/**
	 * Retorna true se o usu�rio existir.
	 * 
	 * @param user Usu�rio com givenName informado
	 * @return true se o usu�rio existir.
	 */
	public boolean isUsuarioExiste(UserDecorator user) {
		boolean resultado = false;

		if (isReferencia(user)) {
			UserDecorator userDecorator = obterUsuarioPeloNome(user);
			resultado = isReferencia(userDecorator);
		}
		return resultado;
	}

	/**
	 * Consulta o usu�rio pelo givenName.
	 * 
	 * @param user Usu�rio com givenName informado
	 * @return Usu�rio recuperado
	 */
	public UserDecorator obterUsuarioPeloNome(UserDecorator user) {
		UserDecorator resultado = null;

		if (isReferencia(user)) {
			resultado = getDao().obterUsuarioPeloNome(user);
		}
		return resultado;
	}

	@Override
	protected UserDao getDao() {
		return userDao;
	}
}
