/**
 * JQueryAction.java
 *
 * Data: 20/11/2009
 */
package teste.action.jquery;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 */
public class JQueryAction extends ActionSupport {

	/**
	 * @return mascara
	 */
	public String acaoCarregarMascara() {
		return "mascara";
	}

	/**
	 * @return validacao
	 */
	public String acaoCarregarValidacao() {
		return "validacao";
	}

}
