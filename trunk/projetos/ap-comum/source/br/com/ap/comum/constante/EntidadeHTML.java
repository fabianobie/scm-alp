/*
 * EntidadeHTML.java
 * 
 * Data de criação: 30/08/2007
 *
 * 
 * 
 */
package br.com.ap.comum.constante;

/**
 * Constantes de entidades HTML.
 * 
 * @author AdrianoP
 */
public final class EntidadeHTML {

	/**
	 * Construtor.
	 */
	private EntidadeHTML() {
		// Construtor
	}

	/**
	 * Retorna a entidade de espaço.
	 * 
	 * @return espaço
	 */
	public static String getEspaco() {
		return "&nbsp;";
	}

	/**
	 * Retorna a entidade de menor que.
	 * 
	 * @return menor que
	 */
	public static String getMenorQue() {
		return "&lt;";
	}

	/**
	 * Retorna a entidade de maior que.
	 * 
	 * @return maior que
	 */
	public static String getMaiorQue() {
		return "&gt;";
	}

	/**
	 * Retorna a entidade de 'e comercial'.
	 * 
	 * @return e comercial
	 */
	public static String getEComercial() {
		return "&amp;";
	}

	/**
	 * Retorna a entidade de aspas.
	 * 
	 * @return aspas
	 */
	public static String getAspas() {
		return "&quot;";
	}

	/**
	 * Retorna a entidade de euro.
	 * 
	 * @return euro
	 */
	public static String getEuro() {
		return "&euro;";
	}

	/**
	 * Retorna a entidade de 'direito de cópia'.
	 * 
	 * @return direito de cópia
	 */
	public static String getDireitoDeCopia() {
		return "&copy;";
	}

	/**
	 * Retorna a entidade de marca registrada.
	 * 
	 * @return marca registrada
	 */
	public static String getMarcaRegistrada() {
		return "&reg;";
	}

	/**
	 * Retorna a entidade de sinal de multiplicação.
	 * 
	 * @return sinal de multiplicação
	 */
	public static String getSinalDeMultiplicacao() {
		return "&times;";
	}

	/**
	 * Retorna a entidade de sinal de divisão.
	 * 
	 * @return sinal de divisão
	 */
	public static String getSinalDeDivisao() {
		return "&divide;";
	}

}
