/*
 * PatternDeFormatacao.java
 * Data: 26/01/2007
 * 
 *  
 * Fábrica de Projetos - Brasília
 */
package br.com.ap.comum.constante.pattern;

/**
 * Patterns usados nas formatações.
 * 
 * @author AdrianoP
 */
public final class PatternDeFormatacao {

	/**
	 * Construtor.
	 */
	private PatternDeFormatacao() {
		// Construtor.
	}

	/**
	 * @return Pattern de CEP.
	 */
	public static String getCEP() {
		return "##.###-###";
	}

	/**
	 * @return Pattern de CNPJ.
	 */
	public static String getCNPJ() {
		return "##.###.###/####-##";
	}

	/**
	 * @return Pattern de CPF.
	 */
	public static String getCPF() {
		return "###.###.###-##";
	}

	/**
	 * @return Pattern de e-mail
	 */
	public static String getEMail() {
		return "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*"
				+ "[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
	}
	
	/**
	 * @return Pattern de telefone com 8 números
	 */
	public static String getTelefoneDeOito() {
		return "####-####";
	}

	/**
	 * @return Pattern de telefone com 10 números
	 */
	public static String getTelefoneDeDez() {
		return "## ####-####";
	}

	/**
	 * @return Pattern de telefone com 12 números
	 */
	public static String getTelefoneDeDoze() {
		return "#### ####-####";
	}

	/**
	 * @return Pattern de cartão
	 */
	public static String getCartao() {
		return "####.####.####.####";
	}
}
