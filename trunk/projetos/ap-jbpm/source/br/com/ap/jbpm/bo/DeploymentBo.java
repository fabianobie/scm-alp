/**
 * DeploymentBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.springframework.stereotype.Component;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.DeploymentDao;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Component
public class DeploymentBo {
	@Resource(name = "deploymentDaoImpl")
	private DeploymentDao deploymentDao;

	public DeploymentDecorator publicar(DeploymentDecorator deployment) {
		DeploymentDecorator resultado = null;
		
		if (UtilObjeto.isReferencia(deployment) && 
			!UtilString.isVazio(deployment.getClasspathJpdl())) {
			
			resultado = deploymentDao.publicar(deployment);
		}
		return resultado;
	}
	
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso() {
		
		return deploymentDao.consultarDefinicaoDeProcesso();
	}

	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition) {
		ProcessDefinition resultado = null;
		
		if (UtilObjeto.isReferencia(processDefinition) && 
			!UtilString.isVazio(processDefinition.getId())) {
			
			resultado = deploymentDao.obterDefinicaoDeProcesso(processDefinition);
		}
		return resultado;
	}

}
