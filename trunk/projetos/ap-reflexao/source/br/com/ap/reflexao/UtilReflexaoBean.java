/*
 * UtilReflexaoBean.java
 * 
 * Data de cria��o: 10/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import br.com.ap.reflexao.engine.BeanEngine;
import br.com.ap.reflexao.excecao.ReflexaoException;

/**
 * Classe respons�vel pela manipula��o dos atributos de uma classe.
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
	 * Cria um clone do objeto passado por par�metro com base nos seus m�todos
	 * get/set, mesmo que o objeto n�o implemente Cloneable.<br/> Observa��o:
	 * Este m�todo cria um clone superficial. Em outras palavras, alguns objetos
	 * ser�o compartilhados entre os dois objetos.<br/>
	 * 
	 * @param <T>
	 *            Tipo do objeto que ser� retornado.
	 * @param objeto
	 *            Objeto que ser� clonado.
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
	 * Retorna o class do tipo passado por par�metro. Para retornar a respectiva
	 * Classe ser� verificado se o tipo � um primitivo, array e por �ltimo um
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
