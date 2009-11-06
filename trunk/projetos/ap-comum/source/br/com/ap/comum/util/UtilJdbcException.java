/*
 * UtilJdbcException.java
 * 
 * Data de criação: 04/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.util;

import java.sql.SQLException;

import br.com.ap.comum.constante.Mensagem;
import br.com.ap.comum.excecao.JdbcException;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.comum.excecao.UtilRuntimeExcecaoAbstrato;
import br.com.ap.comum.log.LogAbstrato;

/**
 * Tratamento das exceções da transação. As mensagens de erro são mapeadas no
 * arquivo mensagem-generico.properties.
 * 
 * @author adrianop
 */
public final class UtilJdbcException extends UtilRuntimeExcecaoAbstrato {

	/**
	 * Construtor.
	 */
	private UtilJdbcException() {
		// Construtor.
	}

	/**
	 * @param e Excecao
	 * @return JdbcException
	 */
	public static JdbcException erro(Throwable e) {
		String chave = Mensagem.getErro();
		String mensagem = getMensagem(e);

		return converter(novaExcecao(e, chave, mensagem));
	}

	/**
	 * @param e SQLException
	 * @return JdbcException
	 */
	public static JdbcException erroAoCriarOStatement(SQLException e) {
		String chave = Mensagem.getErroAoCriarOStatement();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e SQLException
	 * @param sql SQL
	 * @return JdbcException
	 */
	public static JdbcException erroAoInvocarSQL(SQLException e, String sql) {
		String chave = Mensagem.getErroAoInvocarSQL();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro, sql));
	}

	/**
	 * @param indice índice
	 * @param e SQLException
	 * @return JdbcException
	 */
	public static JdbcException erroAoRecuperarAColunaDoCallable(int indice,
			SQLException e) {
		String chave = Mensagem.getErroAoRecuperarAColunaDoCallable();
		String coluna = String.valueOf(indice);
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, coluna, erro));
	}

	/**
	 * @param coluna Coluna do resultset.
	 * @param e SQLException
	 * @return JdbcException
	 */
	public static JdbcException erroAoRecuperarAColunaDoResultSet(
			String coluna, SQLException e) {
		String chave = Mensagem.getErroAoRecuperarAColunaDoResultSet();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, coluna, erro));
	}

	/**
	 * @param e SQLException
	 * @return JdbcException
	 */
	public static JdbcException erroAoRecuperarOMetadata(SQLException e) {
		String chave = Mensagem.getErroAoRecuperarOMetadata();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e SQLException
	 * @return JdbcException
	 */
	public static JdbcException erroAoIrAoProximoRegistroDoResultset(
			SQLException e) {
		String chave = Mensagem.getErroAoIrAoProximoRegistroDoResultset();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e SQLException
	 * @return JdbcException
	 */
	public static JdbcException erroAoRecuperarAQuantidadeDeColunasDoRegistro(
			SQLException e) {
		String chave = Mensagem
				.getErroAoRecuperarAQuantidadeDeColunasDoRegistro();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e SQLException
	 * @return JdbcException
	 */
	public static JdbcException erroAoRecuperarONomeDaColunaDoRegistro(
			SQLException e) {
		String chave = Mensagem.getErroAoRecuperarONomeDaColunaDoRegistro();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * @param e SQLException
	 * @return JdbcException
	 */
	public static JdbcException erroAoRecuperarOTipoDaColunaDoRegistro(
			SQLException e) {
		String chave = Mensagem.getErroAoRecuperarOTipoDaColunaDoRegistro();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * Converte para TransacaoException.
	 * 
	 * @param e RuntimeExceptionAbstrato
	 * @return TransacaoException
	 */
	private static JdbcException converter(RuntimeExceptionAbstrato e) {
		JdbcException excecao = new JdbcException(e);
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
