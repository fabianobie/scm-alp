/*
 * UtilValidadorDeAnoBissexto.java
 * 
 * Data de criação: 22/01/2007
 *
 * 
 * 
 */
package br.com.ap.comum.validador;

import java.util.Date;

import br.com.ap.comum.array.UtilArray;

/**
 * Validador de data iguais.
 * 
 * @author adrianop
 */
public final class UtilValidadorDeDatasIguais extends UtilValidadorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilValidadorDeDatasIguais() {
		// Construtor.
	}

	/**
	 * Retorna true se as duas datas forem iguais. As datas são obrigatórias.
	 * 
	 * @param datas Datas validadas.
	 * @return true se as duas datas forem iguais.
	 */
	public static boolean validar(Date... datas) {
		boolean result = true;

		if (UtilArray.getTamanho(datas) > 1) {
			for (int indice = 0; indice < (datas.length - 1)
					&& (result == true); indice++) {
				result = isObjetosIguais(datas[indice], datas[indice + 1]);
			}
		}

		return result;
	}

}
