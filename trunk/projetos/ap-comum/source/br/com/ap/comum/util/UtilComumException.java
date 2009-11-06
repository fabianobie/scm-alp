/*
 * UtilComumException.java
 * 
 * Data de criação: 27/07/2007
 *
 * 
 * 
 */
package br.com.ap.comum.util;

import br.com.ap.comum.constante.Mensagem;
import br.com.ap.comum.excecao.ComumException;
import br.com.ap.comum.excecao.ExceptionAbstrato;
import br.com.ap.comum.excecao.UtilExcecaoAbstrato;
import br.com.ap.comum.log.LogAbstrato;

/**
 * Classe responsável em centralizar o tratamento das mensagens de exceção.
 * 
 * @author adrianop
 */
public final class UtilComumException extends UtilExcecaoAbstrato {

	/**
	 * @param e Exceção
	 * @return ComumException
	 */
	public static ComumException erro(Throwable e) {
		String chave = Mensagem.getErro();

		return converter(novaExcecao(e, chave));
	}

	/**
	 * Converte uma ExceptionAbstrato em um ComumRuntimeException.
	 * 
	 * @param e ExceptionAbstrato
	 * @return nova ReflectionException
	 */
	private static ComumException converter(ExceptionAbstrato e) {
		ComumException excecao = new ComumException(e);
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
