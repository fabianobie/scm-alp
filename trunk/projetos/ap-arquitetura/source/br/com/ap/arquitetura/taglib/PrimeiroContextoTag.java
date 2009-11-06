/*
 * PrimeiroContextoTag.java
 *
 * Data de cria��o: 24/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.taglib;

import javax.servlet.jsp.JspException;

import br.com.ap.arquitetura.util.UtilWeb;

/**
 * Imprime o primeiro contexto da aplica��o. Se o contexto for /gap/APPS ser�
 * retornado /gap/.
 * 
 * @author adrianop
 */
public class PrimeiroContextoTag extends ArquiteturaTagSupportAbstrato {

	/**
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {
		String contexto = UtilWeb.getPrimeiroContexto(getRequest());
		print(contexto);
		return super.doStartTag();
	}
}