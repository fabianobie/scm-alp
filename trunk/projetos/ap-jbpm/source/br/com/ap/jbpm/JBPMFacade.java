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
	 * Publica um processo no repositório.
	 * 
	 * @param deployment Processo que será publicado.
	 * @return DeploymentDecorator
	 */
	public DeploymentDecorator publicar(DeploymentDecorator deployment);

	/**
	 * Consulta todas as definições de processo do repositório.
	 * 
	 * @return coleção de definições de processo.
	 */
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso();

	/**
	 * Retorna a definição de processo solicitada.
	 * 
	 * @param processDefinition Definição de processo com ID.
	 * @return definição solicitada.
	 */
	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition);

	/**
	 * Consulta as tarefas do usuário solicitado, incluindo as tarefas
	 * atribuídas a ninguém.
	 * 
	 * @param user Usuário
	 * @return tarefas
	 */
	public Collection<Task> consultarTarefa(UserDecorator user);

	/**
	 * Consulta as tarefas atribuídas a um usuário ou a ninguém de uma definição
	 * de processo específica.
	 * 
	 * @param user Usuário
	 * @param processDefinition Definição de processo
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
	 * parâmetro.
	 * 
	 * @param task Tarefa
	 */
	public void cancelarTarefa(TaskDecorator task);

	/**
	 * Completa a execução de uma tarefa e manda ela para o transitionTO
	 * informado.
	 * 
	 * @param task Tarefa
	 */
	public void completarTarefa(TaskDecorator task);

	/**
	 * Loca a tarefa para o usuário informado.
	 * 
	 * @param task Tarefa
	 * @param user Usuário
	 */
	public void locarTarefa(TaskDecorator task, UserDecorator user);

	/**
	 * Retorna o formulário da tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @return formulário da tarefa
	 */
	public TaskDecorator obterFormulario(TaskDecorator task);

	/**
	 * Retorna o formulário inicial de uma definição de processo.
	 * 
	 * @param processDefinition Definição de processo com ID.
	 * @return formulário inicial
	 */
	public TaskDecorator obterFormularioInicial(ProcessDefinitionDecorator processDefinition);

	/**
	 * Consulta o usuário pelo givenName.
	 * 
	 * @param user Usuário com givenName informado
	 * @return Usuário recuperado
	 */
	public UserDecorator obterUsuarioPeloNome(UserDecorator user);

	/**
	 * Retorna true se o usuário existir.
	 * 
	 * @param user Usuário com givenName informado
	 * @return true se o usuário existir.
	 */
	public boolean isUsuarioExiste(UserDecorator user);

	/**
	 * Inicia a execução de uma definição de processo.
	 * 
	 * @param processDefinition Definição de processo com ID
	 * @return instância do processo iniciado
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
	 * Retorna as variáveis a partir de uma tarefa.
	 * 
	 * @param task Tarefa com ID
	 * @return variáveis da tarefa.
	 */
	public Map<String, Object> obterVariables(TaskDecorator task);
}
