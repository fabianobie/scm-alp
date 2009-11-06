/*
 * IBindWhere.java
 * 
 * Data de cria��o: 22/08/2008
 *
 * Desenvolvido por Politec Ltda.
 * F�brica de Software - Bras�lia
 */
package br.com.ap.entitymanager.parametrizacao.bindwhere;

import java.io.Serializable;

import javax.persistence.Query;

/**
 * Interface respons�vel pelo contrato da parametriza��o da clausula where.
 * 
 * @author adrianop
 * @param <T>
 *            Classe que representa o atributo parametrizado.
 */
public interface IBindWhere<T extends Serializable> {

	/**
	 * Retorna a instru��o HQL que representa a clausula where da propriedade
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
