/*
 * DateBindWhere.java
 * 
 * Data de criação: 22/08/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.parametrizacao.bindwhere;

import java.sql.Time;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import br.com.ap.comum.constante.CaracterEspecial;

/**
 * Bind de HQL para objetos do tipo Time.
 * 
 * @author adrianop
 */
public class TimeBindWhere extends BindWhereAbstrato<Time> {

	/**
	 * @see IBindWhere#getHQL(String, java.io.Serializable)
	 */
	public String getHQL(String atributo, Time valor) {
		StringBuilder where = novoStringBuilder();
		where.append(" and e.").append(atributo).append("=:").append(atributo);
		where.append(CaracterEspecial.getQuebraDeLinha());
		return where.toString();
	}

	/**
	 * @see IBindWhere#setParametro(Query, String, java.io.Serializable)
	 */
	public void setParametro(Query query, String atributo, Time valor) {
		query.setParameter(atributo, valor, TemporalType.TIME);
	}
}
