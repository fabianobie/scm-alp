/*
 * UtilXmlTransformador.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.io.InputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import br.com.ap.xml.engine.TransformadorEngine;
import br.com.ap.xml.excecao.XmlException;

/**
 * Classe utilitária responsável pela transformação XML.
 * 
 * @author adrianop
 */
public final class UtilXmlTransformador extends UtilXmlAbstrato {
	private static TransformadorEngine	transformadorEngine;

	/**
	 * Construtor.
	 */
	private UtilXmlTransformador() {
		// Construtor.
	}

	/**
	 * Efetua a transformação do XML com base no XSL passado por parâmetro.
	 * 
	 * @param xml
	 *            XML
	 * @param xsl
	 *            XSL
	 * @param result
	 *            Resultado do processamento.
	 * @throws XmlException
	 */
	public static void transformar(InputStream xml, InputStream xsl,
			Result result) throws XmlException {
		getTransformadorEngine().transformar(xml, xsl, result);
	}

	/**
	 * Efetua a transformação do XML com base no XSL passado por parâmetro.
	 * 
	 * @param xmlSource
	 *            XML
	 * @param xslSource
	 *            XSL
	 * @param result
	 *            Resultado do processamento.
	 * @throws XmlException
	 */
	public static void transformar(Source xmlSource, Source xslSource,
			Result result) throws XmlException {
		getTransformadorEngine().transformar(xmlSource, xslSource, result);
	}

	/**
	 * Efetua a transformação do XML para o tipo resultado passado por
	 * parâmetro.
	 * 
	 * @param xmlSource
	 *            XML
	 * @param result
	 *            Resultado do processamento.
	 * @throws XmlException
	 */
	public static void transformar(Source xmlSource, Result result)
			throws XmlException {
		getTransformadorEngine().transformar(xmlSource, result);
	}

	/**
	 * @return transformadorEngine
	 */
	private static TransformadorEngine getTransformadorEngine() {
		if (!isReferencia(transformadorEngine)) {
			transformadorEngine = new TransformadorEngine();
		}
		return transformadorEngine;
	}
}
