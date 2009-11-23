/**
 * JbpmDecoratorAbstrato.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import br.com.ap.comum.javabean.to.TOAbstrato;
import br.com.ap.jbpm.factory.EntidadeFactory;

/**
 * @author adriano.pamplona
 * 
 */
public abstract class JbpmDecoratorAbstrato extends TOAbstrato {

	/**
	 * @return EntidadeFactory
	 */
	protected EntidadeFactory getEntidadeFactory() {
		return EntidadeFactory.getInstancia();
	}
}
