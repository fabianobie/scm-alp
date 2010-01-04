/**
 * NamedQueryTO.java
 *
 * Data: 04/01/2010
 */
package br.com.ap.gerador.asi.to;

import br.com.ap.comum.javabean.to.TOAbstrato;

/**
 * @author adriano.pamplona
 * 
 */
public class NamedQueryTO extends TOAbstrato {
	private String	name;
	private String	query;

	/**
	 * @return retorna nome.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param nome Atribui nome.
	 */
	public void setName(String nome) {
		this.name = nome;
	}

	/**
	 * @return retorna query.
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query Atribui query.
	 */
	public void setQuery(String query) {
		this.query = query;
	}
}
