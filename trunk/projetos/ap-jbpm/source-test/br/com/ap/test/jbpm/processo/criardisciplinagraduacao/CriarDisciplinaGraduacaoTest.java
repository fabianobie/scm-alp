/**
 * SolicitarDemandaTest.java
 *
 * Data: 20/11/2009
 */
package br.com.ap.test.jbpm.processo.criardisciplinagraduacao;

import br.com.ap.jbpm.JBPMFacade;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.test.TesteAbstrato;

/**
 * @author adriano.pamplona
 */
public class CriarDisciplinaGraduacaoTest extends TesteAbstrato {

	/**
	 * @see JBPMFacade#publicar(DeploymentDecorator)
	 */
	public void testDeploy() {
		DeploymentDecorator decorator = new DeploymentDecorator();
		decorator.setClasspathJpdl("br/com/ap/test/jbpm/processo/solicitardemanda/fluxo_criar_disciplina_graducao.jpdl.xml");
		
		DeploymentDecorator publicado = getJbpmFacade().publicar(decorator);
		assertNotNull(publicado.getId());
		println("Deploy: "+ publicado.getId());
	}

}
