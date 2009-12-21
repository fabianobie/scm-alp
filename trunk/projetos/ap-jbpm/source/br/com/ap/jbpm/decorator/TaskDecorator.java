/**
 * TaskDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import java.util.Date;
import java.util.Map;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.pvm.internal.task.TaskImpl;

/**
 * Decoratora da entidade Task.
 * 
 * @author adriano.pamplona
 */
public class TaskDecorator extends JbpmDecoratorAbstrato {
	private TaskImpl			taskImpl;
	private ProcessDefinition	processDefinition;
	private String				id;
	private String				textoFormulario;
	private String				transitionTO;
	private String				formResourceName;
	private Map<String, Object>	mapaVariables;

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getActivityName()
	 */
	public String getActivityName() {
		return getTaskImpl().getActivityName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getAssignee()
	 */
	public String getAssignee() {
		return getTaskImpl().getAssignee();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getCreateTime()
	 */
	public Date getCreateTime() {
		return getTaskImpl().getCreateTime();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getDescription()
	 */
	public String getDescription() {
		return getTaskImpl().getDescription();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getDuedate()
	 */
	public Date getDuedate() {
		return getTaskImpl().getDuedate();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getExecutionId()
	 */
	public String getExecutionId() {
		return getTaskImpl().getExecutionId();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getFormResourceName()
	 */
	public String getFormResourceName() {
		String resultado = getTaskImpl().getFormResourceName();
		if (isVazio(resultado) || isZero(resultado)) {
			resultado = formResourceName;
		}
		return resultado;
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getId()
	 */
	public String getId() {
		String resultado = getTaskImpl().getId();
		if (isVazio(resultado) || isZero(resultado)) {
			resultado = id;
		}
		return resultado;
	}

	/**
	 * @param id Atribui id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getName()
	 */
	public String getName() {
		return getTaskImpl().getName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.getTaskImpl().Task#getPriority()
	 */
	public int getPriority() {
		return getTaskImpl().getPriority();
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTaskImpl().Task#setAssignee(java.lang.String)
	 */
	public void setAssignee(String arg0) {
		getTaskImpl().setAssignee(arg0);
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTaskImpl().Task#setDescription(java.lang.String)
	 */
	public void setDescription(String arg0) {
		getTaskImpl().setDescription(arg0);
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTaskImpl().Task#setDuedate(java.util.Date)
	 */
	public void setDuedate(Date arg0) {
		getTaskImpl().setDuedate(arg0);
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTaskImpl().Task#setName(java.lang.String)
	 */
	public void setName(String arg0) {
		getTaskImpl().setName(arg0);
	}

	/**
	 * @param arg0
	 * @see org.jbpm.api.getTaskImpl().Task#setPriority(int)
	 */
	public void setPriority(int arg0) {
		getTaskImpl().setPriority(arg0);
	}

	/**
	 * @return retorna getTaskImpl().
	 */
	public TaskImpl getTaskImpl() {
		if (!isReferencia(taskImpl)) {
			taskImpl = getEntidadeFactory().novaTask();
		}
		return taskImpl;
	}

	/**
	 * @param task Atribui getTaskImpl().
	 */
	public void setTaskImpl(TaskImpl taskImpl) {
		this.taskImpl = taskImpl;
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

	/**
	 * @return textoFormulario
	 */
	public String getTextoFormulario() {
		return textoFormulario;
	}

	/**
	 * @param textoFormulario Atribui textoFormulario
	 */
	public void setTextoFormulario(String textoFormulario) {
		this.textoFormulario = textoFormulario;
	}

	/**
	 * @return transitionTO
	 */
	public String getTransitionTO() {
		return transitionTO;
	}

	/**
	 * @param transitionTO Atribui transitionTO
	 */
	public void setTransitionTO(String transitionTO) {
		this.transitionTO = transitionTO;
	}

	/**
	 * @return processDefinition
	 */
	public ProcessDefinition getProcessDefinition() {
		if (!isReferencia(processDefinition)) {
			processDefinition = getEntidadeFactory().novoProcessDefinition();
		}
		return processDefinition;
	}

	/**
	 * @param processDefinition Atribui processDefinition
	 */
	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	/**
	 * @param formResourceName Atribui formResourceName
	 */
	public void setFormResourceName(String formResourceName) {
		this.formResourceName = formResourceName;
	}

}
