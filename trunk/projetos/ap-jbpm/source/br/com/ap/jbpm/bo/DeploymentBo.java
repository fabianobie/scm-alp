/**
 * DeploymentBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.springframework.stereotype.Component;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.DeploymentDao;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Component
public class DeploymentBo extends CrudBoAbstrato<DeploymentImpl>{
	
	@Resource(name = "deploymentDaoImpl")
	private DeploymentDao deploymentDao;

	public DeploymentDecorator publicar(DeploymentDecorator deployment) {
		DeploymentDecorator resultado = null;
		
		if (UtilObjeto.isReferencia(deployment) && 
			!UtilString.isVazio(deployment.getClasspathJpdl())) {
			
			resultado = getDao().publicar(deployment);
		}
		return resultado;
	}
	
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso() {
		
		return getDao().consultarDefinicaoDeProcesso();
	}

	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition) {
		ProcessDefinition resultado = null;
		
		if (UtilObjeto.isReferencia(processDefinition) && 
			!UtilString.isVazio(processDefinition.getId())) {
			
			resultado = getDao().obterDefinicaoDeProcesso(processDefinition);
		}
		return resultado;
	}
	
	public TaskDecorator obterFormulario(DeploymentDecorator deployment, TaskDecorator task) {
		TaskDecorator resultado = null;
		
		if (UtilObjeto.isReferenciaTodos(deployment, task)) {
			resultado = getDao().obterFormulario(deployment, task);
		}
		return resultado;
	}

	@Override
	protected DeploymentDao getDao() {
		return deploymentDao;
	}


}
