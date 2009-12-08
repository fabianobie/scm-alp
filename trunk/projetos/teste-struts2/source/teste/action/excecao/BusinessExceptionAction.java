/**
 * BusinessExceptionAction.java
 *
 * Data: 30/11/2009
 */
package teste.action.excecao;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 * 
 */
public class BusinessExceptionAction extends ActionSupport {
	@SuppressWarnings("unused")
	private Exception	exception;

	@Override
	public String execute() throws Exception {
		System.out.println("Erro de negócio");
		return null;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

}
