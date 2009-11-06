/*
 * ServiceLocatorFactory.java
 * 
 * Data de cria��o: 18/06/2007
 */
package br.com.ap.arquitetura.servicelocator;

/**
 * Interface da f�brica de service locator.
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
	 * Retorna novo service locator. O service locator recuperado manter� cache
	 * de objetos e entendo o contexto inicial do container.
	 * 
	 * @param <S> Tipo de ServiceLocator
	 * @param <C> Tipo do objeto de contexto
	 * @param contexto Contexto da onde os servi�os ser�o recuperados.
	 * @return novo service locator.
	 */
	public <S extends ServiceLocator, C extends Object> S novoServiceLocator(C contexto);
}
