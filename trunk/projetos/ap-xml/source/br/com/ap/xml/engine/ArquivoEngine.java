/*
 * ArquivoEngine.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml.engine;

import java.io.File;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.w3c.dom.Document;

import br.com.ap.comum.arquivo.UtilArquivo;
import br.com.ap.xml.excecao.XmlException;

/**
 * Classe responsável pela geração de arquivos com base em um XML.
 * 
 * @author adrianop
 */
public class ArquivoEngine extends EngineAbstrato {

	/**
	 * @param arquivo
	 * @param documento
	 * @throws XmlException
	 * @see UtilXmlArquivo#gerar(File, Document)
	 */
	public void gerar(File arquivo, Document documento) throws XmlException {
		if (isReferencia(arquivo, documento)) {
			OutputStream output = novoFileOutputStream(arquivo);

			Source source = getXmlFactory().novoDOMSource(documento);
			Result result = getXmlFactory().novoStreamResult(output);

			novoTransformadorEngine().transformar(source, result);

			output = UtilArquivo.fechar(output);
		}
	}

	/**
	 * Retorna novo outputstrem do arquivo.
	 * 
	 * @param arquivo
	 *            Arquivo
	 * @return outputstrem do arquivo.
	 */
	protected OutputStream novoFileOutputStream(File arquivo) {
		return getArquivoFactory().novoFileOutputStream(arquivo);
	}

	/**
	 * @return novo TransformadorEngine
	 * @see TransformadorEngine
	 */
	protected TransformadorEngine novoTransformadorEngine() {
		return new TransformadorEngine();
	}
}
