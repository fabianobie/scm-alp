/*
 * UtilValidadorDeStringsIguais.java
 * 
 * Data de cria��o: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.conversor.UtilConversorDeCharacter;
import br.com.ap.comum.string.UtilString;

/**
 * Classe Respons�vel pela valida��o de igualdade de strings.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeStringsIguais extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeStringsIguais() {
		// Construtor.
	}

	/**
	 * Retorna true se as strings forem iguais. As Strings s�o obrigat�rias.
	 * 
	 * @param strings String validadas.
	 * @return true se as strings forem iguais.
	 */
	public static boolean validar(String... strings) {
		boolean result = false;

		if (UtilArray.getTamanho(strings) > 1) {
			result = true;
			for (int indice = 0; indice < (strings.length - 1)
					&& (result == true); indice++) {
				result = UtilString.isStringsIguais(strings[indice],
						strings[indice + 1]);
			}
		}

		return result;
	}

	/**
	 * Retorna true se os chars forem iguais. Os chars s�o obrigat�rias.
	 * 
	 * @param chars Char validadas.
	 * @return true se as strings forem iguais.
	 */
	public static boolean validar(Character... chars) {
		boolean result = false;

		if (UtilArray.getTamanho(chars) > 1) {
			result = true;
			for (int indice = 0; indice < (chars.length - 1)
					&& (result == true); indice++) {

				String s0 = converterParaString(chars[indice]);
				String s1 = converterParaString(chars[indice + 1]);
				result = UtilString.isStringsIguais(s0, s1);
			}
		}

		return result;
	}

	/**
	 * Retorna true se as strings forem iguais. As Strings s�o obrigat�rias
	 * (ignorando mai�scula/min�scula).
	 * 
	 * @param strings String validadas.
	 * @return true se as strings forem iguais.
	 */
	public static boolean validarIgnoreCase(String... strings) {
		boolean result = false;

		if (UtilArray.getTamanho(strings) > 1) {
			result = true;
			for (int indice = 0; indice < (strings.length - 1)
					&& (result == true); indice++) {
				result = UtilString.isStringsIguaisIgnoreCase(strings[indice],
						strings[indice + 1]);
			}
		}

		return result;
	}

	/**
	 * Retorna true se os chars forem iguais. Os chars s�o obrigat�rias
	 * (ignorando mai�scula/min�scula).
	 * 
	 * @param chars Char validadas.
	 * @return true se as strings forem iguais.
	 */
	public static boolean validarIgnoreCase(Character... chars) {
		boolean result = false;

		if (UtilArray.getTamanho(chars) > 1) {
			result = true;
			for (int indice = 0; indice < (chars.length - 1)
					&& (result == true); indice++) {

				String s0 = converterParaString(chars[indice]);
				String s1 = converterParaString(chars[indice + 1]);
				result = UtilString.isStringsIguaisIgnoreCase(s0, s1);
			}
		}

		return result;
	}

	/**
	 * Converte um character em string.
	 * 
	 * @param character Character que ser� convertido.
	 * @return String
	 */
	private static String converterParaString(Character character) {
		return UtilConversorDeCharacter.converterParaString(character);
	}

}
