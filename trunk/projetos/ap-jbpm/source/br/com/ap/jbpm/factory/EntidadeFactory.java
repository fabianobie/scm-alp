/**
 * EntidadeFactory.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.factory;

import org.jbpm.api.Deployment;
import org.jbpm.api.Execution;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.identity.User;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.jbpm.pvm.internal.task.TaskImpl;

/**
 * @author adriano.pamplona
 * 
 */
public final class EntidadeFactory {
	private static EntidadeFactory instancia = new EntidadeFactory();

	/**
	 * Construtor.
	 */
	private EntidadeFactory() {
		// Construtor.
	}

	/**
	 * @return instância única da classe.
	 */
	public static EntidadeFactory getInstancia() {
		return instancia;
	}

	/**
	 * @return Task
	 */
	public Task novaTask() {
		return new TaskImpl();
	}

	/**
	 * @return Deployment
	 */
	public Deployment novoDeployment() {
		return new DeploymentImpl();
	}

	/**
	 * @return ProcessDefinition
	 */
	public ProcessDefinition novoProcessDefinition() {
		return new ProcessDefinitionImpl();
	}

	/**
	 * @return User
	 */
	public User novoUser() {
		return new UserImpl();
	}

	/**
	 * @return Execution
	 */
	public Execution novoExecution() {
		return new ExecutionImpl();
	}
}
