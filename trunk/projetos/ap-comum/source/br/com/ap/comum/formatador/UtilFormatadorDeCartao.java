/*
 * UtilFormatadorDeCartao.java
 * Data: 26/01/2007
 * 
 *  
 * F�brica de Projetos - Bras�lia
 */
package br.com.ap.comum.formatador;

import br.com.ap.comum.constante.pattern.PatternDeFormatacao;
import br.com.ap.comum.string.UtilString;

/**
 * Formatador de cart�o.
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
	 * Formata um cart�o.
	 * 
	 * @param cartao Cart�o que ser� formatado.
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
	 * Formata um cart�o.
	 * 
	 * @param cartao Cart�o que ser� formatado.
	 * @return String formatada.
	 */
	public static String formatar(Number cartao) {
		return formatar(UtilString.getString(cartao));
	}
}
