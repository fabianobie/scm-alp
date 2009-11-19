/*
 * HibernateCrudDaoAbstrato.java
 * 
 * Data de criação: 22/07/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.dao;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.comum.javabean.entidade.ExclusaoLogica;

/**
 * Classe responsável pela persistência usando hibernate.
 * 
 * @author adrianop
 * @param <T> Tipo da entidade
 */
public abstract class HibernateCrudDaoAbstrato<T extends Object> extends
        HibernateDaoAbstrato<T> implements CrudDao<T> {

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#alterar(br.com.ap.comum.javabean.JavaBean)
	 */
	@Override
	public void alterar(T entidade) {

		if (isReferencia(entidade)) {
			registrarAcaoDeAlteracao();
			getSession().update(entidade);
		}
	}

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#consultar()
	 */
	@Override
	public Collection<T> consultar() {

		Criteria criteria = novoCriteria();
		return consultar(criteria);
	}

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#consultar(br.com.ap.comum.javabean.JavaBean)
	 */
	@Override
	public Collection<T> consultar(T entidade) {
		Criteria criteria = novoCriteria();

		if (isReferencia(entidade)) {
			Example example = Example.create(entidade);
			example.enableLike(MatchMode.START);
			example.excludeZeroes();
			criteria.add(example);
		}

		return consultar(criteria);
	}

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#excluir(br.com.ap.comum.javabean.JavaBean)
	 */
	@Override
	public void excluir(T entidade) {

		if (isReferencia(entidade)) {
			carregarEntidadePersistente(entidade);

			if (isEntidadeComExclusaoLogica(entidade)) {
				removerLogicamente(entidade);
			} else {
				registrarAcaoDeExclusao();
				getSession().delete(entidade);
				getSession().flush();
			}
		}
	}

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#excluirTodos(java.util.Collection)
	 */
	@Override
	public void excluirTodos(Collection<T> entidades) {
		if (isReferencia(entidades)) {
			for (T entidade : entidades) {
				excluir(entidade);
			}
		}
	}

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#incluir(br.com.ap.comum.javabean.JavaBean)
	 */
	@SuppressWarnings("unchecked")
    @Override
	public <R extends Serializable> R incluir(T entidade) {
		R resultado = null;

		if (isReferencia(entidade)) {
			registrarAcaoDeInclusao();
			resultado = (R) getSession().save(entidade);
		}
		return resultado;
	}

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#obter(java.util.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T obter(Serializable pk) {
		T resultado = null;

		if (isReferencia(pk)) {
			registrarAcaoDeConsulta();
			Class<T> tipo = getTipoDaEntidade();
			resultado = (T) getSession().get(tipo, pk);
		}
		return resultado;
	}

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#obter(br.com.ap.comum.javabean.JavaBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T obter(T entidade) {
		T resultado = null;
		
		if (isReferencia(entidade)) {
			registrarAcaoDeConsulta();
			Class<T> tipo = getTipoDaEntidade();
			Serializable pk = getIdentificador(entidade);
			
			if (isReferencia(pk)) {
				resultado = (T) getSession().get(tipo, pk);
			}
		}
		return resultado;
	}

	/**
	 * @see br.com.ap.arquitetura.util.CRUD#salvar(br.com.ap.comum.javabean.JavaBean)
	 */
	@Override
	public void salvar(T entidade) {

		if (isReferencia(entidade)) {
			if (isReferencia(getIdentificador(entidade))) {
				registrarAcaoDeAlteracao();
			} else {
				registrarAcaoDeInclusao();
			}

			getSession().saveOrUpdate(entidade);
		}
	}

	/**
	 * Remove logicamente uma entidade, ou seja, altera o atributo 'excluido'.
	 * 
	 * @param entidade Entidade.
	 */
	@SuppressWarnings("boxing")
	protected void removerLogicamente(T entidade) {
		if (isEntidadeComExclusaoLogica(entidade)) {
			carregarEntidadePersistente(entidade);
			ExclusaoLogica e = (ExclusaoLogica) entidade;
			e.setExcluido(true);
		}
	}

	/**
	 * Restaura uma entidade com exclusão lógica. Ocorrerá a alteração do
	 * atributo que indica que a entidade está excluída para que seja marcada
	 * como entidade não excluída.
	 * 
	 * @param entidade Entidade
	 */
	@SuppressWarnings("boxing")
	protected void restaurarRemocaoLogica(T entidade) {
		if (isEntidadeComExclusaoLogica(entidade)) {
			carregarEntidadePersistente(entidade);
			ExclusaoLogica e = (ExclusaoLogica) entidade;
			e.setExcluido(false);
		}
	}

}
