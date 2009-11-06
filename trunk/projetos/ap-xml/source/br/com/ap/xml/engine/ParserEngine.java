/*
 * ParserEngine.java
 * 
 * Data de criação: 15/07/2008
 *
 * 
 *
 */
package br.com.ap.xml.engine;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.ap.xml.excecao.XmlException;
import br.com.ap.xml.util.UtilXmlException;

/**
 * Classe que implementa os diversos parser's disponibilizados pela biblioteca.
 * 
 * @author adrianop
 */
public class ParserEngine extends EngineAbstrato {

	/**
	 * @param xml
	 * @return Document
	 * @see UtilXmlParser#parserDOM(InputStream)
	 * @throws XmlException
	 */
	public Document parserDOM(InputStream xml) throws XmlException {
		Document resultado = null;
		if (isReferencia(xml)) {
			try {
				resultado = getDocumentBuilder(false).parse(xml);
			} catch (Throwable e) {
				throw UtilXmlException.parserNaoEfetuado(e);
			}
		}
		return resultado;
	}

	/**
	 * @param xml
	 * @param validar
	 * @return Document
	 * @see UtilXmlParser#parserDOM(InputStream, boolean)
	 * @throws XmlException
	 */
	public Document parserDOM(InputStream xml, boolean validar)
			throws XmlException {
		Document resultado = null;
		if (isReferencia(xml)) {
			try {
				resultado = getDocumentBuilder(validar).parse(xml);
			} catch (Throwable e) {
				throw UtilXmlException.parserNaoEfetuado(e);
			}
		}
		return resultado;
	}

	/**
	 * @param xml
	 * @param dh
	 * @see UtilXmlParser#parserSAX(InputStream, DefaultHandler)
	 * @throws XmlException
	 */
	public void parserSAX(InputStream xml, DefaultHandler dh)
			throws XmlException {
		if (isReferencia(xml, dh)) {
			try {
				getSAXParser(true).parse(xml, dh);
			} catch (Throwable e) {
				throw UtilXmlException.parserNaoEfetuado(e);
			}
		}
	}

	/**
	 * @param xml
	 * @param dh
	 * @param validar
	 * @see UtilXmlParser#parserSAX(InputStream, DefaultHandler, boolean)
	 * @throws XmlException
	 */
	public void parserSAX(InputStream xml, DefaultHandler dh, boolean validar)
			throws XmlException {
		if (isReferencia(xml, dh)) {
			try {
				getSAXParser(validar).parse(xml, dh);
			} catch (Throwable e) {
				throw UtilXmlException.parserNaoEfetuado(e);
			}
		}
	}

	/**
	 * Retorna DocumentBuilder.
	 * 
	 * @param validar
	 *            true se for para efetuar a validação do DTD.
	 * @return SAXParser
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	protected SAXParser getSAXParser(boolean validar)
			throws ParserConfigurationException, SAXException {
		return getSAXParserFactory(validar).newSAXParser();
	}

	/**
	 * Retorna DocumentBuilder.
	 * 
	 * @param factory
	 *            DocumentBuilderFactory
	 * @return DocumentBuilder
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	protected SAXParser getSAXParser(SAXParserFactory factory)
			throws ParserConfigurationException, SAXException {
		return factory.newSAXParser();
	}

	/**
	 * Retorna SAXParserFactory.
	 * 
	 * @param validar
	 *            true se for para efetuar a validação do DTD.
	 * @return SAXParserFactory
	 */
	protected SAXParserFactory getSAXParserFactory(boolean validar) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(validar);
		return factory;
	}

	/**
	 * Retorna DocumentBuilder.
	 * 
	 * @param validar
	 *            true se for para efetuar a validação do DTD.
	 * @return DocumentBuilder
	 * @throws ParserConfigurationException
	 */
	protected DocumentBuilder getDocumentBuilder(boolean validar)
			throws ParserConfigurationException {
		DocumentBuilderFactory factory = getDocumentBuilderFactory(validar);
		return getDocumentBuilder(factory);
	}

	/**
	 * Retorna DocumentBuilder.
	 * 
	 * @param factory
	 *            DocumentBuilderFactory
	 * @return DocumentBuilder
	 * @throws ParserConfigurationException
	 */
	protected DocumentBuilder getDocumentBuilder(DocumentBuilderFactory factory)
			throws ParserConfigurationException {
		DocumentBuilder builder = factory.newDocumentBuilder();
		if (!factory.isValidating()) {
			builder
					.setEntityResolver(getXmlFactory()
							.novoEntityResolverVazio());
		}
		return builder;
	}

	/**
	 * Retorna DocumentBuilderFactory.
	 * 
	 * @param validar
	 *            true se for para efetuar a validação do DTD.
	 * @return DocumentBuilderFactory
	 */
	protected DocumentBuilderFactory getDocumentBuilderFactory(boolean validar) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(validar);
		return factory;
	}
}
