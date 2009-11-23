/**
 * TaskDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import java.util.Date;
import java.util.Map;

import org.jbpm.api.task.Task;

/**
 * @author adriano.pamplona
 */
public class TaskDecorator extends JbpmDecoratorAbstrato {
	private Task task;
	private Map<String, Object> mapaVariables;

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getActivityName()
	 */
	public String getActivityName() {
		return getTask().getActivityName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getAssignee()
	 */
	public String getAssignee() {
		return getTask().getAssignee();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getCreateTime()
	 */
	public Date getCreateTime() {
		return getTask().getCreateTime();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getDescription()
	 */
	public String getDescription() {
		return getTask().getDescription();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getDuedate()
	 */
	public Date getDuedate() {
		return getTask().getDuedate();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getExecutionId()
	 */
	public String getExecutionId() {
		return getTask().getExecutionId();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getFormResourceName()
	 */
	public String getFormResourceName() {
		return getTask().getFormResourceName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getId()
	 */
	public String getId() {
		return getTask().getId();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getName()
	 */
	public String getName() {
		return getTask().getName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTask().Task#getPriority()
	 */
	public int getPriority() {
		return getTask().getPriority();
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTask().Task#setAssignee(java.lang.String)
	 */
	public void setAssignee(String arg0) {
		getTask().setAssignee(arg0);
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTask().Task#setDescription(java.lang.String)
	 */
	public void setDescription(String arg0) {
		getTask().setDescription(arg0);
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTask().Task#setDuedate(java.util.Date)
	 */
	public void setDuedate(Date arg0) {
		getTask().setDuedate(arg0);
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTask().Task#setName(java.lang.String)
	 */
	public void setName(String arg0) {
		getTask().setName(arg0);
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTask().Task#setPriority(int)
	 */
	public void setPriority(int arg0) {
		getTask().setPriority(arg0);
	}

	/**
	 * @return retorna getTask().
	 */
	public Task getTask() {
		if (!isReferencia(task)) {
			task = getEntidadeFactory().novaTask();
		}
		return task;
	}

	/**
	 * @param task
	 *            Atribui getTask().
	 */
	public void setTask(Task task) {
		this.task = task;
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
