/*
 * CrudBoAbstrato.java
 * 
 * Data de criação: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.io.Serializable;
import java.util.Collection;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.arquitetura.dao.DAO;

/**
 * @author AdrianoP
 * 
 */
public abstract class CrudBoAbstrato<T extends Object> implements CrudDao<T> {

	@Override
	public void alterar(T arg0) {
		getDao().alterar(arg0);
	}

	@Override
	public Collection<T> consultar() {
		return getDao().consultar();
	}

	@Override
	public Collection<T> consultar(T arg0) {
		return getDao().consultar(arg0);
	}

	@Override
	public void excluir(T arg0) {
		getDao().excluir(arg0);
	}

	@Override
	public void excluirTodos(Collection<T> arg0) {
		getDao().excluirTodos(arg0);
	}

	@Override
	public <R extends Serializable> R incluir(T arg0) {
		return getDao().incluir(arg0);
	}

	@Override
	public T obter(Serializable arg0) {
		return getDao().obter(arg0);
	}

	@Override
	public T obter(T arg0) {
		return getDao().obter(arg0);
	}

	@Override
	public void salvar(T arg0) {
		getDao().salvar(arg0);
	}

	protected abstract CrudDao<T> getDao();
}
