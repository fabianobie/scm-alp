/**
 * DecoratorFactory.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.factory;

import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.task.TaskImpl;

import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.decorator.UserDecorator;

/**
 * @author adriano.pamplona
 * 
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
	 * @return TaskDecorator
	 */
	public TaskDecorator novoTaskDecorator() {
		return new TaskDecorator();
	}

	/**
	 * @return UserDecorator
	 */
	public UserDecorator novoUserDecorator() {
		return new UserDecorator();
	}
}
