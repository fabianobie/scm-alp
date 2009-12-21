/**
 * EntidadeFactory.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.factory;

import org.jbpm.api.Deployment;
import org.jbpm.api.Execution;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.pvm.internal.identity.impl.GroupImpl;
import org.jbpm.pvm.internal.identity.impl.MembershipImpl;
import org.jbpm.pvm.internal.identity.impl.UserImpl;
import org.jbpm.pvm.internal.model.Activity;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.jbpm.pvm.internal.task.TaskImpl;

/**
 * F�brica de entidades.
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
	 * @return inst�ncia �nica da classe.
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
	public UserImpl novoUser() {
		return new UserImpl();
	}

	/**
	 * @return Execution
	 */
	public Execution novoExecution() {
		return new ExecutionImpl();
	}

	/**
	 * @return Activity
	 */
	public Activity novaActivity() {
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
