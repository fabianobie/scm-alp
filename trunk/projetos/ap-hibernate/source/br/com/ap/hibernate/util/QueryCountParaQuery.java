/*
 * QueryCountParaQuery.java
 * 
 * Data de cria��o: 20/11/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.QueryParameters;
import org.hibernate.impl.QueryImpl;
import org.hibernate.type.Type;

/**
 * Respons�vel pela cria��o de uma query de count para objetos do tipo
 * QueryImpl.
 * 
 * @author adrianop
 */
public class QueryCountParaQuery extends QueryCountAbstrato<Query> {

	/**
	 * @param sessao Sess�o
	 * @param query Query
	 * @return query
	 * @see br.com.ap.hibernate.util.IQueryCount#getQueryCount(org.hibernate.Session,
	 *      java.lang.Object)
	 */
	public Query getQueryCount(Session sessao, Query query) {
		String hql = query.getQueryString();
		hql = removerInstrucao(hql, "order by");
		hql = converterHQLParaSQL(sessao.getSessionFactory(), hql);
		hql = adicionarCountNoSelect(hql);
		Query queryCount = novaSQLQuery(sessao, hql);
		adicionarParametros(query, queryCount);

		return queryCount;
	}

	/**
	 * Retorna os par�metros da query oringal
	 * 
	 * @param query Query Original
	 * @return par�metros da query oringal
	 */
	protected QueryParameters getQueryParameters(Query query) {
		return ((QueryImpl) query).getQueryParameters(null);
	}

	/**
	 * @see br.com.ap.hibernate.util.QueryCountAbstrato#novaSQLQuery(org.hibernate.Session,
	 *      java.lang.String)
	 */
	@Override
	protected Query novaSQLQuery(Session sessao, String sql) {
		return sessao.createSQLQuery(sql);
	}

	/**
	 * Adiciona os par�metros da query original na nova query de count.
	 * 
	 * @param query Query original
	 * @param queryCount Query de count
	 */
	protected void adicionarParametros(Query query, Query queryCount) {
		QueryParameters parametros = getQueryParameters(query);
		Type[] tipos = parametros.getPositionalParameterTypes();
		Object[] valores = parametros.getPositionalParameterValues();
		queryCount.setParameters(valores, tipos);
	}
}
