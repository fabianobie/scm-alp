/*
 * UtilReflexaoGeneric.java
 * 
 * Data de cria��o: 12/08/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import br.com.ap.reflexao.engine.GenericEngine;

/**
 * Classe respons�vel pela manipula��o de generics de classe ou m�todo.
 * 
 * @author adrianop
 */
public class UtilReflexaoGeneric extends UtilReflexaoAbstrato {
	private static GenericEngine	genericEngine;

	/**
	 * Retorna a primeira classe generic do objeto em quest�o.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por par�metro.
	 * @param objeto
	 *            Objeto passado por par�metro.
	 * @return Retorna o tipo de generics do objeto.
	 */
	public static <T extends Object> Class<?> getClasseDoTipo(T objeto) {
		return getGenericEngine().getClasseDoTipo(objeto);
	}

	/**
	 * @return genericEngine
	 */
	private static GenericEngine getGenericEngine() {
		if (!isReferencia(genericEngine)) {
			genericEngine = new GenericEngine();
		}
		return genericEngine;
	}
}
