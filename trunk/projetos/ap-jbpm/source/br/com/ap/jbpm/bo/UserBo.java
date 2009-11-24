/**
 * UserBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import javax.annotation.Resource;

import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.springframework.stereotype.Component;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.jbpm.dao.UserDao;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Component
public class UserBo extends CrudBoAbstrato<UserImpl> {
	@Resource(name = "userDaoImpl")
	private UserDao userDao;

	public boolean isUsuarioExiste(UserDecorator user) {
		UserDecorator userDecorator = obterUsuarioPeloNome(user);
		return UtilObjeto.isReferencia(userDecorator);
	}

	public UserDecorator obterUsuarioPeloNome(UserDecorator user) {
		UserDecorator resultado = null;

		if (UtilObjeto.isReferencia(user)) {
			resultado = getDao().obterUsuarioPeloNome(user);
		}
		return resultado;
	}

	@Override
	protected UserDao getDao() {
		return userDao;
	}
}
