/*
 * MensagemAction.java
 * 
 * Data de criação: 21/10/2009
 */
package teste.action.mensagem;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import teste.action.TesteJSFActionAbstrato;

/**
 * @author adriano.pamplona
 */
public class MensagemAction extends TesteJSFActionAbstrato {
	/**
	 * @return formulário.
	 */
	public String acaoCarregar() {
		return "mensagem";
	}
	
	/**
	 * Registra mensagem.
	 * 
	 * @param e
	 */
	public void registrarMensagem(ActionEvent e) {
		getFacesContext().addMessage(null, novaMensagemWarn());
		getFacesContext().addMessage(null, novaMensagemInfo());
		getFacesContext().addMessage(null, novaMensagemError());
		getFacesContext().addMessage(null, novaMensagemFatal());
	}
	
	/**
	 * Registra mensagem de um id específico.
	 * 
	 * @param e
	 */
	public void registrarMensagemParaCampo(ActionEvent e) {
		getFacesContext().addMessage("campo", novaMensagemError());
	}

	/**
	 * @return mensagem warn
	 */
	protected FacesMessage novaMensagemWarn() {
		FacesMessage fm = new FacesMessage();
		fm.setSeverity(FacesMessage.SEVERITY_WARN);
		fm.setSummary("Erro WARN");
		fm.setDetail("Ocorreu um erro do tipo WARN");
		
		return fm;
	}

	/**
	 * @return mensagem info
	 */
	protected FacesMessage novaMensagemInfo() {
		FacesMessage fm = new FacesMessage();
		fm.setSeverity(FacesMessage.SEVERITY_INFO);
		fm.setSummary("Erro INFO");
		fm.setDetail("Ocorreu um erro do tipo INFO");
		
		return fm;
	}

	/**
	 * @return mensagem error
	 */
	protected FacesMessage novaMensagemError() {
		FacesMessage fm = new FacesMessage();
		fm.setSeverity(FacesMessage.SEVERITY_ERROR);
		fm.setSummary("Erro ERROR");
		fm.setDetail("Ocorreu um erro do tipo ERROR");
		
		return fm;
	}

	/**
	 * @return mensagem fatal
	 */
	protected FacesMessage novaMensagemFatal() {
		FacesMessage fm = new FacesMessage();
		fm.setSeverity(FacesMessage.SEVERITY_FATAL);
		fm.setSummary("Erro FATAL");
		fm.setDetail("Ocorreu um erro do tipo FATAL");
		
		return fm;
	}
}
