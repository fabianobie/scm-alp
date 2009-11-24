/**
 * JbpmDecoratorAbstrato.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import br.com.ap.comum.javabean.to.TOAbstrato;
import br.com.ap.comum.validador.UtilValidadorDeStringsIguais;
import br.com.ap.jbpm.factory.EntidadeFactory;

/**
 * @author adriano.pamplona
 * 
 */
public abstract class JbpmDecoratorAbstrato extends TOAbstrato {

	/**
	 * Retorna true se o valor passado for zero ou nulo.
	 * 
	 * @param valor
	 *            Valor que será validado
	 * @return true se o valor passado for zero ou nulo.
	 */
	@SuppressWarnings("boxing")
	protected boolean isZero(Number valor) {
		return !isReferencia(valor) || (valor.intValue() == 0);
	}

	/**
	 * Retorna true se o valor passado for zero ou nulo.
	 * 
	 * @param valor
	 *            Valor que será validado
	 * @return true se o valor passado for zero ou nulo.
	 */
	@SuppressWarnings("boxing")
	protected boolean isZero(String valor) {
		return UtilValidadorDeStringsIguais.validar(valor, "0");
	}
	
	/**
	 * @return EntidadeFactory
	 */
	protected EntidadeFactory getEntidadeFactory() {
		return EntidadeFactory.getInstancia();
	}
}
