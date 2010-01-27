/*
 * ValidadorAction.java
 * 
 * Data de criação: 21/10/2009
 */
package teste.action.validador;

import javax.faces.application.FacesMessage;

import teste.action.TesteJSFActionAbstrato;

/**
 * @author adriano.pamplona
 * 
 */
public class ValidadorAction extends TesteJSFActionAbstrato {

	/**
	 * @return validador.
	 */
	public String acaoCarregar() {
		return "validador";
	}

	/**
	 * @return validador.
	 */
	public String acaoEnviar() {
		FacesMessage fm = new FacesMessage("Sucesso", "Ação executada com sucesso!");
		getFacesContext().addMessage(null, fm);
		return acaoCarregar();
	}

}
