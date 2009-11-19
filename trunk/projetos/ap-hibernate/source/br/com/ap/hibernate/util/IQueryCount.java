/*
 * IQueryCount.java
 * 
 * Data de criação: 20/11/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.util;

import org.hibernate.Session;

/**
 * Responsável pela reprentação de conversão para uma query de count.
 * 
 * @author adrianop
 * @param <T> Tipo do objeto que representa a query.
 */
public interface IQueryCount<T> {

	/**
	 * Retorna a query count da query atual.
	 * 
	 * @param sessao Sessão do hibernate.
	 * @param query Query original
	 * @return query count
	 */
	public T getQueryCount(Session sessao, T query);
}
