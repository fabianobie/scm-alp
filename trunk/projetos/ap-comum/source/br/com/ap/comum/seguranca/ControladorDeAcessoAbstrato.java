/*
 * ControladorDeAcessoAbstrato.java
 * 
 * Data de criação: 24/04/2007
 *
 * 
 * 
 */
package br.com.ap.comum.seguranca;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Controlador de acesso do sistema, representa a interface para a solicitação
 * de recursos do sistema.
 * 
 * @author adrianop
 * @see ControladorDeAcesso
 */
public abstract class ControladorDeAcessoAbstrato implements
		ControladorDeAcesso {

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto tiver referência.
	 */
	protected boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto0 Objeto validado.
	 * @param objeto1 Objeto validado.
	 * @return true se o objeto tiver referência.
	 */
	protected boolean isReferencia(Object objeto0, Object objeto1) {
		return UtilObjeto.isReferencia(objeto0, objeto1);
	}

	/**
	 * Retorna true se a string for vazia.
	 * 
	 * @param string String validada.
	 * @return true se a string for vazia.
	 */
	protected boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}
}
