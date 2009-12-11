/**
 * ProcessDefinitionDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import java.util.Map;

import org.jbpm.api.ProcessDefinition;

/**
 * Decorator da entidade ProcessDefinition.
 * 
 * @author adriano.pamplona
 */
public class ProcessDefinitionDecorator extends JbpmDecoratorAbstrato {
	private ProcessDefinition	processDefinition;
	private Map<String, Object>	mapaVariables;
	private String				id;
	private String				key;
	private Integer				version;

	private String				deploymentId;

	/**
	 * @return
	 * @see org.jbpm.api.ProcessDefinition#getDeploymentId()
	 */
	public String getDeploymentId() {
		String resultado = getProcessDefinition().getDeploymentId();

		if (isVazio(resultado) || isZero(resultado)) {
			resultado = deploymentId;
		}
		return resultado;
	}

	/**
	 * @param deploymentId Atribui deploymentId
	 */
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	/**
	 * @return
	 * @see org.jbpm.api.ProcessDefinition#getDescription()
	 */
	public String getDescription() {
		return getProcessDefinition().getDescription();
	}

	/**
	 * @return
	 * @see org.jbpm.api.ProcessDefinition#getId()
	 */
	public String getId() {
		String resultado = getProcessDefinition().getId();
		if (isVazio(resultado) || isZero(resultado)) {
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
	 * @see org.jbpm.api.ProcessDefinition#getImageResourceName()
	 */
	public String getImageResourceName() {
		return getProcessDefinition().getImageResourceName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.ProcessDefinition#getKey()
	 */
	public String getKey() {
		String resultado = getProcessDefinition().getKey();
		if (isVazio(resultado) || isZero(resultado)) {
			resultado = key;
		}
		return resultado;
	}

	/**
	 * @return
	 * @see org.jbpm.api.ProcessDefinition#getName()
	 */
	public String getName() {
		return getProcessDefinition().getName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.ProcessDefinition#getVersion()
	 */
	public int getVersion() {
		Integer resultado = getProcessDefinition().getVersion();
		if (!isReferencia(resultado) || isZero(resultado)) {
			resultado = version;
		}
		return resultado;
	}

	/**
	 * @return
	 * @see org.jbpm.api.ProcessDefinition#isSuspended()
	 */
	public boolean isSuspended() {
		return getProcessDefinition().isSuspended();
	}

	/**
	 * @return retorna processDefinition.
	 */
	public ProcessDefinition getProcessDefinition() {
		if (!isReferencia(processDefinition)) {
			processDefinition = getEntidadeFactory().novoProcessDefinition();
		}
		return processDefinition;
	}

	/**
	 * @param processDefinition Atribui processDefinition.
	 */
	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
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
	 * @param key Atribui key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param version Atribui version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}
