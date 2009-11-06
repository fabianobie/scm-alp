/*
 * IAlterador.java
 * 
 * Data de cria��o: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface representa a altera��o em um objeto.
 * 
 * @param <T> Tipo do objeto que sofrer� a altera��o.
 * @author AdrianoP
 */
public interface Alterador<T> extends Serializable {

    /**
     * Altera um objeto.
     * 
     * @param objeto Objeto que sofrer� a altera��o.
     * @return Objeto alterado
     */
    public T alterar(T objeto);
}
