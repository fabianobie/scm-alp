/*
 * ServiceLocatorFactoryWebImpl.java
 * 
 * Data de criação: 18/06/2007
 */
package br.com.ap.arquitetura.servicelocator.web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ap.arquitetura.servicelocator.ServiceLocatorFactory;
import br.com.ap.arquitetura.util.excecao.UtilServiceLocatorException;

/**
 * Responsável pela fábrica do service locator para container web.
 * 
 * @author adrianop
 */
public final class ServiceLocatorFactoryWebImpl implements
        ServiceLocatorFactory {

	private static ServiceLocatorFactoryWebImpl instancia = new ServiceLocatorFactoryWebImpl();

	/**
	 * Construtor.
	 */
	private ServiceLocatorFactoryWebImpl() {
		// Construtor.
	}

	/**
	 * Retorna nova instância da classe.<br>
	 * Padrão singleton.
	 * 
	 * @return intância da classe.
	 */
	public static ServiceLocatorFactoryWebImpl getInstancia() {
		return instancia;
	}

	/**
	 * @see br.com.ap.arquitetura.servicelocator.ServiceLocatorFactory#novoServiceLocator()
	 */
	@SuppressWarnings("unchecked")
	public ServiceLocatorWeb novoServiceLocator() {
		ServiceLocatorWebImpl locator = novoServiceLocatorWebImpl();
		locator.setContexto(novoContexto());

		return locator;
	}

	/**
	 * @see br.com.ap.arquitetura.servicelocator.ServiceLocatorFactory#novoServiceLocator(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public ServiceLocatorWeb novoServiceLocator(Object contexto) {
		ServiceLocatorWebImpl locator = novoServiceLocatorWebImpl();
		locator.setContexto((Context) contexto);

		return locator;
	}

	/**
	 * @return Contexto
	 */
	public Context novoContexto() {
		InitialContext contexto;
		try {
			contexto = new InitialContext();
		} catch (NamingException e) {
			throw UtilServiceLocatorException.erroAoCriarContexto(e);
		}
		return contexto;
	}

	/**
	 * @return novo service locator web
	 */
	protected ServiceLocatorWebImpl novoServiceLocatorWebImpl() {
		return new ServiceLocatorWebImpl();
	}

}
