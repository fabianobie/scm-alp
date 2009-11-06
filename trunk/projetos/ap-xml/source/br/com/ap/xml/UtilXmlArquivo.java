/*
 * UtilXmlArquivo.java
 * 
 * Data de cria��o: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.io.File;

import org.w3c.dom.Document;

import br.com.ap.xml.engine.ArquivoEngine;
import br.com.ap.xml.excecao.XmlException;

/**
 * Classe utilit�ria resons�vel pela gera��o de arquivos com base em objetos
 * providos da biblioteca XML.
 * 
 * @author adrianop
 */
public final class UtilXmlArquivo extends UtilXmlAbstrato {
	private static ArquivoEngine	arquivoEngine;

	/**
	 * Construtor.
	 */
	private UtilXmlArquivo() {
		// Construtor.
	}

	/**
	 * Gera um XML do documento.
	 * 
	 * @param arquivo
	 *            Arquivo que ser� criado.
	 * @param documento
	 *            Documento usado para gerar o XML.
	 * @throws XmlException
	 */
	public static void gerar(File arquivo, Document documento) throws XmlException {
		getArquivoEngine().gerar(arquivo, documento);
	}

	/**
	 * @return arquivoEngine
	 */
	private static ArquivoEngine getArquivoEngine() {
		if (!isReferencia(arquivoEngine)) {
			arquivoEngine = new ArquivoEngine();
		}
		return arquivoEngine;
	}
}
