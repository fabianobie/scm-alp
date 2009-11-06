/*
 * CaracterEspecial.java
 * 
 * Data de criação: 25/06/2007
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
	 * @return código da tabulação.
	 */
	public static String getTabulacao() {
		return "\t";
	}

	/**
	 * @return código de quebra de linha.
	 */
	public static String getQuebraDeLinha() {
		return "\n";
	}

	/**
	 * @return código de retorno de carro.
	 */
	public static String getRetornoDeCarro() {
		return "\r";
	}

	/**
	 * @return código de retorno de espaço.
	 */
	public static String getBackspace() {
		return "\b";
	}

	/**
	 * @return código de quebra de linha com retorno de carro.
	 */
	public static String getQuebraComRetornoDeCarro() {
		return getQuebraDeLinha().concat(getRetornoDeCarro());
	}

}
