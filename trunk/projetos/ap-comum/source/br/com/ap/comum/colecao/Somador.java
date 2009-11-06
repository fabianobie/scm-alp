/*
 * ISomador.java
 * 
 * Data de cria��o: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface que representa um somador.
 * 
 * @param <T> Tipo do objeto que ser� usado pela soma.
 * @author AdrianoP
 */
public interface Somador<T> extends Serializable {

    /**
     * Retorna o valor que ser� somado.
     * 
     * @param objeto Objeto verificado.
     * @return o valor que ser� somado.
     */
    public double getValor(T objeto);
}
