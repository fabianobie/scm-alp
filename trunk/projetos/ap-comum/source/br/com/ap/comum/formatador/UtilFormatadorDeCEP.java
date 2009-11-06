/*
 * UtilFormatadorDeCEP.java
 * Data: 26/01/2007
 * 
 *  
 * F�brica de Projetos - Bras�lia
 */
package br.com.ap.comum.formatador;

import br.com.ap.comum.constante.pattern.PatternDeFormatacao;

/**
 * Formatador de Cep.
 * 
 * @author adrianop
 */
public final class UtilFormatadorDeCEP extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeCEP() {
		// Construtor.
	}

	/**
	 * Formata a string.
	 * 
	 * @param cep String que ser� formatada.
	 * @return String formatada.
	 */
	public static String formatar(String cep) {
		String result = cep;

		if (isValido(cep)) {
			result = formatarString(cep, PatternDeFormatacao.getCEP());
		}

		return result;
	}

	/**
	 * Verifica se a string � um CEP v�lido.
	 * 
	 * @param cep String que ser� validada.
	 * @return true se for um CEP v�lido.
	 */
	private static boolean isValido(String cep) {
		return (isReferencia(cep) && cep.length() == 8);
	}
}
