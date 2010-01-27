/*
 * ComponenteAction.java
 * 
 * Data de criação: 26/10/2009
 */
package teste.action.componente;

import teste.action.TesteJSFActionAbstrato;

/**
 * @author adriano.pamplona
 * 
 */
public class ComponenteAction extends TesteJSFActionAbstrato {
	private String outputTextCPF;
	/**
	 * @return componente.
	 */
	public String acaoCarregar() {
		outputTextCPF = "82749655153";
		
		return "componente";
	}
	/**
	 * @return the outputTextCPF
	 */
	public String getOutputTextCPF() {
		return outputTextCPF;
	}
	/**
	 * @param outputTextCPF the outputTextCPF to set
	 */
	public void setOutputTextCPF(String outputTextCPF) {
		this.outputTextCPF = outputTextCPF;
	}
}
