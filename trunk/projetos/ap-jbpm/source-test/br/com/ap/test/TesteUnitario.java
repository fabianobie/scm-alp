/**
 * TesteUnitario.java
 *
 * Data: 01/12/2009
 */
package br.com.ap.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.cmd.Environment;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.env.EnvironmentFactory;
import org.jbpm.pvm.internal.task.TaskImpl;

/**
 * @author adriano.pamplona
 *
 */
public class TesteUnitario extends TesteAbstrato {

	/**
	 * @throws Exception
	 */
	public void test() throws Exception {
		String taskId = "2";
		
		//getTaskService().assignTask(taskId, null);
		imprimirTarefasPeloServico();
		
		//String processDefinitionId = "SolicitarDemanda-1";
		//ProcessInstance pi = getExecutionService().startProcessInstanceById(processDefinitionId);
		//getTaskService().takeTask(taskId, "alex");
		imprimirTarefasPeloHQL();
		imprimirTarefasPeloSession();
	}

	private void imprimirTarefasPeloServico() {
		System.out.println(">>>>> imprimirTarefasPeloServico");
		TaskQuery query = getTaskService().createTaskQuery();
		List<Task> tasks = query.list();
		for (Task task : tasks) {
			System.out.println("id......: "+ task.getId());
			System.out.println("name....: "+ task.getName());
			System.out.println("activity: "+ task.getActivityName());
			System.out.println("assignee: "+ task.getAssignee());
		}
	}

	private void imprimirTarefasPeloHQL() {
		System.out.println(">>>>> imprimirTarefasPeloHQL");
		EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine;

		Environment environment = environmentFactory.openEnvironment();
		Session session = environment.get(Session.class);
		Criteria criteria = session.createCriteria(TaskImpl.class);
		List<Task> tasks = criteria.list();
		for (Task task : tasks) {
			System.out.println("id......: "+ task.getId());
			System.out.println("name....: "+ task.getName());
			System.out.println("activity: "+ task.getActivityName());
			System.out.println("assignee: "+ task.getAssignee());
		}
	}

	private void imprimirTarefasPeloSession() {
		System.out.println(">>>>> imprimirTarefasPeloSession");
		SessionFactory sf = (SessionFactory) getContext().getBean("jbpmSessionFactory");
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(TaskImpl.class);
		List<Task> tasks = criteria.list();
		for (Task task : tasks) {
			System.out.println("id......: "+ task.getId());
			System.out.println("name....: "+ task.getName());
			System.out.println("activity: "+ task.getActivityName());
			System.out.println("assignee: "+ task.getAssignee());
		}
	}
	
	private void x() {
		EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine;

		Environment environment = environmentFactory.openEnvironment();
		Session session = environment.get(Session.class);
		Criteria criteria = session.createCriteria(TaskImpl.class);
		List list = criteria.list();
		System.out.print(list);
		//SpringConfiguration s = (SpringConfiguration) getContext().getBean("jbpmConfiguration");
		//DbSession dbSession = s.get(DbSessionImpl.class);
		//System.out.println(dbSession);
		//environment.get(DbSession.class)
	}
}
 