/*
 * TransformadorEngine.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml.engine;

import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

import br.com.ap.xml.excecao.XmlException;
import br.com.ap.xml.util.UtilXmlException;

/**
 * Classe que implementa a transformações de objetos XML.
 * 
 * @author adrianop
 */
public class TransformadorEngine extends EngineAbstrato {

	/**
	 * @param xml
	 * @param xsl
	 * @param result
	 * @see UtilXmlTransformador#transformar(InputStream, InputStream, Result)
	 * @throws XmlException
	 */
	public void transformar(InputStream xml, InputStream xsl, Result result)
			throws XmlException {

		if (isReferencia(xml, xsl, result)) {
			Document document = novoParserEngine().parserDOM(xml);

			Source xmlSource = getXmlFactory().novoDOMSource(document);
			Source xslSource = getXmlFactory().novoStreamSource(xsl);
			transformar(xmlSource, xslSource, result);
		}
	}

	/**
	 * @param xmlSource
	 * @param xslSource
	 * @param result
	 * @see UtilXmlTransformador#transformar(Source, Source, Result)
	 * @throws XmlException
	 */
	public void transformar(Source xmlSource, Source xslSource, Result result)
			throws XmlException {

		if (isReferencia(xmlSource, xslSource, result)) {
			try {
				Transformer tf = getXmlFactory().novoTransformer(xslSource);
				tf.transform(xmlSource, result);
			} catch (TransformerConfigurationException e) {
				throw UtilXmlException.erroAoCriarTransformer(e);
			} catch (TransformerException e) {
				throw UtilXmlException.erroAoAplicarTransformacao(e);
			}
		}
	}

	/**
	 * @param xmlSource
	 * @param result
	 * @see UtilXmlTransformador#transformar(Source, Result)
	 * @throws XmlException
	 */
	public void transformar(Source xmlSource, Result result)
			throws XmlException {

		if (isReferencia(xmlSource, result)) {
			try {
				Transformer transformer = getXmlFactory().novoTransformer();
				transformer.transform(xmlSource, result);
			} catch (TransformerConfigurationException e) {
				throw UtilXmlException.erroAoCriarTransformer(e);
			} catch (TransformerException e) {
				throw UtilXmlException.erroAoAplicarTransformacao(e);
			}
		}
	}

	/**
	 * @return nova engine do parser.
	 */
	protected ParserEngine novoParserEngine() {
		return new ParserEngine();
	}
}
