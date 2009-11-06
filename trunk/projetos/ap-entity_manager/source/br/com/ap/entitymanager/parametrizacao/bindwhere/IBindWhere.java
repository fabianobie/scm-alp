/*
 * IBindWhere.java
 * 
 * Data de criação: 22/08/2008
 *
 * Desenvolvido por Politec Ltda.
 * Fábrica de Software - Brasília
 */
package br.com.ap.entitymanager.parametrizacao.bindwhere;

import java.io.Serializable;

import javax.persistence.Query;

/**
 * Interface responsável pelo contrato da parametrização da clausula where.
 * 
 * @author adrianop
 * @param <T>
 *            Classe que representa o atributo parametrizado.
 */
public interface IBindWhere<T extends Serializable> {

	/**
	 * Retorna a instrução HQL que representa a clausula where da propriedade
	 * solicitada.
	 * 
	 * @param propriedade
	 *            Propriedade da entidade.
	 * @param valor
	 *            Valor da propriedade.
	 * @return string HQL
	 */
	public String getHQL(String propriedade, T valor);

	/**
	 * Parametriza a query para a propriedade solicitada.
	 * 
	 * @param query
	 *            Query
	 * @param propriedade
	 *            Propriedade da entidade.
	 * @param valor
	 *            Valor da propriedade.
	 */
	public void setParametro(Query query, String propriedade, T valor);

}
