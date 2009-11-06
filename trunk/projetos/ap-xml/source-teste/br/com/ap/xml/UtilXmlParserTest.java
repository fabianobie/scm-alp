/*
 * UtilXmlParserTest.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.io.InputStream;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.helpers.DefaultHandler;

import br.com.ap.xml.UtilXmlParser;
import br.com.ap.xml.excecao.XmlException;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilXmlParser
 */
public class UtilXmlParserTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlParser#parserDOM(java.io.InputStream)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testParserDOMInputStream() throws XmlException {
		InputStream xml = novoInputStream("registros.xml");
		Document d = UtilXmlParser.parserDOM(xml);
		assertNotNull(d);

		try {
			xml = novoInputStream("registros-erro.xml");
			d = UtilXmlParser.parserDOM(xml);
			fail("Um erro de parser deveria ser gerado aqui.");
		} catch (XmlException e) {
			assertNotNull(e.getMessage());
		}

		d = UtilXmlParser.parserDOM(null);
		assertNull(d);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlParser#parserDOM(java.io.InputStream, boolean)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testParserDOMInputStreamBoolean() throws XmlException {
		InputStream xml = novoInputStream("registros.xml");
		Document d = UtilXmlParser.parserDOM(xml, true);
		assertNotNull(d);

		try {
			xml = novoInputStream("registros-erro.xml");
			d = UtilXmlParser.parserDOM(xml, true);
			fail("Um erro de parser deveria ser gerado aqui.");
		} catch (XmlException e) {
			assertNotNull(e.getMessage());
		}

		d = UtilXmlParser.parserDOM(null, true);
		assertNull(d);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlParser#parserSAX(java.io.InputStream, org.xml.sax.helpers.DefaultHandler)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testParserSAXInputStreamDefaultHandler()
			throws XmlException {
		InputStream xml = novoInputStream("registros.xml");
		DefaultHandler dh = new DefaultHandler();
		UtilXmlParser.parserSAX(xml, dh);

		try {
			xml = novoInputStream("registros-erro.xml");
			UtilXmlParser.parserSAX(xml, dh);
			fail("Um erro de parser deveria ser gerado aqui.");
		} catch (XmlException e) {
			assertNotNull(e.getMessage());
		}
		
		UtilXmlParser.parserSAX(null, dh);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlParser#parserSAX(java.io.InputStream, org.xml.sax.helpers.DefaultHandler, boolean)}.
	 * @throws XmlException 
	 */
	@Test
	public final void testParserSAXInputStreamDefaultHandlerBoolean() throws XmlException {
		InputStream xml = novoInputStream("registros.xml");
		DefaultHandler dh = new DefaultHandler();
		UtilXmlParser.parserSAX(xml, dh, true);

		try {
			xml = novoInputStream("registros-erro.xml");
			UtilXmlParser.parserSAX(xml, dh, true);
			fail("Um erro de parser deveria ser gerado aqui.");
		} catch (XmlException e) {
			assertNotNull(e.getMessage());
		}
		
		UtilXmlParser.parserSAX(null, dh, true);
	}

}
