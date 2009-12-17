/**
 * DeploymentDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.NewDeployment;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.RepositoryService;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.comum.conversor.UtilConversorDeString;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.jbpm.dao.DeploymentDao;
import br.com.ap.jbpm.decorator.ActivityDecorator;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;

/**
 * DAO de acesso às informação de deployment e definições de processo.
 * 
 * @author adriano.pamplona
 */
@Repository
public class DeploymentDaoImpl extends JBPMDaoAbstrato<DeploymentImpl> implements DeploymentDao {

	@Resource
	private RepositoryService	repositoryService;

	/**
	 * @see br.com.ap.jbpm.dao.DeploymentDao#publicar(br.com.ap.jbpm.decorator.DeploymentDecorator)
	 */
	public DeploymentDecorator publicar(DeploymentDecorator deployment) {

		NewDeployment novoDeploy = repositoryService.createDeployment();
		novoDeploy.addResourceFromClasspath(deployment.getClasspathJpdl());
		for (String formulario : deployment.getColecaoClasspathFormulario()) {
			novoDeploy.addResourceFromClasspath(formulario);
		}

		return novoDeploymentDecorator(novoDeploy.deploy());
	}

	/**
	 * @see br.com.ap.jbpm.dao.DeploymentDao#consultarDefinicaoDeProcesso()
	 */
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso() {
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		return query.list();
	}

	/**
	 * @see br.com.ap.jbpm.dao.DeploymentDao#obterDefinicaoDeProcesso(br.com.ap.jbpm.decorator.ProcessDefinitionDecorator)
	 */
	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition) {

		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		query.processDefinitionId(processDefinition.getId());
		return query.uniqueResult();
	}

	/**
	 * @see br.com.ap.jbpm.dao.DeploymentDao#obterFormulario(br.com.ap.jbpm.decorator.DeploymentDecorator, br.com.ap.jbpm.decorator.TaskDecorator)
	 */
	public TaskDecorator obterFormulario(DeploymentDecorator deployment, TaskDecorator task) {
		String deploymentId = deployment.getId();
		String form = task.getFormResourceName();

		return obterFormulario(deploymentId, form);
	}
	
	/**
	 * @see br.com.ap.jbpm.dao.DeploymentDao#obterNomesAtividadeStart(br.com.ap.jbpm.decorator.ProcessDefinitionDecorator)
	 */
	public List<String> obterNomesAtividadeStart(ProcessDefinitionDecorator processDefinition) {

		return repositoryService.getStartActivityNames(processDefinition.getId());
	}

	/**
	 * @see br.com.ap.jbpm.dao.DeploymentDao#obterFormularioInicial(br.com.ap.jbpm.decorator.DeploymentDecorator, br.com.ap.jbpm.decorator.ProcessDefinitionDecorator, br.com.ap.jbpm.decorator.ActivityDecorator)
	 */
	public TaskDecorator obterFormularioInicial(DeploymentDecorator deployment,
			ProcessDefinitionDecorator processDefinition, ActivityDecorator activity) {

		String form = repositoryService.getStartFormResourceName(processDefinition.getId(),
				activity.getName());
		String deploymentId = deployment.getId();
		return obterFormulario(deploymentId, form);
	}

	/**
	 * @see br.com.ap.jbpm.dao.DeploymentDao#obterNomeFormularioInicial(br.com.ap.jbpm.decorator.DeploymentDecorator, br.com.ap.jbpm.decorator.ProcessDefinitionDecorator, br.com.ap.jbpm.decorator.ActivityDecorator)
	 */
	public TaskDecorator obterNomeFormularioInicial(DeploymentDecorator deployment,
			ProcessDefinitionDecorator processDefinition, ActivityDecorator activity) {
		
		String form = repositoryService.getStartFormResourceName(processDefinition.getId(),
				activity.getName());
		TaskDecorator taskDecorator = getDecoratorFactory().novoTaskDecorator();
		taskDecorator.setFormResourceName(form);
		return taskDecorator;
	}
	
	/**
	 * @see br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato#obter(java.io.Serializable)
	 */
	@Override
	public DeploymentImpl obter(Serializable id) {
		Serializable parametro = id;
		if (UtilObjeto.isString(id)) {
			parametro = UtilConversorDeString.converterParaLong((String) id);
		}
		return super.obter(parametro);
	}
	
	/**
	 * Recupera o texto do formulário.
	 * 
	 * @param deploymentId
	 * @param nomeForm
	 * @return task com o texto do formulário.
	 */
	private TaskDecorator obterFormulario(String deploymentId, String nomeForm) {
		TaskDecorator resultado = getDecoratorFactory().novoTaskDecorator();
		
		InputStream is = repositoryService.getResourceAsStream(deploymentId, nomeForm);
		String texto = UtilArquivo.getTextoDoInputStream(is);
		resultado.setTextoFormulario(texto);
		
		return resultado;
	}
	
	/**
	 * @param id ID
	 * @return DeploymentDecorator
	 */
	private DeploymentDecorator novoDeploymentDecorator(String id) {
		return getDecoratorFactory().novoDeploymentDecorator(id);
	}
}
