/**
 * ELAction.java
 *
 * Data: 27/11/2009
 */
package teste.action.el;

import teste.action.TesteJSFActionAbstrato;
import teste.entidade.Cliente;

/**
 * @author adriano.pamplona
 */
public class ELAction extends TesteJSFActionAbstrato {
	
	private Cliente cliente;
	
	/**
	 * @return el
	 */
	public String acaoCarregar() {
//		Cidade cidade = new Cidade();
//		cidade.setNome("Brasília");
//		
//		Cliente cliente = new Cliente();
//		cliente.setCidade(cidade);
//		
//		this.cliente = cliente;
		
		return "el";
	}

	/**
	 * @return retorna cliente.
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente Atribui cliente.
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
