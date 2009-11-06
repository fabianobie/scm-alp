/*
 * InfraTagSupportAbstrato.java
 * 
 * Data de criação: 27/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.taglib;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import br.com.ap.arquitetura.util.excecao.UtilArquiteturaException;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que provê os recursos necessários para trabalhar com taglib
 * do tipo TagSupport.
 * 
 * @author adrianop
 */
public class ArquiteturaTagSupportAbstrato extends BodyTagSupport {

	/**
	 * Imprime o texto na tela.
	 * 
	 * @param texto
	 *            Texto que será impresso.
	 * @throws JspException
	 */
	protected void println(String texto) throws JspException {
		try {
			if (!UtilString.isVazio(texto)) {
				getOut().println(texto);
			}
		} catch (IOException e) {
			throw UtilArquiteturaException.erro(e);
		}
	}

	/**
	 * Imprime o texto na tela.
	 * 
	 * @param texto
	 *            Texto que será impresso.
	 * @throws JspException
	 */
	protected void print(String texto) throws JspException {
		try {
			if (!UtilString.isVazio(texto)) {
				getOut().print(texto);
			}
		} catch (IOException e) {
			throw UtilArquiteturaException.erro(e);
		}
	}

	/**
	 * Inclui uma página na JSP.
	 * 
	 * @param pathDaPagina
	 *            Path da página que será incluída.
	 * @throws JspException
	 * @see PageContext#include(java.lang.String)
	 */
	protected void include(String pathDaPagina) throws JspException {
		try {
			getPageContext().include(pathDaPagina);
		} catch (Exception e) {
			throw UtilArquiteturaException.erro(e);
		}
	}

	/**
	 * Faz um forward para a página indicada.
	 * 
	 * @param pathDaPagina
	 *            Path da página que será chamada.
	 * @throws JspException
	 * @see PageContext#forward(java.lang.String)
	 */
	protected void forward(String pathDaPagina) throws JspException {
		try {
			getPageContext().forward(pathDaPagina);
		} catch (Exception e) {
			throw UtilArquiteturaException.erro(e);
		}
	}

	/**
	 * Retorna HttpSession.
	 * 
	 * @return HttpSession
	 */
	protected HttpSession getSession() {
		return getPageContext().getSession();
	}

	/**
	 * Retorna JspWriter.
	 * 
	 * @return JspWriter
	 */
	protected JspWriter getOut() {
		JspWriter out = getEnclosingWriter();
		if (!UtilObjeto.isReferencia(out)) {
			out = getPageContext().getOut();
		}
		return out;
	}

	/**
	 * Retorna o JspWriter do BodyContent.
	 * 
	 * @return JspWriter
	 */
	protected JspWriter getEnclosingWriter() {
		JspWriter out = null;

		if (UtilObjeto.isReferencia(getBodyContent())) {
			out = getBodyContent().getEnclosingWriter();
		}
		return out;
	}

	/**
	 * Retorna HttpServletResponse.
	 * 
	 * @return HttpServletResponse
	 */
	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) getPageContext().getResponse();
	}

	/**
	 * Retorna HttpServletRequest.
	 * 
	 * @return HttpServletRequest
	 */
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) getPageContext().getRequest();
	}

	/**
	 * Retorna PageContext.
	 * 
	 * @return PageContext
	 */
	protected PageContext getPageContext() {
		return pageContext;
	}

	/**
	 * Retorna ServletContext.
	 * 
	 * @return ServletContext
	 */
	protected ServletContext getServletContext() {
		return getPageContext().getServletContext();
	}

	/**
	 * Retorna a String do corpo da tag.
	 * 
	 * @return String do corpo da tag.
	 */
	protected String getString() {
		String resultado = null;
		BodyContent bc = getBodyContent();
		if (isReferencia(bc)) {
			resultado = bc.getString();
		}
		return resultado;
	}

	/**
	 * Retorna true se o objeto tiver referencia.
	 * 
	 * @param objeto
	 *            Objeto validado
	 * @return true se o objeto tiver referencia.
	 */
	protected boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se a string estiver vazia.
	 * 
	 * @param string
	 *            String validada.
	 * @return true se a string estiver vazia.
	 */
	protected boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}
}
