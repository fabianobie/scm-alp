/**
 * DecoratorFactory.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.factory;

import org.jbpm.api.Deployment;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.identity.User;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.task.TaskImpl;

import br.com.ap.jbpm.decorator.ActivityDecorator;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ExecutionDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * Fábrica de decorators.
 * 
 * @author adriano.pamplona
 */
public final class DecoratorFactory {
	private static DecoratorFactory instancia = new DecoratorFactory();

	/**
	 * Construtor.
	 */
	private DecoratorFactory() {
		// Construtor.
	}

	/**
	 * @return instância única da classe.
	 */
	public static DecoratorFactory getInstancia() {
		return instancia;
	}

	/**
	 * @return Task
	 */
	public Task novaTask() {
		return new TaskImpl();
	}

	/**
	 * @return DeploymentDecorator
	 */
	public DeploymentDecorator novoDeploymentDecorator() {
		return new DeploymentDecorator();
	}

	/**
	 * @param deployment Deployment
	 * @return DeploymentDecorator
	 */
	public DeploymentDecorator novoDeploymentDecorator(Deployment deployment) {
		DeploymentDecorator decorator = novoDeploymentDecorator();
		decorator.setDeployment(deployment);
		return decorator;
	}

	/**
	 * @param id ID
	 * @return DeploymentDecorator
	 */
	public DeploymentDecorator novoDeploymentDecorator(String id) {
		DeploymentDecorator decorator = novoDeploymentDecorator();
		decorator.setId(id);
		return decorator;
	}

	/**
	 * @return ProcessDefinitionDecorator
	 */
	public ProcessDefinitionDecorator novoProcessDefinitionDecorator() {
		return new ProcessDefinitionDecorator();
	}

	/**
	 * @param id ID
	 * @return ProcessDefinitionDecorator
	 */
	public ProcessDefinitionDecorator novoProcessDefinitionDecorator(String id) {
		ProcessDefinitionDecorator decorator = novoProcessDefinitionDecorator();
		decorator.setId(id);
		return decorator;
	}

	/**
	 * @param processDefinition ProcessDefinition
	 * @return ProcessDefinitionDecorator
	 */
	public ProcessDefinitionDecorator novoProcessDefinitionDecorator(ProcessDefinition processDefinition) {
		ProcessDefinitionDecorator decorator = novoProcessDefinitionDecorator();
		decorator.setProcessDefinition(processDefinition);
		return decorator;
	}

	/**
	 * @return TaskDecorator
	 */
	public TaskDecorator novoTaskDecorator() {
		return new TaskDecorator();
	}

	/**
	 * @param task Tarefa
	 * @return TaskDecorator
	 */
	public TaskDecorator novoTaskDecorator(Task task) {
		TaskDecorator decorator = novoTaskDecorator();
		decorator.setTask(task);
		return decorator;
	}

	/**
	 * @return UserDecorator
	 */
	public UserDecorator novoUserDecorator() {
		return new UserDecorator();
	}

	/**
	 * @param user Usuário
	 * @return UserDecorator
	 */
	public UserDecorator novoUserDecorator(User user) {
		UserDecorator decorator = novoUserDecorator();
		decorator.setUser(user);
		return decorator;
	}

	/**
	 * @return ExecutionDecorator
	 */
	public ExecutionDecorator novoExecutionDecorator() {
		return new ExecutionDecorator();
	}

	/**
	 * @param id ID
	 * @return ExecutionDecorator
	 */
	public ExecutionDecorator novoExecutionDecorator(String id) {
		ExecutionDecorator decorator = novoExecutionDecorator();
		decorator.setId(id);
		return decorator;
	}
	
	/**
	 * @return ActivityDecorator
	 */
	public ActivityDecorator novaActivityDecorator() {
		return new ActivityDecorator();
	}

	/**
	 * @param nome Nome da atividade
	 * @return ActivityDecorator
	 */
	public ActivityDecorator novaActivityDecorator(String nome) {
		ActivityDecorator decorator = novaActivityDecorator();
		decorator.setName(nome);

		return decorator;
	}
}
