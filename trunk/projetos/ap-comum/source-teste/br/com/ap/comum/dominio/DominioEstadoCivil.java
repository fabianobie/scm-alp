/*
 * DominioEstadoCivil.java
 * 
 * Data de cria��o: 16/09/2008
 *
 * 
 * 
 */
package br.com.ap.comum.dominio;

import java.util.Collection;
import java.util.Map;

import br.com.ap.comum.dominio.UtilDominioAbstrato;
import br.com.ap.comum.javabean.to.DominioTO;

/**
 * @author adrianop
 */
public class DominioEstadoCivil extends UtilDominioAbstrato {

	private static Map<Integer, DominioTO<Integer, String>>	mapaEstadoCivil;

	/**
	 * @return mapa de estado civil.
	 */
	public static Map<Integer, DominioTO<Integer, String>> getMapaEstadoCivil() {
		if (!isReferencia(mapaEstadoCivil)) {
			mapaEstadoCivil = novoHashMap();
			mapaEstadoCivil.put(getSolteiro(), novoDominio(getSolteiro(),
					getDescricaoSolteiro()));
			mapaEstadoCivil.put(getCasado(), novoDominio(getCasado(),
					getDescricaoCasado()));
			mapaEstadoCivil.put(getViuvo(), novoDominio(getViuvo(),
					getDescricaoViuvo()));
		}
		return mapaEstadoCivil;
	}

	/**
	 * @return lista de dom�nios do estado civil.
	 */
	public static Collection<DominioTO<Integer, String>> getListaEstadoCivil() {
		return getMapaEstadoCivil().values();
	}

	/**
	 * @return c�digo do solteiro
	 */
	public static Integer getSolteiro() {
		return novoInteger(1);
	}

	/**
	 * @return c�digo do casado
	 */
	public static Integer getCasado() {
		return novoInteger(2);
	}

	/**
	 * @return c�digo do vi�vo
	 */
	public static Integer getViuvo() {
		return novoInteger(3);
	}

	/**
	 * @return descri��o do solteiro
	 */
	public static String getDescricaoSolteiro() {
		return "Solteiro";
	}

	/**
	 * @return descri��o do casado
	 */
	public static String getDescricaoCasado() {
		return "Casado";
	}

	/**
	 * @return descri��o do vi�vo
	 */
	public static String getDescricaoViuvo() {
		return "Vi�vo";
	}
}
