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
 * @param <T> Tipo do objeto tratado pelo crud
 * @author adriano.pamplona
 */
public abstract class CrudNegocioAbstrato<T extends Object> extends
		NegocioAbstrato implements CRUD<T> {

	@Override
	public void alterar(T entidade) {
		getCrudDao().alterar(entidade);
	}

	@Override
	public Collection<T> consultar(T entidade) {
		return getCrudDao().consultar(entidade);
	}

	@Override
	public Collection<T> consultar() {
		return getCrudDao().consultar();
	}

	@Override
	public void excluir(T entidade) {
		getCrudDao().excluir(entidade);
	}

	@Override
	public void excluirTodos(Collection<T> entidades) {
		getCrudDao().excluirTodos(entidades);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R extends Serializable> R incluir(T entidade) {
		return (R)getCrudDao().incluir(entidade);
	}

	@Override
	public T obter(Serializable pk) {
		return getCrudDao().obter(pk);
	}

	@Override
	public T obter(T entidade) {
		return getCrudDao().obter(entidade);
	}

	@Override
	public void salvar(T entidade) {
		getCrudDao().salvar(entidade);
	}

	/**
	 * @return retorna crud.
	 */
	protected abstract CRUD<T> getCrudDao();
}
