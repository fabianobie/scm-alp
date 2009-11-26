/**
 * ExecutionDao.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.dao;

import org.jbpm.api.ProcessInstance;
import org.jbpm.pvm.internal.model.ExecutionImpl;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.jbpm.decorator.ProcessDefinitionDecorator;

/**
 * DAO de acesso �s informa��o de execution.
 * 
 * @author adriano.pamplona
 * 
 */
public interface ExecutionDao extends CrudDao<ExecutionImpl> {

	/**
	 * Inicia a execu��o de uma defini��o de processo.
	 * 
	 * @param processDefinition Defini��o de processo com ID
	 * @return inst�ncia do processo iniciado
	 */
	public ProcessInstance iniciarProcesso(
			ProcessDefinitionDecorator processDefinition);

}
