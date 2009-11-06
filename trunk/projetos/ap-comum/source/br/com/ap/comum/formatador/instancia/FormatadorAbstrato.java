/*
 * FormatadorAbstrato.java
 * 
 * Data de criação: 24/05/2007
 *
 * 
 * 
 */
package br.com.ap.comum.formatador.instancia;

import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.util.UtilLog;

/**
 * Classe abstrata que representa um formatador.<br>
 * Provê recursos comuns a todos os formatadores de instância.
 * 
 * @param <T> Tipo do objeto que será formatado.
 * @author AdrianoP
 */
public abstract class FormatadorAbstrato<T> implements IFormatador<T> {

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
	 * @return fábrica de objetos IO.
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * @return fábrica de string.
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * Retorna LogAbstrato.
	 * 
	 * @return LogAbstrato
	 */
	protected LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
