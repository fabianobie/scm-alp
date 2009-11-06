/*
 * Entidade.java
 * 
 * Data de cria��o: 20/06/2008
 *
 */

package br.com.ap.comum.javabean.entidade;

import java.io.Serializable;

import br.com.ap.comum.javabean.JavaBean;

/**
 * Interface pai de todas as entidades para utiliza��o do identificador.
 * 
 * @author AdrianoP
 */
public interface Entidade extends JavaBean {

    /**
     * @return O identificador da entidade
     */
    public Serializable getIdentificador();

}
