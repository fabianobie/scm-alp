/*
 * MainTest.java
 * 
 * Data de cria��o: 12/11/2009
 */
package br.com.ap.test.jbpm;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.jbpm.api.NewDeployment;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.test.TesteAbstrato;

/**
 * @author AdrianoP
 * 
 */
public class MainTest extends TesteAbstrato {
	private static String	deployID;
	private static String	ultimoProcessoID;
	private static String	ultimaInstanciaID;

	public void test_deploy() {
		println("deploy");
		println("------");

		NewDeployment deployment = getRepositoryService().createDeployment();
		deployment.addResourceFromClasspath("process.jpdl.xml");
		deployment.addResourceFromClasspath("formulario.ftl");

		deployID = deployment.deploy();
		println("Deploy: " + deployID);
	}

	public void test_listarProcessos() {
		println("listarProcessos");
		println("---------------");

		ProcessDefinitionQuery query = getRepositoryService().createProcessDefinitionQuery();
		List<ProcessDefinition> processos = query.list();
		if (!UtilColecao.isVazio(processos)) {
			for (ProcessDefinition processo : processos) {
				ultimoProcessoID = processo.getId();

				println("id.........: " + processo.getId());
				println("Deploy id..: " + processo.getDeploymentId());
				println("Name.......: " + processo.getName());
				println("Key........: " + processo.getKey());
				println("Description: " + processo.getDescription());
			}
		}
	}

	public void test_criarInstanciaDoProcesso() {
		println("criarInstanciaDoProcesso");
		println("------------------------");

		ProcessDefinitionQuery query = getRepositoryService().createProcessDefinitionQuery();
		query.processDefinitionId(ultimoProcessoID);
		ProcessDefinition processo = query.uniqueResult();

		ProcessInstance instancia = getExecutionService().startProcessInstanceByKey(
				processo.getKey());
		if (UtilObjeto.isReferencia(instancia)) {
			ultimaInstanciaID = instancia.getId();

			println("Inst�ncia criada:");
			println("ID..: " + instancia.getId());
			println("Name: " + instancia.getName());
			println("State: " + instancia.getState());

		} else {
			println("Inst�ncia n�o criada:");
		}
	}
	
	public void teste_recuperarFormulario() throws IOException {
		println("recuperarFormulario");
		println("-------------------");
		
		ProcessInstance instancia = getExecutionService().findProcessInstanceById(ultimaInstanciaID);
		
		ProcessDefinitionQuery pdQuery = getRepositoryService().createProcessDefinitionQuery();
		pdQuery.processDefinitionId(instancia.getProcessDefinitionId());
		ProcessDefinition processo = (ProcessDefinitionImpl) pdQuery.uniqueResult();
		
		TaskQuery tQuery = getTaskService().createTaskQuery();
		tQuery.processDefinitionId(processo.getId());
		Task tarefa = tQuery.uniqueResult();
		
		InputStream form = getRepositoryService().getResourceAsStream(processo.getDeploymentId(), tarefa.getFormResourceName());
		BufferedReader br = new BufferedReader(new InputStreamReader(form));
		String s0 = "";
		String linha = null;
		while ((linha = br.readLine()) != null) {
			s0 += linha +"\n\r";
		}
				
		System.out.println("Form....: "+ form);
		System.out.println("String 0: "+ s0);
		
		
		
	}
}
