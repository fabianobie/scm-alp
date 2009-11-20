/**
 * ProcessDefinitionTest.java
 *
 * Data: 20/11/2009
 */
package br.com.ap.test.jbpm.processdefinition;

import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.test.TesteAbstrato;

/**
 * @author adriano.pamplona
 *
 */
public class ProcessDefinitionTest extends TesteAbstrato {
	private static String ultimoProcessoID;
	
	/**
	 * 
	 */
	public void test() {
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
				println("Version....: " + processo.getVersion());
			}
		}
	}

	/**
	 * @return retorna ultimoProcessoID.
	 */
	public static String getUltimoProcessoID() {
		return ultimoProcessoID;
	}

	/**
	 * @param ultimoProcessoID Atribui ultimoProcessoID.
	 */
	public static void setUltimoProcessoID(String ultimoProcessoID) {
		ProcessDefinitionTest.ultimoProcessoID = ultimoProcessoID;
	}
}
