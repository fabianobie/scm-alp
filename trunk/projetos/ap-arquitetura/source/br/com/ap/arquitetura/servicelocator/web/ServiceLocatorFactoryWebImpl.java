/*
 * ServiceLocatorFactoryWebImpl.java
 * 
 * Data de cria��o: 18/06/2007
 */
package br.com.ap.arquitetura.servicelocator.web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ap.arquitetura.servicelocator.ServiceLocatorFactory;
import br.com.ap.arquitetura.util.excecao.UtilServiceLocatorException;

/**
 * Respons�vel pela f�brica do service locator para container web.
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
	 * Retorna nova inst�ncia da classe.<br>
	 * Padr�o singleton.
	 * 
	 * @return int�ncia da classe.
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
