/*
 * FormatadorAbstrato.java
 * 
 * Data de cria��o: 24/05/2007
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
 * Prov� recursos comuns a todos os formatadores de inst�ncia.
 * 
 * @param <T> Tipo do objeto que ser� formatado.
 * @author AdrianoP
 */
public abstract class FormatadorAbstrato<T> implements IFormatador<T> {

	/**
	 * Retorna true se houver refer�ncia.
	 * 
	 * @param objeto Objeto validado
	 * @return true se houver refer�ncia.
	 */
	protected boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * @return f�brica de objetos IO.
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * @return f�brica de string.
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
