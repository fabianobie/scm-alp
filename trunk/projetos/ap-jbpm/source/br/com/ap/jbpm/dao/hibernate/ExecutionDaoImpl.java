/**
 * ExecutionDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessInstance;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.comum.string.UtilString;
import br.com.ap.jbpm.dao.ExecutionDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;

/**
 * DAO de acesso às informação de execução.
 * 
 * @author adriano.pamplona
 */
@Repository
public class ExecutionDaoImpl extends JBPMDaoAbstrato<ExecutionImpl> implements ExecutionDao {

	@Resource
	private ExecutionService	executionService;

	/**
	 * @see br.com.ap.jbpm.dao.ExecutionDao#iniciarProcesso(br.com.ap.jbpm.decorator.ProcessDefinitionDecorator)
	 */
	public ProcessInstance iniciarProcesso(ProcessDefinitionDecorator processDefinition) {

		String id = processDefinition.getId();
		Map<String, Object> mapaVariables = processDefinition.getMapaVariables();
		return executionService.startProcessInstanceById(id, mapaVariables);
	}

	/**
	 * @see br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato#obter(java.io.Serializable)
	 */
	@Override
	public ExecutionImpl obter(Serializable id) {
		String stringId = UtilString.getString(id);
		return (ExecutionImpl) executionService.findExecutionById(stringId);
	}
}
