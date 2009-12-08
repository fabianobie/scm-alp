/**
 * PrincipalAction.java
 *
 * Data: 20/11/2009
 */
package teste.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 *
 */
public class PrincipalAction extends ActionSupport {

	/**
	 * @return principal
	 */
	public String acaoCarregarPrincipal() {
		return "principal";
	}
}
