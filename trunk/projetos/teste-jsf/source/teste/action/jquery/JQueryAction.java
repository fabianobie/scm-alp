/*
 * JQueryAction.java
 * 
 * Data de criação: 19/10/2009
 */
package teste.action.jquery;

/**
 * @author adriano.pamplona
 *
 */
public class JQueryAction {
	private String telefone;
	
	/**
	 * @return jquery
	 */
	public String acaoCarregar() {
		return "jquery";
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
