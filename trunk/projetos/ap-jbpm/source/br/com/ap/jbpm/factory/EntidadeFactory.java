/**
 * EntidadeFactory.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.factory;

import org.jbpm.pvm.internal.identity.impl.GroupImpl;
import org.jbpm.pvm.internal.identity.impl.MembershipImpl;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.jbpm.pvm.internal.task.TaskImpl;

/**
 * Fábrica de entidades.
 * 
 * @author adriano.pamplona
 */
public final class EntidadeFactory {
	private static EntidadeFactory	instancia	= new EntidadeFactory();

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
	public TaskImpl novaTask() {
		return new TaskImpl();
	}

	/**
	 * @return Deployment
	 */
	public DeploymentImpl novoDeployment() {
		return new DeploymentImpl();
	}

	/**
	 * @return ProcessDefinition
	 */
	public ProcessDefinitionImpl novoProcessDefinition() {
		return new ProcessDefinitionImpl();
	}

	/**
	 * @return User
	 */
	public UserImpl novoUser() {
		return new UserImpl();
	}

	/**
	 * @return Execution
	 */
	public ExecutionImpl novoExecution() {
		return new ExecutionImpl();
	}

	/**
	 * @return Activity
	 */
	public ActivityImpl novaActivity() {
		return new ActivityImpl();
	}

	/**
	 * @return Group
	 */
	public GroupImpl novoGroup() {
		return new GroupImpl();
	}

	/**
	 * @return MembershipImpl
	 */
	public MembershipImpl novoMembership() {
		return new MembershipImpl();
	}
}
