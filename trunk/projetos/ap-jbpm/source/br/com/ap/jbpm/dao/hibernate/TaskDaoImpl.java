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
import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.TaskDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * DAO de acesso às informação de tarefa.
 * 
 * @author adriano.pamplona
 */
@Repository
public class TaskDaoImpl extends JBPMDaoAbstrato<TaskImpl> implements TaskDao {

	@Resource
	private TaskService	taskService;

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#cancelarTarefa(br.com.ap.jbpm.decorator.TaskDecorator)
	 */
	public void cancelarTarefa(TaskDecorator task) {
		taskService.assignTask(task.getId(), null);
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#completarTarefa(br.com.ap.jbpm.decorator.TaskDecorator)
	 */
	public void completarTarefa(TaskDecorator task) {
		taskService.completeTask(task.getId(), task.getMapaVariables());
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#consultarTarefa(br.com.ap.jbpm.decorator.UserDecorator)
	 */
	@SuppressWarnings("unchecked")
	public Collection<Task> consultarTarefa(UserDecorator user) {
		
		String givenName = user.getGivenName();
		
		Criteria criteria = novoCriteria();
		criteria.add(Restrictions.or(
				Restrictions.eq("assignee", givenName), 
				Restrictions.isNull("assignee")));
		return criteria.list();
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#consultarTarefa(br.com.ap.jbpm.decorator.UserDecorator, br.com.ap.jbpm.decorator.ProcessDefinitionDecorator)
	 */
	@SuppressWarnings("unchecked")
	public Collection<Task> consultarTarefa(UserDecorator user,
			ProcessDefinitionDecorator processDefinition) {

		String givenName = user.getGivenName();
		
		Criteria criteria = novoCriteria();
		criteria.add(Restrictions.or(
				Restrictions.eq("assignee", givenName), 
				Restrictions.isNull("assignee")));
		Criteria execution = criteria.createCriteria("execution");
		execution.add(Restrictions.eq("processDefinitionId", processDefinition.getId()));
		return criteria.list();
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#salvarTarefa(br.com.ap.jbpm.decorator.TaskDecorator)
	 */
	public void salvarTarefa(TaskDecorator task) {

		taskService.setVariables(task.getId(), task.getMapaVariables());
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#locarTarefa(br.com.ap.jbpm.decorator.TaskDecorator, br.com.ap.jbpm.decorator.UserDecorator)
	 */
	public void locarTarefa(TaskDecorator task, UserDecorator user) {
		
		taskService.takeTask(task.getId(), user.getGivenName());
	}

	/**
	 * @see br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato#obter(java.io.Serializable)
	 */
	@Override
	public TaskImpl obter(Serializable id) {
		String stringId = UtilString.getString(id);
		return (TaskImpl) taskService.getTask(stringId);
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#obterVariables(br.com.ap.jbpm.decorator.TaskDecorator)
	 */
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
