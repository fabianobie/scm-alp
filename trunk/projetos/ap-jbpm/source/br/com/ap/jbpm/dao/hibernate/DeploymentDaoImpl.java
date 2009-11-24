/**
 * DeploymentDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.NewDeployment;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.RepositoryService;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.jbpm.dao.DeploymentDao;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;
import br.com.ap.jbpm.factory.DecoratorFactory;

/**
 * @author adriano.pamplona
 * 
 */
@Repository
public class DeploymentDaoImpl extends HibernateCrudDaoAbstrato<DeploymentImpl>
		implements DeploymentDao {

	@Resource
	private RepositoryService repositoryService;

	@Override
	public DeploymentDecorator publicar(DeploymentDecorator deployment) {
		
		NewDeployment novoDeploy = repositoryService.createDeployment();
		novoDeploy.addResourceFromClasspath(deployment.getClasspathJpdl());
		novoDeploy.addResourceFromClasspath(deployment.getClasspathImagem());
		for (String formulario : deployment.getColecaoClasspathFormulario()) {
			novoDeploy.addResourceFromClasspath(formulario);
		}

		return novoDeploymentDecorator(novoDeploy.deploy());
	}

	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso() {
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		return query.list();
	}

	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition) {
		
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		query.processDefinitionId(processDefinition.getId());
		return query.uniqueResult();
	}

	/**
	 * @param id
	 *            ID
	 * @return DeploymentDecorator
	 */
	private DeploymentDecorator novoDeploymentDecorator(String id) {
		return getDecoratorFactory().novoDeploymentDecorator(id);
	}

	/**
	 * @return DecoratorFactory
	 */
	private DecoratorFactory getDecoratorFactory() {
		return DecoratorFactory.getInstancia();
	}

	@Override
	public TaskDecorator obterFormulario(DeploymentDecorator deployment,
			TaskDecorator task) {
		TaskDecorator resultado = getDecoratorFactory().novoTaskDecorator();
		String deploymentId = deployment.getId();
		String form = task.getFormResourceName();
		
		InputStream is = repositoryService.getResourceAsStream(deploymentId, form);
		String texto = UtilArquivo.getTextoDoInputStream(is);
		resultado.setTextoFormulario(texto);
		
		return resultado;
	}
}
