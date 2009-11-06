/*
 * GenericEngine.java
 * 
 * Data de criação: 12/08/2008
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
 * Classe responsável pela manipulação de generics de classe ou método.
 * 
 * @author adrianop
 */
public class GenericEngine extends EngineAbstrato {

	/**
	 * Retorna a primeira classe generic do objeto em questão.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por parâmetro.
	 * @param objeto
	 *            Objeto passado por parâmetro.
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
	 * Retorna as classes generics do objeto em questão.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por parâmetro.
	 * @param objeto
	 *            Objeto passado por parâmetro.
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
	 * Retorna a classe generic do objeto em questão.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por parâmetro.
	 * @param objeto
	 *            Objeto passado por parâmetro.
	 * @param indice
	 *            Índice do tipo do generic que deseja retornar.
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
	 * Retorna a primeira classe generic do objeto em questão.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por parâmetro.
	 * @param objeto
	 *            Objeto passado por parâmetro.
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
	 * Retorna a parametrização do objeto.
	 * 
	 * @param <T>
	 *            Tipo do objeto passado por parâmetro.
	 * @param objeto
	 *            Objeto passado por parâmetro.
	 * @return parametrização do objeto.
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
