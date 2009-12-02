/**
 * JBPMFacadeTest.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.test.jbpm;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.colecao.UtilMapa;
import br.com.ap.comum.string.UtilString;
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
	private boolean print = true;
	
	
	public void testPublicar() {
		DeploymentDecorator decorator = new DeploymentDecorator();
		decorator.setClasspathJpdl("br/com/ap/test/jbpm/deploy/process.jpdl.xml");
		decorator.setClasspathImagem("br/com/ap/test/jbpm/deploy/process.png");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-start.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-conferir-demanda.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-solicitar-demanda.ftl");
		decorator.getColecaoClasspathFormulario().add("br/com/ap/test/jbpm/deploy/taskform-solicitar-informacao.ftl");
		
		decorator = getFacade().publicar(decorator);
		String id = decorator.getId();
		assertNotNull(id);
		
		print("Deploy: "+ decorator.getId());
	}
	
	public void testConsultarDefinicaoDeProcesso() {
		Collection<ProcessDefinition> definicoes = getFacade().consultarDefinicaoDeProcesso();
		assertNotNull(definicoes);
		assertFalse(UtilColecao.isVazio(definicoes));
		
		print("Total: "+ definicoes.size());
		for (ProcessDefinition definicao : definicoes) {
			print("Id...: "+ definicao.getId());
			print("Name.: "+ definicao.getName());
		}
	}
	
	public void testObterDefinicaoDeProcesso() {
		ProcessDefinitionDecorator decorator = new ProcessDefinitionDecorator();
		decorator.setId("SolicitarDemanda-1");
		
		ProcessDefinition processDefinition = getFacade().obterDefinicaoDeProcesso(decorator);
		assertNotNull(processDefinition);
		
		print("Id...: "+ processDefinition.getId());
		print("Name.: "+ processDefinition.getName());
	}
	
	public void testObterFormularioInicial() {
		ProcessDefinitionDecorator decorator = new ProcessDefinitionDecorator();
		decorator.setId("SolicitarDemanda-1");
		
		TaskDecorator taskDecorator = getFacade().obterFormularioInicial(decorator);
		assertNotNull(taskDecorator);
		
		print(taskDecorator.getTextoFormulario());
	}

	public void testIniciarProcesso() {
		ProcessDefinitionDecorator decorator = new ProcessDefinitionDecorator();
		decorator.setId("SolicitarDemanda-1");
		
		ProcessInstance processInstance = getFacade().iniciarProcesso(decorator);
		assertNotNull(processInstance);
		
		print(processInstance.getKey());
		print(processInstance.getId());
		print(processInstance.getState());
	}
	
	public void testLocarTarefa() {
		TaskDecorator task = new TaskDecorator();
		task.setId("1");
		
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		getFacade().locarTarefa(task, user);
		task = getFacade().obterTarefa(task);
		assertNotNull(task);
		
		print("assignee...: "+ task.getAssignee());
	}

	public void testConsultarTarefa() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		Collection<Task> tarefas = getFacade().consultarTarefa(user);
		assertFalse(UtilColecao.isVazio(tarefas));
		
		for (Task tarefa : tarefas) {
			print("tarefa id..: "+ tarefa.getId());
			print("assignee...: "+ tarefa.getAssignee());
			print("name.......: "+ tarefa.getName());
		}
	}

	public void testConsultarTarefa_user_processDefinition() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		ProcessDefinitionDecorator processDefinition = new ProcessDefinitionDecorator();
		processDefinition.setId("SolicitarDemanda-1");
		
		Collection<Task> tarefas = getFacade().consultarTarefa(user, processDefinition);
		assertFalse(UtilColecao.isVazio(tarefas));
		
		for (Task tarefa : tarefas) {
			print("tarefa id..: "+ tarefa.getId());
			print("assignee...: "+ tarefa.getAssignee());
			print("name.......: "+ tarefa.getName());
		}
	}
	
	public void testCancelarTarefa() {
		TaskDecorator task = new TaskDecorator();
		task.setId("1");
		getFacade().cancelarTarefa(task);
		
		task = getFacade().obterTarefa(task);
		assertTrue(UtilString.isVazio(task.getAssignee()));
		
		print("assignee...: "+ task.getAssignee());
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
		assertFalse(UtilMapa.isVazio(mapaVariables));
		print("Variables: "+ mapaVariables);
	}

	public void testObterVariablesFormatadas() {
		TaskDecorator task = new TaskDecorator();
		task.setId("1");

		Map<String, String> mapaVariables = getFacade().obterVariablesFormatadas(task);
		assertFalse(UtilMapa.isVazio(mapaVariables));
		Set<String> keys = mapaVariables.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			print(mapaVariables.get(key));
		}
	}
	
	public void testCompletarTarefa() {
		TaskDecorator task = new TaskDecorator();
		task.setId("1");
		
		getFacade().completarTarefa(task);
	}
	
	public void testObterFormulario() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		Collection<Task> tarefas = getFacade().consultarTarefa(user);
		Task tarefa = UtilColecao.getElementoDoIndice(tarefas, 0);
		
		TaskDecorator decorator = new TaskDecorator();
		decorator.setTask(tarefa);
		TaskDecorator resultado = getFacade().obterFormulario(decorator);
		assertNotNull(resultado);
		
		print(resultado.getTextoFormulario());
	}
	
	public void testObterUsuarioPeloNome() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		user = getFacade().obterUsuarioPeloNome(user);
		
		assertNotNull(user);
		print(user.getGivenName());
	}

	public void testIsUsuarioExiste() {
		UserDecorator user = new UserDecorator();
		user.setGivenName("alex");
		
		boolean existe = getFacade().isUsuarioExiste(user);
		assertTrue(existe);
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
	
	/**
	 * Imprime o texto na tela.
	 * @param texto
	 */
	private void print(String texto) {
		if (print) {
			System.out.println(texto);
		}
	}
}
