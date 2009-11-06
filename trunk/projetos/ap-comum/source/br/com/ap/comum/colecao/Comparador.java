/*
 * IComparador.java
 * 
 * Data de cria��o: 28/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.colecao;

import java.io.Serializable;

/**
 * Interface que representa um comparador de objetos.
 * 
 * @param <T1> Objeto prim�rio da compara��o.
 * @param <T2> Objeto secund�rio da compara��o.
 * @author Adrianop
 */
public interface Comparador<T1, T2> extends Serializable {

    /**
     * Compara dois objetos e retorna se ambos s�o iguais.
     * 
     * @param objeto1 Objeto validado
     * @param objeto2 Objeto validado
     * @return true se os dois objetos s�o iguais.
     */
    public boolean isIguais(T1 objeto1, T2 objeto2);
}
