/*
 * UtilXmlArquivoTest.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.io.File;

import org.junit.Test;
import org.w3c.dom.Document;

import br.com.ap.xml.UtilXmlArquivo;
import br.com.ap.xml.excecao.XmlException;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilXmlArquivo
 */
public class UtilXmlArquivoTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlArquivo#gerar(java.io.File, org.w3c.dom.Document)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testGerar() throws XmlException {
		Document documento = getRegistrosDocument();

		File arquivo = novoFile("registros-temp.xml");
		assertFalse(arquivo.exists());

		UtilXmlArquivo.gerar(arquivo, documento);
		assertTrue(arquivo.exists());

		arquivo.delete();
	}

}
