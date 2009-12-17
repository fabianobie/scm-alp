/**
 * CrudNegocioAbstrato.java
 *
 * Data: 17/12/2009
 */
package br.com.ap.arquitetura.negocio;

import java.io.Serializable;
import java.util.Collection;

import br.com.ap.arquitetura.util.CRUD;

/**
 * Classe CRUD de negócio.
 * 
 * @author adriano.pamplona
 */
public abstract class CrudNegocioAbstrato<T extends Object> extends
		NegocioAbstrato implements CRUD<T> {

	@Override
	public void alterar(T entidade) {
		getCrud().alterar(entidade);
	}

	@Override
	public Collection<T> consultar(T entidade) {
		return getCrud().consultar(entidade);
	}

	@Override
	public Collection<T> consultar() {
		return getCrud().consultar();
	}

	@Override
	public void excluir(T entidade) {
		getCrud().excluir(entidade);
	}

	@Override
	public void excluirTodos(Collection<T> entidades) {
		getCrud().excluirTodos(entidades);
	}

	@Override
	public <R extends Serializable> R incluir(T entidade) {
		return getCrud().incluir(entidade);
	}

	@Override
	public T obter(Serializable pk) {
		return getCrud().obter(pk);
	}

	@Override
	public T obter(T entidade) {
		return getCrud().obter(entidade);
	}

	@Override
	public void salvar(T entidade) {
		getCrud().salvar(entidade);
	}

	/**
	 * @return retorna crud.
	 */
	protected abstract CRUD<T> getCrud();
}
