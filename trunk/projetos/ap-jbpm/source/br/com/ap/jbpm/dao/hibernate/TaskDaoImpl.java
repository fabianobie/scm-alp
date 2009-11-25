/**
 * TaskDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.jbpm.dao.TaskDao;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Repository
public class TaskDaoImpl extends HibernateCrudDaoAbstrato<TaskImpl> implements
		TaskDao {
	
	@Resource
	private TaskService taskService;

	@Override
	public void cancelarTarefa(TaskDecorator task) {
		taskService.assignTask(task.getId(), null);
	}

	@Override
	public void completarTarefa(TaskDecorator task) {
		taskService.completeTask(task.getId(), task.getMapaVariables());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Task> consultarTarefa(UserDecorator user) {
		
		Criteria criteria = novoCriteria();
		criteria.add(
			Restrictions.or(
				Restrictions.eq("assignee", user.getGivenName()),
				Restrictions.isNull("assignee"))
			);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Task> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition) {
		
		Criteria criteria = novoCriteria();
		criteria.add(
			Restrictions.or(
				Restrictions.eq("assignee", user.getGivenName()),
				Restrictions.isNull("assignee"))
			);
		Criteria execution = criteria.createCriteria("execution");
		execution.add(Restrictions.eq("processDefinitionId", processDefinition.getId()));
		return criteria.list();
	}

	@Override
	public TaskDecorator obterFormulario(DeploymentDecorator deployment, TaskDecorator task) {
		
		return null;
	}

	@Override
	public void salvarTarefa(TaskDecorator task) {
		
		taskService.setVariables(task.getId(), task.getMapaVariables());
	}

	@Override
	public void locarTarefa(TaskDecorator task, UserDecorator user) {
		taskService.assignTask(task.getId(), user.getGivenName());
		//taskService.takeTask(task.getId(), user.getGivenName());
	}
	
	@Override
	public TaskImpl obter(Serializable id) {
		return (TaskImpl) taskService.getTask((String) id);
	}
	
	public Map<String, Object> obterVariables(TaskDecorator task) {
		Map<String, Object> resultado = null;
		String id = task.getId();
		Set<String> nomes = taskService.getVariableNames(id);
		if (!UtilColecao.isVazio(nomes)) {
			resultado = getColecaoFactory().novoHashMap();
			for (String nome : nomes) {
				resultado.put(nome, taskService.getVariable(id, nome));
			}
		}
		return resultado;
	}
}
