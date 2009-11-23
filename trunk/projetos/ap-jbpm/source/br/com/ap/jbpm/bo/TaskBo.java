/**
 * TaskBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.task.Task;
import org.springframework.stereotype.Component;

import br.com.ap.jbpm.dao.TaskDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Component
public class TaskBo {
	@Resource(name = "taskDaoImpl.java")
	private TaskDao taskDao;

	public Collection<Task> consultarTarefa(UserDecorator user) {
		return taskDao.consultarTarefa(user);
	}

	public Collection<Task> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition) {
		return taskDao.consultarTarefa(user, processDefinition);
	}

	public void salvarTarefa(TaskDecorator task) {
		taskDao.salvarTarefa(task);
	}

	public void cancelarTarefa(TaskDecorator task) {
		taskDao.cancelarTarefa(task);
	}

	public void completarTarefa(TaskDecorator task) {
		taskDao.completarTarefa(task);
	}

	public TaskDecorator obterFormulario(TaskDecorator task) {
		return taskDao.obterFormulario(task);
	}
}
