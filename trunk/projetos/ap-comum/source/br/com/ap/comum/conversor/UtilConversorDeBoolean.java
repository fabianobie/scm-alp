/*
 * UtilConversorDeBoolean.java
 * 
 * Data de criação: 18/12/2006
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import br.com.ap.comum.constante.Booleano;
import br.com.ap.comum.string.UtilString;

/**
 * Conversor de objetos do tipo boolean.
 * 
 * @author adrianop
 */
public final class UtilConversorDeBoolean extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeBoolean() {
		// Construtor.
	}

	/**
	 * Converte para o tipo primitivo, se não for possível efetuar a conversão o
	 * valor default do tipo será retornado.
	 * 
	 * @param _boolean Objeto que será convertido.
	 * @return tipo primitivo.
	 */
	public static boolean converterParaPrimitivo(Boolean _boolean) {
		Boolean res = (Boolean) getValorDefault(Boolean.class);

		if (isReferencia(_boolean)) {
			res = _boolean;
		}

		return res.booleanValue();
	}

	/**
	 * Converte para o tipo Boolean
	 * 
	 * @param _boolean boolean que será convertido.
	 * @return tipo Boolean.
	 */
	public static Boolean converterParaBooleanWrapper(boolean _boolean) {
		return getBoleanoFactory().novoBoolean(_boolean);
	}

	/**
	 * Retorna Sim se for true ou Nao se for false.
	 * 
	 * @param _boolean boolean verificado.
	 * @return Sim ou Nao.
	 */
	public static String converterParaSimNao(boolean _boolean) {
		String sim = Booleano.getSim();
		String nao = Booleano.getNao();
		return (_boolean ? sim : nao);
	}

	/**
	 * Retorna S se for true ou N se for false.
	 * 
	 * @param _boolean boolean verificado.
	 * @return Sim ou Nao.
	 */
	public static String converterParaCodigoSimNao(boolean _boolean) {
		String sim = Booleano.getCodigoSim();
		String nao = Booleano.getCodigoNao();
		return (_boolean ? sim : nao);
	}

	/**
	 * Retorna On se for true ou Off se for false.
	 * 
	 * @param _boolean boolean verificado.
	 * @return On ou Off.
	 */
	public static String converterParaOnOff(boolean _boolean) {
		String on = Booleano.getOn();
		String off = Booleano.getOff();
		return (_boolean ? on : off);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _boolean Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(Boolean _boolean) {
		return UtilString.getString(_boolean);
	}

	/**
	 * Converter o objeto para uma string.
	 * 
	 * @param _boolean Objeto que será convertido.
	 * @return string
	 */
	public static String converterParaString(boolean _boolean) {
		return String.valueOf(_boolean);
	}

}
