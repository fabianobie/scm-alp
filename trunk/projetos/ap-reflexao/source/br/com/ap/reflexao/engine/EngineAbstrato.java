/*
 * EngineAbstrato.java
 * 
 * Data de cria��o: 23/02/2007
 * 
 *
 *
 */
package br.com.ap.reflexao.engine;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe que representa a engine da reflex�o.
 * 
 * @author AdrianoP
 */
public abstract class EngineAbstrato {

	/**
	 * @param strings
	 *            Strings que ser�o verificadas.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazioTodos(String[])
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * @param objetos
	 *            Objetos que ser�o validados.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferenciaTodos(Object[])
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}
}
