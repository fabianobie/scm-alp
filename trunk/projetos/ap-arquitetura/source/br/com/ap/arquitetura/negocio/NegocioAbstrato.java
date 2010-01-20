/*
 * ModelAbstrato.java
 * 
 * Data de criação: 24/04/2007
 *
 * 
 * 
 */
package br.com.ap.arquitetura.negocio;

import br.com.ap.arquitetura.util.UtilLog;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.seguranca.ControladorDeAcesso;
import br.com.ap.comum.string.UtilString;

/**
 * Classe abstrata que provê os recursos necessário para uma model.
 * 
 * @author adrianop
 */
public abstract class NegocioAbstrato implements Negocio {

	private ControladorDeAcesso controladorDeAcesso;

	/**
	 * Retorna novo ControladorDeAcesso.
	 * 
	 * @return novo ControladorDeAcesso
	 */
	protected abstract ControladorDeAcesso novoControladorDeAcesso();

	/**
	 * Retorna controladorDeAcesso.
	 * 
	 * @return ControladorDeAcesso
	 */
	protected ControladorDeAcesso getControladorDeAcesso() {
		if (!isReferencia(controladorDeAcesso)) {
			controladorDeAcesso = novoControladorDeAcesso();
		}

		return controladorDeAcesso;
	}

	/**
	 * Retorna a fábrica de numéricos.
	 * 
	 * @return NumeroFactory
	 */
	protected NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * @return ColecaoFactory
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna DataFactory.
	 * 
	 * @return DataFactory
	 */
	protected DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * Retorna true se o objeto tiver uma referência.
	 * 
	 * @param objetos Objeto(s) validado(s)
	 * @return true se o objeto tiver uma referência.
	 */
	protected boolean isReferencia(Object... objetos) {
		return UtilObjeto.isReferenciaTodos(objetos);
	}

	/**
	 * Retorna true se a(s) string(s) estiver(rem) vazia(s).
	 * 
	 * @param strings String(s) validada(s)
	 * @return true se a(s) string(s) estiver(rem) vazia(s).
	 */
	protected boolean isVazio(String... strings) {
		return UtilString.isVazioTodos(strings);
	}

	/**
	 * Retorna log.
	 * 
	 * @return log
	 */
	protected LogAbstrato getLog() {
		return UtilLog.getLog();
	}
}
