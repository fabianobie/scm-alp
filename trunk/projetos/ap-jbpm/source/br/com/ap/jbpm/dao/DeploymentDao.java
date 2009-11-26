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
 * DAO de acesso �s informa��o de deployment e defini��es de processo.
 * 
 * @author adriano.pamplona
 */
public interface DeploymentDao extends CrudDao<DeploymentImpl> {

	/**
	 * Publica um processo no reposit�rio.
	 * 
	 * @param deployment Processo que ser� publicado.
	 * @return DeploymentDecorator
	 */
	public DeploymentDecorator publicar(DeploymentDecorator deployment);

	/**
	 * Consulta todas as defini��es de processo do reposit�rio.
	 * 
	 * @return cole��o de defini��es de processo.
	 */
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso();

	/**
	 * Retorna a defini��o de processo solicitada.
	 * 
	 * @param processDefinition Defini��o de processo com ID.
	 * @return defini��o solicitada.
	 */
	public ProcessDefinition obterDefinicaoDeProcesso(
			ProcessDefinitionDecorator processDefinition);

	/**
	 * Retorna o formul�rio da tarefa.
	 * 
	 * @param deployment Deployment com ID.
	 * @param task Tarefa com ID.
	 * @return formul�rio da tarefa
	 */
	public TaskDecorator obterFormulario(DeploymentDecorator deployment,
			TaskDecorator task);

	/**
	 * Retorna a lista de nomes das atividades de start de uma defini��o de
	 * processo.
	 * 
	 * @param processDefinition Defini��o de processo com ID
	 * @return lista de nomes
	 */
	public List<String> obterNomesAtividadeStart(
			ProcessDefinitionDecorator processDefinition);

	/**
	 * Retorna o formul�rio inicial de uma defini��o de processo.
	 * 
	 * @param deployment Deployment com ID.
	 * @param processDefinition Defini��o de processo com ID.
	 * @param activity Atividade com nome.
	 * @return formul�rio inicial
	 */
	public TaskDecorator obterFormularioInicial(DeploymentDecorator deployment,
			ProcessDefinitionDecorator processDefinition,
			ActivityDecorator activity);
}
