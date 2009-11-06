/*
 * UtilValidadorDeCNPJ.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.constante.Constante;
import br.com.ap.comum.string.UtilString;

/**
 * Validador de CNPJ.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeCNPJ extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeCNPJ() {
		// Construtor.
	}

	/**
	 * Retorna true se o número form um cnpj válido.
	 * 
	 * @param cnpj CNPJ
	 * @return true se o número form um cnpj válido.
	 */
	public static boolean validar(Number cnpj) {
		boolean res = false;

		if (isReferencia(cnpj)) {
			res = validar(cnpj.toString());
		}

		return res;
	}

	/**
	 * Retorna true se o número form um cnpj válido.
	 * 
	 * @param cnpj CNPJ
	 * @return true se o número form um cnpj válido.
	 */
	public static boolean validar(long cnpj) {
		return validar(getNumeroFactory().novoLong(cnpj));
	}

	/**
	 * Retorna true se a string form um cnpj válido.
	 * 
	 * @param cnpj CNPJ
	 * @return true se a string form um cnpj válido.
	 */
	public static boolean validar(String cnpj) {
		cnpj = UtilString.removerCaracteres(cnpj);
		boolean result;
		int position;
		if (cnpj == null
				|| !(cnpj.length() >= getQuantidadeDeCaracteresDoCNPJ())) {
			return false;
		}
		result = false;
		cnpj = cnpj.trim();
		int tamanho = cnpj.length();
		if (tamanho > getQuantidadeDeCaracteresDoCNPJ() && tamanho < 19) {
			cnpj = UtilString.removerCaracteres(cnpj);
		}
		if (cnpj.length() > getQuantidadeDeCaracteresDoCNPJ()) {
			return false;
		}
		position = 0;
		int i = 0;
		int j = 5;
		for (; i < 12; i++) {
			position += j-- * (cnpj.charAt(i) - 48);
			if (j < 2) {
				j = 9;
			}
		}
		position = 11 - position % 11;
		if (position > 9) {
			position = 0;
		}
		if (position == cnpj.charAt(12) - 48) {
			position = 0;
			i = 0;
			j = 6;
			for (; i < 13; i++) {
				position += j-- * (cnpj.charAt(i) - 48);
				if (j < 2) {
					j = 9;
				}
			}
			position = 11 - position % 11;
			if (position > 9) {
				position = 0;
			}
			if (position == cnpj.charAt(13) - 48) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * @return quantidade de caracteres do cnpj.
	 * @see Constante#getQuantidadeDeCaracteresDoCNPJ()
	 */
	private static int getQuantidadeDeCaracteresDoCNPJ() {
		return Constante.getQuantidadeDeCaracteresDoCNPJ();
	}
}
