/*
 * UtilReflexaoConstrutor.java
 * 
 * Data de criação: 10/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import br.com.ap.reflexao.engine.ConstrutorEngine;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * Classe responsável pela manipulação dos atributos de uma classe.
 * 
 * @author adrianop
 */
public final class UtilReflexaoConstrutor extends UtilReflexaoAbstrato {
	private static ConstrutorEngine	construtorEngine;

	/**
	 * Construtor.
	 */
	private UtilReflexaoConstrutor() {
		// Construtor.
	}

	/**
	 * Retorna a instância da classe invocando o construtor padrão com com
	 * parâmetros.
	 * 
	 * @param <T>
	 *            Tipo do objeto que será criado.
	 * @param classe
	 *            Classe.
	 * @param args
	 *            Parâmetros do construtor.
	 * @return instância da classe.
	 * @throws ReflexaoException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T invocar(Class<?> classe, Object... args)
			throws ReflexaoException {
		T resultado = null;

		try {
			resultado = (T) getConstrutorEngine().invocar(classe, args);
		} catch (Exception e) {
			throw classeNaoInstanciada(classe, e);
		}
		return resultado;
	}

	/**
	 * Retorna a instância da classe invocando o construtor padrão com com
	 * parâmetros.
	 * 
	 * @param <T>
	 *            Tipo do objeto que será criado.
	 * @param classe
	 *            Classe.
	 * @return instância da classe.
	 * @throws ReflexaoException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T invocar(Class<?> classe)
	throws ReflexaoException {
		T resultado = null;
		
		try {
			Object[] params = null;
			resultado = (T) getConstrutorEngine().invocar(classe, params);
		} catch (Exception e) {
			throw classeNaoInstanciada(classe, e);
		}
		return resultado;
	}

	/**
	 * @return construtorEngine
	 */
	private static ConstrutorEngine getConstrutorEngine() {
		if (!isReferencia(construtorEngine)) {
			construtorEngine = new ConstrutorEngine();
		}
		return construtorEngine;
	}
}
