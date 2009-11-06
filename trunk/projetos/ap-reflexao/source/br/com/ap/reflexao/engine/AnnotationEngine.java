/*
 * AnnotationEngine.java
 * 
 * Data de cria��o: 12/08/2008
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
 * Classe respons�vel pela manipula��o das anota��o de classe ou m�todo.
 * 
 * @author adrianop
 */
public class AnnotationEngine extends EngineAbstrato {

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
	public <T extends Annotation> T getAnotacaoDoMetodo(Object objeto,
			Method metodo, Class anotacao) {
		T resultado = null;

		if (isReferencia(objeto, metodo, anotacao)) {
			resultado = (T) metodo.getAnnotation(anotacao);
		}
		return resultado;
	}
}
