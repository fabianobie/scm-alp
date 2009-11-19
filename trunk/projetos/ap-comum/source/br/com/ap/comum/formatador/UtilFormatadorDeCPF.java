/*
 * UtilFormatadorDeCPF.java
 * Data: 26/01/2007
 * 
 *  
 * 
 */
package br.com.ap.comum.formatador;

import br.com.ap.comum.constante.Constante;
import br.com.ap.comum.constante.pattern.PatternDeFormatacao;
import br.com.ap.comum.validador.UtilValidadorDeNumerosIguais;

/**
 * Formatador de CPF.
 * 
 * @author AdrianoP
 */
public final class UtilFormatadorDeCPF extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeCPF() {
		// Construtor.
	}

	/**
	 * Formata a string.
	 * 
	 * @param cpf String que será formatada.
	 * @return String formatada.
	 */
	public static String formatar(String cpf) {
		String res = cpf;

		if (isValido(cpf)) {
			res = formatarString(cpf, PatternDeFormatacao.getCPF());
		}
		return res;
	}

	/**
	 * Verifica se a string é um CPF válido.
	 * 
	 * @param cpf String que será validada.
	 * @return true se for um cpf válido.
	 */
	private static boolean isValido(String cpf) {
		return (isReferencia(cpf) && isTamanhoValido(cpf));
	}

	/**
	 * Verifica se a string tem o tamnho válido.
	 * 
	 * @param cpf String que será verificada.
	 * @return true se o tamanho da string for válido.
	 */
	private static boolean isTamanhoValido(String cpf) {
		int size = cpf.length();
		int cpfSize = Constante.getQuantidadeDeCaracteresDoCPF();
		return (UtilValidadorDeNumerosIguais.validar(size, cpfSize));
	}

}
