/*
 * AnnotationEngine.java
 * 
 * Data de criação: 12/08/2008
 *
 * 
 *
 */
package br.com.ap.reflexao.engine;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import br.com.ap.reflexao.UtilReflexaoMetodo;
import br.com.ap.comum.objeto.UtilObjeto;

/**
 * Classe responsável pela manipulação das anotação de classe ou método.
 * 
 * @author adrianop
 */
public class AnnotationEngine extends EngineAbstrato {

	/**
	 * Retorna a anotação da classe.
	 * 
	 * @param <T>
	 *            Tipo da anotação que será retornado.
	 * @param objeto
	 *            Objeto onde a anotação está definida.
	 * @param anotacao
	 *            Anotação que será recuperada.
	 * @return anotação da classe.
	 */
	@SuppressWarnings("unchecked")
	public <T extends Annotation> T getAnotacaoDaClasse(Object objeto,
			Class anotacao) {
		T resultado = null;

		if (isReferencia(objeto, anotacao)) {
			Class<?> classe = UtilObjeto.getClasse(objeto);
			resultado = (T) classe.getAnnotation(anotacao);
		}
		return resultado;
	}

	/**
	 * Retorna a anotação do método da classe.
	 * 
	 * @param <T>
	 *            Tipo da anotação que será retornado.
	 * @param objeto
	 *            Objeto.
	 * @param nomeDoMetodo
	 *            Nome do método que terá sua anotação recuperada.
	 * @param anotacao
	 *            Anotação que será recuperada.
	 * @return anotação do método.
	 */
	@SuppressWarnings("unchecked")
	public <T extends Annotation> T getAnotacaoDoMetodo(Object objeto,
			String nomeDoMetodo, Class anotacao) {
		T resultado = null;

		if (isReferencia(objeto, anotacao) && !isVazio(nomeDoMetodo)) {
			Class<?> classe = UtilObjeto.getClasse(objeto);
			Method metodo = UtilReflexaoMetodo.get(classe, nomeDoMetodo);
			resultado = (T) getAnotacaoDoMetodo(objeto, metodo, anotacao);
		}
		return resultado;
	}

	/**
	 * Retorna a anotação do método da classe.
	 * 
	 * @param <T>
	 *            Tipo da anotação que será retornado.
	 * @param objeto
	 *            Objeto.
	 * @param metodo
	 *            Método que terá sua anotação recuperada.
	 * @param anotacao
	 *            Anotação que será recuperada.
	 * @return anotação do método.
	 */
	@SuppressWarnings("unchecked")
	public <T extends Annotation> T getAnotacaoDoMetodo(Object objeto,
			Method metodo, Class anotacao) {
		T resultado = null;

		if (isReferencia(objeto, metodo, anotacao)) {
			resultado = (T) metodo.getAnnotation(anotacao);
		}
		return resultado;
	}
}
