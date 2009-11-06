/*
 * UtilNumero.java
 * 
 * Data de cria��o: 08/12/2006
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
 * Classe utilit�ria respons�vel em tratar n�meros.
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
	 * @param string String validada. O valor n�o poder� ter ponto ou v�rgula.
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
	 * Retorna true se a string for um num�rico real v�lido.
	 * 
	 * @param string String validada.
	 * @return true se a string for um num�rico real v�lido.
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
	 * Gera um n�mero aleat�rio no per�odo de 0 � 'faixaFinal'. Observa��o, o
	 * valor definido no par�metro faixaFinal n�o est� contido no montante de
	 * valores gerados.<br>
	 * Ex: <br>
	 * <dd>getAleatorio(15) => poder� retornar um valor de 0 � 14.
	 * 
	 * @param faixaFinal Faixa final do n�mero aleat�rio.
	 * @return n�mero gerado.
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
	 * Gera um n�mero aleat�rio no per�odo de 'faixaInicial' � 'faixaFinal'.
	 * Observa��o, o valor definido no par�metro faixaInicial n�o est� contido
	 * no montante de valores gerados.<br>
	 * Ex: <br>
	 * <dd>getAleatorio(5, 15) => poder� retornar um valor de 6 � 15.
	 * 
	 * @param faixaInicial Faixa inicial do n�mero aleat�rio.
	 * @param faixaFinal Faixa final do n�mero aleat�rio.
	 * @return n�mero gerado.
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
