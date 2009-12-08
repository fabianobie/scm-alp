/**
 * ExceptionHandlerAction.java
 *
 * Data: 20/11/2009
 */
package teste.action.mensagem;


import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 * 
 */
public class MensagemAction extends ActionSupport {

	/**
	 * @return mensagem
	 */
	public String acaoCarregarMensagem() {
		return "mensagem";
	}

	/**
	 * @return principal
	 */
	public String acaoGerarMensagemDeErro() {
		addActionError("Mensagem de Erro");
		return acaoCarregarMensagem();
	}

	/**
	 * @return principal
	 */
	public String acaoGerarMensagemInformativa() {
		addActionMessage("Mensagem Informativa");
		return acaoCarregarMensagem();
	}
	
}
