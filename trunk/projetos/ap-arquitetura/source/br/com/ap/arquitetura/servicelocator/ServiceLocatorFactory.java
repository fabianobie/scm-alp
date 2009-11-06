/*
 * ServiceLocatorFactory.java
 * 
 * Data de criação: 18/06/2007
 */
package br.com.ap.arquitetura.servicelocator;

/**
 * Interface da fábrica de service locator.
 * 
 * @author adrianop
 */
public interface ServiceLocatorFactory {

	/**
	 * Retorna novo service locator.
	 * 
	 * @param <S> Tipo de ServiceLocator
	 * @return novo service locator.
	 */
	public <S extends ServiceLocator> S novoServiceLocator();

	/**
	 * Retorna novo service locator. O service locator recuperado manterá cache
	 * de objetos e entendo o contexto inicial do container.
	 * 
	 * @param <S> Tipo de ServiceLocator
	 * @param <C> Tipo do objeto de contexto
	 * @param contexto Contexto da onde os serviços serão recuperados.
	 * @return novo service locator.
	 */
	public <S extends ServiceLocator, C extends Object> S novoServiceLocator(C contexto);
}
