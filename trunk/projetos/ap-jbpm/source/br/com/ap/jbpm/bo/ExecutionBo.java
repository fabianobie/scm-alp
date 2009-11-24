/**
 * ExecutionBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import javax.annotation.Resource;

import org.apache.tools.ant.taskdefs.condition.IsReference;
import org.jbpm.api.ProcessInstance;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.springframework.stereotype.Component;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.jbpm.dao.ExecutionDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Component
public class ExecutionBo extends CrudBoAbstrato<ExecutionImpl> {
	@Resource(name = "executionDaoImpl")
	private ExecutionDao executionDao;

	@Override
	protected ExecutionDao getDao() {
		return executionDao;
	}

	public ProcessInstance iniciarProcesso(
			ProcessDefinitionDecorator processDefinition) {
		
		ProcessInstance resultado = null;
		
		if (UtilObjeto.isReferencia(processDefinition)) {
			resultado = getDao().iniciarProcesso(processDefinition);
		}
		return resultado;
	}

}
