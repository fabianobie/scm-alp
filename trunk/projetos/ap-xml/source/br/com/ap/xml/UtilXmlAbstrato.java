/*
 * UtilXmlAbstrato.java
 * 
 * Data de criação: 04/06/2007
 * 
 *
 *
 */
package br.com.ap.xml;

import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe abstrata que provê recursos para as classes de acesso às
 * funcionalidades da API.
 * 
 * @author AdrianoP
 */
public abstract class UtilXmlAbstrato {

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto
	 *            Objeto validado.
	 * @return true se o objeto tiver referência.
	 */
	protected static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}
}
