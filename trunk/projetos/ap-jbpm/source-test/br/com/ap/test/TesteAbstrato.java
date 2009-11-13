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

/**
 * @author AdrianoP
 * 
 */
public class TesteAbstrato extends JbpmTestCase {
	
	/**
	 * @see org.jbpm.test.JbpmTestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
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
	protected void print(String texto) {
		System.out.print(texto);
	}

	/**
	 * Imprime um texto.
	 * 
	 * @param texto
	 */
	protected void println(String texto) {
		System.out.println(texto);
	}
}
