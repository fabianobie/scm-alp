/*
 * ConversorAbstrato.java
 * 
 * Data de criação: 24/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.conversor.instancia;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import br.com.ap.comum.array.UtilArray;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.util.UtilLog;

/**
 * Classe abstrata que representa um conversor.<br>
 * Provê recursos comuns a todos os conversores de instância.
 * 
 * @author AdrianoP
 * @param <O> Tipo do objeto de origem
 * @param <D> Tipo do objeto de destino
 */
public abstract class ConversorAbstrato<O, D> implements IConversor<O, D> {

	/**
	 * @see IConversor#getTipoDeOrigem()
	 */
	@SuppressWarnings("unchecked")
	public Class<O> getTipoDeOrigem() {
		return (Class<O>) UtilArray
				.getElementoDoIndice(getTiposGenericos(), 0);
	}

	/**
	 * @see IConversor#getTipoDeDestino()
	 */
	@SuppressWarnings("unchecked")
	public Class<D> getTipoDeDestino() {
		return (Class<D>) UtilArray
				.getElementoDoIndice(getTiposGenericos(), 1);
	}

	/**
	 * Retorna o tipo dos objetos genéricos.
	 * 
	 * @return tipo dos genéricos.
	 */
	protected Type[] getTiposGenericos() {
		Class<?> classe = UtilObjeto.getClasse(this);
		ParameterizedType p = (ParameterizedType) classe
				.getGenericSuperclass();
		return p.getActualTypeArguments();
	}

	/**
	 * Retorna true se houver referência.
	 * 
	 * @param objeto Objeto validado
	 * @return true se houver referência.
	 */
	protected boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * Retorna true se o objeto for do tipo BigDecimal.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for do tipo BigDecimal
	 */
	protected boolean isBigDecimal(Object objeto) {
		return UtilObjeto.isBigDecimal(objeto);
	}

	/**
	 * Retorna true se o objeto for do tipo Double.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for do tipo double
	 */
	protected boolean isDouble(Object objeto) {
		return UtilObjeto.isDouble(objeto);
	}

	/**
	 * Retorna true se o objeto for do tipo sql.Date.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for do tipo sql.Date
	 */
	protected boolean isSqlDate(Object objeto) {
		return (objeto instanceof java.sql.Date);
	}

	/**
	 * Retorna true se o objeto for do tipo util.Date.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for do tipo util.Date.
	 */
	protected boolean isUtilDate(Object objeto) {
		return UtilObjeto.isDate(objeto);
	}

	/**
	 * Retorna true se o objeto for do tipo Timestamp.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for do tipo Timestamp
	 */
	protected boolean isTimestamp(Object objeto) {
		return UtilObjeto.isTimestamp(objeto);
	}

	/**
	 * Retorna true se o objeto for do tipo Time.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for do tipo Time
	 */
	protected boolean isTime(Object objeto) {
		return UtilObjeto.isTime(objeto);
	}

	/**
	 * Retorna true se o objeto for do tipo String.
	 * 
	 * @param objeto Objeto validado.
	 * @return true se o objeto for do tipo String
	 */
	protected boolean isString(Object objeto) {
		return UtilObjeto.isString(objeto);
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return AbstractLog
	 */
	protected LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
