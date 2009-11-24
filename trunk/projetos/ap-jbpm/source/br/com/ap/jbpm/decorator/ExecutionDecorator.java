/**
 * ExecutionDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.jbpm.api.Execution;

/**
 * @author adriano.pamplona
 */
public class ExecutionDecorator extends JbpmDecoratorAbstrato {
	private Execution	execution;
	private String		id;

	/**
	 * @return
	 * @see org.jbpm.api.Execution#findActiveActivityNames()
	 */
	public Set<String> findActiveActivityNames() {
		return getExecution().findActiveActivityNames();
	}

	/**
	 * @param activityName
	 * @return
	 * @see org.jbpm.api.Execution#findActiveExecutionIn(java.lang.String)
	 */
	public Execution findActiveExecutionIn(String activityName) {
		return getExecution().findActiveExecutionIn(activityName);
	}

	/**
	 * @param name
	 * @return
	 * @see org.jbpm.api.Execution#getExecution(java.lang.String)
	 */
	public Execution getExecution(String name) {
		return getExecution().getExecution(name);
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getExecutions()
	 */
	public Collection<? extends Execution> getExecutions() {
		return getExecution().getExecutions();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getExecutionsMap()
	 */
	public Map<String, Execution> getExecutionsMap() {
		return getExecution().getExecutionsMap();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getId()
	 */
	public String getId() {
		String resultado = getExecution().getId();
		if (isVazio(resultado)) {
			resultado = id;
		}
		return resultado;
	}

	/**
	 * @param id Atribui id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getKey()
	 */
	public String getKey() {
		return getExecution().getKey();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getName()
	 */
	public String getName() {
		return getExecution().getName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getParent()
	 */
	public Execution getParent() {
		return getExecution().getParent();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getPriority()
	 */
	public int getPriority() {
		return getExecution().getPriority();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getProcessDefinitionId()
	 */
	public String getProcessDefinitionId() {
		return getExecution().getProcessDefinitionId();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getProcessInstance()
	 */
	public Execution getProcessInstance() {
		return getExecution().getProcessInstance();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getState()
	 */
	public String getState() {
		return getExecution().getState();
	}

	/**
	 * @param executionName
	 * @return
	 * @see org.jbpm.api.Execution#hasExecution(java.lang.String)
	 */
	public boolean hasExecution(String executionName) {
		return getExecution().hasExecution(executionName);
	}

	/**
	 * @param activityName
	 * @return
	 * @see org.jbpm.api.Execution#isActive(java.lang.String)
	 */
	public boolean isActive(String activityName) {
		return getExecution().isActive(activityName);
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#isEnded()
	 */
	public boolean isEnded() {
		return getExecution().isEnded();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#isProcessInstance()
	 */
	public boolean isProcessInstance() {
		return getExecution().isProcessInstance();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#isSuspended()
	 */
	public boolean isSuspended() {
		return getExecution().isSuspended();
	}

	/**
	 * @return execution
	 */
	public Execution getExecution() {
		if (!isReferencia(execution)) {
			execution = getEntidadeFactory().novoExecution();
		}
		return execution;
	}

	/**
	 * @param execution Atribui execution
	 */
	public void setExecution(Execution execution) {
		this.execution = execution;
	}

}
