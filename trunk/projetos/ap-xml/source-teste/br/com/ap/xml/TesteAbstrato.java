/*
 * TesteAbstrato.java
 * 
 * Data de criação: Jul 1, 2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import junit.framework.TestCase;

import org.w3c.dom.Document;

import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.ConversorFactory;
import br.com.ap.comum.fabrica.DataFactory;
import br.com.ap.comum.fabrica.FormatadorFactory;
import br.com.ap.comum.fabrica.NumeroFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.string.UtilString;
import br.com.ap.xml.UtilXmlParser;
import br.com.ap.xml.excecao.XmlException;
import br.com.ap.xml.fabrica.XmlFactory;

/**
 * Classe que implementa os recursos necessários aos testes.
 * 
 * @author adrianop
 */
public abstract class TesteAbstrato extends TestCase {

	/**
	 * @return Document do arquivo registros.xml
	 * @throws XmlException
	 */
	protected Document getRegistrosDocument() throws XmlException {
		InputStream xml = novoInputStream("registros.xml");
		return UtilXmlParser.parserDOM(xml, false);
	}

	/**
	 * @param arquivo
	 *            nome do arquivo.
	 * @return arquivo do path passado por parâmetro.
	 */
	protected File getFile(String arquivo) {
		return getArquivoFactory().novoFile(getPath(arquivo));
	}

	/**
	 * @param arquivo
	 *            nome do arquivo.
	 * @return arquivo do path passado por parâmetro.
	 */
	protected File novoFile(String arquivo) {
		String path = getPathAtual();
		path += arquivo;
		return getArquivoFactory().novoFile(path);
	}

	/**
	 * @param arquivo
	 *            nome do arquivo.
	 * @return arquivo do path passado por parâmetro.
	 */
	protected Properties novoProperties(String arquivo) {
		return getArquivoFactory().novoProperties(getPath(arquivo));
	}

	/**
	 * @param arquivo
	 *            nome do arquivo.
	 * @return arquivo do path passado por parâmetro.
	 */
	protected InputStream novoInputStream(String arquivo) {
		return getArquivoFactory().novoInputStream(getPath(arquivo));
	}

	/**
	 * @param nome
	 *            Nome do arquivo.
	 * @return path do arquivo
	 */
	protected String getPath(String nome) {
		return this.getClass().getResource(nome).getPath();
	}

	/**
	 * @return path atual.
	 */
	protected String getPathAtual() {
		String path = this.getClass().getResource(".").getPath();
		path = UtilString.substituirString(path, "source", "test");
		return path;
	}

	/**
	 * @return fábrica de IO
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * @return fábrica de string
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
	 * Retorna novo XmlFactory.
	 * 
	 * @return novo XmlFactory
	 */
	protected XmlFactory getXmlFactory() {
		return XmlFactory.getInstancia();
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
	 * Retorna nova fábrica de conversores.
	 * 
	 * @return nova fábrica de conversores
	 */
	protected ConversorFactory getConversorFactory() {
		return ConversorFactory.getInstancia();
	}

	/**
	 * Retorna nova fábrica de formatadores.
	 * 
	 * @return nova fábrica de formatadores
	 */
	protected FormatadorFactory getFormatadorFactory() {
		return FormatadorFactory.getInstancia();
	}
}
