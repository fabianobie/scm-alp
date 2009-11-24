/**
 * DeploymentDao.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao;

import java.util.Collection;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.pvm.internal.repository.DeploymentImpl;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;

/**
 * @author adriano.pamplona
 * 
 */
public interface DeploymentDao extends CrudDao<DeploymentImpl> {

	public DeploymentDecorator publicar(DeploymentDecorator deployment);

	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso();

	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition);
	
	public TaskDecorator obterFormulario(DeploymentDecorator deployment, TaskDecorator task);
}
