/*
 * UtilValidadorDeReal.java
 * 
 * Data de cria��o: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.numerico.UtilNumero;
import br.com.ap.comum.string.UtilString;

/**
 * Classe respons�vel em verificar se o n�mero � real.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeReal extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeReal() {
		// Construtor.
	}

	/**
	 * Retorna true se o valor for um real v�lido.
	 * 
	 * @param numero String validada.
	 * @return true se o valor for um real v�lido.
	 */
	public static boolean validar(String numero) {
		return UtilNumero.isReal(numero);
	}

	/**
	 * Retorna true se o valor for um real v�lido.
	 * 
	 * @param numero String validada.
	 * @param decimais Quantidade de casas decimais.
	 * @return true se o valor for um real v�lido.
	 */
	public static boolean validar(String numero, int decimais) {
		boolean resultado = false;
		if (validar(numero)) {
			int qtd = getQuantidadeDeCasasDecimais(numero);
			resultado = UtilValidadorDeNumerosIguais.validar(decimais, qtd);
		}
		return resultado;
	}

	/**
	 * Retorna a quantidade de casas decimais.
	 * 
	 * @param numero N�mero
	 * @return quantidade de casas decimais.
	 */
	private static int getQuantidadeDeCasasDecimais(String numero) {
		return UtilString.getTamanho(getCasasDecimais(numero));
	}

	/**
	 * Retorna as casas decimais.
	 * 
	 * @param numero N�mero
	 * @return casas decimais.
	 */
	private static String getCasasDecimais(String numero) {
		return UtilString.substring(numero, numero.indexOf(",") + 1);
	}
}
