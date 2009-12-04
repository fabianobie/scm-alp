/**
 * JBPMFacadeImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

import br.com.ap.jbpm.bo.DeploymentBo;
import br.com.ap.jbpm.bo.ExecutionBo;
import br.com.ap.jbpm.bo.TaskBo;
import br.com.ap.jbpm.bo.UserBo;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * Implementação da JBPMFacade.
 * 
 * @author adriano.pamplona
 * @see JBPMFacade
 */
@Service
public class JBPMFacadeImpl implements JBPMFacade {
	@Resource
	private DeploymentBo	deploymentBo;

	@Resource
	private TaskBo			taskBo;

	@Resource
	private UserBo			userBo;

	@Resource
	private ExecutionBo		executionBo;

	@Override
	public void cancelarTarefa(TaskDecorator task) {
		taskBo.cancelarTarefa(task);
	}

	@Override
	public void completarTarefa(TaskDecorator task) {
		taskBo.completarTarefa(task);
	}

	@Override
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso() {
		return deploymentBo.consultarDefinicaoDeProcesso();
	}

	@Override
	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition) {
		return deploymentBo.obterDefinicaoDeProcesso(processDefinition);
	}

	@Override
	public Collection<TaskDecorator> consultarTarefa(UserDecorator user) {
		return taskBo.consultarTarefa(user);
	}

	@Override
	public Collection<Task> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition) {
		return taskBo.consultarTarefa(user, processDefinition);
	}

	@Override
	public boolean isUsuarioExiste(UserDecorator user) {
		return userBo.isUsuarioExiste(user);
	}

	@Override
	public TaskDecorator obterFormulario(TaskDecorator task) {
		return taskBo.obterFormulario(task);
	}

	@Override
	public TaskDecorator obterFormularioInicial(ProcessDefinitionDecorator processDefinition) {
		return deploymentBo.obterFormularioInicial(processDefinition);
	}

	@Override
	public UserDecorator obterUsuarioPeloNome(UserDecorator user) {
		return userBo.obterUsuarioPeloNome(user);
	}

	@Override
	public DeploymentDecorator publicar(DeploymentDecorator deployment) {
		return deploymentBo.publicar(deployment);
	}

	@Override
	public void salvarTarefa(TaskDecorator task) {
		taskBo.salvarTarefa(task);
	}

	@Override
	public void locarTarefa(TaskDecorator task, UserDecorator user) {
		taskBo.locarTarefa(task, user);
	}

	@Override
	public ProcessInstance iniciarProcesso(ProcessDefinitionDecorator processDefinition) {
		return executionBo.iniciarProcesso(processDefinition);
	}

	@Override
	public TaskDecorator obterTarefa(TaskDecorator task) {
		return taskBo.obterTarefa(task);
	}

	@Override
	public Map<String, Object> obterVariables(TaskDecorator task) {
		return taskBo.obterVariables(task);
	}

	@Override
	public Map<String, String> obterVariablesFormatadas(TaskDecorator task) {
		return taskBo.obterVariablesFormatadas(task);
	}

}
