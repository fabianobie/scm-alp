/*
 * IAlteradorMapa.java
 * 
 * Data de criação: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface representa a alteração em um mapa.
 * 
 * @param <K> Tipo da chave do mapa.
 * @param <V> Tipo do objeto do mapa.
 * @author AdrianoP
 */
public interface AlteradorMapa<K, V> extends Serializable {

    /**
     * Altera a chave de um mapa.
     * 
     * @param objeto Chave do mapa.
     * @return Objeto alterado
     */
    public Object alterarChave(K objeto);

    /**
     * Altera o objeto de um mapa.
     * 
     * @param objeto Objeto do mapa.
     * @return Objeto alterado
     */
    public Object alterarValor(V objeto);
}
