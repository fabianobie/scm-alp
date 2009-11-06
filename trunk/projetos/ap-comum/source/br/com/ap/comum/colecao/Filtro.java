/*
 * IFiltro.java
 * 
 * Data de criação: 25/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface que representa um filtro aplicado em uma determinada coleção.
 * 
 * @param <T> Tipo do objeto que será filtrado.
 * @author AdrianoP
 */
public interface Filtro<T> extends Serializable {

    /**
     * Retorna true se o objeto será filtrado, se o retorno for falso o objeto
     * será removido.
     * 
     * @param objeto Objeto verificado
     * @return true se o objeto será filtrado.
     */
    public boolean isFiltrado(T objeto);
}
