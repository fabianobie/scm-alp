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
 * DAO de acesso às informação de execution.
 * 
 * @author adriano.pamplona
 * 
 */
public interface ExecutionDao extends CrudDao<ExecutionImpl> {

	/**
	 * Inicia a execução de uma definição de processo.
	 * 
	 * @param processDefinition Definição de processo com ID
	 * @return instância do processo iniciado
	 */
	public ProcessInstance iniciarProcesso(
			ProcessDefinitionDecorator processDefinition);

}
