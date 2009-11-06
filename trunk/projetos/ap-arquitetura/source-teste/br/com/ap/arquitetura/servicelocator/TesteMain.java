/*
 * TesteMain.java
 * 
 * Data de cria��o: 20/03/2009
 */
package br.com.ap.arquitetura.servicelocator;

import br.com.ap.arquitetura.servicelocator.web.ServiceLocatorFactoryWebImpl;
import br.com.ap.arquitetura.servicelocator.web.ServiceLocatorWeb;
import junit.framework.TestCase;

/**
 * @author AdrianoP
 */
public class TesteMain extends TestCase {

	/**
	 * Teste de inst�ncia do service locator.
	 */
	public void testMain() {
		ServiceLocatorFactory factory = ServiceLocatorFactoryWebImpl.getInstancia();
		ServiceLocatorWeb sl = factory.novoServiceLocator();
		System.out.println(sl);
	}
}
