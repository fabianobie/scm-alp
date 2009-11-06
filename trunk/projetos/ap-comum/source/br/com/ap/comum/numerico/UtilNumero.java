/*
 * UtilNumero.java
 * 
 * Data de criação: 08/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.numerico;

import java.util.Random;
import java.util.regex.Pattern;

import br.com.ap.comum.constante.pattern.PatternDeNumero;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.validador.UtilValidadorDeNumeroInicialMaiorQueNumeroFinal;

/**
 * Classe utilitária responsável em tratar números.
 * 
 * @author adrianop
 */
@SuppressWarnings("boxing")
public final class UtilNumero {

	/**
	 * Construtor.
	 */
	private UtilNumero() {
		// Construtor
	}

	/**
	 * Retorna true se a string for um inteiro.
	 * 
	 * @param string String validada. O valor não poderá ter ponto ou vírgula.
	 * @return true se a string for um inteiro.
	 */
	public static boolean isInteiro(String string) {
		boolean res = false;

		if (!UtilString.isVazio(string)) {
			res = Pattern.matches(PatternDeNumero.getInteger(), string);
		}
		return res;
	}

	/**
	 * Retorna true se a string for um numérico real válido.
	 * 
	 * @param string String validada.
	 * @return true se a string for um numérico real válido.
	 */
	public static boolean isReal(String string) {
		boolean result = false;
		if (!UtilString.isVazio(string)) {
			string = UtilString.substituirString(string, "[.]", "");
			result = Pattern.matches(PatternDeNumero.getReal(), string);
		}
		return result;
	}

	/**
	 * Gera um número aleatório no período de 0 à 'faixaFinal'. Observação, o
	 * valor definido no parâmetro faixaFinal não está contido no montante de
	 * valores gerados.<br>
	 * Ex: <br>
	 * <dd>getAleatorio(15) => poderá retornar um valor de 0 à 14.
	 * 
	 * @param faixaFinal Faixa final do número aleatório.
	 * @return número gerado.
	 */
	public static int getAleatorio(int faixaFinal) {
		int resultado = 0;

		if (UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.validar(
				faixaFinal, 0)) {
			Random random = new Random();
			resultado = random.nextInt(faixaFinal);
		}
		return resultado;
	}

	/**
	 * Gera um número aleatório no período de 'faixaInicial' à 'faixaFinal'.
	 * Observação, o valor definido no parâmetro faixaInicial não está contido
	 * no montante de valores gerados.<br>
	 * Ex: <br>
	 * <dd>getAleatorio(5, 15) => poderá retornar um valor de 6 à 15.
	 * 
	 * @param faixaInicial Faixa inicial do número aleatório.
	 * @param faixaFinal Faixa final do número aleatório.
	 * @return número gerado.
	 */
	public static int getAleatorio(int faixaInicial, int faixaFinal) {
		int resultado = 0;

		if (UtilValidadorDeNumeroInicialMaiorQueNumeroFinal.validar(
				faixaFinal, faixaInicial)) {
			resultado = getAleatorio(faixaInicial) + 1;
			resultado = resultado + (faixaFinal - faixaInicial);
		}
		return resultado;
	}
}
