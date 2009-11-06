/*
 * UtilFormatadorDeCNPJ.java
 * Data: 26/01/2007
 * 
 *  
 * Fábrica de Projetos - Brasília
 */
package br.com.ap.comum.formatador;

import br.com.ap.comum.constante.Constante;
import br.com.ap.comum.constante.pattern.PatternDeFormatacao;
import br.com.ap.comum.validador.UtilValidadorDeNumerosIguais;

/**
 * Formatador de CNPJ.
 * 
 * @author AdrianoP
 */
public final class UtilFormatadorDeCNPJ extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeCNPJ() {
		// Construtor
	}

	/**
	 * Formata a string.
	 * 
	 * @param cnpj String que será formatada.
	 * @return String formatada.
	 */
	public static String formatar(String cnpj) {
		String res = cnpj;

		if (isValido(cnpj)) {
			res = formatarString(cnpj, PatternDeFormatacao.getCNPJ());
		}
		return res;
	}

	/**
	 * Verifica se a string é um CNPJ válido.
	 * 
	 * @param cnpj String que será validada.
	 * @return true se for um cnpj válido.
	 */
	private static boolean isValido(String cnpj) {
		return (isReferencia(cnpj) && isTamanhoValido(cnpj));
	}

	/**
	 * Verifica se a string tem o tamnho válido.
	 * 
	 * @param cnpj String que será verificada.
	 * @return true se o tamanho da string for válido.
	 */
	private static boolean isTamanhoValido(String cnpj) {
		int size = cnpj.length();
		int cnpjSize = Constante.getQuantidadeDeCaracteresDoCNPJ();
		return (UtilValidadorDeNumerosIguais.validar(size, cnpjSize));
	}
}
