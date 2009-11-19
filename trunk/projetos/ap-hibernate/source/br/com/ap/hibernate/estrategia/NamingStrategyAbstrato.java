/*
 * NamingStrategyAbstrato.java
 * 
 * Data de cria��o: 30/07/2008
 *
 * 
 * F�brica de Software - Bras�lia
 */
package br.com.ap.hibernate.estrategia;

import org.hibernate.cfg.DefaultNamingStrategy;

import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que prov� os recursos necess�rios para a cria��o de
 * estrat�gias de manipula��o de nomes dos objetos de Banco.
 * 
 * @author adrianop
 * @see org.hibernate.cfg.NamingStrategy
 */
public abstract class NamingStrategyAbstrato extends DefaultNamingStrategy {

	/**
	 * @param strings Strings que ser�o verificadas.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazioTodos(String[])
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * @param objetos Objetos que ser�o validados.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferenciaTodos(Object[])
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Retorna f�brica de cole��o.
	 * 
	 * @return f�brica de cole��o.
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna f�brica de string.
	 * 
	 * @return f�brica de string
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}
}
