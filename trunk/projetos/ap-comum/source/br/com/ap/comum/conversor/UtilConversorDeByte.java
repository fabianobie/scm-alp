/*
 * UtilConversorDeByte.java
 * 
 * Data de cria��o: 11/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos to tipo byte.
 * 
 * @author adrianop
 */
public final class UtilConversorDeByte extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeByte() {
		// Construtor
	}

	/**
	 * Converte para o tipo primitivo, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param _byte Objeto que ser� convertido.
	 * @return tipo primitivo.
	 */
	public static byte converterParaPrimitivo(Byte _byte) {
		Byte res = (Byte) getValorDefault(Byte.class);

		if (isReferencia(_byte)) {
			res = _byte;
		}

		return res.byteValue();
	}

	/**
	 * Converte para o tipo wrapper, se n�o for poss�vel efetuar a convers�o o
	 * valor default do tipo ser� retornado.
	 * 
	 * @param _byte Primitivo que ser� convertido.
	 * @return tipo wrapper.
	 */
	public static Byte converterParaByteWrapper(byte _byte) {
		return getNumeroFactory().novoByte(_byte);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _byte Objeto que ser� convertido.
	 * @return string
	 */
	public static String converterParaString(Byte _byte) {
		return UtilString.getString(_byte);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _byte Objeto que ser� convertido.
	 * @return string
	 */
	public static String converterParaString(byte _byte) {
		return String.valueOf(_byte);
	}
}
