/*
 * GenericEngine.java
 * 
 * Data de cria��o: 12/08/2008
 *
 * 
 *
 */
package br.com.ap.reflexao.engine;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe respons�vel pela manipula��o de generics de classe ou m�todo.
 * 
 * @author adrianop
 */
public class GenericEngine extends EngineAbstrato {

	/**
	 * Retorna a primeira classe generic do objeto em quest�o.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por par�metro.
	 * @param objeto
	 *            Objeto passado por par�metro.
	 * @return Retorna o tipo de generics do objeto.
	 */
	public <T extends Object> Class<?> getClasseDoTipo(T objeto) {
		Class<?> resultado = null;
		if (isReferencia(objeto)) {
			resultado = (Class<?>) getTipo(objeto, 0);
		}
		return resultado;
	}

	/**
	 * Retorna as classes generics do objeto em quest�o.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por par�metro.
	 * @param objeto
	 *            Objeto passado por par�metro.
	 * @return Retorna o array de tipos de generics do objeto.
	 */
	public <T extends Object> Type[] getTipos(T objeto) {
		Type[] resultado = null;
		if (isReferencia(objeto)) {
			ParameterizedType tipo = getParameterizedType(objeto);
			resultado = tipo.getActualTypeArguments();
		}
		return resultado;
	}

	/**
	 * Retorna a classe generic do objeto em quest�o.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por par�metro.
	 * @param objeto
	 *            Objeto passado por par�metro.
	 * @param indice
	 *            �ndice do tipo do generic que deseja retornar.
	 * @return Retorna o tipo de generics do objeto.
	 */
	public <T extends Object> Type getTipo(T objeto, int indice) {
		Type resultado = null;
		if (isReferencia(objeto)) {
			Type[] tipos = getTipos(objeto);
			resultado = UtilArray.getElementoDoIndice(tipos, indice);
		}
		return resultado;
	}

	/**
	 * Retorna a primeira classe generic do objeto em quest�o.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por par�metro.
	 * @param objeto
	 *            Objeto passado por par�metro.
	 * @return Retorna o tipo de generics do objeto.
	 */
	public <T extends Object> Type getTipo(T objeto) {
		Type resultado = null;
		if (isReferencia(objeto)) {
			resultado = getTipo(objeto, 0);
		}
		return resultado;
	}

	/**
	 * Retorna a parametriza��o do objeto.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por par�metro.
	 * @param objeto
	 *            Objeto passado por par�metro.
	 * @return parametriza��o do objeto.
	 */
	protected <T extends Object> ParameterizedType getParameterizedType(T objeto) {
		ParameterizedType resultado = null;

		if (isReferencia(objeto)) {
			Class<T> classe = UtilObjeto.getClasse(objeto);
			resultado = (ParameterizedType) classe.getGenericSuperclass();
		}
		return resultado;
	}
}
