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
import org.jbpm.pvm.internal.model.ExecutionImpl;

/**
 * Decorator da entidade Execution.
 * 
 * @author adriano.pamplona
 */
public class ExecutionDecorator extends JbpmDecoratorAbstrato {
	private ExecutionImpl		executionImpl;
	private Map<String, Object>	mapaVariables;

	/**
	 * @return
	 * @see org.jbpm.api.Execution#findActiveActivityNames()
	 */
	public Set<String> findActiveActivityNames() {
		return getExecutionImpl().findActiveActivityNames();
	}

	/**
	 * @param activityName
	 * @return
	 * @see org.jbpm.api.Execution#findActiveExecutionIn(java.lang.String)
	 */
	public Execution findActiveExecutionIn(String activityName) {
		return getExecutionImpl().findActiveExecutionIn(activityName);
	}

	/**
	 * @param name
	 * @return
	 * @see org.jbpm.api.Execution#getExecution(java.lang.String)
	 */
	public Execution getExecution(String name) {
		return getExecutionImpl().getExecution(name);
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getExecutions()
	 */
	public Collection<? extends Execution> getExecutions() {
		return getExecutionImpl().getExecutions();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getExecutionsMap()
	 */
	public Map<String, Execution> getExecutionsMap() {
		return getExecutionImpl().getExecutionsMap();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getId()
	 */
	public String getId() {
		return getExecutionImpl().getId();
	}

	/**
	 * @param id Atribui id
	 */
	public void setId(String id) {
		getExecutionImpl().setId(id);
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getKey()
	 */
	public String getKey() {
		return getExecutionImpl().getKey();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getName()
	 */
	public String getName() {
		return getExecutionImpl().getName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getParent()
	 */
	public Execution getParent() {
		return getExecutionImpl().getParent();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getPriority()
	 */
	public int getPriority() {
		return getExecutionImpl().getPriority();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getProcessDefinitionId()
	 */
	public String getProcessDefinitionId() {
		return getExecutionImpl().getProcessDefinitionId();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getProcessInstance()
	 */
	public Execution getProcessInstance() {
		return getExecutionImpl().getProcessInstance();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#getState()
	 */
	public String getState() {
		return getExecutionImpl().getState();
	}

	/**
	 * @param executionName
	 * @return
	 * @see org.jbpm.api.Execution#hasExecution(java.lang.String)
	 */
	public boolean hasExecution(String executionName) {
		return getExecutionImpl().hasExecution(executionName);
	}

	/**
	 * @param activityName
	 * @return
	 * @see org.jbpm.api.Execution#isActive(java.lang.String)
	 */
	public boolean isActive(String activityName) {
		return getExecutionImpl().isActive(activityName);
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#isEnded()
	 */
	public boolean isEnded() {
		return getExecutionImpl().isEnded();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#isProcessInstance()
	 */
	public boolean isProcessInstance() {
		return getExecutionImpl().isProcessInstance();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Execution#isSuspended()
	 */
	public boolean isSuspended() {
		return getExecutionImpl().isSuspended();
	}

	/**
	 * @return execution
	 */
	public ExecutionImpl getExecutionImpl() {
		if (!isReferencia(executionImpl)) {
			executionImpl = getEntidadeFactory().novoExecution();
		}
		return executionImpl;
	}

	/**
	 * @param execution Atribui execution
	 */
	public void setExecutionImpl(ExecutionImpl execution) {
		this.executionImpl = execution;
	}

	/**
	 * @return retorna mapaVariables.
	 */
	public Map<String, Object> getMapaVariables() {
		if (!isReferencia(mapaVariables)) {
			mapaVariables = getColecaoFactory().novoHashMap();
		}
		return mapaVariables;
	}

	/**
	 * @param mapaVariables Atribui mapaVariables.
	 */
	public void setMapaVariables(Map<String, Object> mapaVariables) {
		this.mapaVariables = mapaVariables;
	}

}
