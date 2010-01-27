/*
 * CPFValidator.java
 * 
 * Data de criação: 23/10/2009
 */
package teste.action.validador;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import teste.util.UtilJsf;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.validador.UtilValidadorDeCPF;

/**
 * @author adriano.pamplona
 */
public class CPFValidator implements Validator {

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext,
	 *      javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		if (UtilObjeto.isReferencia(value)
				&& !UtilValidadorDeCPF.validar(value.toString())) {
			String label = UtilJsf.getLabel(context, component);
			String summary = "Erro de validação no CPF";
			String detail = "{0}: campo com CPF inválido!";
			detail = MessageFormat.format(detail, new Object[] { label });

			FacesMessage fm = new FacesMessage(summary, detail);
			throw new ValidatorException(fm);

		}
	}
	
}
