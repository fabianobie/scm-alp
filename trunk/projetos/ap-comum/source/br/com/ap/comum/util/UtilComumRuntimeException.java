/*
 * UtilComumRuntimeException.java
 * 
 * Data de criação: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.util;

import br.com.ap.comum.constante.Mensagem;
import br.com.ap.comum.excecao.ComumRuntimeException;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.comum.excecao.UtilRuntimeExcecaoAbstrato;
import br.com.ap.comum.log.LogAbstrato;

/**
 * Classe responsável em centralizar o tratamento das mensagens de exceção.
 * 
 * @author adrianop
 */
public final class UtilComumRuntimeException extends
		UtilRuntimeExcecaoAbstrato {

	/**
	 * Construtor.
	 */
	private UtilComumRuntimeException() {
		// construtor
	}

	/**
	 * @param e Exceção
	 * @return ComumException
	 */
	public static ComumRuntimeException erro(Throwable e) {
		String chave = Mensagem.getErro();

		return converter(novaExcecao(e, chave));
	}

	/**
	 * @param classe Classe não encontrada
	 * @return ComumRuntimeException
	 */
	public static ComumRuntimeException erroAoCriarInstancia(String classe) {
		String chave = Mensagem.getErroAoCriarInstancia();

		return converter(novaExcecao(chave, classe));
	}

	/**
	 * Converte uma ExceptionAbstrato em um ComumRuntimeException.
	 * 
	 * @param e RuntimeExceptionAbstrato
	 * @return nova ComumRuntimeException
	 */
	private static ComumRuntimeException converter(RuntimeExceptionAbstrato e) {
		ComumRuntimeException excecao = new ComumRuntimeException(e);
		getLog().error("Ocorreu um erro.", excecao);

		return excecao;
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	private static LogAbstrato getLog() {
		return UtilLog.getLog();
	}

}
