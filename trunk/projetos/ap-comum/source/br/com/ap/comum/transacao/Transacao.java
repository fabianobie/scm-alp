/*
 * ITransacao.java
 * 
 * Data de cria��o: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.transacao;

import br.com.ap.comum.excecao.TransacaoException;

/**
 * Interface que representa uma transa��o.
 * 
 * @param <T> Tipo do objeto que sofrer� a transa��o
 * @author adrianop
 */
public interface Transacao<T> {

    /**
     * Inicia a transa��o.
     * 
     * @throws TransacaoException Exce��o de transa��o
     */
    public void iniciar() throws TransacaoException;

    /**
     * Commit da transa��o.
     * 
     * @throws TransacaoException Exce��o de transa��o
     */
    public void commit() throws TransacaoException;

    /**
     * Rollback da transa��o.
     */
    public void rollback();

    /**
     * Finaliza a conex�o.
     */
    public void finalizar();

    /**
     * Atribui o objeto no qual ser� efetuado o controle transacional
     * 
     * @param conexao Conex�o
     */
    public void setConexao(T conexao);

    /**
     * Retorna o objeto no qual ser� efetuado o controle transacional
     * 
     * @return conexao
     * @throws TransacaoException Exce��o de transa��o
     */
    public T getConexao() throws TransacaoException;
}
