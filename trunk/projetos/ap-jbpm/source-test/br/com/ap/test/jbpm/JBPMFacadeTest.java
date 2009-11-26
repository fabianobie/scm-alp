/**
 * JBPMFacadeTest.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.test.jbpm;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.jbpm.JBPMFacade;
import br.com.ap.jbpm.JBPMFacadeImpl;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * @author adriano.pamplona
 */
public class JBPMFacadeTest extends TestCase {
	private static ClassPathXmlApplicationContext contexto;
	
	public void testPublicar() {
		DeploymentDecorator decorator = new DeploymentDecorator();
		decorator.setClasspathJpdl("br/com/ap/test/jbpm/deploy/process.jpdl.xml");
		decorator.setClasspathImagem("br/com/ap/test/jbpm/deploy/process.png");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-start.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-conferir-demanda.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-solicitar-demanda.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-solicitar-informacao.ftl");
		
		decorator = getFacade().publicar(decorator);
		System.out.println("Deploy: "+ decorator.getId());
	}
	
	public void testConsultarDefinicaoDeProcesso() {
		Collection<ProcessDefinition> definicoes = getFacade().consultarDefinicaoDeProcesso();
		System.out.println("Total: "+ definicoes.size());
		for (ProcessDefinition definicao : definicoes) {
			System.out.println("Id...: "+ definicao.getId());
			System.out.println("Name.: "+ definicao.getName());
		}
	}
	
	public void testObterDefinicaoDeProcesso() {
		ProcessDefinitionDecorator decorator = new ProcessDefinitionDecorator();
		decorator.setId("SolicitarDemanda-1");
		
		ProcessDefinition processDefinition = getFacade().obterDefinicaoDeProcesso(decorator);
		System.out.println("Id...: "+ processDefinition.getId());
		System.out.println("Name.: "+ processDefinition.getName());
	}
	
	public void testObterFormularioInicial() {
		ProcessDefinitionDecorator decorator = new ProcessDefinitionDecorator();
		decorator.setId("SolicitarDemanda-1");
		
		TaskDecorator taskDecorator = getFacade().obterFormularioInicial(decorator);
		System.out.println(taskDecorator.getTextoFormulario());
	}

	public void testIniciarProcesso() {
		ProcessDefinitionDecorator decorator = new ProcessDefinitionDecorator();
		decorator.setId("SolicitarDemanda-1");
		
		ProcessInstance processInstance = getFacade().iniciarProcesso(decorator);
		System.out.println(processInstance.getKey());
		System.out.println(processInstance.getId());
		System.out.println(processInstance.getState());
	}
	
	public void testLocarTarefa() {
		TaskDecorator task = new TaskDecorator();
		task.setId("1");
		
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		getFacade().locarTarefa(task, user);
		task = getFacade().obterTarefa(task);
		System.out.println("assignee...: "+ task.getAssignee());
	}

	public void testConsultarTarefa() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		Collection<Task> tarefas = getFacade().consultarTarefa(user);
		for (Task tarefa : tarefas) {
			System.out.println("tarefa id..: "+ tarefa.getId());
			System.out.println("assignee...: "+ tarefa.getAssignee());
			System.out.println("name.......: "+ tarefa.getName());
		}
	}

	public void testConsultarTarefa_user_processDefinition() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		ProcessDefinitionDecorator processDefinition = new ProcessDefinitionDecorator();
		processDefinition.setId("SolicitarDemanda-1");
		
		Collection<Task> tarefas = getFacade().consultarTarefa(user, processDefinition);
		for (Task tarefa : tarefas) {
			System.out.println("tarefa id..: "+ tarefa.getId());
			System.out.println("assignee...: "+ tarefa.getAssignee());
			System.out.println("name.......: "+ tarefa.getName());
		}
	}
	
	public void testCancelarTarefa() {
		TaskDecorator task = new TaskDecorator();
		task.setId("1");
		getFacade().cancelarTarefa(task);
		
		task = getFacade().obterTarefa(task);
		System.out.println("assignee...: "+ task.getAssignee());
	}
	
	public void testSalvarTarefa() {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("data", new Date());
		variables.put("nome", "Adriano");
		
		TaskDecorator task = new TaskDecorator();
		task.setId("1");
		task.setMapaVariables(variables);
		
		getFacade().salvarTarefa(task);
	}

	public void testObterVariablesTarefa() {
		TaskDecorator task = new TaskDecorator();
		task.setId("1");
		
		Map<String, Object> mapaVariables = getFacade().obterVariables(task);
		System.out.println("Variables: "+ mapaVariables);
	}
	
	public void testCompletarTarefa() {
		TaskDecorator task = new TaskDecorator();
		task.setId("1");
		
		getFacade().completarTarefa(task);
	}
	
	public void testObterFormulario() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		TaskService taskService = (TaskService) getContexto().getBean("taskService");
		TaskQuery query = taskService.createTaskQuery();
		List<Task> tarefas = query.list();
		Task tarefa = UtilColecao.getElementoDoIndice(tarefas, 0);
		
		TaskDecorator decorator = new TaskDecorator();
		decorator.setTask(tarefa);
		TaskDecorator resultado = getFacade().obterFormulario(decorator);
		System.out.println(resultado.getTextoFormulario());
	}
	
	public void testObterUsuarioPeloNome() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		user = getFacade().obterUsuarioPeloNome(user);
		System.out.println(user.getGivenName());
	}

	public void testIsUsuarioExiste() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		boolean existe = getFacade().isUsuarioExiste(user);
		System.out.println(existe);
	}
	
	
	/**
	 * @return JBPMFacade
	 */
	private JBPMFacade getFacade() {
		return (JBPMFacade) getContexto().getBean(JBPMFacadeImpl.class.getSimpleName());
	}
	
	/**
	 * @return ClassPathXmlApplicationContext
	 */
	private ClassPathXmlApplicationContext getContexto() {
		if (contexto == null) {
			contexto = new ClassPathXmlApplicationContext("ap-jbpm-application-context.xml");
		}
		return contexto;
	}
}
