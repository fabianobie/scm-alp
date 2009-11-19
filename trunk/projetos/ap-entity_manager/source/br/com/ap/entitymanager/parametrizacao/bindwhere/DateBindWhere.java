/*
 * DateBindWhere.java
 * 
 * Data de criação: 22/08/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.parametrizacao.bindwhere;

import java.util.Date;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import br.com.ap.comum.constante.CaracterEspecial;

/**
 * Bind de HQL para objetos do tipo Date.
 * 
 * @author adrianop
 */
public class DateBindWhere extends BindWhereAbstrato<Date> {

	/**
	 * @see IBindWhere#getHQL(String, java.io.Serializable)
	 */
	public String getHQL(String atributo, Date valor) {
		StringBuilder where = novoStringBuilder();
		where.append(" and e.").append(atributo).append("=:").append(atributo);
		where.append(CaracterEspecial.getQuebraDeLinha());
		return where.toString();
	}

	/**
	 * @see IBindWhere#setParametro(Query, String, java.io.Serializable)
	 */
	public void setParametro(Query query, String atributo, Date valor) {
		query.setParameter(atributo, valor, TemporalType.DATE);
	}
}
