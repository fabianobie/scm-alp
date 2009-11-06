/*
 * UtilXmlTransformador.java
 * 
 * Data de cria��o: 16/07/2008
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
 * Classe utilit�ria respons�vel pela transforma��o XML.
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
	 * Efetua a transforma��o do XML com base no XSL passado por par�metro.
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
	 * Efetua a transforma��o do XML com base no XSL passado por par�metro.
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
	 * Efetua a transforma��o do XML para o tipo resultado passado por
	 * par�metro.
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
