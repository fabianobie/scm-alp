/**
 * DeploymentBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.Deployment;
import org.jbpm.api.Execution;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.springframework.stereotype.Component;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.jbpm.dao.DeploymentDao;
import br.com.ap.jbpm.decorator.ActivityDecorator;
import br.com.ap.jbpm.decorator.DeploymentDecorator;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;
import br.com.ap.jbpm.decorator.TaskDecorator;

/**
 * BO respons�vel pelas regras de neg�cio de deployment.
 * 
 * @author adriano.pamplona
 */
@Component
public class DeploymentBo extends CrudBoAbstrato<DeploymentImpl> {

	@Resource(name = "deploymentDaoImpl")
	private DeploymentDao	deploymentDao;

	/**
	 * Publica um processo no reposit�rio.
	 * 
	 * @param deployment Processo que ser� publicado.
	 * @return DeploymentDecorator
	 */
	public DeploymentDecorator publicar(DeploymentDecorator deployment) {
		DeploymentDecorator resultado = null;

		if (isReferencia(deployment) && !isVazio(deployment.getClasspathJpdl())) {

			resultado = getDao().publicar(deployment);
		}
		return resultado;
	}

	/**
	 * Consulta todas as defini��es de processo do reposit�rio.
	 * 
	 * @return cole��o de defini��es de processo.
	 */
	public Collection<ProcessDefinition> consultarDefinicaoDeProcesso() {

		return getDao().consultarDefinicaoDeProcesso();
	}

	/**
	 * Retorna a defini��o de processo solicitada.
	 * 
	 * @param processDefinition Defini��o de processo com ID.
	 * @return defini��o solicitada.
	 */
	public ProcessDefinition obterDefinicaoDeProcesso(
			ProcessDefinitionDecorator processDefinition) {
		ProcessDefinition resultado = null;

		if (isReferencia(processDefinition)
				&& !isVazio(processDefinition.getId())) {

			resultado = getDao().obterDefinicaoDeProcesso(processDefinition);
		}
		return resultado;
	}

	/**
	 * Retorna a defini��o de processo solicitada.
	 * 
	 * @param execution Execution com ID.
	 * @return defini��o solicitada.
	 */
	public ProcessDefinition obterDefinicaoDeProcesso(Execution execution) {

		ProcessDefinition resultado = null;
		if (isReferencia(execution)) {
			String definicaoId = execution.getProcessDefinitionId();
			ProcessDefinitionDecorator definitionDecorator = novoProcessDefinitionDecorator(definicaoId);
			resultado = obterDefinicaoDeProcesso(definitionDecorator);
		}
		return resultado;
	}

	/**
	 * Retorna o formul�rio da tarefa.
	 * 
	 * @param deployment Deployment com ID.
	 * @param task Tarefa com ID.
	 * @return formul�rio da tarefa
	 */
	public TaskDecorator obterFormulario(DeploymentDecorator deployment,
			TaskDecorator task) {
		TaskDecorator resultado = null;

		if (isReferencia(deployment, task)) {
			resultado = getDao().obterFormulario(deployment, task);
		}
		return resultado;
	}

	/**
	 * Retorna o formul�rio da tarefa.
	 * 
	 * @param deployment Deployment com ID.
	 * @param task Tarefa com ID.
	 * @return formul�rio da tarefa
	 */
	public TaskDecorator obterFormulario(Deployment deployment, Task task) {
		TaskDecorator resultado = null;

		if (isReferencia(deployment, task)) {
			DeploymentDecorator deploymentDecorator = novoDeploymentDecorator(deployment);
			TaskDecorator taskDecorator = novoTaskDecorator(task);
			resultado = getDao().obterFormulario(deploymentDecorator,
					taskDecorator);
		}
		return resultado;
	}

	/**
	 * Retorna o formul�rio inicial de uma defini��o de processo.
	 * 
	 * @param processDefinition Defini��o de processo com ID.
	 * @return formul�rio inicial
	 */
	public TaskDecorator obterFormularioInicial(
			ProcessDefinitionDecorator processDefinition) {

		ActivityDecorator activity = obterNomeAtividadeStart(processDefinition);
		ProcessDefinition process = obterDefinicaoDeProcesso(processDefinition);
		Deployment deployment = obter(process.getDeploymentId());

		DeploymentDecorator deploymentDecorator = novoDeploymentDecorator(deployment);
		return getDao().obterFormularioInicial(deploymentDecorator,
				processDefinition, activity);
	}

	/**
	 * Retorna o nome da atividade de start. Se houver mais de uma atividade
	 * Start ser� retornado o nome da primeira.
	 * 
	 * @param processDefinition Defini��o de processo com ID
	 * @return activity com nome
	 */
	public ActivityDecorator obterNomeAtividadeStart(
			ProcessDefinitionDecorator processDefinition) {

		List<String> atividades = getDao().obterNomesAtividadeStart(
				processDefinition);
		String atividade = UtilColecao.getElementoDoIndice(atividades, 0);
		return getDecoratorFactory().novaActivityDecorator(atividade);
	}

	@Override
	protected DeploymentDao getDao() {
		return deploymentDao;
	}

}
