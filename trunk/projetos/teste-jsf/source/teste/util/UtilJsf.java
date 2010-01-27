/*
 * UtilJsf.java
 * 
 * Data de criação: 23/10/2009
 */
package teste.util;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import br.com.ap.comum.string.UtilString;

/**
 * @author adriano.pamplona
 *
 */
public final class UtilJsf {

	/**
	 * Construtor.
	 */
	private UtilJsf() {
		// Construtor.
	}
	
	/**
	 * Retorna um objeto do contexto do JSF.
	 * 
	 * @param <T> Tipo do objeto de retorno.
	 * @param id Identificador do objeto. Ex: #{BuildView}
	 * @return objeto do contexto JSF.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T getObjetoDoContexto(String id) {
		// T resultado = null;
		id = converterID(id);
		ValueExpression ve = novoValueExpression(id, Object.class);
		return (T) ve.getValue(getELContext());
	}
	
	/**
	 * Retorna o label do componente, se não houver label será retornado o ID.
	 * 
	 * @param context
	 * @param component
	 * @return label do componente.
	 */
	public static String getLabel(FacesContext context, UIComponent component) {
		String label = "";
		label = getLabelDoComponente(component);
		label = getLabelDaValueExpression(label, component);
		label = getLabelDoClientID(label, context, component);
		return label;
	}
	
	/**
	 * @param component
	 * @return label do componente.
	 */
	private static String getLabelDoComponente(UIComponent component) {
		return (String) component.getAttributes().get("label");
	}

	/**
	 * Retorna o label do componente, caso o label seja uma valuebind, esta será
	 * resolvida.
	 * 
	 * @param label
	 * @param component
	 * @return label do componente.
	 */
	private static String getLabelDaValueExpression(String label, UIComponent component) {
		if (UtilString.isVazio(label)) {
			ValueExpression expression = component.getValueExpression("label");
			if (expression != null)
				label = expression.getExpressionString();
		}
		return label;
	}

	/**
	 * @param label
	 * @param context
	 * @param component
	 * @return ID do componente
	 */
	private static String getLabelDoClientID(String label, FacesContext context,
			UIComponent component) {
		if (UtilString.isVazio(label)) {
			label = component.getClientId(context);
		}
		return label;
	}
	
	/**
	 * Retorna o ValueExpression para recuperação de um objeto disponibilizado
	 * no contexto do JSF.
	 * 
	 * @param id ID do objeto disponibilizado no contexto do JSF
	 * @param tipo Tipo do objeto que será retornado.
	 * @return ValueExpression
	 */
	private static ValueExpression novoValueExpression(String id, Class<?> tipo) {
		ELContext el = getELContext();
		return getExpressionFactory().createValueExpression(el, id, tipo);
	}
	
	/**
	 * @return ELContext
	 */
	private static ELContext getELContext() {
		return getFacesContext().getELContext();
	}

	/**
	 * @return ExpressionFactory
	 */
	private static ExpressionFactory getExpressionFactory() {
		return getApplication().getExpressionFactory();
	}

	/**
	 * @return Application
	 */
	private static Application getApplication() {
		return getFacesContext().getApplication();
	}
	
	/**
	 * @return FacesContext.
	 */
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	/**
	 * Converte o ID solicitado para um identificador válido para consulta no
	 * contexto JSF. Ou seja, o ID deverá iniciar com "#{" e finalizar com "}".
	 * 
	 * @param id Identificador
	 * @return id com prefixo "#{" e sufixo "}".
	 */
	private static String converterID(String id) {
		if (!UtilString.isVazio(id) && !id.startsWith("#")) {
			id = "#{" + id + "}";
		}
		return id;
	}
}
