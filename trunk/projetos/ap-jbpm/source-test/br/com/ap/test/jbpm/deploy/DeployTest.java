/**
 * DeployTest.java
 *
 * Data: 20/11/2009
 */
package br.com.ap.test.jbpm.deploy;

import org.jbpm.api.NewDeployment;

import br.com.ap.test.TesteAbstrato;

/**
 * @author adriano.pamplona
 */
public class DeployTest extends TesteAbstrato {
	private static String ultimoDeployID;
	
	/**
	 * 
	 */
	public void testDeploy() {
		NewDeployment deployment = getRepositoryService().createDeployment();
		deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/process.jpdl.xml");
		deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/process.png");
		deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/taskform-start.ftl");
		deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/taskform-conferir-demanda.ftl");
		deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/taskform-solicitar-demanda.ftl");
		deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/taskform-solicitar-informacao.ftl");

		println("Deploy: " + deployment.deploy());
	}
	
	/**
	 * @return retorna ultimoDeployID.
	 */
	public static String getUltimoDeployID() {
		return ultimoDeployID;
	}
	
	/**
	 * @param ultimoDeployID Atribui ultimoDeployID.
	 */
	public static void setUltimoDeployID(String ultimoDeployID) {
		DeployTest.ultimoDeployID = ultimoDeployID;
	}
}
