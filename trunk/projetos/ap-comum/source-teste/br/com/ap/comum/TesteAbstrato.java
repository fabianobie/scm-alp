/*
 * TesteAbstrato.java
 * 
 * Data de cria��o: Jul 1, 2008
 *
 * 
 * 
 */
package br.com.ap.comum;

import java.io.File;
import java.util.Properties;

import junit.framework.TestCase;
import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.ConversorFactory;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.FormatadorFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.fabrica.StringFactory;

/**
 * Classe que implementa os recursos necess�rios aos testes.
 * 
 * @author adrianop
 */
public abstract class TesteAbstrato extends TestCase {

	/**
	 * @param arquivo nome do arquivo.
	 * @return arquivo do path passado por par�metro.
	 */
	protected File novoFile(String arquivo) {
		return getArquivoFactory().novoFile(getPath(arquivo));
	}

	/**
	 * @param arquivo nome do arquivo.
	 * @return arquivo do path passado por par�metro.
	 */
	protected Properties novoProperties(String arquivo) {
		return getArquivoFactory().novoProperties(getPath(arquivo));
	}

	/**
	 * @param nome Nome do arquivo.
	 * @return path do arquivo
	 */
	protected String getPath(String nome) {
		return this.getClass().getResource(nome).getPath();
	}

	/**
	 * @return f�brica de IO
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * @return f�brica de string
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * Retorna novo ColecaoFactory.
	 * 
	 * @return novo ColecaoFactory
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna novo NumeroFactory.
	 * 
	 * @return novo NumeroFactory
	 */
	protected NumeroFactory getNumeroFactory() {
		return NumeroFactory.getInstancia();
	}

	/**
	 * Retorna novo DataFactory.
	 * 
	 * @return novo DataFactory
	 */
	protected DataFactory getDataFactory() {
		return DataFactory.getInstancia();
	}

	/**
	 * Retorna nova f�brica de conversores.
	 * 
	 * @return nova f�brica de conversores
	 */
	protected ConversorFactory getConversorFactory() {
		return ConversorFactory.getInstancia();
	}

	/**
	 * Retorna nova f�brica de formatadores.
	 * 
	 * @return nova f�brica de formatadores
	 */
	protected FormatadorFactory getFormatadorFactory() {
		return FormatadorFactory.getInstancia();
	}
}
