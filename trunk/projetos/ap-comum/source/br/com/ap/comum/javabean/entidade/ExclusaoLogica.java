/*
 * ExclusaoLogica.java
 * 
 * Data de cria��o: 20/06/2008
 *
 */

package br.com.ap.comum.javabean.entidade;

/**
 * Interface para utiliza��o de exclus�o l�gica
 * 
 * @author AdrianoP
 */
public interface ExclusaoLogica extends Entidade {

    /**
     * Campo para altera��o do atributo para excluido
     * 
     * @param estado Estado da exclus�o
     */
    public void setExcluido(Boolean estado);

}
