/*
 * ExclusaoLogica.java
 * 
 * Data de criação: 20/06/2008
 *
 */

package br.com.ap.comum.javabean.entidade;

/**
 * Interface para utilização de exclusão lógica
 * 
 * @author AdrianoP
 */
public interface ExclusaoLogica extends Entidade {

    /**
     * Campo para alteração do atributo para excluido
     * 
     * @param estado Estado da exclusão
     */
    public void setExcluido(Boolean estado);

}
