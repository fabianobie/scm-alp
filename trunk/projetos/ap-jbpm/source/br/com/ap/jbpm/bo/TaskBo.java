/**
 * TaskBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.Deployment;
import org.jbpm.api.Execution;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.springframework.stereotype.Component;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.TaskDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * BO respons�vel pelas regras de neg�cio de task.
 * 
 * @author adriano.pamplona
 */
@Component
public class TaskBo extends CrudBoAbstrato<TaskImpl> {

	@Resource(name = "taskDaoImpl")
	private TaskDao			taskDao;

	@Resource
	private ExecutionBo		executionBo;

	@Resource
	private DeploymentBo	deploymentBo;

	/**
	 * Consulta as tarefas do usu�rio solicitado, incluindo as tarefas
	 * atribu�das a ningu�m.
	 * 
	 * @param user Usu�rio
	 * @return tarefas
	 */
	public Collection<Task> consultarTarefa(UserDecorator user) {

		Collection<Task> resultado = null;
		if (isReferencia(user)) {
			resultado = getDao().consultarTarefa(user);
		}
		return resultado;
	}

	/**
	 * Consulta as tarefas atribu�das a um usu�rio ou a ningu�m de uma defini��o
	 * de processo espec�fica.
	 * 
	 * @param user Usu�rio
	 * @param processDefinition Defini��o de processo
	 * @return tarefas
	 */
	public Collection<Task> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition) {

		Collection<Task> resultado = null;
		if (isReferencia(user, processDefinition)) {
			resultado = getDao().consultarTarefa(user, processDefinition);
		}
		return resultado;
	}

	/**
	 * Salva a tarefa.
	 * 
	 * @param task Tarefa
	 */
	public void salvarTarefa(TaskDecorator task) {

		if (isReferencia(task)) {
			getDao().salvarTarefa(task);
		}
	}

	/**
	 * Cancela uma tarefa, ou seja, remove o assignee da tarefa passada por
	 * par�metro.
	 * 
	 * @param task Tarefa
	 */
	public void cancelarTarefa(TaskDecorator task) {

		if (isReferencia(task)) {
			getDao().cancelarTarefa(task);
		}
	}

	/**
	 * Completa a execu��o de uma tarefa e manda ela para o transitionTO
	 * informado.
	 * 
	 * @param task Tarefa
	 */
	public void completarTarefa(TaskDecorator task) {

		if (isReferencia(task)) {
			getDao().completarTarefa(task);
		}
	}

	/**
	 * Retorna o formul�rio da tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @return formul�rio da tarefa
	 */
	public TaskDecorator obterFormulario(TaskDecorator task) {

		TaskDecorator resultado = null;
		if (UtilObjeto.isReferencia(task)) {
			Task tarefa = getDao().obter(task.getId());
			Execution execucao = executionBo.obter(tarefa.getExecutionId());
			ProcessDefinition process = deploymentBo
					.obterDefinicaoDeProcesso(execucao);
			Deployment deployment = deploymentBo.obter(process
					.getDeploymentId());

			resultado = deploymentBo.obterFormulario(deployment, tarefa);
			resultado.setTask(tarefa);
		}
		return resultado;
	}

	/**
	 * Loca a tarefa para o usu�rio informado.
	 * 
	 * @param task Tarefa
	 * @param user Usu�rio
	 */
	public void locarTarefa(TaskDecorator task, UserDecorator user) {

		if (!isTarefaLocada(task, user)) {
			taskDao.locarTarefa(task, user);
		}
	}

	/**
	 * Retorna true se a tarefa estiver locada para o usu�rio.
	 * 
	 * @param task Tarefa com ID
	 * @param user Usu�rio com givenName
	 * @return true se a tarefa estiver locada para o usu�rio.
	 */
	public boolean isTarefaLocada(TaskDecorator task, UserDecorator user) {

		boolean resultado = false;
		if (isReferencia(task, user)) {
			Task tarefa = taskDao.obter(task.getId());

			String assignee = tarefa.getAssignee();
			String givenName = user.getGivenName();
			resultado = isReferencia(tarefa)
					&& UtilString.isStringsIguais(assignee, givenName);
		}
		return resultado;
	}

	/**
	 * Retorna a tarefa solicitada.
	 * 
	 * @param task Tarefa com ID.
	 * @return tarefa
	 */
	public TaskDecorator obterTarefa(TaskDecorator task) {
		TaskDecorator resultado = null;

		if (isReferencia(task)) {
			Task temp = obter(task.getId());
			resultado = novoTaskDecorator(temp);
		}
		return resultado;
	}

	/**
	 * Retorna as vari�veis a partir de uma tarefa.
	 * 
	 * @param task Tarefa com ID
	 * @return vari�veis da tarefa.
	 */
	public Map<String, Object> obterVariables(TaskDecorator task) {

		Map<String, Object> resultado = null;

		if (isReferencia(task)) {
			resultado = getDao().obterVariables(task);
		}
		return resultado;
	}

	@Override
	protected TaskDao getDao() {
		return taskDao;
	}
}
