/**
 * JBPMFacade.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.facade;

import java.util.Collection;
import java.util.Map;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;

import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * @author adriano.pamplona
 */
public interface JBPMFacade {
	
	public DeploymentDecorator publicar(DeploymentDecorator deployment);
	
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso();
	
	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition);
	
	public Collection<Task> consultarTarefa(UserDecorator user);
	
	public Collection<Task> consultarTarefa(UserDecorator user, ProcessDefinitionDecorator processDefinition);
	
	public void salvarTarefa(TaskDecorator task);
	
	public void cancelarTarefa(TaskDecorator task);
	
	public void completarTarefa(TaskDecorator task);
	
	public void locarTarefa(TaskDecorator task, UserDecorator user);
	
	public TaskDecorator obterFormulario(TaskDecorator task);
	
	public TaskDecorator obterFormularioInicial(ProcessDefinitionDecorator processDefinition);
	
	public UserDecorator obterUsuarioPeloNome(UserDecorator user);
	
	public boolean isUsuarioExiste(UserDecorator user);
	
	public ProcessInstance iniciarProcesso(ProcessDefinitionDecorator processDefinition);

	public TaskDecorator obterTarefa(TaskDecorator task);

	public Map<String, Object> obterVariables(TaskDecorator task);
}
