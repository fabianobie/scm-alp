/*
 * TesteMain.java
 * 
 * Data de criação: 20/03/2009
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
	 * Teste de instância do service locator.
	 */
	public void testMain() {
		ServiceLocatorFactory factory = ServiceLocatorFactoryWebImpl.getInstancia();
		ServiceLocatorWeb sl = factory.novoServiceLocator();
		System.out.println(sl);
	}
}
