/*
 * QueryCountParaSQLQueryNativo.java
 * 
 * Data de criação: 20/11/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.util;

import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.com.ap.hibernate.util.fabrica.HibernateFactory;

/**
 * Responsável pela criação de uma query de count para objetos do tipo
 * SQLQueryNativo.
 * 
 * @author adrianop
 */
public class QueryCountParaSQLQueryNativo extends
		QueryCountAbstrato<SQLQueryNativo> {

	/**
	 * @param sessao Sessão
	 * @param query Query
	 * @return query
	 * @see br.com.ap.hibernate.util.IQueryCount#getQueryCount(org.hibernate.Session,
	 *      java.lang.Object)
	 */
	public SQLQueryNativo getQueryCount(Session sessao, SQLQueryNativo query) {
		String sql = query.getQueryString();
		sql = removerInstrucao(sql, "order by");
		sql = adicionarCountNoSelect(sql);
		SQLQueryNativo queryCount = novaSQLQuery(sessao, sql);
		adicionarParametros(query, queryCount);

		return queryCount;
	}

	/**
	 * @see br.com.ap.hibernate.util.QueryCountAbstrato#novaSQLQuery(org.hibernate.Session,
	 *      java.lang.String)
	 */
	@Override
	protected SQLQueryNativo novaSQLQuery(Session sessao, String sql) {
		SQLQuery q = sessao.createSQLQuery(sql);
		SQLQueryNativo query = getHibernateFactory().novoSQLQueryNativo(q);
		return query;
	}

	/**
	 * @return fábrica dos objetos da api do hibernate STJ
	 */
	private HibernateFactory getHibernateFactory() {
		return HibernateFactory.getInstancia();
	}

	/**
	 * Adiciona os parâmetros da query original na nova query de count.
	 * 
	 * @param query Query original
	 * @param queryCount Query de count
	 */
	protected void adicionarParametros(SQLQueryNativo query,
			SQLQueryNativo queryCount) {
		Map<String, Object> parametros = query.getMapaDeParametros();
		Set<String> set = parametros.keySet();
		for (String chave : set) {
			queryCount.setParameter(chave, parametros.get(chave));
		}
	}
}
