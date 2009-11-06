/*
 * UtilFormatadorDeCPFouCNPJ.java
 * Data: 22/12/2007
 * 
 *  
 * Fábrica de Projetos - Brasília
 */
package br.com.ap.comum.formatador;

import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.validador.UtilValidadorDeCNPJ;
import br.com.ap.comum.validador.UtilValidadorDeCPF;

/**
 * Formatador de CPF ou CNPJ.
 * 
 * @author AdrianoP
 */
public final class UtilFormatadorDeCPFouCNPJ extends UtilFormatadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilFormatadorDeCPFouCNPJ() {
		// Construtor.
	}

	/**
	 * Formata a string.
	 * 
	 * @param cpfCnpj String que será formatada.
	 * @return String formatada.
	 */
	public static String formatar(String cpfCnpj) {
		String res = cpfCnpj;

		res = removerCaracteresEspeciais(res);
		res = formatarCPF(res);
		res = formatarCNPJ(res);

		return res;
	}

	/**
	 * Formata cpf.
	 * 
	 * @param cpf
	 * @return String formatada.
	 */
	private static String formatarCPF(String cpf) {
		if (UtilValidadorDeCPF.validar(cpf)) {
			cpf = UtilFormatadorDeCPF.formatar(cpf);
		}
		return cpf;
	}

	/**
	 * Formata cnpj.
	 * 
	 * @param cnpj
	 * @return String formatada.
	 */
	private static String formatarCNPJ(String cnpj) {
		if (UtilValidadorDeCNPJ.validar(cnpj)) {
			cnpj = UtilFormatadorDeCNPJ.formatar(cnpj);
		}
		return cnpj;
	}

	/**
	 * Revove os caracteres especiais.
	 * 
	 * @param string String
	 * @return string sem os caracteres especiais.
	 */
	private static String removerCaracteresEspeciais(String string) {
		string = UtilString.substituirString(string, "[\n]", " ");
		string = UtilString.substituirString(string, "[\r]", " ");
		string = UtilString.substituirString(string, "[\t]", " ");
		return string;
	}
}
