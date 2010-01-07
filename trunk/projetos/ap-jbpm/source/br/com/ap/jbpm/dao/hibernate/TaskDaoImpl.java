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
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.jbpm.api.TaskService;
import org.jbpm.pvm.internal.identity.impl.MembershipImpl;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.TaskDao;
import br.com.ap.jbpm.decorator.TaskDecorator;

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
		String transitionTO = task.getTransitionTO();

		if (UtilString.isVazio(transitionTO)) {
			taskService.completeTask(task.getId(), task.getMapaVariables());
		} else {
			taskService.completeTask(task.getId(), transitionTO, task
					.getMapaVariables());
		}
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#consultarTodos()
	 */
	@SuppressWarnings("unchecked")
	public Collection<TaskDecorator> consultarTodos() {
		Criteria criteria = novoCriteriaTask();
		Collection<TaskDecorator> resultado = criteria.list();
		carregarAtributosPadrao(resultado);
		return resultado;
	}
	
	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#consultarTarefa(org.jbpm.pvm.internal.identity.impl.UserImpl)
	 */
	@SuppressWarnings("unchecked")
	public Collection<TaskDecorator> consultarTarefa(UserImpl user) {

		Criteria criteria = novoCriteriaTask();
		aplicarFiltroDeGrupo(criteria, user);
		
		Collection<TaskDecorator> resultado = criteria.list();
		carregarAtributosPadrao(resultado);
		
		return resultado;
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#consultarTarefa(org.jbpm.pvm.internal.identity.impl.UserImpl,
	 *      org.jbpm.pvm.internal.model.ProcessDefinitionImpl)
	 */
	@SuppressWarnings("unchecked")
	public Collection<TaskDecorator> consultarTarefa(UserImpl user,
			ProcessDefinitionImpl processDefinition) {

		Criteria criteria = novoCriteriaTask();
		aplicarFiltroDeGrupo(criteria, user);
		aplicarFiltroDeProcessDefinition(criteria, processDefinition);

		Collection<TaskDecorator> resultado = criteria.list();
		carregarAtributosPadrao(resultado);
		
		return resultado;
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#salvarTarefa(br.com.ap.jbpm.decorator.TaskDecorator)
	 */
	public void salvarTarefa(TaskDecorator task) {

		taskService.setVariables(task.getId(), task.getMapaVariables());
	}

	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#locarTarefa(br.com.ap.jbpm.decorator.TaskDecorator,
	 *      org.jbpm.pvm.internal.identity.impl.UserImpl)
	 */
	public void locarTarefa(TaskDecorator task, UserImpl user) {

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
		Map<String, Object> resultado = getColecaoFactory().novoHashMap();
		String id = task.getId();
		Set<String> nomes = taskService.getVariableNames(id);
		if (!UtilColecao.isVazio(nomes)) {
			for (String nome : nomes) {
				resultado.put(nome, taskService.getVariable(id, nome));
			}
		}
		return resultado;
	}
	
	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#isPossuiAcesso(br.com.ap.jbpm.decorator.TaskDecorator, org.jbpm.pvm.internal.identity.impl.UserImpl)
	 */
	public boolean isPossuiAcesso(TaskDecorator task, UserImpl user) {
		Criteria criteria = novoCriteria();
		criteria.setProjection(Projections.count("dbid"));
		criteria.add(novoCriterioEQ("dbid", new Long(task.getId())));
		aplicarFiltroDeGrupo(criteria, user);
		Number resultado = (Number) criteria.uniqueResult();
		
		return (resultado.intValue() > 0);
	}
	
	/**
	 * @see br.com.ap.jbpm.dao.TaskDao#isPossuiAcesso(br.com.ap.jbpm.decorator.TaskDecorator)
	 */
	public boolean isPossuiAcesso(TaskDecorator task) {
		Criteria criteria = novoCriteria();
		criteria.setProjection(Projections.count("dbid"));
		criteria.add(novoCriterioEQ("dbid", new Long(task.getId())));
		aplicarFiltroDeGrupo(criteria);
		
		Number resultado = (Number) criteria.uniqueResult();
		
		return (resultado.intValue() > 0);
	}
	
	/**
	 * @return novo criteria de TaskImpl
	 */
	private Criteria novoCriteriaTask() {
		Criteria criteria = novoCriteria("taskImpl");
		criteria.setFetchMode("variables", FetchMode.JOIN);
		criteria.setResultTransformer(new AliasToBeanResultTransformer(TaskDecorator.class));
		return criteria;
	}
	
	/**
	 * Filtra as tarefas que forem do tipo de process definition passado por parâmetro.
	 * 
	 * @param criteria Criteria(TaskImpl)
	 * @param processDefinition Process Definition com ID
	 */
	private void aplicarFiltroDeProcessDefinition(Criteria criteria,
			ProcessDefinitionImpl processDefinition) {
		
		if (isReferencia(processDefinition) && !isVazio(processDefinition.getId())) {
			String id = processDefinition.getId();
			
			criteria.setFetchMode("execution", FetchMode.JOIN);
			Criteria execution = criteria.createCriteria("execution", Criteria.LEFT_JOIN);
			execution.add(Restrictions.eq("processDefinitionId", id));
		}
	}

	/**
	 * Filtra as tarefas que forem permitidas ao usuário.
	 * @param criteria Criteria(TaskImpl)
	 * @param user Usuário
	 */
	private void aplicarFiltroDeGrupo(Criteria criteria, UserImpl user) {
		
		if (isReferencia(user) && !isVazio(user.getId())) {
			criteria.setFetchMode("participations", FetchMode.JOIN);
			
			DetachedCriteria grupos = DetachedCriteria.forClass(MembershipImpl.class);
			grupos.createAlias("user", "user");
			grupos.createAlias("group", "group");
			grupos.setProjection(Projections.property("group.id"));
			grupos.add(Restrictions.eq("user.id", user.getId()));
			
			Criteria participations = criteria.createCriteria("participations", Criteria.LEFT_JOIN);
			LogicalExpression or = Restrictions.or(
					Property.forName("groupId").in(grupos), 
					Restrictions.isNull("groupId"));
			participations.add(or);
		}
	}

	/**
	 * Filtra as tarefas que forem permitidas à qualquer usuário.
	 * @param criteria Criteria(TaskImpl)
	 */
	private void aplicarFiltroDeGrupo(Criteria criteria) {
		
		criteria.setFetchMode("participations", FetchMode.JOIN);
		Criteria participations = criteria.createCriteria("participations", Criteria.LEFT_JOIN);
		participations.add(Restrictions.isNull("groupId"));
	}

	
	/**
	 * Carrega os atributos padrão da TaskImpl.
	 * 
	 * @param colecao Coleção de TaskDecorator.
	 */
	private void carregarAtributosPadrao(Collection<TaskDecorator> colecao) {
		String[] atributos = new String[2];
		atributos[0] = "taskImpl.variables";
		atributos[1] = "taskImpl.execution.processDefinition";
		
		invocarGet(colecao, atributos);
	}

}
