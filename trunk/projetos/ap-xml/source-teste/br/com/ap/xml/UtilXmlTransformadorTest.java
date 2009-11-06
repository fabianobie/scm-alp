/*
 * UtilXmlTransformadorTest.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;

import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.xml.UtilXmlParser;
import br.com.ap.xml.UtilXmlTransformador;
import br.com.ap.xml.excecao.XmlException;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilXmlTransformador
 */
public class UtilXmlTransformadorTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlTransformador#transformar(java.io.InputStream, java.io.InputStream, javax.xml.transform.Result)}.
	 * @throws XmlException 
	 */
	@Test
	public final void testTransformarInputStreamInputStreamResult() throws XmlException {
		InputStream xml = novoInputStream("registros.xml");
		InputStream xsl = novoInputStream("registros.xsl");
		
		File arquivo = novoFile("registros-temp.html");
		arquivo.delete();
		assertFalse(arquivo.exists());
		
		OutputStream fos = novoFileOutputStream(arquivo);
		StreamResult r = getXmlFactory().novoStreamResult(fos);
		
		UtilXmlTransformador.transformar(xml, xsl, r);
		assertTrue(arquivo.exists());
		
		UtilArquivo.fechar(fos);
		arquivo.delete();
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlTransformador#transformar(javax.xml.transform.Source, javax.xml.transform.Source, javax.xml.transform.Result)}.
	 * @throws XmlException 
	 */
	@Test
	public final void testTransformarSourceSourceResult() throws XmlException {
		InputStream xml = novoInputStream("registros.xml");
		InputStream xsl = novoInputStream("registros.xsl");
		
		Document document = UtilXmlParser.parserDOM(xml);

		Source xmlSource = getXmlFactory().novoDOMSource(document);
		Source xslSource = getXmlFactory().novoStreamSource(xsl);
		
		File arquivo = novoFile("registros-temp.html");
		arquivo.delete();
		assertFalse(arquivo.exists());
		
		OutputStream fos = novoFileOutputStream(arquivo);
		StreamResult r = getXmlFactory().novoStreamResult(fos);
		
		UtilXmlTransformador.transformar(xmlSource, xslSource, r);
		assertTrue(arquivo.exists());
		
		UtilArquivo.fechar(fos);
		arquivo.delete();
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlTransformador#transformar(javax.xml.transform.Source, javax.xml.transform.Result)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testTransformarSourceResult() throws XmlException {
		InputStream xml = novoInputStream("registros.xml");
		Document documento = UtilXmlParser.parserDOM(xml);

		DOMSource xmlSource = getXmlFactory().novoDOMSource(documento);

		File arquivo = novoFile("registros-copia.xml");
		assertFalse(arquivo.exists());
		
		OutputStream fos = novoFileOutputStream(arquivo);
		StreamResult sr = getXmlFactory().novoStreamResult(fos);
		UtilXmlTransformador.transformar(xmlSource, sr);
		
		assertTrue(arquivo.exists());
		
		UtilArquivo.fechar(fos);
		arquivo.delete();
	}

	/**
	 * @param arquivo Arquivo
	 * @return file outputstream
	 */
	private OutputStream novoFileOutputStream(File arquivo) {
		return getArquivoFactory().novoFileOutputStream(arquivo);
	}

}
