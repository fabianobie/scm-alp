/**
 * BusinessException.java
 *
 * Data: 30/11/2009
 */
package teste.action.excecao;

/**
 * @author adriano.pamplona
 *
 */
public class BusinessException extends RuntimeException {

	public BusinessException(String mensagem) {
		super(mensagem);
	}
	
}
