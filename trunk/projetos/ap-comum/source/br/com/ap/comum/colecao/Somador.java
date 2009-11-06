/*
 * ISomador.java
 * 
 * Data de criação: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface que representa um somador.
 * 
 * @param <T> Tipo do objeto que será usado pela soma.
 * @author AdrianoP
 */
public interface Somador<T> extends Serializable {

    /**
     * Retorna o valor que será somado.
     * 
     * @param objeto Objeto verificado.
     * @return o valor que será somado.
     */
    public double getValor(T objeto);
}
