/**
 * DeploymentDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import java.util.Collection;

import org.jbpm.pvm.internal.repository.DeploymentImpl;

/**
 * Decorator da entidade Deployment.
 * 
 * @author adriano.pamplona
 */
public class DeploymentDecorator extends JbpmDecoratorAbstrato {
	private DeploymentImpl		deploymentImpl;
	private String				id;
	private String				classpathJpdl;
	private Collection<String>	colecaoClasspathFormulario;

	/**
	 * @return
	 * @see org.jbpm.api.Deployment#getId()
	 */
	public String getId() {
		String resultado = getDeploymentImpl().getId();
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
	 * @see org.jbpm.api.Deployment#getName()
	 */
	public String getName() {
		return getDeploymentImpl().getName();
	}

	/**
	 * @param name
	 * @return
	 * @see org.jbpm.pvm.internal.repository.DeploymentImpl#setName(java.lang.String)
	 */
	public DeploymentImpl setName(String name) {
		return getDeploymentImpl().setName(name);
	}

	/**
	 * @return
	 * @see org.jbpm.api.Deployment#getState()
	 */
	public String getState() {
		return getDeploymentImpl().getState();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Deployment#getTimestamp()
	 */
	public long getTimestamp() {
		return getDeploymentImpl().getTimestamp();
	}

	/**
	 * @param timestamp
	 * @return
	 * @see org.jbpm.pvm.internal.repository.DeploymentImpl#setTimestamp(long)
	 */
	public DeploymentImpl setTimestamp(long timestamp) {
		return getDeploymentImpl().setTimestamp(timestamp);
	}

	/**
	 * @return retorna deployment.
	 */
	public DeploymentImpl getDeploymentImpl() {
		if (!isReferencia(deploymentImpl)) {
			deploymentImpl = getEntidadeFactory().novoDeployment();
		}
		return deploymentImpl;
	}

	/**
	 * @param deployment Atribui deployment.
	 */
	public void setDeploymentImpl(DeploymentImpl deploymentImpl) {
		this.deploymentImpl = deploymentImpl;
	}

	/**
	 * @return retorna classpathJpdl.
	 */
	public String getClasspathJpdl() {
		return classpathJpdl;
	}

	/**
	 * @param classpathJpdl Atribui classpathJpdl.
	 */
	public void setClasspathJpdl(String classpathJpdl) {
		this.classpathJpdl = classpathJpdl;
	}

	/**
	 * @return retorna colecaoClasspathFormulario.
	 */
	public Collection<String> getColecaoClasspathFormulario() {
		if (!isReferencia(colecaoClasspathFormulario)) {
			colecaoClasspathFormulario = getColecaoFactory().novoArrayList();
		}
		return colecaoClasspathFormulario;
	}

	/**
	 * @param colecaoClasspathFormulario Atribui colecaoClasspathFormulario.
	 */
	public void setColecaoClasspathFormulario(
			Collection<String> colecaoClasspathFormulario) {
		this.colecaoClasspathFormulario = colecaoClasspathFormulario;
	}

}
