/**
 * FaceletAction.java
 *
 * Data: 17/12/2009
 */
package teste.action.facelet;

import teste.action.TesteJSFActionAbstrato;

/**
 * @author adriano.pamplona
 * 
 */
public class FaceletAction extends TesteJSFActionAbstrato {
	private String valor;
	/**
	 * @return composicao
	 */
	public String acaoCarregarComposicao() {
		return "composicao";
	}

	/**
	 * @return composicao
	 */
	public String acaoEnviar(Object valor) {
		System.out.println("acaoEnviar: "+ valor);
		return acaoCarregarComposicao();
	}

	/**
	 * @return composicao
	 */
	public String acaoEnviarSemParametro() {
		System.out.println("acaoEnviar: "+ valor);
		return acaoCarregarComposicao();
	}

	/**
	 * @return retorna valor.
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor Atribui valor.
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
