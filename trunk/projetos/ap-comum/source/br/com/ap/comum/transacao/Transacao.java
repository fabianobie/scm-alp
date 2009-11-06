/*
 * ITransacao.java
 * 
 * Data de criação: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.transacao;

import br.com.ap.comum.excecao.TransacaoException;

/**
 * Interface que representa uma transação.
 * 
 * @param <T> Tipo do objeto que sofrerá a transação
 * @author adrianop
 */
public interface Transacao<T> {

    /**
     * Inicia a transação.
     * 
     * @throws TransacaoException Exceção de transação
     */
    public void iniciar() throws TransacaoException;

    /**
     * Commit da transação.
     * 
     * @throws TransacaoException Exceção de transação
     */
    public void commit() throws TransacaoException;

    /**
     * Rollback da transação.
     */
    public void rollback();

    /**
     * Finaliza a conexão.
     */
    public void finalizar();

    /**
     * Atribui o objeto no qual será efetuado o controle transacional
     * 
     * @param conexao Conexão
     */
    public void setConexao(T conexao);

    /**
     * Retorna o objeto no qual será efetuado o controle transacional
     * 
     * @return conexao
     * @throws TransacaoException Exceção de transação
     */
    public T getConexao() throws TransacaoException;
}
