/*
 * HibernateFactory.java
 * 
 * Data de cria��o: 20/11/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.util.fabrica;

import org.hibernate.SQLQuery;

import br.com.ap.hibernate.util.SQLQueryNativo;

/**
 * F�brica dos objetos da biblioteca do hibernate.
 * 
 * @author adrianop
 */
public final class HibernateFactory {
	private static HibernateFactory instancia = new HibernateFactory();

	/**
	 * Construtor
	 */
	private HibernateFactory() {
		// Construtor.
	}

	/**
	 * @return inst�ncia �nica da classe.
	 */
	public static HibernateFactory getInstancia() {
		return instancia;
	}

	/**
	 * @return novo SQLQueryNativo
	 */
	public SQLQueryNativo novoSQLQueryNativo() {
		return new SQLQueryNativo();
	}

	/**
	 * @param sqlquery SQLQuery
	 * @return novo SQLQueryNativo
	 */
	public SQLQueryNativo novoSQLQueryNativo(SQLQuery sqlquery) {
		SQLQueryNativo query = novoSQLQueryNativo();
		query.setQuery(sqlquery);

		return query;
	}
}
