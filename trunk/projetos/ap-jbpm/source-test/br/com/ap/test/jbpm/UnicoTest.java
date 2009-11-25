/*
 * MainTest.java
 * 
 * Data de criação: 12/11/2009
 */
package br.com.ap.test.jbpm;

import org.jbpm.pvm.internal.cfg.JbpmConfiguration;
import org.jbpm.pvm.internal.env.EnvironmentImpl;

import br.com.ap.test.TesteAbstrato;

/**
 * @author AdrianoP
 * 
 */
public class UnicoTest extends TesteAbstrato {

	public void test() {
		JbpmConfiguration c = new JbpmConfiguration();
		EnvironmentImpl env = c.openEnvironment();
		
	}
}
