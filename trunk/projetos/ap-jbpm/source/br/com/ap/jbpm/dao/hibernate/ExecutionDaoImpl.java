/**
 * ExecutionDaoImpl.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao.hibernate;

import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessInstance;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.springframework.stereotype.Repository;

import br.com.ap.hibernate.dao.HibernateCrudDaoAbstrato;
import br.com.ap.jbpm.dao.ExecutionDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Repository
public class ExecutionDaoImpl extends HibernateCrudDaoAbstrato<ExecutionImpl> implements
		ExecutionDao {

	@Resource
	private ExecutionService	executionService;

	@Override
	public ProcessInstance iniciarProcesso(
			ProcessDefinitionDecorator processDefinition) {
		
		String id = processDefinition.getId();
		Map<String, Object> mapaVariables = processDefinition.getMapaVariables();
		return executionService.startProcessInstanceById(id, mapaVariables);
	}
}
