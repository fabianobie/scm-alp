/**
 * ProcessDefinitionDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import java.util.Date;
import java.util.Map;

import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;

/**
 * Decorator da entidade ProcessDefinition.
 * 
 * @author adriano.pamplona
 */
public class ProcessDefinitionDecorator extends JbpmDecoratorAbstrato {
	private ProcessDefinitionImpl	processDefinitionImpl;
	private Map<String, Object>		mapaVariables;

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#getDeploymentId()
	 */
	public String getDeploymentId() {
		return getProcessDefinitionImpl().getDeploymentId();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#getDeploymentTime()
	 */
	public Date getDeploymentTime() {
		return getProcessDefinitionImpl().getDeploymentTime();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElementImpl#getDescription()
	 */
	public String getDescription() {
		return getProcessDefinitionImpl().getDescription();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#getId()
	 */
	public String getId() {
		return getProcessDefinitionImpl().getId();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#getImageResourceName()
	 */
	public String getImageResourceName() {
		return getProcessDefinitionImpl().getImageResourceName();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#getKey()
	 */
	public String getKey() {
		return getProcessDefinitionImpl().getKey();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ObservableElementImpl#getName()
	 */
	public String getName() {
		return getProcessDefinitionImpl().getName();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#getVersion()
	 */
	public int getVersion() {
		return getProcessDefinitionImpl().getVersion();
	}

	/**
	 * @return
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#isSuspended()
	 */
	public boolean isSuspended() {
		return getProcessDefinitionImpl().isSuspended();
	}

	/**
	 * @param deploymentTime
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#setDeploymentTime(java.util.Date)
	 */
	public void setDeploymentTime(Date deploymentTime) {
		getProcessDefinitionImpl().setDeploymentTime(deploymentTime);
	}

	/**
	 * @param description
	 * @see org.jbpm.pvm.internal.model.ObservableElementImpl#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		getProcessDefinitionImpl().setDescription(description);
	}

	/**
	 * @param id
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#setId(java.lang.String)
	 */
	public void setId(String id) {
		getProcessDefinitionImpl().setId(id);
	}

	/**
	 * @param imageResourceName
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#setImageResourceName(java.lang.String)
	 */
	public void setImageResourceName(String imageResourceName) {
		getProcessDefinitionImpl().setImageResourceName(imageResourceName);
	}

	/**
	 * @param key
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#setKey(java.lang.String)
	 */
	public void setKey(String key) {
		getProcessDefinitionImpl().setKey(key);
	}

	/**
	 * @param name
	 * @see org.jbpm.pvm.internal.model.ObservableElementImpl#setName(java.lang.String)
	 */
	public void setName(String name) {
		getProcessDefinitionImpl().setName(name);
	}

	/**
	 * @param isSuspended
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#setSuspended(boolean)
	 */
	public void setSuspended(boolean isSuspended) {
		getProcessDefinitionImpl().setSuspended(isSuspended);
	}

	/**
	 * @param version
	 * @see org.jbpm.pvm.internal.model.ProcessDefinitionImpl#setVersion(int)
	 */
	public void setVersion(int version) {
		getProcessDefinitionImpl().setVersion(version);
	}

	/**
	 * @return retorna processDefinition.
	 */
	public ProcessDefinitionImpl getProcessDefinitionImpl() {
		if (!isReferencia(processDefinitionImpl)) {
			processDefinitionImpl = getEntidadeFactory()
					.novoProcessDefinition();
		}
		return processDefinitionImpl;
	}

	/**
	 * @param processDefinition Atribui processDefinition.
	 */
	public void setProcessDefinitionImpl(ProcessDefinitionImpl processDefinition) {
		this.processDefinitionImpl = processDefinition;
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
