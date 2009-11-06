/*
 * Constante.java 
 * 
 * Data de criação: 27/10/2006 
 * 
 * 
 * 
 */
package br.com.ap.comum.constante;

import java.util.Locale;

/**
 * Constantes usadas pela API.
 * 
 * @author adrianop
 */
public final class Constante {

	/**
	 * Construtor.
	 */
	private Constante() {
		// Construtor.
	}

	/**
	 * Retorna Locale pt-BR.
	 * 
	 * @return Locale pt-BR
	 */
	public static Locale getLocaleBrasil() {
		return new Locale("pt", "BR");
	}

	/**
	 * Retorna a quantidade de caracteres do CNPJ.
	 * 
	 * @return 14
	 */
	public static int getQuantidadeDeCaracteresDoCNPJ() {
		return 14;
	}

	/**
	 * Retorna a quantidade de caracteres do CPF.
	 * 
	 * @return 11
	 */
	public static int getQuantidadeDeCaracteresDoCPF() {
		return 11;
	}

	/**
	 * Retorna prefixo de string que representa um array. <br>
	 * Ex: java.lang.String[]
	 * 
	 * @return []
	 */
	public static String getSufixoArray() {
		return "[]";
	}

	/**
	 * Retorna Nome do logger.
	 * 
	 * @return Nome do logger
	 */
	public static String getNomeDoLogger() {
		return "br.com.ap.comum";
	}

	/**
	 * Retorna o prefixo do monetário.
	 * 
	 * @return R$
	 */
	public static String getPrefixoMonetario() {
		return "R$";
	}

	/**
	 * Quantidade mínima de casas decimais.
	 * 
	 * @return dois
	 */
	public static int getQuantidadeMinimaDeCasasDecimais() {
		return 2;
	}
	
	
}
