/*
 * UtilInfraRuntimeException.java
 * 
 * Data de criação: 18/06/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.util.excecao;

import br.com.ap.arquitetura.constante.MensagemID;
import br.com.ap.arquitetura.exception.ArquiteturaException;
import br.com.ap.arquitetura.util.UtilLog;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.comum.excecao.UtilRuntimeExcecaoAbstrato;
import br.com.ap.comum.log.LogAbstrato;

/**
 * Tratamento das exceções de Sistema. As mensagens de erro são mapeadas no
 * arquivo mensagem.properties.
 * 
 * @author adrianop
 */
public final class UtilArquiteturaException extends UtilRuntimeExcecaoAbstrato {

	/**
	 * Construtor.
	 */
	private UtilArquiteturaException() {
		// Construtor.
	}

	/**
	 * @param e
	 *            Excecao
	 * @return ArquiteturaException
	 */
	public static ArquiteturaException erro(Throwable e) {
		String chave = MensagemID.getErro();
		String mensagem = getMensagem(e);

		return converter(novaExcecao(e, chave, mensagem));
	}

	/**
	 * @return ArquiteturaException
	 */
	public static ArquiteturaException profileInexistente() {
		String chave = MensagemID.getProfileInexistente();

		return converter(novaExcecao(chave));
	}

	/**
	 * Converte para ArquiteturaException.
	 * 
	 * @param e
	 *            RuntimeExceptionAbstrato
	 * @return ArquiteturaException
	 */
	private static ArquiteturaException converter(RuntimeExceptionAbstrato e) {
		ArquiteturaException excecao = new ArquiteturaException(e);
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
