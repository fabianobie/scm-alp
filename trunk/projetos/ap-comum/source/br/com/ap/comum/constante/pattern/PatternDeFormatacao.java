/*
 * PatternDeFormatacao.java
 * Data: 26/01/2007
 * 
 *  
 * F�brica de Projetos - Bras�lia
 */
package br.com.ap.comum.constante.pattern;

/**
 * Patterns usados nas formata��es.
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
	 * @return Pattern de telefone com 8 n�meros
	 */
	public static String getTelefoneDeOito() {
		return "####-####";
	}

	/**
	 * @return Pattern de telefone com 10 n�meros
	 */
	public static String getTelefoneDeDez() {
		return "## ####-####";
	}

	/**
	 * @return Pattern de telefone com 12 n�meros
	 */
	public static String getTelefoneDeDoze() {
		return "#### ####-####";
	}

	/**
	 * @return Pattern de cart�o
	 */
	public static String getCartao() {
		return "####.####.####.####";
	}
}
