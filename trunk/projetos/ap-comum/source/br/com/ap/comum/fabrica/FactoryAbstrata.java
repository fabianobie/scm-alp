/*
 * FactoryAbstrata.java
 * 
 * Data de cria��o: Jun 25, 2008
 *
 * 
 * 
 */
package br.com.ap.comum.fabrica;

import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.util.UtilLog;

/**
 * Classe que implementa os recursos comuns �s f�bricas.
 * 
 * @author adrianop
 */
public abstract class FactoryAbstrata {

	/**
	 * Verifica se o objeto tem refer�ncia.
	 * 
	 * @param obj objeto a ser verificado.
	 * @return true se o objeto tiver uma refer�ncia.
	 */
	protected boolean isReferencia(Object obj) {
		return UtilObjeto.isReferencia(obj);
	}

	/**
	 * Retorna true se a string for vazia.
	 * 
	 * @param string String a ser validada.
	 * @return true se a string for vazia.
	 */
	protected boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	protected LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
