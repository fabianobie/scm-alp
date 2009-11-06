/*
 * ServiceLocatorWeb.java
 * 
 * Data de cria��o: 20/03/2009
 */
package br.com.ap.arquitetura.servicelocator.web;

import java.sql.Connection;

import javax.sql.DataSource;

import br.com.ap.arquitetura.servicelocator.ServiceLocator;

/**
 * Interface de acesso aos servi�os do container web.
 * 
 * @author AdrianoP
 */
public interface ServiceLocatorWeb extends ServiceLocator {

	/**
	 * Retorna uma string com a vari�vel de ambiente solicitada.
	 * 
	 * @param jndi JNDI
	 * @return String da vari�vel de ambiente.
	 * @throws br.com.ap.arquitetura.exception.ServiceLocatorException
	 */
	public String getString(String jndi);

	/**
	 * Retorna um integer com a vari�vel de ambiente solicitada.
	 * 
	 * @param jndi JNDI
	 * @return Integer da vari�vel de ambiente.
	 * @throws br.com.ap.arquitetura.exception.ServiceLocatorException
	 */
	public Integer getInteger(String jndi);

	/**
	 * Retorna o datasource solicitado.
	 * 
	 * @param jndi JNDI
	 * @return DataSource solicitado.
	 * @throws br.com.ap.arquitetura.exception.ServiceLocatorException
	 */
	public DataSource getDataSource(String jndi);

	/**
	 * Retorna uma conex�o do datasource solicitado atrav�s do endere�o JNDI.
	 * 
	 * @param jndi JNDI do Datasource.
	 * @return Uma conex�o do datasource.
	 * @throws br.com.ap.arquitetura.exception.ServiceLocatorException
	 */
	public Connection getConexao(String jndi);
}
