/*
 * QueryCountAbstrato.java
 * 
 * Data de cria��o: 20/11/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.util;

import java.util.Collections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.query.HQLQueryPlan;
import org.hibernate.engine.query.QueryPlanCache;
import org.hibernate.impl.SessionFactoryImpl;

import br.com.ap.comum.string.UtilString;

/**
 * Classe respons�vel em prov� infra estrutura para manipula��o dos objetos
 * Query.
 * 
 * @param <T> Tipo do objeto que representa uma query.
 * @author adrianop
 */
public abstract class QueryCountAbstrato<T> implements IQueryCount<T> {

	/**
	 * Retorna a query original modificada com um count(*)
	 * 
	 * @param sql SQL
	 * @return query com count
	 */
	protected String adicionarCountNoSelect(String sql) {
		return "select count(*) from (" + sql + ") as TB";
	}

	/**
	 * Converte o HQL passado por par�metro para a instru��o SQL que ser�
	 * executada.
	 * 
	 * @param sf SessionFactory
	 * @param hql HQL
	 * @return SQL do HQL
	 */
	protected String converterHQLParaSQL(SessionFactory sf, String hql) {
		QueryPlanCache qpc = ((SessionFactoryImpl) sf).getQueryPlanCache();
		HQLQueryPlan qp = qpc.getHQLQueryPlan(hql, false,
				Collections.EMPTY_MAP);
		return qp.getSqlStrings()[0];
	}

	/**
	 * Retorna uma nova sql query.
	 * 
	 * @param sessao Sess�o do hibernate
	 * @param sql SQL
	 * @return Nova sql query
	 */
	protected abstract T novaSQLQuery(Session sessao, String sql);

	/**
	 * Remove a instru��o solicitada do hql.
	 * 
	 * @param hql HQL
	 * @param instrucao Instru��o que ser� removida.
	 * @return query sem a instru��o solicitada.
	 */
	protected String removerInstrucao(String hql, String instrucao) {

		if (UtilString.isTemString(hql, instrucao)) {
			int indiceOrderBy = hql.lastIndexOf(instrucao);
			int indiceParenteces = hql.lastIndexOf(")");
			// a instru��o est� fora de uma subconsulta,
			// caso a subconsulta exista.
			if (indiceParenteces < indiceOrderBy) {
				hql = hql.substring(0, hql.lastIndexOf(instrucao));
			}
		}
		return hql;
	}
}
