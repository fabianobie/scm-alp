/*
 * UtilConversorDeColecao.java
 * 
 * Data de criação: 21/12/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor;

import java.util.List;
import java.util.Set;

/**
 * Conversor de objetos do tipo collection.
 * 
 * @author adrianop
 */
public final class UtilConversorDeColecao extends UtilConversorAbstrato {

	/**
	 * Construtor.
	 */
	private UtilConversorDeColecao() {
		// Construtor.
	}

	/**
	 * Converte um Set para List.
	 * 
	 * @param <T> Tipo do retorno
	 * @param set Set
	 * @return novo List
	 */
	public static <T> List<T> converterSetParaList(Set<T> set) {
		List<T> resultado = getColecaoFactory().novoArrayList();

		if (isReferencia(set)) {
			for (T objeto : set) {
				resultado.add(objeto);
			}
		}
		return resultado;
	}

}
