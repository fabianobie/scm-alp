/*
 * IAlterador.java
 * 
 * Data de criação: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface representa a alteração em um objeto.
 * 
 * @param <T> Tipo do objeto que sofrerá a alteração.
 * @author AdrianoP
 */
public interface Alterador<T> extends Serializable {

    /**
     * Altera um objeto.
     * 
     * @param objeto Objeto que sofrerá a alteração.
     * @return Objeto alterado
     */
    public T alterar(T objeto);
}
