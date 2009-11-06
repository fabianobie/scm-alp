/*
 * RemoverCacheTag.java
 * 
 * Data de criação: 30/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.taglib;

import javax.servlet.jsp.JspException;

/**
 * Tag responsável em remover a página atual do cache.
 * 
 * @author adrianop
 */
public class RemoverCacheTag extends ArquiteturaTagSupportAbstrato {

	/**
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {
		getResponse().setDateHeader("Expires", 0);
		getResponse().setHeader("Pragma", "no-cache");
		
		if (isProtocoloHttp11()) {
			getResponse().setHeader("Cache-Control", "no-cache");
			getResponse().addHeader("Cache-Control", "no-store");
		}
		return EVAL_PAGE;
	}

	/**
	 * @return true se o protocolo for HTTP 1.1
	 */
	protected boolean isProtocoloHttp11() {
		String tipoDoProtocolo = getHttp11();
		return getProtocolo().equals(tipoDoProtocolo);
	}

	/**
	 * Retorna o tipo do protocolo "HTTP/1.1".
	 * 
	 * @return HTTP/1.1
	 */
	protected String getHttp11() {
		return "HTTP/1.1";
	}

	/**
	 * Retorna o protocolo.
	 * 
	 * @return protocolo
	 */
	protected String getProtocolo() {
		return getRequest().getProtocol();
	}
}
