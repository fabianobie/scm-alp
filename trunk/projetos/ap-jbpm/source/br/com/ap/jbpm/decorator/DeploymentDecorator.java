/**
 * DeploymentDecorator.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.decorator;

import java.util.Collection;

import org.jbpm.api.Deployment;

/**
 * Decorator da entidade Deployment.
 * 
 * @author adriano.pamplona
 */
public class DeploymentDecorator extends JbpmDecoratorAbstrato {
	private Deployment			deployment;
	private String				id;
	private String				classpathJpdl;
	private Collection<String>	colecaoClasspathFormulario;

	/**
	 * @return
	 * @see org.jbpm.api.Deployment#getId()
	 */
	public String getId() {
		String resultado = getDeployment().getId();
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
		return getDeployment().getName();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Deployment#getState()
	 */
	public String getState() {
		return getDeployment().getState();
	}

	/**
	 * @return
	 * @see org.jbpm.api.Deployment#getTimestamp()
	 */
	public long getTimestamp() {
		return getDeployment().getTimestamp();
	}

	/**
	 * @return retorna deployment.
	 */
	public Deployment getDeployment() {
		if (!isReferencia(deployment)) {
			deployment = getEntidadeFactory().novoDeployment();
		}
		return deployment;
	}

	/**
	 * @param deployment Atribui deployment.
	 */
	public void setDeployment(Deployment deployment) {
		this.deployment = deployment;
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
	public void setColecaoClasspathFormulario(Collection<String> colecaoClasspathFormulario) {
		this.colecaoClasspathFormulario = colecaoClasspathFormulario;
	}

}
