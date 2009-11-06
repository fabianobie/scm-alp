/*
 * UtilFormatadorDeCartao.java
 * Data: 26/01/2007
 * 
 *  
 * Fábrica de Projetos - Brasília
 */
package br.com.ap.comum.formatador;

import br.com.ap.comum.constante.pattern.PatternDeFormatacao;
import br.com.ap.comum.string.UtilString;

/**
 * Formatador de cartão.
 * 
 * @author AdrianoP
 */
public final class UtilFormatadorDeCartao extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeCartao() {
		// Construtor.
	}

	/**
	 * Formata um cartão.
	 * 
	 * @param cartao Cartão que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(String cartao) {
		String resultado = null;

		if (!isVazio(cartao)) {
			String pattern = PatternDeFormatacao.getCartao();
			resultado = formatarString(cartao, pattern);
		}
		return resultado;
	}

	/**
	 * Formata um cartão.
	 * 
	 * @param cartao Cartão que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(Number cartao) {
		return formatar(UtilString.getString(cartao));
	}
}
