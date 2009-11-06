/*
 * ServiceLocator.java
 * 
 * Data de criação: 18/06/2007
 */
package br.com.ap.arquitetura.servicelocator;

/**
 * Interface do service locator.
 * 
 * @author adrianop
 */
public interface ServiceLocator {

	/**
	 * Retorna o contexto fonte dos serviços localizados.
	 * 
	 * @param <T> Tipo do objeto do contexto
	 * @return contexto atual ou solicitado.
	 */
	public <T extends Object> T getContexto();

	/**
	 * Efetua a localização do serviço solicitado no contexto atribuído ao
	 * ServiceLocator.
	 * 
	 * @param <T> Tipo do objeto do serviço
	 * @param id Identificador do serviço, um endereço JNDI ou outro.
	 * @return Objeto solicitado.
	 */
	public <T extends Object> T getServico(String id);
}