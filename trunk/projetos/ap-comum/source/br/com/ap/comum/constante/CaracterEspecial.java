/*
 * CaracterEspecial.java
 * 
 * Data de cria��o: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.constante;

/**
 * Classe contendo as constantes que referenciam arquivos de alguma forma.
 * 
 * @author adrianop
 */
public final class CaracterEspecial {

	/**
	 * Construtor.
	 */
	private CaracterEspecial() {
		// Construtor
	}

	/**
	 * @return c�digo da tabula��o.
	 */
	public static String getTabulacao() {
		return "\t";
	}

	/**
	 * @return c�digo de quebra de linha.
	 */
	public static String getQuebraDeLinha() {
		return "\n";
	}

	/**
	 * @return c�digo de retorno de carro.
	 */
	public static String getRetornoDeCarro() {
		return "\r";
	}

	/**
	 * @return c�digo de retorno de espa�o.
	 */
	public static String getBackspace() {
		return "\b";
	}

	/**
	 * @return c�digo de quebra de linha com retorno de carro.
	 */
	public static String getQuebraComRetornoDeCarro() {
		return getQuebraDeLinha().concat(getRetornoDeCarro());
	}

}
