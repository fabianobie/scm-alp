/*
 * TOAbstrato.java
 * 
 * Data de cria��o: 24/04/2007
 * 
 */
package br.com.ap.comum.javabean.to;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que prov� os recursos necess�rio para um TO.
 * 
 * @author adrianop
 */
public abstract class TOAbstrato implements TO {

    /**
     * @param o Objeto
     * @return resultado da compara��o
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(TO o) {
	return 0;
    }

    /**
     * Retorna ColecaoFactory.
     * 
     * @return ColecaoFactory
     */
    protected ColecaoFactory getColecaoFactory() {
	return ColecaoFactory.getInstancia();
    }

    /**
     * @return NumeroFactory
     */
    protected NumeroFactory getNumeroFactory() {
	return NumeroFactory.getInstancia();
    }

    /**
     * Retorna true se o objeto tiver refer�ncia.
     * 
     * @param objetos Objetos validados.
     * @return true se o objeto tiver refer�ncia.
     */
    protected boolean isReferencia(Object... objetos) {
	return UtilObjeto.isReferenciaTodos(objetos);
    }

    /**
     * Retorna true se a string for vazia.
     * 
     * @param strings Strings validadas.
     * @return true se a string for vazia.
     */
    protected boolean isVazio(String... strings) {
	return UtilString.isVazioTodos(strings);
    }
}
