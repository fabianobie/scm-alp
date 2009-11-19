/*
 * BindWhereAbstrato.java
 * 
 * Data de cria��o: 22/08/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.entitymanager.parametrizacao.bindwhere;

import java.io.Serializable;

import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que prov� recursos comuns aos binds implementados.
 * 
 * @author adrianop
 * @param <T>
 *            Classe que representa o atributo parametrizado.
 * @see br.com.ap.entitymanager.parametrizacao.bindwhere.IBindWhere
 */
public abstract class BindWhereAbstrato<T extends Serializable> implements
		IBindWhere<T> {

	/**
	 * Retorna true se for uma string.
	 * 
	 * @param classe
	 *            Objeto validado.
	 * @return true se for uma string.
	 */
	protected boolean isString(Class<?> classe) {
		return (isReferencia(classe) && classe == String.class);
	}

	/**
	 * Retorna true se for um n�mero.
	 * 
	 * @param classe
	 *            Objeto validado.
	 * @return true se for um n�mero.
	 */
	protected boolean isNumero(Class<?> classe) {
		return (isReferencia(classe) && classe.isAssignableFrom(Number.class));
	}

	/**
	 * Retorna true se o tipo for uma string e o objeto estiver vazio.
	 * 
	 * @param tipo
	 *            Tipo da classe.
	 * @param valor
	 *            Valor que ser� validado, caso seja uma string.
	 * @return true se o tipo for uma string e o objeto estiver vazio.
	 */
	protected boolean isStringVazia(Class<?> tipo, Object valor) {
		return (isString(tipo) && isVazio((String) valor));
	}

	/**
	 * Retorna true se o tipo for um num�rico e o objeto for igual a zero.
	 * 
	 * @param tipo
	 *            Tipo da classe.
	 * @param valor
	 *            Valor que ser� validado, caso seja um num�rico.
	 * @return true se o tipo for um num�rico e o objeto for igual a zero.
	 */
	protected boolean isNumericoZero(Class<?> tipo, Object valor) {
		return (isNumero(tipo) && isZero((Number) valor));
	}

	/**
	 * Retorna true se o n�mero for zero.
	 * 
	 * @param numero
	 *            N�mero validado.
	 * @return true se o n�mero for zero.
	 */
	protected boolean isZero(Number numero) {
		return (!isReferencia(numero) || numero.intValue() == 0);
	}

	/**
	 * Retorna true se os objetos tiverem refer�ncia.
	 * 
	 * @param objetos
	 *            Objetos
	 * @return true se os objetos tiverem refer�ncia.
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Retorna true se as strings tiverem vazias.
	 * 
	 * @param strings
	 *            Strings
	 * @return true se as strings tiverem vazias.
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * @return f�brica de string.
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * @return novo string builder.
	 */
	protected StringBuilder novoStringBuilder() {
		return getStringFactory().novoStringBuilder();
	}
}
