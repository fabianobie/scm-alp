/**
 * ValidacaoAction.java
 *
 * Data: 09/12/2009
 */
package teste.action.validacao;

import java.util.Date;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author adriano.pamplona
 * 
 */
public class ValidacaoAction extends ActionSupport {
	
	private String	txtNome;
	private Date	txtDate;

	/**
	 * @return validacao
	 */
	@SkipValidation
	public String acaoCarregarValidacao() {
		return "validacao";
	}

	/**
	 * @return validacao
	 */
	public String acaoEnviar() {
		return acaoCarregarValidacao();
	}

	/**
	 * @return retorna txtNome.
	 */
	public String getTxtNome() {
		return txtNome;
	}

	/**
	 * @param txtNome Atribui txtNome.
	 */
	public void setTxtNome(String txtNome) {
		this.txtNome = txtNome;
	}

	/**
	 * @return retorna txtDate.
	 */
	public Date getTxtDate() {
		return txtDate;
	}

	/**
	 * @param txtDate Atribui txtDate.
	 */
	public void setTxtDate(Date txtDate) {
		this.txtDate = txtDate;
	}
}
