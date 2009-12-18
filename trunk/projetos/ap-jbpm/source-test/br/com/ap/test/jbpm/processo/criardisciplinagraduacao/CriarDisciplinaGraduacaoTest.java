/**
 * SolicitarDemandaTest.java
 *
 * Data: 20/11/2009
 */
package br.com.ap.test.jbpm.processo.criardisciplinagraduacao;

import java.util.Collection;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.jbpm.JBPMFacade;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.GroupDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.test.TesteAbstrato;

/**
 * @author adriano.pamplona
 */
public class CriarDisciplinaGraduacaoTest extends TesteAbstrato {

	/**
	 * @see JBPMFacade#publicar(DeploymentDecorator)
	 */
	public void test() {
		JBPMFacade facade = getJbpmFacade();
		// Criando usuários e grupos.
		String[] grupos = new String[]{"secretaria_ceam","comissao_graduacao","direcao_ceam"};
		for (int indice = 0; indice < grupos.length; indice++) {
			GroupDecorator g = new GroupDecorator();
			g.setName(grupos[indice]);
			facade.incluirGrupo(g);
		}
		
		// DEPLOY
		DeploymentDecorator decorator = new DeploymentDecorator();
		decorator.setClasspathJpdl("br/com/ap/test/jbpm/processo/criardisciplinagraduacao/" +
				"fluxo_criar_disciplina_graducao.jpdl.xml");
		
		DeploymentDecorator publicado = facade.publicar(decorator);
		assertNotNull(publicado.getId());
		println("Deploy: "+ publicado.getId());
		
		Collection<ProcessDefinition> definicoes = facade.consultarDefinicaoDeProcesso();
		assertNotNull(definicoes);
		assertFalse(UtilColecao.isVazio(definicoes));
		
		print("Total: "+ definicoes.size());
		for (ProcessDefinition definicao : definicoes) {
			print("Id...: "+ definicao.getId());
			print("Name.: "+ definicao.getName());
		}
		
		//CRIANDO INSTÂNCIA DO PROCESSO
		ProcessDefinitionDecorator pd = new ProcessDefinitionDecorator();
		pd.setId("fluxo_criar_disciplina-1");
		ProcessInstance pi = facade.iniciarProcesso(pd);
		
		System.out.println(pi.isActive("task_fornecer_requisitos"));
	}
}
