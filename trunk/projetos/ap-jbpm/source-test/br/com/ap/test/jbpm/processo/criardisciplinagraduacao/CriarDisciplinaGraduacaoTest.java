/**
 * SolicitarDemandaTest.java
 *
 * Data: 20/11/2009
 */
package br.com.ap.test.jbpm.processo.criardisciplinagraduacao;

import java.util.Collection;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.pvm.internal.identity.impl.GroupImpl;
import org.jbpm.pvm.internal.task.TaskImpl;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.jbpm.JBPMFacade;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.GroupDecorator;
import br.com.ap.jbpm.decorator.MembershipDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;
import br.com.ap.jbpm.factory.DecoratorFactory;
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
		String[] usuarios = new String[]{"usuario_secretaria_ceam","usuario_comissao_graduacao","usuario_direcao_ceam"};
		for (int indice = 0; indice < usuarios.length; indice++) {
			UserDecorator g = new UserDecorator();
			g.setId(usuarios[indice]);
			g.setGivenName(usuarios[indice]);
			facade.incluirUsuario(g);
		}
		MembershipDecorator membro = new MembershipDecorator();
		membro.setGroupName("secretaria_ceam");
		membro.setUserGivenName("usuario_secretaria_ceam");
		facade.incluirUsuarioAoGrupo(membro);
		
		membro = new MembershipDecorator();
		membro.setGroupName("comissao_graduacao");
		membro.setUserGivenName("usuario_comissao_graduacao");
		facade.incluirUsuarioAoGrupo(membro);
		
		membro = new MembershipDecorator();
		membro.setGroupName("direcao_ceam");
		membro.setUserGivenName("usuario_direcao_ceam");
		facade.incluirUsuarioAoGrupo(membro);
		
		// consultar grupos de um usuário
		DecoratorFactory decoratorFactory = DecoratorFactory.getInstancia();
		UserDecorator userDecorator = decoratorFactory.novoUserDecorator(membro.getUser());
		Collection<GroupImpl> gruposDoUsuario = facade.consultarGrupo(userDecorator);
		GroupImpl g = UtilColecao.getElementoDoIndice(gruposDoUsuario, 0);
		println("Tem grupo: "+ (UtilObjeto.isReferencia(g)));
		
		// DEPLOY
		DeploymentDecorator decorator = new DeploymentDecorator();
		decorator.setClasspathJpdl("br/com/ap/test/jbpm/processo/criardisciplinagraduacao/" +
				"fluxo_criar_disciplina_graducao.jpdl.xml");
		
		DeploymentDecorator publicado = facade.publicar(decorator);
		assertNotNull(publicado.getId());
		println("Deploy: "+ publicado.getId());
		
		// CONSULTA AS DEFINIÇÕES DE PROCESSO
		Collection<ProcessDefinition> definicoes = facade.consultarDefinicaoDeProcesso();
		assertNotNull(definicoes);
		assertFalse(UtilColecao.isVazio(definicoes));
		
		print("Total: "+ definicoes.size());
		for (ProcessDefinition definicao : definicoes) {
			println("Id...: "+ definicao.getId());
			println("Name.: "+ definicao.getName());
		}
		
		//CRIANDO INSTÂNCIA DO PROCESSO
		ProcessDefinitionDecorator pd = new ProcessDefinitionDecorator();
		pd.setId("fluxo_criar_disciplina-1");
		ProcessInstance pi = facade.iniciarProcesso(pd);
		
		println(pi.isActive("task_fornecer_requisitos"));
		
		// LOCANDO A TAREFA
		Collection<TaskImpl> tarefas = facade.consultarTarefa();
		if (!UtilColecao.isVazio(tarefas)) {
			for (TaskImpl tarefa : tarefas) {
				println(tarefa.getId());
				println(tarefa.getAssignee());
			}
 		}
		
		TaskImpl tarefa = tarefas.iterator().next();
		TaskDecorator taskdecoration = new TaskDecorator();
		taskdecoration.setTaskImpl(tarefa);
		
		UserDecorator userdecorator = new UserDecorator();
		userdecorator.setGivenName("usuario_comissao_graduacao");
		
		facade.locarTarefa(taskdecoration, userdecorator);
		Collection<TaskImpl> tarefas2 = facade.consultarTarefa();
		if (!UtilColecao.isVazio(tarefas2)) {
			for (TaskImpl t2 : tarefas2) {
				println(t2.getId());
				println(t2.getAssignee());
			}
 		}
	}
}
