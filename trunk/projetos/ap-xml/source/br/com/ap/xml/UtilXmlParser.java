/*
 * UtilXmlParser.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.io.InputStream;

import org.w3c.dom.Document;
import org.xml.sax.helpers.DefaultHandler;

import br.com.ap.xml.engine.ParserEngine;
import br.com.ap.xml.excecao.XmlException;

/**
 * Classe utilitária resonsável pelo parser de arquivos XML.
 * 
 * @author adrianop
 */
public final class UtilXmlParser extends UtilXmlAbstrato {
	private static ParserEngine	parserEngine;

	/**
	 * Construtor.
	 */
	private UtilXmlParser() {
		// Construtor.
	}

	/**
	 * Faz o parser do XML e retorna o Documento do XML.
	 * 
	 * @param xml
	 *            XML que será feito o parser.
	 * @return Document do XML.
	 * @throws XmlException
	 * @see Document
	 */
	public static Document parserDOM(InputStream xml) throws XmlException {
		return getParserEngine().parserDOM(xml);
	}

	/**
	 * Faz o parser do XML e retorna o Document do XML.
	 * 
	 * @param xml
	 *            XML que será feito o parser.
	 * @param validar
	 *            true se o XML será validado pelo DTD.
	 * @return Document do XML.
	 * @throws XmlException
	 * @see Document
	 */
	public static Document parserDOM(InputStream xml, boolean validar)
			throws XmlException {
		return getParserEngine().parserDOM(xml, validar);
	}

	/**
	 * Faz o parser do XML e atualiza o DefaultHandler passado por parâmetro.
	 * 
	 * @param xml
	 *            XML que será feito o parser.
	 * @param dh
	 *            DefaultHandler.
	 * @throws XmlException
	 */
	public static void parserSAX(InputStream xml, DefaultHandler dh)
			throws XmlException {
		getParserEngine().parserSAX(xml, dh);
	}

	/**
	 * Faz o parser do XML e atualiza o DefaultHandler passado por parâmetro.
	 * 
	 * @param xml
	 *            XML que será feito o parser.
	 * @param dh
	 *            DefaultHandler.
	 * @param validar
	 *            true se o XML será validado pelo DTD.
	 * @throws XmlException
	 */
	public static void parserSAX(InputStream xml, DefaultHandler dh,
			boolean validar) throws XmlException {
		getParserEngine().parserSAX(xml, dh, validar);
	}

	/**
	 * @return parserEngine
	 */
	private static ParserEngine getParserEngine() {
		if (!isReferencia(parserEngine)) {
			parserEngine = new ParserEngine();
		}
		return parserEngine;
	}
}
