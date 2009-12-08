/**
 * ExceptionHandlerAction.java
 *
 * Data: 20/11/2009
 */
package teste.action.excecao;


import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 * 
 */
public class ExcecaoAction extends ActionSupport {

	/**
	 * @return principal
	 */
	public String acaoCarregarExcecao() {
		return "excecao";
	}

	/**
	 * @return principal
	 */
	public String acaoGerarBusinessException() {
		if (true)
			throw new BusinessException("erro de negócio");
		return "excecao";
	}

	/**
	 * @return principal
	 */
	public String acaoGerarSystemException() {
		if (true)
			throw new SystemException("erro de sistema");
		return "excecao";
	}
	
	public String acaoExcecao() {
		return "excecao";
	}
}
