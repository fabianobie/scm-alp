/*
 * TransacaoAbstrato.java
 * 
 * Data de criação: 15/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.transacao;

import br.com.ap.comum.excecao.TransacaoException;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.util.UtilLog;
import br.com.ap.comum.util.UtilTransacaoException;

/**
 * Classe abstrata que provê recursos aos objetos de transação.
 * 
 * @param <T> Tipo do objeto que sofrerá a transação
 * @author adrianop
 */
public abstract class TransacaoAbstrato<T> implements Transacao<T> {

    private T conexao;

    /**
     * @see br.com.ap.comum.transacao.Transacao#getConexao()
     */
    public T getConexao() throws TransacaoException {
	if (!UtilObjeto.isReferencia(conexao)) {
	    throw UtilTransacaoException.conexaoNaoDefinida();
	}
	return conexao;
    }

    /**
     * @see br.com.ap.comum.transacao.Transacao#setConexao(java.lang.Object)
     */
    public void setConexao(T conexao) {
	this.conexao = conexao;
    }

    /**
     * Retorna true se o objeto tiver referência.
     * 
     * @param objeto Objeto validado.
     * @return true se o objeto tiver referência.
     */
    protected boolean isReferencia(Object objeto) {
	return UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna log.
     * 
     * @return log
     */
    protected LogAbstrato getLog() {
	return UtilLog.getLog();
    }
}
