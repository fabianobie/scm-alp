/*
 * EntidadeConverter.java
 * 
 * Data de criação: 26/10/2009
 */
package teste.action.conversor;

import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.estrategia.UtilEstrategiaDeConversores;
import br.com.ap.comum.javabean.entidade.Entidade;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.reflexao.UtilReflexaoBean;
import br.com.ap.reflexao.UtilReflexaoConstrutor;
import br.com.ap.reflexao.UtilReflexaoPropriedade;

/**
 * @author adriano.pamplona
 * 
 */
public class EntidadeConverter implements Converter, StateHolder {
	private String	classe;
	private String	atributo;
	private boolean	isTransient;

	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext,
	 *      javax.faces.component.UIComponent, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {

		Entidade entidade = null;

		if (!UtilString.isVazio(value, getClasse(), getAtributo())) {
			Class<Entidade> classeEntidade = (Class<Entidade>) UtilReflexaoBean.novaClasse(getClasse());
			entidade = UtilReflexaoConstrutor.invocar(classeEntidade);
			Object valueConvertido = converter(value, entidade);
			
			UtilReflexaoPropriedade.set(entidade, getAtributo(), valueConvertido);
		}
		return entidade;
	}
	
	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext,
	 *      javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		
		String id = null;
		if (UtilObjeto.isObjetoDoTipo(value, Entidade.class)) {
			Entidade entidade = (Entidade) value;
			
			id = entidade.getIdentificador().toString();
		}
		return id;
	}

	/**
	 * @return the classe
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * @param classe
	 *            the classe to set
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * @return the atributo
	 */
	public String getAtributo() {
		return atributo;
	}

	/**
	 * @param atributo
	 *            the atributo to set
	 */
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	/**
	 * @see javax.faces.component.StateHolder#isTransient()
	 */
	public boolean isTransient() {
		return isTransient;
	}

	/**
	 * @see javax.faces.component.StateHolder#setTransient(boolean)
	 */
	public void setTransient(boolean _transient) {
		this.isTransient = _transient;
	}

	/**
	 * @see javax.faces.component.StateHolder#restoreState(javax.faces.context.FacesContext,
	 *      java.lang.Object)
	 */
	public void restoreState(FacesContext context, Object state) {
		Object[] estado = (Object[]) state;
		classe = (String) estado[0];
		atributo = (String) estado[1];
	}

	/**
	 * @see javax.faces.component.StateHolder#saveState(javax.faces.context.FacesContext)
	 */
	public Object saveState(FacesContext context) {
		Object[] estado = new Object[2];
		estado[0] = classe;
		estado[1] = atributo;
		return estado;
	}

	/**
	 * @param value
	 * @param entidade
	 * @return value convertido para o mesmo tipo da propriedade da entidade.
	 */
	@SuppressWarnings("unchecked")
	private Object converter(String value, Entidade entidade) {
		Class<?> tipo = UtilReflexaoPropriedade.getTipoDaPropriedade(entidade, getAtributo());
		IConversor conversor = getConversor(tipo);
		return conversor.converter(value);
	}
	
	/**
	 * @param tipo
	 * @return conversor do tipo do atributo.
	 */
	@SuppressWarnings("unchecked")
	private IConversor getConversor(Class<?> tipo) {
		return UtilEstrategiaDeConversores.getInstancia().recuperar(tipo);
	}
}
