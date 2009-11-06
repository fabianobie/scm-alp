/*
 * UtilServiceLocatorException.java
 * 
 * Data de criação: 18/06/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.util.excecao;

import java.sql.SQLException;

import javax.naming.NamingException;

import br.com.ap.arquitetura.constante.MensagemID;
import br.com.ap.arquitetura.exception.ServiceLocatorException;
import br.com.ap.arquitetura.util.UtilLog;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.comum.excecao.UtilRuntimeExcecaoAbstrato;
import br.com.ap.comum.log.LogAbstrato;

/**
 * Tratamento das exceções lançadas pelo service locator. As mensagens de erro
 * são mapeadas no arquivo mensagem-infra.properties.
 * 
 * @author adrianop
 */
public final class UtilServiceLocatorException extends
		UtilRuntimeExcecaoAbstrato {

	/**
	 * Construtor.
	 */
	private UtilServiceLocatorException() {
		// Construtor
	}

	/**
	 * @param e
	 *            Excecao
	 * @return ServiceLocatorException
	 */
	public static ServiceLocatorException erro(Throwable e) {
		String chave = MensagemID.getErro();
		String mensagem = getMensagem(e);

		return converter(novaExcecao(e, chave, mensagem));
	}

	/**
	 * @param jndiName
	 *            JNDI name
	 * @return ServiceLocatorException
	 */
	public static ServiceLocatorException jndiNameNaoEncontrado(String jndiName) {
		String chave = MensagemID.getJndiNameNaoEncontrado();

		return converter(novaExcecao(chave, jndiName));
	}

	/**
	 * @param jndiName
	 *            JNDI name
	 * @param e
	 *            SQLException
	 * @return ServiceLocatorException
	 */
	public static ServiceLocatorException conexaoNaoEfetuada(String jndiName,
			SQLException e) {
		String chave = MensagemID.getConexaoNaoEfetuada();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, jndiName, erro));
	}

	/**
	 * @param e
	 *            NamingException
	 * @return ServiceLocatorException
	 */
	public static ServiceLocatorException erroAoCriarContexto(NamingException e) {
		String chave = MensagemID.getErroAoCriarContexto();
		String erro = getMensagem(e);

		return converter(novaExcecao(e, chave, erro));
	}

	/**
	 * Converte para ExecutorSQLException.
	 * 
	 * @param e
	 *            RuntimeExceptionAbstrato
	 * @return ServiceLocatorException
	 */
	private static ServiceLocatorException converter(RuntimeExceptionAbstrato e) {
		ServiceLocatorException excecao = new ServiceLocatorException(e);
		getLog().error("Ocorreu um erro", excecao);

		return excecao;
	}

	/**
	 * Retorna log.
	 * 
	 * @return log
	 */
	private static LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
