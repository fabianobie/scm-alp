/*
 * ServiceLocatorAbstrato.java
 * 
 * Data de criação: Jun 18, 2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.servicelocator;

import java.util.Map;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe abstrata que provê recursos aos service locator's.
 * 
 * @param <T> Tipo do objeto usado como contexto
 * @author adrianop
 */
public abstract class ServiceLocatorAbstrato<T extends Object> implements
        ServiceLocator {

	private T                   contexto;
	private boolean             cache = true;
	private Map<String, Object> objetos;

	/**
	 * Retorna contexto.
	 * 
	 * @return Context
	 */
	@SuppressWarnings("unchecked")
	public T getContexto() {
		return contexto;
	}

	/**
     * Atribui contexto.
     * 
     * @param contexto Context
     */
    public void setContexto(T contexto) {
    	this.contexto = contexto;
    }

	/**
	 * Adiciona um objeto no cache de objetos solicitados. <br>
	 * O objeto somente será armazenado em cache se for autorizado pela classe.
	 * 
	 * @param <T> Tipo do objeto adicionado no cache
	 * @param id ID
	 * @param objeto Objeto solicitado
	 */
	@SuppressWarnings("hiding")
    protected <T extends Object> void adicionarObjetoNoCache(String id,
	        T objeto) {
		if (isCache()) {
			getObjetos().put(id, objeto);
		}
	}

	/**
	 * Retorna novo ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Atribui cache.
	 * 
	 * @param cache cache
	 */
	protected void setCache(boolean cache) {
		this.cache = cache;
	}

	/**
	 * Retorna cache.
	 * 
	 * @return boolean
	 */
	protected boolean isCache() {
		return cache;
	}

	/**
	 * Retorna true se o objeto do endereço JNDI solicitado está em cache.
	 * 
	 * @param id Endereço JNDI
	 * @return true se o objeto estiver em cache.
	 */
	protected boolean isObjetoEmCache(String id) {
		return getObjetos().containsKey(id);
	}

	/**
	 * Retorna true se o objeto tiver referência.
	 * 
	 * @param objetos Objetos validados
	 * @return true se o objeto tiver referência.
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Recupera um objeto do cache.
	 * 
	 * @param <T> Tipo do objeto recuperado
	 * @param id ID do objeto solicitado.
	 * @return Objeto do cache.
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	protected <T extends Object> T recuperarObjetoDoCache(String id) {
		return (T) getObjetos().get(id);
	}

	/**
	 * Retorna mapa de objetos em cache.
	 * 
	 * @return Map de objetos
	 */
	private Map<String, Object> getObjetos() {
		if (!isReferencia(objetos)) {
			objetos = getColecaoFactory().novoHashMap();
		}
		return objetos;
	}
}
