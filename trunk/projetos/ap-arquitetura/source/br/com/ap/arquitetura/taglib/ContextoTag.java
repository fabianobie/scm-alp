/*
 * ContextoTag.java
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
 * Imprime o contexto da aplica��o.
 * 
 * @author adrianop
 */
public class ContextoTag extends ArquiteturaTagSupportAbstrato {

	/**
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {
		String contexto = UtilWeb.getContexto(getRequest());
		print(contexto);
		return super.doStartTag();
	}
}