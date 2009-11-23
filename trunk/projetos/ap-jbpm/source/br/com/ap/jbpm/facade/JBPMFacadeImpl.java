/**
 * JBPMFacadeImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.facade;

import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

import br.com.ap.jbpm.bo.DeploymentBo;
import br.com.ap.jbpm.bo.TaskBo;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Service
public class JBPMFacadeImpl implements JBPMFacade {
	@Resource
	private DeploymentBo deploymentBo;

	@Resource
	private TaskBo taskBo;

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
	public ProcessDefinition obterDefinicaoDeProcesso(
			ProcessDefinitionDecorator processDefinition) {
		return deploymentBo.obterDefinicaoDeProcesso(processDefinition);
	}

	@Override
	public Collection<Task> consultarTarefa(UserDecorator user) {
		return taskBo.consultarTarefa(user);
	}

	@Override
	public Collection<Task> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition) {
		return taskBo.consultarTarefa(user, processDefinition);
	}

	@Override
	public boolean isUsuarioExiste(UserDecorator user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TaskDecorator obterFormulario(TaskDecorator task) {
		return taskBo.obterFormulario(task);
	}

	@Override
	public ProcessDefinitionDecorator obterFormularioInicial(
			ProcessDefinitionDecorator processDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDecorator obterUsuario(UserDecorator user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeploymentDecorator publicar(DeploymentDecorator deployment) {
		return deploymentBo.publicar(deployment);
	}

	@Override
	public void salvarTarefa(TaskDecorator task) {
		taskBo.salvarTarefa(task);
	}

}
