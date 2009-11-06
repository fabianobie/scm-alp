/*
 * IFiltro.java
 * 
 * Data de cria��o: 25/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface que representa um filtro aplicado em uma determinada cole��o.
 * 
 * @param <T> Tipo do objeto que ser� filtrado.
 * @author AdrianoP
 */
public interface Filtro<T> extends Serializable {

    /**
     * Retorna true se o objeto ser� filtrado, se o retorno for falso o objeto
     * ser� removido.
     * 
     * @param objeto Objeto verificado
     * @return true se o objeto ser� filtrado.
     */
    public boolean isFiltrado(T objeto);
}
