/*
 * UtilValidadorDeCPF.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.string.UtilString;

/**
 * Validador de cpf.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeCPF extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeCPF() {
		// Construtor.
	}

	/**
	 * Retorna true se a string for um CPF válido.
	 * 
	 * @param cpf CPF
	 * @return true se a string for um CPF válido.
	 */
	public static boolean validar(String cpf) {
		boolean resultado = false;
		int posicaoTemp;
		cpf = UtilString.removerCaracteres(cpf);
		
		if (!isNumeroDeCPFNullOuPadrao(cpf) && cpf.length() == 11) {
			cpf = cpf.trim();
			posicaoTemp = 0;
			for (int i = 0; i < 9; i++) {
				posicaoTemp += (10 - i) * (cpf.charAt(i) - 48);
			}
			posicaoTemp = 11 - posicaoTemp % 11;
			if (posicaoTemp > 9) {
				posicaoTemp = 0;
			}
			if (posicaoTemp == cpf.charAt(9) - 48) {
				posicaoTemp = 0;
				for (int i = 0; i < 10; i++) {
					posicaoTemp += (11 - i) * (cpf.charAt(i) - 48);
				}
				posicaoTemp = 11 - posicaoTemp % 11;
				if (posicaoTemp > 9) {
					posicaoTemp = 0;
				}
				if (posicaoTemp == cpf.charAt(10) - 48) {
					resultado = true;
				}
			}
		}
		return resultado;
	}

	/**
	 * @param numeroDoCPF
	 * @return verdadeiro se o CPF for null ou for um número padrão.
	 */
	private static boolean isNumeroDeCPFNullOuPadrao(String numeroDoCPF) {
		String numero = UtilString.removerCaracteres(numeroDoCPF);
		return numero == null || numero.equals("00000000000")
				|| numero.equals("11111111111")
				|| numero.equals("22222222222")
				|| numero.equals("33333333333")
				|| numero.equals("44444444444")
				|| numero.equals("55555555555")
				|| numero.equals("66666666666")
				|| numero.equals("77777777777")
				|| numero.equals("88888888888")
				|| numero.equals("99999999999");
	}
}
