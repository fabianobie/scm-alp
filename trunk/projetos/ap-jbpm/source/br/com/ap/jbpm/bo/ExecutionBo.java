/**
 * ExecutionBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import javax.annotation.Resource;

import org.jbpm.api.ProcessInstance;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.springframework.stereotype.Component;

import br.com.ap.jbpm.dao.ExecutionDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;

/**
 * BO respons�vel pelas regras de neg�cio de execution.
 * 
 * @author adriano.pamplona
 */
@Component
public class ExecutionBo extends CrudBoAbstrato<ExecutionImpl> {
	@Resource(name = "executionDaoImpl")
	private ExecutionDao	executionDao;

	/**
	 * Inicia a execu��o de uma defini��o de processo.
	 * 
	 * @param processDefinition Defini��o de processo com ID
	 * @return inst�ncia do processo iniciado
	 */
	public ProcessInstance iniciarProcesso(
			ProcessDefinitionDecorator processDefinition) {

		ProcessInstance resultado = null;

		if (isReferencia(processDefinition)) {
			resultado = getDao().iniciarProcesso(processDefinition);
		}
		return resultado;
	}

	@Override
	protected ExecutionDao getDao() {
		return executionDao;
	}

}
