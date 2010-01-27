/*
 * OpcoesValidator.java
 * 
 * Data de criação: 23/10/2009
 */
package teste.action.validador;

import java.text.MessageFormat;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import teste.util.UtilJsf;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * @author adriano.pamplona
 */
public class OpcoesValidator implements Validator, StateHolder {
	private String	opcoes;
	private boolean	isTransient;

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext,
	 *      javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		if (UtilObjeto.isReferencia(value)) {
			String string = value.toString();
			
			if (!getOpcoesList().contains(string)) {
				String label = UtilJsf.getLabel(context, component);
				String summary = "Erro de validação de opções";
				String detail = "{0}: campo com valor inválido, os valores devem ser ''{1}''!";
				detail = MessageFormat.format(detail, new Object[] { label,
						getOpcoes() });
				
				FacesMessage fm = new FacesMessage(summary, detail);
				throw new ValidatorException(fm);
			}
		}
	}

	/**
	 * @see javax.faces.component.StateHolder#restoreState(javax.faces.context.FacesContext,
	 *      java.lang.Object)
	 */
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		opcoes = (String) values[0];
	}

	/**
	 * @see javax.faces.component.StateHolder#saveState(javax.faces.context.FacesContext)
	 */
	public Object saveState(FacesContext context) {
		Object values[] = new Object[1];
		values[0] = opcoes;
		return values;
	}

	/**
	 * @see javax.faces.component.StateHolder#setTransient(boolean)
	 */
	public final void setTransient(final boolean isTransient) {
		this.isTransient = isTransient;
	}

	/**
	 * @see javax.faces.component.StateHolder#isTransient()
	 */
	public final boolean isTransient() {
		return isTransient;
	}

	/**
	 * @return the opcoes
	 */
	public String getOpcoes() {
		if (!UtilObjeto.isReferencia(opcoes)) {
			opcoes = new String("");
		}
			
		return opcoes;
	}

	/**
	 * @param opcoes
	 *            the opcoes to set
	 */
	public void setOpcoes(String opcoes) {
		this.opcoes = opcoes;
	}
	
	/**
	 * @return lista de opções
	 */
	protected List<String> getOpcoesList() {
		return UtilString.split(getOpcoes(), ",");
	}
}
