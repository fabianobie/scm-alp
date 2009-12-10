/**
 * PrincipalAction.java
 *
 * Data: 20/11/2009
 */
package teste.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 *
 */
public class PrincipalAction extends ActionSupport {

	/**
	 * @return principal
	 */
	@SkipValidation
	public String acaoCarregarPrincipal() {
		return "principal";
	}
}
