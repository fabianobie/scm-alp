/*
 * UtilCopiarQueryParaQueryCount.java
 * 
 * Data de criação: 16/10/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.util;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.impl.QueryImpl;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe responsável em criar uma Query de count para uma Query passada por
 * parâmetro, a query criada é usada para retornar o total de registros da
 * consulta para a paginação.<br/>
 * Para criar a query de count é necessário executar os seguintes passos:<br/>
 * <dd>Recuperar o HQL da query original e adicionar o count <dd>Criar uma nova
 * Query com o HQL de count <dd>Adicionar os parâmetros da query original na
 * query de count.
 * 
 * @author adrianop
 */
@SuppressWarnings("unchecked")
public final class UtilCriarQueryDeCount {

	private static Map<Class<?>, IQueryCount> mapaQueryCount;

	/**
	 * Construtor.
	 */
	private UtilCriarQueryDeCount() {
		// Construtor.
	}

	/**
	 * Cria a query de count.
	 * 
	 * @param <T> Objeto que representa uma query.
	 * @param sessao Sessão do hibernate.
	 * @param query Query original
	 * @return Query de count
	 */
	public static <T> T criar(Session sessao, T query) {
		T queryCount = null;

		IQueryCount comando = getQueryCount(query);

		if (UtilObjeto.isReferencia(comando)) {
			queryCount = (T) comando.getQueryCount(sessao, query);
		}

		return queryCount;
	}

	/**
	 * Retorna o comando query para a query passada por parâmetro.
	 * 
	 * @param query Query
	 * @return query count
	 */
	private static <T extends Object> IQueryCount getQueryCount(T query) {
		Class<?> tipo = UtilObjeto.getClasse(query);
		return getMapaQueryCount().get(tipo);
	}

	/**
	 * Retorna mapaQueryCount.
	 * 
	 * @return Map
	 */
	private static Map<Class<?>, IQueryCount> getMapaQueryCount() {
		if (!UtilObjeto.isReferencia(mapaQueryCount)) {
			mapaQueryCount = ColecaoFactory.getInstancia().novoHashMap();
			mapaQueryCount.put(QueryImpl.class, novoQueryCountParaQuery());
			mapaQueryCount.put(SQLQueryNativo.class,
			        novoQueryCountParaSQLQueryNativo());
		}
		return mapaQueryCount;
	}

	/**
	 * @return QueryCountParaSQLQuery
	 */
	private static IQueryCount novoQueryCountParaSQLQueryNativo() {
		return new QueryCountParaSQLQueryNativo();
	}

	/**
	 * @return QueryCountParaQuery
	 */
	private static IQueryCount novoQueryCountParaQuery() {
		return new QueryCountParaQuery();
	}

}
