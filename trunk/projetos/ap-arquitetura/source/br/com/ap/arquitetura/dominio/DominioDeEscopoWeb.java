/*
 * DominioDeEscopoWeb.java
 * 
 * Data de criação: 30/08/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.dominio;

import java.util.Map;

import javax.servlet.jsp.PageContext;

import br.com.ap.comum.conversor.UtilConversorDeInteger;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe de domínio dos escopos do container web. <br>
 * Lista de domínios disponibilizados pela classe:<br>
 * <dd>PageContext.APPLICATION_SCOPE - application<br> 
 * <dd>PageContext.SESSION_SCOPE - session<br>
 * <dd>PageContext.REQUEST_SCOPE - request<br> 
 * <dd>PageContext.PAGE_SCOPE - page<br>
 * 
 * @author adrianop
 */
public final class DominioDeEscopoWeb extends DominioAbstrato {
	private static Map<String, Integer> mapaDosEscopos;

	/**
	 * Construtor.
	 */
	private DominioDeEscopoWeb() {
		// Construtor
	}

	/**
	 * Retorna o código do escopo solicitado.
	 * 
	 * @param escopo String do escopo solicitado. (application, session,
	 *            request, page)
	 * @return código do escopo
	 */
	public static int getCodigoDoEscopo(String escopo) {
		Integer codigo = getCodigoDoEscopoPadrao();
		if (getMapaDosEscopos().containsKey(escopo)) {
			codigo = (Integer) getMapaDosEscopos().get(escopo);
		}
		return codigo.intValue();
	}

	/**
	 * String do escopo padrão. (request)
	 * 
	 * @return escopo padrão
	 */
	public static String getEscopoPadrao() {
		return getRequest();
	}

	/**
	 * Retorna o código do escopo padrão. (PageContext.REQUEST_SCOPE)
	 * 
	 * @return escopo default.
	 */
	public static Integer getCodigoDoEscopoPadrao() {
		return getCodigoDoRequestInteger();
	}

	/**
	 * Retorna o escopo application.
	 * 
	 * @return application
	 */
	public static String getApplication() {
		return "application";
	}

	/**
	 * Retorna o escopo page.
	 * 
	 * @return page
	 */
	public static String getPage() {
		return "page";
	}

	/**
	 * Retorna o escopo session.
	 * 
	 * @return session
	 */
	public static String getSession() {
		return "session";
	}

	/**
	 * Retorna o escopo request.
	 * 
	 * @return request
	 */
	public static String getRequest() {
		return "request";
	}

	/**
	 * 
	 * Retorna o codigo do escopo application.
	 * 
	 * @return application
	 */
	public static int getCodigoDoApplication() {
		return PageContext.APPLICATION_SCOPE;
	}

	/**
	 * Retorna o codigo do escopo page.
	 * 
	 * @return page
	 */
	public static int getCodigoDoPage() {
		return PageContext.PAGE_SCOPE;
	}

	/**
	 * Retorna o codigo do escopo session.
	 * 
	 * @return session
	 */
	public static int getCodigoDoSession() {
		return PageContext.SESSION_SCOPE;
	}

	/**
	 * Retorna o codigo do escopo request.
	 * 
	 * @return request
	 */
	public static int getCodigoDoRequest() {
		return PageContext.REQUEST_SCOPE;
	}

	/**
	 * Retorna o codigo do escopo application.
	 * 
	 * @return application
	 */
	public static Integer getCodigoDoApplicationInteger() {
		return converterParaInteger(PageContext.APPLICATION_SCOPE);
	}

	/**
	 * Retorna o codigo do escopo page.
	 * 
	 * @return page
	 */
	public static Integer getCodigoDoPageInteger() {
		return converterParaInteger(PageContext.PAGE_SCOPE);
	}

	/**
	 * Retorna o codigo do escopo session.
	 * 
	 * @return session
	 */
	public static Integer getCodigoDoSessionInteger() {
		return converterParaInteger(PageContext.SESSION_SCOPE);
	}

	/**
	 * Retorna o codigo do escopo request.
	 * 
	 * @return request
	 */
	public static Integer getCodigoDoRequestInteger() {
		return converterParaInteger(PageContext.REQUEST_SCOPE);
	}

	/**
	 * @return Retorna mapaDeCodigoDeEscopo
	 */
	public static Map<String, Integer> getMapaDosEscopos() {
		if (!UtilObjeto.isReferencia(mapaDosEscopos)) {
			mapaDosEscopos = getColecaoFactory().novoHashMap();
			mapaDosEscopos.put(getRequest(), getCodigoDoRequestInteger());
			mapaDosEscopos.put(getSession(), getCodigoDoSessionInteger());
			mapaDosEscopos.put(getPage(), getCodigoDoPageInteger());
			mapaDosEscopos.put(getApplication(),
			        getCodigoDoApplicationInteger());
		}

		return mapaDosEscopos;
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Converte o int para Integer.
	 * 
	 * @param _int int que será convertido
	 * @return integer
	 */
	private static Integer converterParaInteger(int _int) {
		return UtilConversorDeInteger.converterParaInteger(_int);
	}
}
