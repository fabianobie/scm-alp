/*
 * UtilValidadorDeEmail.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.regex.Pattern;

import br.com.ap.comum.constante.pattern.PatternDeFormatacao;

/**
 * Validador de e-mail.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeEmail extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeEmail() {
		// Construtor.
	}

	/**
	 * Retorna true se for um e-mail válido.
	 * 
	 * @param email String do e-mail.
	 * @return true se for um e-mail válido.
	 */
	public static boolean validar(String email) {
		boolean res = false;

		if (!isVazio(email)) {
			res = Pattern.matches(PatternDeFormatacao.getEMail(), email);
		}
		return res;
	}
}
