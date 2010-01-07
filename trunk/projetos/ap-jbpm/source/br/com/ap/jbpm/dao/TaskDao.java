/**
 * TaskDao.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao;

import java.util.Collection;
import java.util.Map;

import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.task.TaskImpl;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.jbpm.decorator.TaskDecorator;

/**
 * DAO de acesso às informação da task.
 * 
 * @author adriano.pamplona
 */
public interface TaskDao extends CrudDao<TaskImpl> {
	/**
	 * Consulta as tarefas do usuário solicitado, incluindo as tarefas
	 * atribuídas a ninguém.
	 * 
	 * @param user Usuário
	 * @return tarefas
	 */
	public Collection<TaskDecorator> consultarTarefa(UserImpl user);

	/**
	 * Consulta as tarefas atribuídas a um usuário ou a ninguém de uma definição
	 * de processo específica.
	 * 
	 * @param user Usuário
	 * @param processDefinition Definição de processo
	 * @return tarefas
	 */
	public Collection<TaskDecorator> consultarTarefa(UserImpl user,
			ProcessDefinitionImpl processDefinition);

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
	public void locarTarefa(TaskDecorator task, UserImpl user);

	/**
	 * Retorna as variáveis a partir de uma tarefa.
	 * 
	 * @param task Tarefa com ID
	 * @return variáveis da tarefa.
	 */
	public Map<String, Object> obterVariables(TaskDecorator task);

	/**
	 * Retorna todas as tarefas.
	 * 
	 * @return todas as tarefas.
	 */
	public Collection<TaskDecorator> consultarTodos();

	/**
	 * Retorna true se o usuário tiver acesso à tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @param user Usuário com ID.
	 * @return true se o usuário tiver acesso à tarefa.
	 */
	public boolean isPossuiAcesso(TaskDecorator task, UserImpl user);
	
	/**
	 * Retorna true se qualquer usuário tiver acesso à tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @return true se qualquer usuário tiver acesso à tarefa.
	 */
	public boolean isPossuiAcesso(TaskDecorator task);
}
