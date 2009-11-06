/*
 * ConstrutorEngine.java
 * 
 * Data de cria��o: 09/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao.engine;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.ConstructorUtils;

/**
 * Classe respons�vel pela manipula��o dos construtores de uma classe.
 * 
 * @author adrianop
 */
public class ConstrutorEngine extends EngineAbstrato {

	/**
	 * Retorna a inst�ncia da classe invocando o construtor padr�o com com
	 * par�metros.
	 * 
	 * @param <T>
	 *            Tipo do objeto que ser� criado.
	 * @param classe
	 *            Classe.
	 * @param args
	 *            Par�metros do construtor.
	 * @return inst�ncia da classe.
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
