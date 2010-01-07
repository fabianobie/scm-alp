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
 * DAO de acesso �s informa��o da task.
 * 
 * @author adriano.pamplona
 */
public interface TaskDao extends CrudDao<TaskImpl> {
	/**
	 * Consulta as tarefas do usu�rio solicitado, incluindo as tarefas
	 * atribu�das a ningu�m.
	 * 
	 * @param user Usu�rio
	 * @return tarefas
	 */
	public Collection<TaskDecorator> consultarTarefa(UserImpl user);

	/**
	 * Consulta as tarefas atribu�das a um usu�rio ou a ningu�m de uma defini��o
	 * de processo espec�fica.
	 * 
	 * @param user Usu�rio
	 * @param processDefinition Defini��o de processo
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
	public void locarTarefa(TaskDecorator task, UserImpl user);

	/**
	 * Retorna as vari�veis a partir de uma tarefa.
	 * 
	 * @param task Tarefa com ID
	 * @return vari�veis da tarefa.
	 */
	public Map<String, Object> obterVariables(TaskDecorator task);

	/**
	 * Retorna todas as tarefas.
	 * 
	 * @return todas as tarefas.
	 */
	public Collection<TaskDecorator> consultarTodos();

	/**
	 * Retorna true se o usu�rio tiver acesso � tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @param user Usu�rio com ID.
	 * @return true se o usu�rio tiver acesso � tarefa.
	 */
	public boolean isPossuiAcesso(TaskDecorator task, UserImpl user);
	
	/**
	 * Retorna true se qualquer usu�rio tiver acesso � tarefa.
	 * 
	 * @param task Tarefa com ID.
	 * @return true se qualquer usu�rio tiver acesso � tarefa.
	 */
	public boolean isPossuiAcesso(TaskDecorator task);
}
