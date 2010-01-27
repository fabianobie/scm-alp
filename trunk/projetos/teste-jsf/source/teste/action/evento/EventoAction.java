/*
 * EventoAction.java
 * 
 * Data de cria��o: 21/10/2009
 */
package teste.action.evento;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import teste.action.TesteJSFActionAbstrato;

/**
 * @author adriano.pamplona
 *
 */
public class EventoAction extends TesteJSFActionAbstrato {
	private String nome;
	
	/**
	 * @return formul�rio.
	 */
	public String acaoCarregar() {
		return "evento";
	}
	
	/**
	 * Processa uma action.
	 * 
	 * @return evento 
	 */
	public String acaoProcessarAction() {
		return acaoCarregar();
	}
	
	/**
	 * Processa um listener.
	 * 
	 * @param e Evento
	 */
	public void acaoProcessarActionListener(ActionEvent e) {
		// m�todo
	}
	
	public void acaoMudarNome(ValueChangeEvent e) {
		String nome = (String) e.getNewValue();
		if (nome != null) {
			setNome(nome.toUpperCase());
		}
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
