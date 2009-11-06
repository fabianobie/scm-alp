/*
 * UtilFormatadorDeTelefone.java
 * 
 * Data de criação: 21/12/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador;

import java.util.Map;

import br.com.ap.comum.constante.pattern.PatternDeFormatacao;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.validador.UtilValidadorDeNumerosIguais;

/**
 * Utilitário para formatação de telefone.
 * 
 * @author adrianop
 */
public final class UtilFormatadorDeTelefone extends UtilFormatadorAbstrato {

	private static Map<Integer, String>	patterns;

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeTelefone() {
		// Construtor.
	}

	/**
	 * Formata um telefone.
	 * 
	 * @param telefone Real que será formatado.
	 * @return String formatada.
	 */
	public static String formatar(String telefone) {
		String resultado = telefone;
		if (isValido(telefone)) {
			String pattern = getPattern(telefone);
			resultado = formatarString(telefone, pattern);
		}
		return resultado;
	}

	/**
	 * Formata um telefone.
	 * 
	 * @param telefone Telefone
	 * @return String formatada.
	 */
	public static String formatar(Number telefone) {
		return formatar(UtilString.getString(telefone));
	}

	/**
	 * Formata um telefone.
	 * 
	 * @param telefone Telefone
	 * @return String formatada.
	 */
	public static String formatar(int telefone) {
		return formatar(String.valueOf(telefone));
	}

	/**
	 * Formata um telefone.
	 * 
	 * @param telefone Telefone
	 * @return String formatada.
	 */
	public static String formatar(long telefone) {
		return formatar(String.valueOf(telefone));
	}

	/**
	 * Verifica se a string é um Telefone válido.
	 * 
	 * @param telefone String que será validada.
	 * @return true se for um telefone válido.
	 */
	private static boolean isValido(String telefone) {
		int tamanho = UtilString.getTamanho(telefone);
		return (isReferencia(telefone) && (isTamanho(tamanho, 8)
				|| isTamanho(tamanho, 10) || isTamanho(tamanho, 12)));
	}

	/**
	 * Retorna true se o tamanho for o mesmo do desejado.
	 * 
	 * @param tamanho Inteiro validado
	 * @param desejado Inteiro desejado
	 * @return true se o tamanho for o mesmo do desejado.
	 */
	private static boolean isTamanho(int tamanho, int desejado) {
		return UtilValidadorDeNumerosIguais.validar(tamanho, desejado);
	}

	/**
	 * Retorna um novo inteiro do int
	 * 
	 * @param _int Inteiro
	 * @return inteiro
	 */
	private static Integer novoInteger(int _int) {
		return getNumeroFactory().novoInteger(_int);
	}

	/**
	 * Retorna o pattern de um telefone.
	 * 
	 * @param telefone Telefone
	 * @return pattern
	 */
	private static String getPattern(String telefone) {
		int tamanho = UtilString.getTamanho(telefone);
		return getPatterns().get(novoInteger(tamanho));
	}

	/**
	 * @return patterns de telefone.
	 */
	private static Map<Integer, String> getPatterns() {
		if (!isReferencia(patterns)) {
			patterns = getColecaoFactory().novoHashMap();
			patterns.put(novoInteger(8), PatternDeFormatacao
					.getTelefoneDeOito());
			patterns.put(novoInteger(10), PatternDeFormatacao
					.getTelefoneDeDez());
			patterns.put(novoInteger(12), PatternDeFormatacao
					.getTelefoneDeDoze());
		}
		return patterns;
	}
}
