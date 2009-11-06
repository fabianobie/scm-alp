/*
 * ServiceLocator.java
 * 
 * Data de cria��o: 18/06/2007
 */
package br.com.ap.arquitetura.servicelocator;

/**
 * Interface do service locator.
 * 
 * @author adrianop
 */
public interface ServiceLocator {

	/**
	 * Retorna o contexto fonte dos servi�os localizados.
	 * 
	 * @param <T> Tipo do objeto do contexto
	 * @return contexto atual ou solicitado.
	 */
	public <T extends Object> T getContexto();

	/**
	 * Efetua a localiza��o do servi�o solicitado no contexto atribu�do ao
	 * ServiceLocator.
	 * 
	 * @param <T> Tipo do objeto do servi�o
	 * @param id Identificador do servi�o, um endere�o JNDI ou outro.
	 * @return Objeto solicitado.
	 */
	public <T extends Object> T getServico(String id);
}