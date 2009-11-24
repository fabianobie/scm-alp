/**
 * ExecutionBo.java
 *
 * Data: 23/11/2009
 */
package br.com.ap.jbpm.bo;

import javax.annotation.Resource;

import org.jbpm.api.Execution;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.springframework.stereotype.Component;

import br.com.ap.arquitetura.dao.CrudDao;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.jbpm.dao.ExecutionDao;
import br.com.ap.jbpm.decorator.ExecutionDecorator;

/**
 * @author adriano.pamplona
 * 
 */
@Component
public class ExecutionBo extends CrudBoAbstrato<ExecutionImpl> {
	@Resource(name = "ExecutionDaoImpl")
	private ExecutionDao	executionDao;

	public Execution obter(ExecutionDecorator executionDecorator) {
		Execution resultado = null;

		if (UtilObjeto.isReferencia(executionDecorator)) {
			resultado = executionDao.obter(executionDecorator.getId());
		}
		return resultado;
	}

	@Override
	protected ExecutionDao getDao() {
		return executionDao;
	}

}
