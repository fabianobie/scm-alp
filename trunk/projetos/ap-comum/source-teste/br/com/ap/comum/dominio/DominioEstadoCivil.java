/*
 * DominioEstadoCivil.java
 * 
 * Data de criação: 16/09/2008
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
	 * @return lista de domínios do estado civil.
	 */
	public static Collection<DominioTO<Integer, String>> getListaEstadoCivil() {
		return getMapaEstadoCivil().values();
	}

	/**
	 * @return código do solteiro
	 */
	public static Integer getSolteiro() {
		return novoInteger(1);
	}

	/**
	 * @return código do casado
	 */
	public static Integer getCasado() {
		return novoInteger(2);
	}

	/**
	 * @return código do viúvo
	 */
	public static Integer getViuvo() {
		return novoInteger(3);
	}

	/**
	 * @return descrição do solteiro
	 */
	public static String getDescricaoSolteiro() {
		return "Solteiro";
	}

	/**
	 * @return descrição do casado
	 */
	public static String getDescricaoCasado() {
		return "Casado";
	}

	/**
	 * @return descrição do viúvo
	 */
	public static String getDescricaoViuvo() {
		return "Viúvo";
	}
}
