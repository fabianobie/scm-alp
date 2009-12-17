/**
 * TesteGeral.java
 *
 * Data: 20/11/2009
 */
package br.com.ap.test;

import br.com.ap.test.jbpm.processo.solicitardemanda.SolicitarDemandaTest;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author adriano.pamplona
 *
 */
public class TesteGeral extends TestSuite {

	/**
	 * @return Test
	 */
	public static Test suite() {
		TestSuite testes = novoTestSuite();
		testes.addTest(new SolicitarDemandaTest());
		
		return testes;
	}
	
	/**
	 * @return nova suite de teste.
	 */
	private static TestSuite novoTestSuite() {
		return new TestSuite("Testes do br.com.ap.test.jbpm");
	}
}
