/**
 * GrafoEL.java
 *
 * Data: 27/11/2009
 */
package teste.action.el;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.ap.comum.colecao.UtilColecao;

/**
 * @author adriano.pamplona
 */
public class GrafoEL implements Serializable {
	private List<String>	chaveAtributo;
	private List<Object>	valorAtributo;

	public Object getValorEL() {
		return getUltimoValorAtributo();
	}

	public void adicionarAtributo(String chave, Object valor) {
		getChaveAtributo().add(chave);
		getValorAtributo().add(valor);
	}
	public Object getUltimoValorAtributo() {
		return UtilColecao.getElementoDoUltimoIndice(getValorAtributo());
	}
	
	public boolean isListaDeAtributoVazia() {
		return UtilColecao.isVazio(getChaveAtributo());
	}
	/**
	 * @return retorna chaveAtributo.
	 */
	public List<String> getChaveAtributo() {
		if (chaveAtributo == null) {
			chaveAtributo = new ArrayList<String>();
		}
		return chaveAtributo;
	}

	/**
	 * @param chaveAtributo Atribui chaveAtributo.
	 */
	public void setChaveAtributo(List<String> chaveAtributo) {
		this.chaveAtributo = chaveAtributo;
	}

	/**
	 * @return retorna valorAtributo.
	 */
	public List<Object> getValorAtributo() {
		if (valorAtributo == null) {
			valorAtributo = new ArrayList<Object>();
		}
		return valorAtributo;
	}

	/**
	 * @param valorAtributo Atribui valorAtributo.
	 */
	public void setValorAtributo(List<Object> valorAtributo) {
		this.valorAtributo = valorAtributo;
	}
}
