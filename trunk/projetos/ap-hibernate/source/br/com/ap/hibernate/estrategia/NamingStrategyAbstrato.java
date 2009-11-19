/*
 * NamingStrategyAbstrato.java
 * 
 * Data de criação: 30/07/2008
 *
 * 
 * Fábrica de Software - Brasília
 */
package br.com.ap.hibernate.estrategia;

import org.hibernate.cfg.DefaultNamingStrategy;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que provê os recursos necessários para a criação de
 * estratégias de manipulação de nomes dos objetos de Banco.
 * 
 * @author adrianop
 * @see org.hibernate.cfg.NamingStrategy
 */
public abstract class NamingStrategyAbstrato extends DefaultNamingStrategy {

	/**
	 * @param strings Strings que serão verificadas.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazioTodos(String[])
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * @param objetos Objetos que serão validados.
	 * @return true se o objeto tiver referência.
	 * @see UtilObjeto#isReferenciaTodos(Object[])
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Retorna fábrica de coleção.
	 * 
	 * @return fábrica de coleção.
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna fábrica de string.
	 * 
	 * @return fábrica de string
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}
}
