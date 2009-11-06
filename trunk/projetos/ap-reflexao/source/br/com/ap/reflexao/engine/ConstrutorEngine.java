/*
 * ConstrutorEngine.java
 * 
 * Data de criação: 09/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao.engine;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.ConstructorUtils;

/**
 * Classe responsável pela manipulação dos construtores de uma classe.
 * 
 * @author adrianop
 */
public class ConstrutorEngine extends EngineAbstrato {

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
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings("unchecked")
	public <T> T invocar(Class<?> classe, Object... args)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		T resultado = null;

		if (isReferencia(classe)) {
			resultado = (T) ConstructorUtils.invokeConstructor(classe, args);
		}
		return resultado;
	}
}
