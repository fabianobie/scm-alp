/*
 * UtilReflexaoAnnotation.java
 * 
 * Data de cria��o: 12/08/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import br.com.ap.reflexao.engine.AnnotationEngine;

/**
 * Classe respons�vel pela manipula��o das anota��o de classe ou m�todo.
 * 
 * @author adrianop
 */
public class UtilReflexaoAnnotation extends UtilReflexaoAbstrato {
	private static AnnotationEngine annotationEngine;

	/**
	 * Retorna a anota��o da classe.
	 * 
	 * @param <T>
	 *            Tipo da anota��o que ser� retornado.
	 * @param objeto
	 *            Objeto onde a anota��o est� definida.
	 * @param anotacao
	 *            Anota��o que ser� recuperada.
	 * @return anota��o da classe.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Annotation> T getAnotacaoDaClasse(Object objeto,
			Class<?> anotacao) {
		return (T) getAnnotationEngine().getAnotacaoDaClasse(objeto, anotacao);
	}

	/**
	 * Retorna a anota��o do m�todo da classe.
	 * 
	 * @param <T>
	 *            Tipo da anota��o que ser� retornado.
	 * @param objeto
	 *            Objeto.
	 * @param nomeDoMetodo
	 *            Nome do m�todo que ter� sua anota��o recuperada.
	 * @param anotacao
	 *            Anota��o que ser� recuperada.
	 * @return anota��o do m�todo.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Annotation> T getAnotacaoDoMetodo(Object objeto,
			String nomeDoMetodo, Class anotacao) {
		return (T) getAnnotationEngine().getAnotacaoDoMetodo(objeto, nomeDoMetodo,
				anotacao);
	}

	/**
	 * Retorna a anota��o do m�todo da classe.
	 * 
	 * @param <T>
	 *            Tipo da anota��o que ser� retornado.
	 * @param objeto
	 *            Objeto.
	 * @param metodo
	 *            M�todo que ter� sua anota��o recuperada.
	 * @param anotacao
	 *            Anota��o que ser� recuperada.
	 * @return anota��o do m�todo.
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
