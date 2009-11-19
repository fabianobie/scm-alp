/*
 * IQueryCount.java
 * 
 * Data de cria��o: 20/11/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.util;

import org.hibernate.Session;

/**
 * Respons�vel pela reprenta��o de convers�o para uma query de count.
 * 
 * @author adrianop
 * @param <T> Tipo do objeto que representa a query.
 */
public interface IQueryCount<T> {

	/**
	 * Retorna a query count da query atual.
	 * 
	 * @param sessao Sess�o do hibernate.
	 * @param query Query original
	 * @return query count
	 */
	public T getQueryCount(Session sessao, T query);
}
