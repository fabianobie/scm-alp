/*
 * XmlException.java
 * 
 * Data de criação: 04/06/2007
 * 
 *
 *
 */
package br.com.ap.xml.excecao;

import br.com.ap.comum.excecao.ExceptionAbstrato;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.comum.string.UtilString;
import br.com.ap.xml.constante.Mensagem;
import br.com.ap.xml.util.UtilMensagem;

/**
 * Classe que representa uma exceção lançada pela API de XML.
 * 
 * @author AdrianoP
 */
public class XmlException extends RuntimeExceptionAbstrato {

    /**
     * Construtor.
     */
    public XmlException() {
	super();
    }

    /**
     * Construtor.
     * 
     * @param excecao Exceção
     */
    public XmlException(ExceptionAbstrato excecao) {
	super(excecao);
    }

    /**
     * Construtor.
     * 
     * @param excecao Exceção
     */
    public XmlException(RuntimeExceptionAbstrato excecao) {
	super(excecao);
    }

    /**
     * Construtor.
     * 
     * @param key Chave
     */
    public XmlException(String key) {
	super(key);
    }

    /**
     * Construtor.
     * 
     * @param key Chave
     * @param args Argumentos
     */
    public XmlException(String key, String... args) {
	super(key, args);
    }

    /**
     * @see br.com.ap.comum.excecao.RuntimeExceptionAbstrato#getKey()
     */
    public String getKey() {
	if (UtilString.isVazio(super.getKey())) {
	    super.setKey(Mensagem.getErro());
	}
	return super.getKey();
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
