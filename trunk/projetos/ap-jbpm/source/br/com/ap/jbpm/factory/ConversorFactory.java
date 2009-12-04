/**
 * ConversorFactory.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.factory;

import br.com.ap.jbpm.util.ConversorDeTaskParaTaskDecorator;

/**
 * F�brica de conversores.
 * 
 * @author adriano.pamplona
 */
public final class ConversorFactory {
	private static ConversorFactory	instancia	= new ConversorFactory();

	/**
	 * Construtor.
	 */
	private ConversorFactory() {
		// Construtor.
	}

	/**
	 * @return inst�ncia �nica da classe.
	 */
	public static ConversorFactory getInstancia() {
		return instancia;
	}

	/**
	 * @return ConversorDeTaskParaTaskDecorator
	 */
	public ConversorDeTaskParaTaskDecorator novoConversorDeTaskParaTaskDecorator() {
		return new ConversorDeTaskParaTaskDecorator();
	}

}
