/*
 * ReflexaoException.java 
 * 
 * Data de criação: 23/02/2007 
 * 
 *
 *
 */
package br.com.ap.reflexao.excecao;

import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.reflexao.util.UtilMensagem;

/**
 * Classe que representa uma exceção ocorrida na API de reflexao.
 * 
 * @author AdrianoP
 */
public class ReflexaoException extends RuntimeExceptionAbstrato {

    /**
     * Construtor.
     */
    public ReflexaoException() {
	super();
    }

    /**
     * Construtor.
     * 
     * @param excecao Exceção
     */
    public ReflexaoException(RuntimeExceptionAbstrato excecao) {
	super(excecao);
    }

    /**
     * Construtor.
     * 
     * @param key chave
     */
    public ReflexaoException(String key) {
	super(key);
    }

    /**
     * Construtor.
     * 
     * @param key chave
     * @param args argumentos
     */
    public ReflexaoException(String key, String... args) {
	super(key, args);
    }

    /**
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
	return getUtilMensagem().getMensagem(getKey(), getArgs());
    }

    /**
     * Retorna UtilMensagem.
     * 
     * @return UtilMensagem
     */
    private UtilMensagem getUtilMensagem() {
	return UtilMensagem.getInstancia();
    }

}
