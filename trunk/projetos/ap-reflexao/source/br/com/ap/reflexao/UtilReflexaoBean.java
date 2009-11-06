/*
 * UtilReflexaoBean.java
 * 
 * Data de criação: 10/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import br.com.ap.reflexao.engine.BeanEngine;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * Classe responsável pela manipulação dos atributos de uma classe.
 * 
 * @author adrianop
 */
public final class UtilReflexaoBean extends UtilReflexaoAbstrato {
	private static BeanEngine	beanEngine;

	/**
	 * Construtor.
	 */
	private UtilReflexaoBean() {
		// Construtor.
	}

	/**
	 * Cria um clone do objeto passado por parâmetro com base nos seus métodos
	 * get/set, mesmo que o objeto não implemente Cloneable.<br/> Observação:
	 * Este método cria um clone superficial. Em outras palavras, alguns objetos
	 * serão compartilhados entre os dois objetos.<br/>
	 * 
	 * @param <T>
	 *            Tipo do objeto que será retornado.
	 * @param objeto
	 *            Objeto que será clonado.
	 * @return Objeto clonado.
	 * @throws ReflexaoException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T clonar(Object objeto) throws ReflexaoException {
		T resultado = null;

		try {
			resultado = (T) getBeanEngine().clonar(objeto);
		} catch (Exception e) {
			throw naoFoiPossivelClonarObjeto(e);
		}
		return resultado;
	}

	/**
	 * Retorna o class do tipo passado por parâmetro. Para retornar a respectiva
	 * Classe será verificado se o tipo é um primitivo, array e por último um
	 * objeto.
	 * 
	 * @param classe
	 *            tipo da classe solicitada.
	 * @return Classe do tipo solicitado.
	 * @throws ReflexaoException
	 */
	public static Class<?> novaClasse(String classe) throws ReflexaoException {
		Class<?> resultado = null;

		try {
			resultado = getBeanEngine().novaClasse(classe);
		} catch (Exception e) {
			throw erro(e);
		}
		return resultado;
	}

	/**
	 * @return beanEngine
	 */
	private static BeanEngine getBeanEngine() {
		if (!isReferencia(beanEngine)) {
			beanEngine = new BeanEngine();
		}
		return beanEngine;
	}
}
