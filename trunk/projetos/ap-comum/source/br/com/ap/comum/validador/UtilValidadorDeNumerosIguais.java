/*
 * UtilValidadorDeValoresIguais.java
 * 
 * Data de criação: 27/04/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.conversor.UtilConversorDeInteger;

/**
 * Classe Responsável pela validação de igualdade de números.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeNumerosIguais extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeNumerosIguais() {
		// Construtor.
	}

	/**
	 * Retorna true se os números forem iguais. Os números são obrigatórios.
	 * 
	 * @param numeros Números validadas.
	 * @return true se as duas datas forem iguais.
	 */
	@SuppressWarnings("unchecked")
	public static boolean validar(Number... numeros) {
		boolean result = false;

		if (UtilArray.getTamanho(numeros) > 1 && isComparable(numeros)) {
			result = true;
			for (int indice = 0; indice < (numeros.length - 1)
					&& (result == true); indice++) {
				result = isObjetosIguais((Comparable) numeros[indice],
						(Comparable) numeros[indice + 1]);
			}
		}

		return result;
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param int0 int
	 * @param int1 int
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(int int0, int int1) {
		return (int0 == int1);
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param byte0 byte
	 * @param byte1 byte
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(byte byte0, byte byte1) {
		return (byte0 == byte1);
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param short0 short
	 * @param short1 short
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(short short0, short short1) {
		return (short0 == short1);
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param long0 long
	 * @param long1 long
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(long long0, long long1) {
		return (long0 == long1);
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param float0 float
	 * @param float1 float
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(float float0, float float1) {
		return (float0 == float1);
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param double0 double
	 * @param double1 double
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(double double0, double double1) {
		return (double0 == double1);
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param long0 long
	 * @param int1 int
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(long long0, int int1) {
		return (long0 == int1);
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param integer0 Integer
	 * @param integer1 Integer
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(Integer integer0, Integer integer1) {
		int int0 = UtilConversorDeInteger.converterParaPrimitivo(integer0);
		int int1 = UtilConversorDeInteger.converterParaPrimitivo(integer1);

		return validar(int0, int1);
	}

	/**
	 * Retorna true se os valores forem iguais.
	 * 
	 * @param integer0 Integer
	 * @param int1 int
	 * @return true se os valores forem iguais.
	 */
	public static boolean validar(Integer integer0, int int1) {
		int int0 = UtilConversorDeInteger.converterParaPrimitivo(integer0);

		return validar(int0, int1);
	}

}
