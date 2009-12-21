/**
 * TaskBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.jbpm.api.Deployment;
import org.jbpm.api.Execution;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.springframework.stereotype.Component;

import br.com.ap.comum.colecao.Alterador;
import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.formatador.instancia.IFormatador;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.TaskDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;
import br.com.ap.jbpm.util.UtilConversor;

/**
 * BO respons�vel pelas regras de neg�cio de task.
 * 
 * @author adriano.pamplona
 */
@Component
public class TaskBo extends JBPMBoAbstrato<TaskImpl> {

	@Resource(name = "taskDaoImpl")
	private TaskDao			taskDao;

	@Resource
	private ExecutionBo		executionBo;

	@Resource
	private DeploymentBo	deploymentBo;

	/**
	 * Consultar todas as tarefas.
	 * 
	 * @return tarefas
	 */
	public Collection<TaskImpl> consultarTarefa() {
		return getCrudDao().consultar();
	}
	
	/**
	 * Consulta as tarefas do usu�rio solicitado, incluindo as tarefas
	 * atribu�das a ningu�m.
	 * 
	 * @param user Usu�rio
	 * @return tarefas
	 */
	public Collection<TaskDecorator> consultarTarefa(UserDecorator user) {

		Collection<TaskDecorator> resultado = null;
		if (isReferencia(user)) {
			Collection<TaskImpl> tasks = getCrudDao().consultarTarefa(user);
			resultado = UtilConversor.converter(tasks);
			consultarProcessDefinitionEVariables(resultado);
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
	public Collection<TaskDecorator> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition) {

		Collection<TaskDecorator> resultado = null;
		if (isReferencia(user, processDefinition)) {
			Collection<TaskImpl> tasks = getCrudDao().consultarTarefa(user, processDefinition);
			resultado = UtilConversor.converter(tasks);
			consultarProcessDefinitionEVariables(resultado);
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
			getCrudDao().salvarTarefa(task);
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
			getCrudDao().cancelarTarefa(task);
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
			getCrudDao().completarTarefa(task);
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
			TaskImpl tarefa = getCrudDao().obter(task.getId());
			Deployment deployment = obterDeployment(tarefa);

			resultado = deploymentBo.obterFormulario(deployment, tarefa);
			resultado.setTaskImpl(tarefa);
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
			TaskImpl tarefa = taskDao.obter(task.getId());

			String assignee = tarefa.getAssignee();
			String givenName = user.getGivenName();
			resultado = isReferencia(tarefa) && UtilString.isStringsIguais(assignee, givenName);
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
			TaskImpl temp = obter(task.getId());
			resultado = novoTaskDecorator(temp);
		}
		return resultado;
	}

	/**
	 * Retorna a tarefa solicitada.
	 * 
	 * @param task Tarefa com ID.
	 * @return tarefa
	 */
	public TaskDecorator obterTarefa(TaskImpl task) {
		TaskDecorator resultado = null;

		if (isReferencia(task)) {

			if (isVazio(task.getExecutionId())) {
				TaskImpl temp = obter(task.getId());
				resultado = novoTaskDecorator(temp);
			} else {
				resultado = novoTaskDecorator(task);
			}
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
			resultado = getCrudDao().obterVariables(task);
		}
		return resultado;
	}

	/**
	 * Retorna as vari�veis a partir de uma tarefa. Os valores retornados ser�o
	 * formatados.
	 * 
	 * @param task Tarefa com ID
	 * @return vari�veis da tarefa formatadas.
	 */
	public Map<String, String> obterVariablesFormatadas(TaskDecorator task) {

		Map<String, String> resultado = null;

		if (isReferencia(task)) {
			Map<String, Object> mapa = getCrudDao().obterVariables(task);
			Set<String> keys = mapa.keySet();
			Iterator<String> iterator = getColecaoFactory().novoIterator(keys);

			if (!UtilColecao.isVazio(keys)) {
				resultado = getColecaoFactory().novoHashMap();
				while (iterator.hasNext()) {
					String chave = iterator.next();
					String valorFormatado = formatar(mapa.get(chave));
					resultado.put(chave, valorFormatado);
				}
			}
		}
		return resultado;
	}

	/**
	 * Consulta ProcessDefinition e variables para cada task da cole��o.
	 * 
	 * @param resultado Cole��o de taskDecorator
	 */
	protected void consultarProcessDefinitionEVariables(Collection<TaskDecorator> resultado) {
		UtilColecao.aplicarAlterador(resultado, new Alterador<TaskDecorator>() {
			@Override
			public TaskDecorator alterar(TaskDecorator taskDecorator) {
				TaskImpl task = taskDecorator.getTaskImpl();

				ProcessDefinition processDefinition = obterProcessDefinition(task);
				taskDecorator.setProcessDefinition(processDefinition);

				Map<String, Object> variables = obterVariables(taskDecorator);
				taskDecorator.setMapaVariables(variables);
				return taskDecorator;
			}
		});
	}

	/**
	 * Retorna o deployment da task.
	 * 
	 * @param task Task
	 * @return deployment da task
	 */
	protected Deployment obterDeployment(TaskImpl task) {
		Deployment resultado = null;

		if (isReferencia(task)) {
			ProcessDefinition definition = obterProcessDefinition(task);
			String id = definition.getDeploymentId();
			resultado = deploymentBo.obter(id);
		}
		return resultado;
	}

	/**
	 * Retorna a defini��o do processo da task.
	 * 
	 * @param task Task
	 * @return defini��o do processo da task
	 */
	protected ProcessDefinition obterProcessDefinition(TaskImpl task) {
		ProcessDefinition resultado = null;

		if (isReferencia(task)) {
			Execution execution = obterExecution(task);
			resultado = deploymentBo.obterDefinicaoDeProcesso(execution);
		}
		return resultado;
	}

	/**
	 * Retorna a execution da task.
	 * 
	 * @param task Task
	 * @return execution da task
	 */
	protected Execution obterExecution(TaskImpl task) {
		Execution resultado = null;

		if (isReferencia(task)) {
			TaskDecorator taskDecorator = obterTarefa(task);
			String id = taskDecorator.getExecutionId();
			resultado = executionBo.obter(id);
		}
		return resultado;
	}

	/**
	 * Formata o objeto passado por par�metro.
	 * 
	 * @param objeto Objeto que ser� formatado.
	 * @return objeto formatado
	 */
	@SuppressWarnings("unchecked")
	private String formatar(Object objeto) {
		String resultado = null;

		if (isReferencia(objeto)) {
			Class classe = UtilObjeto.getClasse(objeto);
			IFormatador formatador = getUtilEstrategiaDeFormatadores().recuperar(classe);
			resultado = formatador.formatar(objeto);
		}
		return resultado;
	}

	@Override
	protected TaskDao getCrudDao() {
		return taskDao;
	}
	
}
