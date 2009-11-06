/*
 * TransacaoJDBC.java
 * 
 * Data de criação: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.transacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.ap.comum.excecao.TransacaoException;
import br.com.ap.comum.util.UtilTransacaoException;

/**
 * Implementação de transação para JDBC.
 * 
 * @author adrianop
 * @see Transacao
 */
public class TransacaoJDBC extends TransacaoAbstrato<Connection> {

    /**
     * @see br.com.ap.comum.transacao.Transacao#iniciar()
     */
    public void iniciar() throws TransacaoException {
	try {
	    getConexao().setAutoCommit(false);
	} catch (SQLException e) {
	    throw UtilTransacaoException.transacaoNaoIniciada(e);
	}
    }

    /**
     * @see br.com.ap.comum.transacao.Transacao#commit()
     */
    public void commit() throws TransacaoException {
	try {
	    getConexao().commit();
	} catch (SQLException e) {
	    throw UtilTransacaoException.erroAoEfetuarOCommit(e);
	}
    }

    /**
     * @see br.com.ap.comum.transacao.Transacao#rollback()
     */
    public void rollback() {
	try {
	    getConexao().rollback();
	} catch (SQLException e) {
	    getLog().warn("Erro ao efetuar rollback na conexão.", e);
	} catch (TransacaoException e) {
	    getLog().warn(e.getMessage());
	}
    }

    /**
     * @see br.com.ap.comum.transacao.Transacao#finalizar()
     */
    public void finalizar() {
	try {
	    getConexao().close();
	} catch (SQLException e) {
	    getLog().warn("Erro ao fechar a conexão.", e);
	} catch (TransacaoException e) {
	    getLog().warn(e.getMessage());
	} finally {
	    setConexao(null);
	}
    }
}
