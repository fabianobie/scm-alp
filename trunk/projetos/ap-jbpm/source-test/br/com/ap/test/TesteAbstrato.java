/*
 * TesteAbstrato.java
 * 
 * Data de criação: 31/10/2009
 */
package br.com.ap.test;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.test.JbpmTestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.jbpm.JBPMFacade;

/**
 * @author AdrianoP
 * 
 */
public class TesteAbstrato extends JbpmTestCase {
	private ClassPathXmlApplicationContext	context;
	private JBPMFacade						jbpmFacade;

	/**
	 * @see org.jbpm.test.JbpmTestCase#initialize()
	 */
	@Override
	protected synchronized void initialize() {
		if (processEngine == null) {
			processEngine = (ProcessEngine) getContext().getBean("processEngine");

			repositoryService = (RepositoryService) getContext().getBean("repositoryService");
			executionService = (ExecutionService) getContext().getBean("executionService");
			historyService = (HistoryService) getContext().getBean("historyService");
			taskService = (TaskService) getContext().getBean("taskService");
			identityService = (IdentityService) getContext().getBean("identityService");
		}
	}

	/**
	 * @see org.jbpm.test.JbpmTestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {

	}

	/**
	 * @return context
	 */
	protected ClassPathXmlApplicationContext getContext() {
		if (context == null) {
			String xml = "ap-jbpm-application-context.xml";
			context = new ClassPathXmlApplicationContext(xml);
		}
		return context;
	}

	/**
	 * @return processEngine
	 */
	protected ProcessEngine getProcessEngine() {
		return processEngine;
	}

	/**
	 * @return repositoryService
	 */
	protected RepositoryService getRepositoryService() {
		return repositoryService;
	}

	/**
	 * @return executionService
	 */
	protected ExecutionService getExecutionService() {
		return executionService;
	}

	/**
	 * @return managementService
	 */
	protected ManagementService getManagementService() {
		return managementService;
	}

	/**
	 * @return taskService
	 */
	protected TaskService getTaskService() {
		return taskService;
	}

	/**
	 * @return historyService
	 */
	protected HistoryService getHistoryService() {
		return historyService;
	}

	/**
	 * @return identityService
	 */
	protected IdentityService getIdentityService() {
		return identityService;
	}

	/**
	 * Imprime um texto.
	 * 
	 * @param texto
	 */
	protected void print(Object texto) {
		System.out.print(texto);
	}

	/**
	 * Imprime um texto.
	 * 
	 * @param texto
	 */
	protected void println(Object texto) {
		System.out.println(texto);
	}

	/**
	 * @return jbpmFacade
	 */
	protected JBPMFacade getJbpmFacade() {
		if (!UtilObjeto.isReferencia(jbpmFacade)) {
			jbpmFacade = (JBPMFacade) getContext().getBean("JBPMFacadeImpl");
		}
		return jbpmFacade;
	}
}
