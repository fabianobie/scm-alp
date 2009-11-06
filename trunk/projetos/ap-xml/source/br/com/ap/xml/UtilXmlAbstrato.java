/*
 * UtilXmlAbstrato.java
 * 
 * Data de cria��o: 04/06/2007
 * 
 *
 *
 */
package br.com.ap.xml;

import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe abstrata que prov� recursos para as classes de acesso �s
 * funcionalidades da API.
 * 
 * @author AdrianoP
 */
public abstract class UtilXmlAbstrato {

	/**
	 * Retorna true se o objeto tiver refer�ncia.
	 * 
	 * @param objeto
	 *            Objeto validado.
	 * @return true se o objeto tiver refer�ncia.
	 */
	protected static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}
}
