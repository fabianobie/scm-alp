/*
 * UtilReflexaoAnnotation.java
 * 
 * Data de criação: 12/08/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import br.com.ap.reflexao.engine.AnnotationEngine;

/**
 * Classe responsável pela manipulação das anotação de classe ou método.
 * 
 * @author adrianop
 */
public class UtilReflexaoAnnotation extends UtilReflexaoAbstrato {
	private static AnnotationEngine annotationEngine;

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
	public static <T extends Annotation> T getAnotacaoDaClasse(Object objeto,
			Class<?> anotacao) {
		return (T) getAnnotationEngine().getAnotacaoDaClasse(objeto, anotacao);
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
	public static <T extends Annotation> T getAnotacaoDoMetodo(Object objeto,
			String nomeDoMetodo, Class anotacao) {
		return (T) getAnnotationEngine().getAnotacaoDoMetodo(objeto, nomeDoMetodo,
				anotacao);
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
	public static <T extends Annotation> T getAnotacaoDoMetodo(Object objeto,
			Method metodo, Class anotacao) {
		return (T) getAnnotationEngine().getAnotacaoDoMetodo(objeto, metodo,
				anotacao);
	}

	/**
	 * @return annotationEngine
	 */
	private static AnnotationEngine getAnnotationEngine() {
		if (!isReferencia(annotationEngine)) {
			annotationEngine = new AnnotationEngine();
		}
		return annotationEngine;
	}
}
