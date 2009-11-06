/*
 * DateBindWhere.java
 * 
 * Data de criação: 22/08/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.parametrizacao.bindwhere;

import java.sql.Timestamp;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import br.com.ap.comum.constante.CaracterEspecial;

/**
 * Bind de HQL para objetos do tipo Timestamp.
 * 
 * @author adrianop
 */
public class TimestampBindWhere extends BindWhereAbstrato<Timestamp> {

	/**
	 * @see IBindWhere#getHQL(String, java.io.Serializable)
	 */
	public String getHQL(String atributo, Timestamp valor) {
		StringBuilder where = novoStringBuilder();
		where.append(" and e.").append(atributo).append("=:").append(atributo);
		where.append(CaracterEspecial.getQuebraDeLinha());
		return where.toString();
	}

	/**
	 * @see IBindWhere#setParametro(Query, String, java.io.Serializable)
	 */
	public void setParametro(Query query, String atributo, Timestamp valor) {
		query.setParameter(atributo, valor, TemporalType.TIMESTAMP);
	}
}
