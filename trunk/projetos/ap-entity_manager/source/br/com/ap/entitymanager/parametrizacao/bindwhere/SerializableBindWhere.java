/*
 * SerializableBindWhere.java
 * 
 * Data de criação: 22/08/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.parametrizacao.bindwhere;

import java.io.Serializable;

import javax.persistence.Query;

import br.com.ap.comum.constante.CaracterEspecial;

/**
 * Bind de HQL para objetos do tipo Serializable.
 * 
 * @author adrianop
 */
public class SerializableBindWhere extends BindWhereAbstrato<Serializable> {

	/**
	 * @see IBindWhere#getHQL(String, java.io.Serializable)
	 */
	public String getHQL(String atributo, Serializable valor) {
		StringBuilder where = novoStringBuilder();
		where.append(" and e.").append(atributo).append("=:").append(atributo);
		where.append(CaracterEspecial.getQuebraDeLinha());
		return where.toString();
	}

	/**
	 * @see IBindWhere#setParametro(Query, String, java.io.Serializable)
	 */
	public void setParametro(Query query, String atributo, Serializable valor) {
		query.setParameter(atributo, valor);
	}
}
