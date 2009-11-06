/*
 * BeanEngine.java
 * 
 * Data de cria��o: 09/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao.engine;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.objeto.UtilPrimitivo;

/**
 * Classe respons�vel pela manipula��o dos objetos instanciados.
 * 
 * @author adrianop
 */
public class BeanEngine extends EngineAbstrato {

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
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public <T> T clonar(Object objeto) throws IllegalAccessException,
			InstantiationException, InvocationTargetException,
			NoSuchMethodException {
		T resultado = null;

		if (isReferencia(objeto)) {
			resultado = (T) BeanUtils.cloneBean(objeto);
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
	 * @throws ClassNotFoundException
	 */
	public Class<?> novaClasse(String classe) throws ClassNotFoundException {
		Class<?> res = null;

		if (!isVazio(classe)) {
			res = novaClasseDoPrimitivo(classe);
			res = novaClasseDoArray(res, classe);
			res = novaClasseDoObjeto(res, classe);
		} else {
			throw new ClassNotFoundException("null");
		}

		return res;
	}

	/**
	 * Retorna o Class do primitivo.
	 * 
	 * @param classe
	 *            tipo do primitivo.
	 * @return Class do primitivo.
	 */
	private Class<?> novaClasseDoPrimitivo(String classe) {
		Class<?> res = null;

		if (UtilPrimitivo.isPrimitivo(classe)) {
			res = UtilPrimitivo.getClasseWrapperDoPrimitivo(classe);
		}
		return res;
	}

	/**
	 * Retorna o class do Array.<br>
	 * O class ser� recuperado se novaClass for nula, se for nula � porque j�
	 * foi verificado se � um primitivo e n�o �.
	 * 
	 * @param novaClasse
	 *            tipo criado.
	 * @param classe
	 *            tippo do array que ser� criado.
	 * @return Class do array.
	 * @throws ClassNotFoundException
	 */
	private Class<?> novaClasseDoArray(Class<?> novaClasse, String classe)
			throws ClassNotFoundException {
		Class<?> res = novaClasse;

		if (!isReferencia(novaClasse) && UtilArray.isArray(classe)) {
			res = UtilArray.novaClasseDeArray(classe);
		}

		return res;
	}

	/**
	 * Retorna a inst�ncia do objeto solicitado.<br>
	 * O class ser� recuperado se novaClass for nula, se for nula � porque j�
	 * foi verificado se � um primitivo ou array e n�o �.
	 * 
	 * @param novaClasse
	 *            tipo criado.
	 * @param classe
	 *            tippo do objeto que ser� criado.
	 * @return Class do objeto.
	 * @throws ClassNotFoundException
	 */
	private Class<?> novaClasseDoObjeto(Class<?> novaClasse, String classe)
			throws ClassNotFoundException {
		Class<?> res = novaClasse;

		if (!isReferencia(novaClasse)) {
			res = Class.forName(classe);
		}
		return res;
	}
}
