/**
 * DeployTest.java
 *
 * Data: 20/11/2009
 */
package br.com.ap.test.jbpm.deploy;

import java.io.InputStream;

import org.jbpm.api.NewDeployment;

import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.test.TesteAbstrato;

/**
 * @author adriano.pamplona
 */
public class DeployTest extends TesteAbstrato {
	private static String	ultimoDeployID;

	/**
	 * 
	 */
	public void _testDeployOfertaDeDisciplina() {
		NewDeployment deployment = getRepositoryService().createDeployment();
		deployment.addResourceFromClasspath("fluxo_oferta_disciplina.jpdl.xml");
		deployment.addResourceFromClasspath("fluxo_oferta_disciplina.png");
		deployment.addResourceFromClasspath("taskform-apreciar-lista-disciplinas.ftl");
		deployment.addResourceFromClasspath("taskform-elabora-lista-disciplinas.ftl");
		deployment.addResourceFromClasspath("taskform-elabora-parecer-disciplinas.ftl");
		deployment.addResourceFromClasspath("taskform-preecher-formulario-oferta.ftl");
		deployment.addResourceFromClasspath("taskform-preencher-formulario-oferta.ftl");
		deployment.addResourceFromClasspath("taskform-registrar-lista-disciplinas-sigra.ftl");
		deployment.addResourceFromClasspath("taskform-solicita-preecher-formulario-oferta.ftl");
		deployment.addResourceFromClasspath("taskform-solicita-preencher-formulario-oferta.ftl");

		println("Deploy: " + deployment.deploy());
	}

	/**
	 * 
	 */
	public void testDeploy() {
		NewDeployment deployment = getRepositoryService().createDeployment();
		deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/process.jpdl.xml");
		deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/process.png");
		//deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/taskform-start.ftl");
		//deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/taskform-conferir-demanda.ftl");
		//deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/taskform-solicitar-demanda.ftl");
		//deployment.addResourceFromClasspath("br/com/ap/test/jbpm/deploy/taskform-solicitar-informacao.ftl");

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
