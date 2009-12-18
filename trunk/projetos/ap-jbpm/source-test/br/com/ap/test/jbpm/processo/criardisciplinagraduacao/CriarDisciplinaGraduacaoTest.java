/**
 * SolicitarDemandaTest.java
 *
 * Data: 20/11/2009
 */
package br.com.ap.test.jbpm.processo.criardisciplinagraduacao;

import org.jbpm.api.ProcessInstance;

import br.com.ap.jbpm.JBPMFacade;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
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
		decorator.setClasspathJpdl("br/com/ap/test/jbpm/processo/criardisciplinagraduacao/" +
				"fluxo_criar_disciplina_graducao.jpdl.xml");
		
		DeploymentDecorator publicado = getJbpmFacade().publicar(decorator);
		assertNotNull(publicado.getId());
		println("Deploy: "+ publicado.getId());
	}
	
	public void testFluxoPrincipal() {
		ProcessDefinitionDecorator pd = new ProcessDefinitionDecorator();
		pd.setId("1");
		ProcessInstance pi = getJbpmFacade().iniciarProcesso(pd);
		
		System.out.println(pi.isActive("task_fornecer_requisitos"));
	}

}
