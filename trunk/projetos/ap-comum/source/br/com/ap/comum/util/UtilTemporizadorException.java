/*
 * UtilTemporizadorException.java
 * 
 * Data de criação: 24/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.util;

import br.com.ap.comum.constante.Mensagem;
import br.com.ap.comum.excecao.RuntimeExceptionAbstrato;
import br.com.ap.comum.excecao.TemporizadorException;
import br.com.ap.comum.excecao.UtilRuntimeExcecaoAbstrato;

/**
 * Classe responsável em centralizar o tratamento das mensagens de exceção.
 * 
 * @author AdrianoP
 */
public final class UtilTemporizadorException extends
		UtilRuntimeExcecaoAbstrato {

	/**
	 * Construtor.
	 */
	private UtilTemporizadorException() {
		// construtor
	}

	/**
	 * @param e Exceção
	 * @return TemporizadorException
	 */
	public static TemporizadorException erro(Throwable e) {
		String chave = Mensagem.getErro();

		return converter(novaExcecao(e, chave));
	}

	/**
	 * @param decorrido tempo decorrido
	 * @param sugerido tempo sugerido
	 * @return TemporizadorException
	 */
	public static TemporizadorException tempoDeRespostaExpirado(int decorrido,
			int sugerido) {
		String chave = Mensagem.getTempoDeResposta();
		String arg0 = String.valueOf(decorrido);
		String arg1 = String.valueOf(sugerido);

		return converter(novaExcecao(chave, arg0, arg1));
	}

	/**
	 * Converte uma exceção
	 * 
	 * @param e RuntimeExceptionAbstrato
	 * @return nova ComumRuntimeException
	 */
	private static TemporizadorException converter(RuntimeExceptionAbstrato e) {
		return new TemporizadorException(e);
	}
}
