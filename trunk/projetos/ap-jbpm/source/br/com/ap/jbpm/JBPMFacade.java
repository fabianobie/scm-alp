/**
 * JBPMFacade.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm;

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
 * Facade de interface aos recursos do JBPM.
 * 
 * @author adriano.pamplona
 */
public interface JBPMFacade {

	/**
	 * Publica um processo no reposit�rio.
	 * 
	 * @param deployment Processo que ser� publicado.
	 * @return DeploymentDecorator
	 */
	public DeploymentDecorator publicar(DeploymentDecorator deployment);

	/**
	 * Consulta todas as defini��es de processo do reposit�rio.
	 * 
	 * @return cole��o de defini��es de processo.
	 */
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso();

	/**
	 * Retorna a defini��o de processo solicitada.
	 * 
	 * @param processDefinition Defini��o de processo com ID.
	 * @return defini��o solicitada.
	 */
	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition);

	/**
	 * Consulta as tarefas do usu�rio solicitado, incluindo as tarefas
	 * atribu�das a ningu�m.
	 * 
	 * @param user Usu�rio
	 * @return tarefas
	 */
	public Collection<Task> consultarTarefa(UserDecorator user);

	/**
	 * Consulta as tarefas atribu�das a um usu�rio ou a ningu�m de uma defini��o
	 * de processo espec�fica.
	 * 
	 * @param user Usu�rio
	 * @param processDefinition Defini��o de processo
	 * @return tarefas
	 */
	public Collection<Task> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition);

	/**
	 * Salva a tarefa.
	 * 
	 * @param task Tarefa
	 */
	public void salvarTarefa(TaskDecorator task);

	/**
	 * Cancela uma tarefa, ou seja, remove o assignee da tarefa passada por
	 * par�metro.
	 * 
	 * @param task Tarefa
	 */
	public void cancelarTarefa(TaskDecorator task);

	/**
	 * Completa a execu��o de uma tarefa e manda ela para o transitionTO
	 * informado.
	 * 
	 * @param task Tarefa
	 */
	public void completarTarefa(TaskDecorator task);

	/**
	 * Loca a tarefa para o usu�rio informado.
	 * 
	 * @param task Tarefa
	 * @param user Usu�rio
	 */
	public void locarTarefa(TaskDecorator task, UserDecorator user);

	/**
	 * Retorna o formul�rio da tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @return formul�rio da tarefa
	 */
	public TaskDecorator obterFormulario(TaskDecorator task);

	/**
	 * Retorna o formul�rio inicial de uma defini��o de processo.
	 * 
	 * @param processDefinition Defini��o de processo com ID.
	 * @return formul�rio inicial
	 */
	public TaskDecorator obterFormularioInicial(ProcessDefinitionDecorator processDefinition);

	/**
	 * Consulta o usu�rio pelo givenName.
	 * 
	 * @param user Usu�rio com givenName informado
	 * @return Usu�rio recuperado
	 */
	public UserDecorator obterUsuarioPeloNome(UserDecorator user);

	/**
	 * Retorna true se o usu�rio existir.
	 * 
	 * @param user Usu�rio com givenName informado
	 * @return true se o usu�rio existir.
	 */
	public boolean isUsuarioExiste(UserDecorator user);

	/**
	 * Inicia a execu��o de uma defini��o de processo.
	 * 
	 * @param processDefinition Defini��o de processo com ID
	 * @return inst�ncia do processo iniciado
	 */
	public ProcessInstance iniciarProcesso(ProcessDefinitionDecorator processDefinition);

	/**
	 * Retorna a tarefa solicitada.
	 * 
	 * @param task Tarefa com ID
	 * @return tarefa solicitada.
	 */
	public TaskDecorator obterTarefa(TaskDecorator task);

	/**
	 * Retorna as vari�veis a partir de uma tarefa.
	 * 
	 * @param task Tarefa com ID
	 * @return vari�veis da tarefa.
	 */
	public Map<String, Object> obterVariables(TaskDecorator task);
}
