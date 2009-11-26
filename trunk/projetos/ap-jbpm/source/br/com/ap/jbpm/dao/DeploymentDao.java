/**
 * DeploymentDao.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao;

import java.util.Collection;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.pvm.internal.repository.DeploymentImpl;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.jbpm.decorator.ActivityDecorator;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;

/**
 * DAO de acesso às informação de deployment e definições de processo.
 * 
 * @author adriano.pamplona
 */
public interface DeploymentDao extends CrudDao<DeploymentImpl> {
	/**
	 * Publica um processo no repositório.
	 * 
	 * @param deployment Processo que será publicado.
	 * @return DeploymentDecorator
	 */
	public DeploymentDecorator publicar(DeploymentDecorator deployment);
	/**
	 * Consulta todas as definições de processo do repositório.
	 * 
	 * @return coleção de definições de processo.
	 */
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso();
	/**
	 * Retorna a definição de processo solicitada.
	 * 
	 * @param processDefinition Definição de processo com ID.
	 * @return definição solicitada.
	 */
	public ProcessDefinition obterDefinicaoDeProcesso(ProcessDefinitionDecorator processDefinition);
	
	public TaskDecorator obterFormulario(DeploymentDecorator deployment, TaskDecorator task);
	
	public List<String> obterNomesAtividadeStart(
			ProcessDefinitionDecorator processDefinition);

	public TaskDecorator obterFormularioInicial(
			DeploymentDecorator deployment,
			ProcessDefinitionDecorator processDefinition,
			ActivityDecorator activity);
}
