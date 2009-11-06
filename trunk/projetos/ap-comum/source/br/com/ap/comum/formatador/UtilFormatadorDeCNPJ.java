/*
 * UtilFormatadorDeCNPJ.java
 * Data: 26/01/2007
 * 
 *  
 * F�brica de Projetos - Bras�lia
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
	 * @param cnpj String que ser� formatada.
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
	 * Verifica se a string � um CNPJ v�lido.
	 * 
	 * @param cnpj String que ser� validada.
	 * @return true se for um cnpj v�lido.
	 */
	private static boolean isValido(String cnpj) {
		return (isReferencia(cnpj) && isTamanhoValido(cnpj));
	}

	/**
	 * Verifica se a string tem o tamnho v�lido.
	 * 
	 * @param cnpj String que ser� verificada.
	 * @return true se o tamanho da string for v�lido.
	 */
	private static boolean isTamanhoValido(String cnpj) {
		int size = cnpj.length();
		int cnpjSize = Constante.getQuantidadeDeCaracteresDoCNPJ();
		return (UtilValidadorDeNumerosIguais.validar(size, cnpjSize));
	}
}
