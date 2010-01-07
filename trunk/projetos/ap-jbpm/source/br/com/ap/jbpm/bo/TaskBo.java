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

import org.jbpm.api.Execution;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.springframework.stereotype.Component;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.formatador.instancia.IFormatador;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.TaskDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;
import br.com.ap.jbpm.util.UtilJbpmException;

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
	public Collection<TaskDecorator> consultarTarefa() {
		return getCrudDao().consultarTodos();
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
			UserImpl userImpl = user.getUserImpl();

			resultado = getCrudDao().consultarTarefa(userImpl);
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
			UserImpl userImpl = user.getUserImpl();
			ProcessDefinitionImpl processDefinitionImpl = processDefinition
					.getProcessDefinitionImpl();

			resultado = getCrudDao().consultarTarefa(userImpl,
					processDefinitionImpl);
		}
		return resultado;
	}

	/**
	 * Salva a tarefa.
	 * 
	 * @param task Tarefa
	 */
	public void salvarTarefa(TaskDecorator decorator) {

		if (isReferencia(decorator) && isPossuiAcesso(decorator)) {
			getCrudDao().salvarTarefa(decorator);
		}
	}

	/**
	 * Salva a tarefa. A tarefa somente ser� salva se o usu�rio tiver acesso �
	 * tarefa.
	 * 
	 * @param task Tarefa
	 * @param user Usu�rio
	 */
	public void salvarTarefa(TaskDecorator decorator, UserDecorator user) {

		if (isReferencia(decorator) && isPossuiAcesso(decorator, user)) {
			getCrudDao().salvarTarefa(decorator);
		}
	}

	/**
	 * Cancela uma tarefa, ou seja, remove o assignee da tarefa passada por
	 * par�metro.
	 * 
	 * @param task Tarefa
	 */
	public void cancelarTarefa(TaskDecorator decorator) {

		if (isReferencia(decorator) && isPossuiAcesso(decorator)) {
			getCrudDao().cancelarTarefa(decorator);
		}
	}

	/**
	 * Cancela uma tarefa, ou seja, remove o assignee da tarefa passada por
	 * par�metro. A tarefa somente ser� cancelada se o usu�rio tiver acesso �
	 * tarefa.
	 * 
	 * @param task Tarefa
	 * @param user Usu�rio
	 */
	public void cancelarTarefa(TaskDecorator decorator, UserDecorator user) {

		if (isReferencia(decorator) && isPossuiAcesso(decorator, user)) {
			getCrudDao().cancelarTarefa(decorator);
		}
	}

	/**
	 * Completa a execu��o de uma tarefa e manda ela para o transitionTO
	 * informado.
	 * 
	 * @param task Tarefa
	 */
	public void completarTarefa(TaskDecorator decorator) {

		if (isReferencia(decorator) && isPossuiAcesso(decorator)) {
			getCrudDao().completarTarefa(decorator);
		}
	}

	/**
	 * Completa a execu��o de uma tarefa e manda ela para o transitionTO
	 * informado. A tarefa somente ser� completada se o usu�rio tiver acesso �
	 * tarefa.
	 * 
	 * @param task Tarefa
	 * @param user Usu�rio
	 */
	public void completarTarefa(TaskDecorator decorator, UserDecorator user) {

		if (isReferencia(decorator) && isPossuiAcesso(decorator, user)) {
			getCrudDao().completarTarefa(decorator);
		}
	}

	/**
	 * Retorna o formul�rio da tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @return formul�rio da tarefa
	 */
	public TaskDecorator obterFormulario(TaskDecorator decorator) {

		TaskDecorator resultado = null;
		if (isReferencia(decorator)) {
			TaskImpl tarefa = getCrudDao().obter(decorator.getId());
			DeploymentImpl deployment = obterDeployment(tarefa);

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

		if (!isTarefaLocada(task, user) && isPossuiAcesso(task, user)) {
			UserImpl userImpl = user.getUserImpl();
			taskDao.locarTarefa(task, userImpl);
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
			resultado = isReferencia(tarefa)
					&& UtilString.isStringsIguais(assignee, givenName);
		}
		return resultado;
	}

	/**
	 * Retorna true se qualquer usu�rio tiver acesso � tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @return true se qualquer usu�rio tiver acesso � tarefa.
	 */
	public boolean isPossuiAcesso(TaskDecorator task) {
		if (!getCrudDao().isPossuiAcesso(task)) {
			throw UtilJbpmException.novaAcessoNaoPermitidoATarefa(task);
		}

		return true;
	}

	/**
	 * Retorna true se o usu�rio tiver acesso � tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @param user Usu�rio com ID.
	 * @return true se o usu�rio tiver acesso � tarefa.
	 */
	public boolean isPossuiAcesso(TaskDecorator task, UserDecorator user) {
		UserImpl userImpl = user.getUserImpl();
		if (!getCrudDao().isPossuiAcesso(task, userImpl)) {
			throw UtilJbpmException.novaUsuarioSemAcessoATarefa(task, userImpl);
		}

		return true;
	}

	/**
	 * Retorna a tarefa solicitada.
	 * 
	 * @param task Tarefa com ID.
	 * @return tarefa
	 */
	public TaskDecorator obterTarefa(TaskDecorator decorator) {
		TaskDecorator resultado = null;

		if (isReferencia(decorator)) {
			TaskImpl temp = obter(decorator.getId());
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
	 * @param decorator Tarefa com ID
	 * @return vari�veis da tarefa.
	 */
	public Map<String, Object> obterVariables(TaskDecorator decorator) {

		Map<String, Object> resultado = null;

		if (isReferencia(decorator)) {
			resultado = getCrudDao().obterVariables(decorator);
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
	public Map<String, String> obterVariablesFormatadas(TaskDecorator decorator) {

		Map<String, String> resultado = null;

		if (isReferencia(decorator)) {
			Map<String, Object> mapa = getCrudDao().obterVariables(decorator);
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
	 * Retorna o deployment da task.
	 * 
	 * @param task Task
	 * @return deployment da task
	 */
	protected DeploymentImpl obterDeployment(TaskImpl task) {
		DeploymentImpl resultado = null;

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
			IFormatador formatador = getUtilEstrategiaDeFormatadores()
					.recuperar(classe);
			resultado = formatador.formatar(objeto);
		}
		return resultado;
	}

	@Override
	protected TaskDao getCrudDao() {
		return taskDao;
	}

}
