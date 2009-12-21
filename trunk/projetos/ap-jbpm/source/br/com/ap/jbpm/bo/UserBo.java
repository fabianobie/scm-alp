/**
 * UserBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.io.Serializable;

import javax.annotation.Resource;

import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.springframework.stereotype.Component;

import br.com.ap.arquitetura.util.CRUD;
import br.com.ap.jbpm.dao.UserDao;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * BO respons�vel pelas regras de neg�cio de usu�rio.
 * 
 * @author adriano.pamplona
 */
@Component
public class UserBo extends JBPMBoAbstrato<UserImpl> {

	@Resource(name = "userDaoImpl")
	private UserDao	userDao;

	/**
	 * @param <R> Serializable
	 * @param decorator UserDecorator
	 * @return Serializable
	 * @see CRUD#incluir(Object)
	 */
	public <R extends Serializable> R incluir(UserDecorator decorator) {
		R resultado = null;

		if (isUsuarioTemReferencia(decorator)) {
			UserImpl user = decorator.getUserImpl();
			super.incluir(user);
		}
		return resultado;
	}

	/**
	 * @param decorator UserDecorator
	 * @see CRUD#alterar(Object)
	 */
	public void alterar(UserDecorator decorator) {
		if (isUsuarioTemReferencia(decorator)) {
			UserImpl user = decorator.getUserImpl();
			super.alterar(user);
			decorator.setUserImpl(user);
		}
	}

	/**
	 * @param decorator UserDecorator
	 * @see CRUD#excluir(Object)
	 */
	public void excluir(UserDecorator decorator) {
		if (isUsuarioTemReferencia(decorator)) {
			UserImpl user = decorator.getUserImpl();
			super.excluir(user);
		}
	}

	/**
	 * Retorna o usu�rio pelo ID.
	 * 
	 * @param decorator UserDecorator com ID informado.
	 * @return usu�rio
	 */
	public UserDecorator obterPorId(UserDecorator decorator) {
		UserDecorator resultado = null;

		if (isReferencia(decorator) && isReferencia(decorator.getId())) {
			UserImpl user = super.obter(decorator.getId());
			resultado = getDecoratorFactory().novoUserDecorator(user);
		}
		return resultado;
	}

	/**
	 * Consulta o usu�rio pelo givenName.
	 * 
	 * @param decorator Usu�rio com givenName informado
	 * @return Usu�rio recuperado
	 */
	public UserDecorator obterPorGivenName(UserDecorator decorator) {
		UserDecorator resultado = null;

		if (isReferencia(decorator)) {
			UserImpl user = decorator.getUserImpl();
			UserImpl localizado = getCrudDao().obterPorGivenName(user);

			if (isReferencia(localizado)
					&& isReferencia(localizado.getGivenName())) {
				resultado = getDecoratorFactory().novoUserDecorator(localizado);
			}
		}
		return resultado;
	}
	
	/**
	 * Consulta o usu�rio pelo givenName.
	 * 
	 * @param user Usu�rio com givenName informado
	 * @return Usu�rio recuperado
	 */
	public UserDecorator obterPorGivenName(UserImpl user) {
		UserDecorator decorator = getDecoratorFactory().novoUserDecorator(user);
		return obterPorGivenName(decorator);
	}

	/**
	 * Retorna true se o usu�rio existir.
	 * 
	 * @param decorator Usu�rio com givenName informado
	 * @return true se o usu�rio existir.
	 */
	public boolean isUsuarioExiste(UserDecorator decorator) {
		UserDecorator resultado = obterPorGivenName(decorator);
		return isReferencia(resultado)
				&& isReferencia(resultado.getGivenName());
	}

	@Override
	protected UserDao getCrudDao() {
		return userDao;
	}
}
