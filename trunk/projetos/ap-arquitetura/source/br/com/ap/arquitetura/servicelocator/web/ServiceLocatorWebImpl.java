/*
 * ServiceLocator.java
 * 
 * Data de criação: 18/06/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.servicelocator.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import br.com.ap.arquitetura.servicelocator.ServiceLocatorAbstrato;
import br.com.ap.arquitetura.util.excecao.UtilServiceLocatorException;
import br.com.ap.comum.string.UtilString;

/**
 * Classe responsável em encapsular o solicitação de serviços.<br>
 * Padrão Service Locator
 * 
 * @author adrianop
 */
public class ServiceLocatorWebImpl extends ServiceLocatorAbstrato<Context>
        implements ServiceLocatorWeb {

	/**
	 * @see br.com.ap.arquitetura.servicelocator.ServiceLocatorAbstrato#getContexto()
	 */
	@SuppressWarnings("unchecked")
	public Context getContexto() {
		return super.getContexto();
	}

	/**
	 * @see br.com.ap.arquitetura.servicelocator.ServiceLocator#getServico(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public <T> T getServico(String id) {
		T resultado = null;

		if (!UtilString.isVazio(id)) {
			try {

				if (isObjetoEmCache(id)) {
					resultado = (T) recuperarObjetoDoCache(id);
				} else {
					resultado = (T) getContexto().lookup(id);
					adicionarObjetoNoCache(id, resultado);
				}
			} catch (NamingException e) {
				throw UtilServiceLocatorException.jndiNameNaoEncontrado(id);
			}
		}
		return resultado;
	}

	/**
	 * @see br.com.ap.arquitetura.servicelocator.web.ServiceLocatorWeb#getConexao(java.lang.String)
	 */
	public Connection getConexao(String jndi) {
		Connection connection = null;

		try {
			DataSource dataSource = getDataSource(jndi);
			if (isReferencia(dataSource)) {
				connection = dataSource.getConnection();
				connection.setAutoCommit(false);
			}
		} catch (SQLException e) {
			throw UtilServiceLocatorException.conexaoNaoEfetuada(jndi, e);
		}

		return connection;
	}

	/**
	 * @see br.com.ap.arquitetura.servicelocator.web.ServiceLocatorWeb#getDataSource(java.lang.String)
	 */
	public DataSource getDataSource(String jndi) {
		return (DataSource) getServico(jndi);
	}

	/**
	 * @see br.com.ap.arquitetura.servicelocator.web.ServiceLocatorWeb#getInteger(java.lang.String)
	 */
	public Integer getInteger(String jndi) {
		return (Integer) getServico(jndi);
	}

	/**
	 * @see br.com.ap.arquitetura.servicelocator.web.ServiceLocatorWeb#getString(java.lang.String)
	 */
	public String getString(String jndi) {
		return (String) getServico(jndi);
	}
}
