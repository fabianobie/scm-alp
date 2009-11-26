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
 * BO responsável pelas regras de negócio de execution.
 * 
 * @author adriano.pamplona
 */
@Component
public class ExecutionBo extends CrudBoAbstrato<ExecutionImpl> {
	@Resource(name = "executionDaoImpl")
	private ExecutionDao	executionDao;

	/**
	 * Inicia a execução de uma definição de processo.
	 * 
	 * @param processDefinition Definição de processo com ID
	 * @return instância do processo iniciado
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
