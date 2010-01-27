/*
 * CPFConverter.java
 * 
 * Data de criação: 26/10/2009
 */
package teste.action.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import br.com.ap.comum.formatador.UtilFormatadorDeCPF;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * @author adriano.pamplona
 * 
 */
public class CPFConverter implements Converter {

	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext,
	 *      javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		
		Long cpf = null;
		if (!UtilString.isVazio(value)) {
			value = UtilString.removerCaracteres(value);
			cpf = new Long(value);
		}
		return cpf;
	}

	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext,
	 *      javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		
		String cpf = null;
		if (UtilObjeto.isReferencia(value)) {
			Long _long = (Long) value;
			cpf = UtilFormatadorDeCPF.formatar(_long.toString());
		}
		return cpf;
	}

}
