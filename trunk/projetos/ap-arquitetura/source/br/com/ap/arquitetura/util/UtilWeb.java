/*
 * UtilWeb.java
 * 
 * Data de criação: 28/06/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Utilitário para manipulação de objetos do container WEB.
 * 
 * @author adrianop
 */
public final class UtilWeb {

	/**
	 * Construtor.
	 */
	private UtilWeb() {
		// Construtor.
	}

	/**
	 * Retorna o contexto da aplicação.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return contexto
	 */
	public static String getContexto(HttpServletRequest request) {
		String contexto = null;

		if (isReferencia(request)) {
			contexto = request.getContextPath() + "/";
		}
		return contexto;
	}

	/**
	 * Retorna o primeiro contexto da aplicação.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return primeiro contexto
	 */
	public static String getPrimeiroContexto(HttpServletRequest request) {
		String contexto = null;

		if (isReferencia(request)) {
			contexto = request.getContextPath();

			int inicio = 0;
			int fim = contexto.lastIndexOf("/") + 1;

			contexto = UtilString.substring(contexto, inicio, fim);
		}
		return contexto;
	}

	/**
	 * Retorna a URI sem o contexto atual.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return URI sem contexto
	 */
	public static String getURISemContexto(HttpServletRequest request) {
		String uri = null;

		if (isReferencia(request)) {
			String contexto = request.getContextPath();
			uri = request.getRequestURI();
			uri = UtilString.remover(uri, contexto);
		}
		return uri;
	}

	/**
	 * Retorna a URL sem o contexto atual.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return URL sem contexto
	 */
	public static String getURLSemContexto(HttpServletRequest request) {
		String url = null;

		if (isReferencia(request)) {
			String contexto = request.getContextPath();
			url = request.getRequestURL().toString();
			url = UtilString.remover(url, contexto);
		}
		return url;
	}

	/**
	 * Retorna a URL da página solicitada, pode ser uma jsp ou um alias..
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return URL
	 */
	public static String getPaginaDaURL(HttpServletRequest request) {
		String url = null;

		if (isReferencia(request)) {
			url = request.getRequestURL().toString();

			String contexto = request.getContextPath();
			url = UtilString.remover(url, contexto);
			url = UtilString.substring(url, url.lastIndexOf("/"), url.length());
			url = contexto + url;
		}
		return url;
	}

	/**
	 * Retorna a sessão atual ou null se não houver sessão criada.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return sessão.
	 */
	public static HttpSession getSessao(HttpServletRequest request) {
		HttpSession sessao = null;

		if (isReferencia(request)) {
			sessao = request.getSession();
		}
		return sessao;
	}

	/**
	 * Retorna a sessão atual ou nova sessão.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param novaSessao
	 *            booleano que indica se uma nova sessão será criada.
	 * @return sessão
	 */
	public static HttpSession getSessao(HttpServletRequest request,
			boolean novaSessao) {
		HttpSession sessao = null;

		if (isReferencia(request)) {
			sessao = request.getSession(novaSessao);
		}
		return sessao;
	}

	/**
	 * Retorna a sessão atual.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param novaSessao
	 *            booleano que indica se uma nova sessão será criada.
	 * @return sessão
	 */
	public static HttpSession getSessao(ServletRequest request,
			boolean novaSessao) {
		HttpSession sessao = null;

		if (isReferencia(request)) {
			sessao = getRequest(request).getSession(novaSessao);
		}
		return sessao;
	}

	/**
	 * Faz o cast para HttpServletRequest
	 * 
	 * @param servletRequest
	 *            ServletRequest
	 * @return request
	 */
	public static HttpServletRequest getRequest(ServletRequest servletRequest) {
		HttpServletRequest request = null;

		if (isReferencia(servletRequest)) {
			request = (HttpServletRequest) servletRequest;
		}
		return request;
	}

	/**
	 * Faz o cast para HttpServletResponse
	 * 
	 * @param servletRequest
	 *            ServletResponse
	 * @return reponse
	 */
	public static HttpServletResponse getResponse(ServletResponse servletRequest) {
		HttpServletResponse response = null;

		if (isReferencia(servletRequest)) {
			response = (HttpServletResponse) servletRequest;
		}
		return response;
	}

	/**
	 * Recupera um atributo da sessão.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param nome
	 *            Nome do atributo
	 * @return Objeto da sessão
	 */
	public static Object getAtributoDaSessao(HttpServletRequest request,
			String nome) {
		Object atributo = null;

		if (isReferencia(request) && !isVazio(nome)) {
			atributo = getSessao(request).getAttribute(nome);
		}
		return atributo;
	}

	/**
	 * Recupera um atributo do request.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param nome
	 *            Nome do atributo.
	 * @return Objeto do request.
	 */
	public static Object getAtributoDoRequest(HttpServletRequest request,
			String nome) {
		Object atributo = null;

		if (isReferencia(request) && !isVazio(nome)) {
			atributo = request.getAttribute(nome);
		}
		return atributo;
	}

	/**
	 * Retorna o valor de um parâmetro do request.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param nome
	 *            Nome do parâmetro.
	 * @return valor do parâmetro
	 */
	public static String getParametroDoRequest(HttpServletRequest request,
			String nome) {
		String parametro = null;

		if (isReferencia(request) && !isVazio(nome)) {
			parametro = request.getParameter(nome);
		}
		return parametro;
	}

	/**
	 * Retorna o path da aplicação
	 * 
	 * @param evento
	 *            ServletContextEvent
	 * @return path da aplicação.
	 */
	public static String getPathDaAplicacao(ServletContextEvent evento) {
		String path = null;

		if (isReferencia(evento)) {
			path = getPathDaAplicacao(evento.getServletContext());
		}
		return path;
	}

	/**
	 * Retorna o path da aplicação
	 * 
	 * @param servletContext
	 *            ServletContext
	 * @return path da aplicação.
	 */
	public static String getPathDaAplicacao(ServletContext servletContext) {
		String path = null;

		if (isReferencia(servletContext)) {
			StringBuffer pathSB = new StringBuffer();
			pathSB.append(servletContext.getRealPath("."));
			pathSB.delete(pathSB.length() - 2, pathSB.length());

			path = pathSB.toString();
		}
		return path;
	}

	/**
	 * Retorna o mapa com todos os parâmetros do filtro.
	 * 
	 * @param config
	 *            FilterConfig
	 * @return Mapa dos parâmetros do filtro.
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getMapaParametros(FilterConfig config) {
		Map<String, String> resultado = getColecaoFactory().novoHashMap();

		if (isReferencia(config)) {
			String parametro = null;
			Enumeration<String> parametros = config.getInitParameterNames();
			while (parametros.hasMoreElements()) {
				parametro = (String) parametros.nextElement();
				resultado.put(parametro, config.getInitParameter(parametro));
			}
		}
		return resultado;
	}

	/**
	 * Retorna o tipo de requisição GET.
	 * 
	 * @return get
	 */
	public static String getRequisicaoGet() {
		return "GET";
	}

	/**
	 * Retorna o tipo de requisição POST.
	 * 
	 * @return post
	 */
	public static String getRequisicaoPost() {
		return "POST";
	}

	/**
	 * Atribui um objeto no request.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param nome
	 *            Nome do atributo.
	 * @param valor
	 *            Objeto que será adiciono
	 */
	public static void setAtributoNoRequest(HttpServletRequest request,
			String nome, Object valor) {

		if (isReferencia(request) && !isVazio(nome)) {
			request.setAttribute(nome, valor);
		}
	}

	/**
	 * Atribui um objeto na sessão.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param nome
	 *            Nome do atributo.
	 * @param valor
	 *            Objeto que será adicionado à sessão
	 */
	public static void setAtributoNaSessao(HttpServletRequest request,
			String nome, Object valor) {

		if (isReferencia(request) && !isVazio(nome)) {
			getSessao(request).setAttribute(nome, valor);
		}
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objeto
	 *            Objeto validado
	 * @return true se o objeto tiver referência.
	 */
	private static boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se a string for vazia.
	 * 
	 * @param string
	 *            String validada.
	 * @return true se a string for vazia.
	 */
	private static boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	private static ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
