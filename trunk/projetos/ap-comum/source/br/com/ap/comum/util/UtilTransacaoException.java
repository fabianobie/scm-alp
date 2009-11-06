/*
 * UtilTransacaoException.java
 * 
 * Data de criação: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.util;

import java.sql.SQLException;

import br.com.ap.comum.constante.Mensagem;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.comum.excecao.TransacaoException;
import br.com.ap.comum.excecao.UtilRuntimeExcecaoAbstrato;
import br.com.ap.comum.log.LogAbstrato;

/**
 * Tratamento das exceções da transação. As mensagens de erro são mapeadas no
 * arquivo mensagem-infra.properties.
 * 
 * @author adrianop
 */
public final class UtilTransacaoException extends UtilRuntimeExcecaoAbstrato {

	/**
	 * Construtor.
	 */
	private UtilTransacaoException() {
		// Construtor.
	}

	/**
	 * @param e Excecao
	 * @return TransacaoException
	 */
	public static TransacaoException erro(Throwable e) {
		String chave = Mensagem.getErro();
		String mensagem = getMensagem(e);

		return converter(novaExcecao(e, chave, mensagem));
	}

	/**
	 * @return TransacaoException
	 */
	public static TransacaoException conexaoNaoDefinida() {
		String chave = Mensagem.getConexaoNaoDefinida();

		return converter(novaExcecao(chave));
	}

	/**
	 * @param e SQLException
	 * @return TransacaoException
	 */
	public static TransacaoException transacaoNaoIniciada(SQLException e) {
		String chave = Mensagem.getTransacaoNaoIniciada();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e SQLException
	 * @return TransacaoException
	 */
	public static TransacaoException erroAoEfetuarOCommit(SQLException e) {
		String chave = Mensagem.getErroAoEfetuarOCommit();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e SQLException
	 * @return TransacaoException
	 */
	public static TransacaoException erroAoEfetuarORollback(SQLException e) {
		String chave = Mensagem.getErroAoEfetuarORollback();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * Converte para TransacaoException.
	 * 
	 * @param e RuntimeExceptionAbstrato
	 * @return TransacaoException
	 */
	private static TransacaoException converter(RuntimeExceptionAbstrato e) {
		TransacaoException excecao = new TransacaoException(e);
		getLog().error("Ocorreu um erro", excecao);

		return excecao;
	}

	/**
	 * Retorna UtilLog.
	 * 
	 * @return UtilLog
	 */
	private static LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
