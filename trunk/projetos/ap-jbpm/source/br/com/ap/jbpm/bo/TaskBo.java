/**
 * TaskBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.Deployment;
import org.jbpm.api.Execution;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.springframework.stereotype.Component;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.TaskDao;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ExecutionDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;
import br.com.ap.jbpm.factory.DecoratorFactory;

/**
 * @author adriano.pamplona
 * 
 */
@Component
public class TaskBo extends CrudBoAbstrato<TaskImpl> {
	@Resource(name = "taskDaoImpl")
	private TaskDao			taskDao;

	@Resource
	private ExecutionBo		executionBo;

	@Resource
	private DeploymentBo	deploymentBo;

	public Collection<Task> consultarTarefa(UserDecorator user) {
		Collection<Task> resultado = null;
		if (UtilObjeto.isReferencia(user)) {
			resultado = taskDao.consultarTarefa(user);
		}
		return resultado;
	}

	public Collection<Task> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition) {
		Collection<Task> resultado = null;
		if (UtilObjeto.isReferenciaTodos(user, processDefinition)) {
			resultado = taskDao.consultarTarefa(user, processDefinition);
		}
		return resultado;
	}

	public void salvarTarefa(TaskDecorator task) {
		if (UtilObjeto.isReferencia(task)) {
			taskDao.salvarTarefa(task);
		}
	}

	public void cancelarTarefa(TaskDecorator task) {
		if (UtilObjeto.isReferencia(task)) {
			taskDao.cancelarTarefa(task);
		}
	}

	public void completarTarefa(TaskDecorator task) {
		if (UtilObjeto.isReferencia(task)) {
			taskDao.completarTarefa(task);
		}
	}

	public TaskDecorator obterFormulario(TaskDecorator task) {
		TaskDecorator resultado = null;
		if (UtilObjeto.isReferencia(task)) {
			Task tarefa = taskDao.obter(task.getId());
			String tarefaId = tarefa.getId();

			ExecutionDecorator executionDecorator = getDecoratorFactory().novoExecutionDecorator(
					tarefaId);
			Execution execucao = executionBo.obter(executionDecorator);

			String definicaoId = execucao.getProcessDefinitionId();
			ProcessDefinitionDecorator definicao = getDecoratorFactory()
					.novoProcessDefinitionDecorator(definicaoId);

			Deployment deployment = deploymentBo.obter(definicao.getId());
			DeploymentDecorator deploymentDecorator = getDecoratorFactory()
					.novoDeploymentDecorator(deployment);
			TaskDecorator taskDecorator = getDecoratorFactory().novoTaskDecorator(tarefa);
			resultado = deploymentBo.obterFormulario(deploymentDecorator, taskDecorator);
		}
		return resultado;
	}

	/**
	 * @return DecoratorFactory
	 */
	protected DecoratorFactory getDecoratorFactory() {
		return DecoratorFactory.getInstancia();
	}

	public void locarTarefa(TaskDecorator task, UserDecorator user) {

		if (!isTarefaLocada(task, user)) {
			taskDao.locarTarefa(task, user);
		}
	}

	public boolean isTarefaLocada(TaskDecorator task, UserDecorator user) {
		boolean resultado = false;
		if (UtilObjeto.isReferenciaTodos(task, user)) {
			Task tarefa = taskDao.obter(task.getId());

			resultado = UtilObjeto.isReferencia(tarefa)
					&& UtilString.isStringsIguais(tarefa.getAssignee(), user.getGivenName());
		}
		return resultado;
	}

	@Override
	protected TaskDao getDao() {
		return taskDao;
	}
}
