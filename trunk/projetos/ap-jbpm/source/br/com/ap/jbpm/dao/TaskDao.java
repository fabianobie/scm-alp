/**
 * TaskDao.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao;

import java.util.Collection;

import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.task.TaskImpl;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * @author adriano.pamplona
 * 
 */
public interface TaskDao extends CrudDao<TaskImpl> {

	public Collection<Task> consultarTarefa(UserDecorator user);
	
	public Collection<Task> consultarTarefa(UserDecorator user, ProcessDefinitionDecorator processDefinition);
	
	public void salvarTarefa(TaskDecorator task);
	
	public void cancelarTarefa(TaskDecorator task);
	
	public void completarTarefa(TaskDecorator task);
	
	public TaskDecorator obterFormulario(TaskDecorator task);
}
