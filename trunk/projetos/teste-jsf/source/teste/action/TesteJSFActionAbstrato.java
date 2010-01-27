/*
 * ActionAbstrato.java
 * 
 * Data de criação: 16/10/2009
 */
package teste.action;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import teste.service.TesteJSFService;

/**
 * @author adriano.pamplona
 * 
 */
public abstract class TesteJSFActionAbstrato {
	/**
	 * @return Servico
	 */
	protected TesteJSFService getTesteJSFService() {
		return (TesteJSFService) getBean("testeJSFService");
	}

	/**
	 * @return FacesContext
	 */
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * @param <T>
	 *            Tipo do objeto de retorno.
	 * @param nome
	 *            Nome do bean localizado no contexto do spring.
	 * @return objeto do contexto do spring.
	 */
	@SuppressWarnings("unchecked")
	private <T extends Object> T getBean(String nome) {
		return (T) getWebApplicationContext().getBean(nome);
	}

	/**
	 * @return WebApplicationContext
	 */
	private WebApplicationContext getWebApplicationContext() {
		ServletContext sc = getServletContext();
		return WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
	}

	/**
	 * @return ExternalContext
	 */
	private ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	/**
	 * @return ServletContext
	 */
	private ServletContext getServletContext() {
		return (ServletContext) getExternalContext().getContext();
	}
}
