/*
 * IFiltroMapa.java
 * 
 * Data de cria��o: 29/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface que representa um filtro aplicado em um determinado mapa.
 * 
 * @param <K> Tipo da chave do mapa.
 * @param <V> Tipo do objeto do mapa.
 * @author adrianop
 */
public interface FiltroMapa<K, V> extends Serializable {

    /**
     * Retorna true se o objeto ser� filtrado, se o retorno for falso o objeto
     * ser� removido do mapa.
     * 
     * @param chave chave do mapa.
     * @param valor objeto da chave do mapa.
     * @return true se o objeto ser� filtrado.
     */
    public boolean isFiltrado(K chave, V valor);
}
