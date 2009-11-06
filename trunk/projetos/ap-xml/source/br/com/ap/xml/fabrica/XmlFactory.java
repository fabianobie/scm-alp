/*
 * XmlFactory.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml.fabrica;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.xml.constante.Constante;
import br.com.ap.xml.excecao.XmlException;
import br.com.ap.xml.util.UtilXmlException;

/**
 * Fábrica de objetos da api XML.
 * 
 * @author adrianop
 */
public final class XmlFactory {
	private static XmlFactory	instancia	= new XmlFactory();

	/**
	 * Construtor.
	 */
	private XmlFactory() {
		// Construtor.
	}

	/**
	 * @return instância única da classe.
	 */
	public static XmlFactory getInstancia() {
		return instancia;
	}

	/**
	 * Retorna novo Document.
	 * 
	 * @return novo Document
	 * @throws XmlException
	 */
	public Document novoDocumento() throws XmlException {

		DocumentBuilderFactory factory = getDocumentBuilderFactory(false);
		return getDocumentBuilder(factory).newDocument();
	}

	/**
	 * Retorna novo DOMResult.
	 * 
	 * @return novo DOMResult
	 */
	public DOMResult novoDOMResult() {
		return new DOMResult();
	}

	/**
	 * Retorna novo DOMResult.
	 * 
	 * @param node
	 *            DOM Node no qual há a árvore.
	 * @return novo DOMResult
	 */
	public DOMResult novoDOMResult(Node node) {
		return new DOMResult(node);
	}

	/**
	 * Retorna novo DOMSource.
	 * 
	 * @return novo DOMSource
	 */
	public DOMSource novoDOMSource() {
		return new DOMSource();
	}

	/**
	 * Retorna novo DOMSource.
	 * 
	 * @param documento
	 *            Documento
	 * @return novo DOMSource
	 */
	public DOMSource novoDOMSource(Document documento) {
		DOMSource res = null;
		if (isReferencia(documento)) {
			res = new DOMSource(documento);
		}
		return res;
	}

	/**
	 * Retorna novo EntityResolver vazio para evitar a validação do XML.
	 * 
	 * @return novo EntityResolver vazio.
	 */
	public EntityResolver novoEntityResolverVazio() {
		return new EntityResolver() {

			/**
			 * @see EntityResolver#resolveEntity(String, String)
			 */
			public InputSource resolveEntity(String publicId, String systemId)
					throws SAXException, IOException {
				return novoInputSource(UtilString.getReader(""));
			}

			/**
			 * Retorna novo input source.
			 * 
			 * @param reader
			 *            Reader
			 * @return input source.
			 */
			private InputSource novoInputSource(Reader reader) {
				return new InputSource(reader);
			}
		};
	}

	/**
	 * Retorna novo StreamSource.
	 * 
	 * @return novo StreamSource
	 */
	public StreamSource novoStreamSource() {
		return new StreamSource();
	}

	/**
	 * Retorna novo StreamSource.
	 * 
	 * @param fonte
	 *            Fonte de dados (Ex: inputstream de um XSL)
	 * @return novo StreamSource
	 */
	public StreamSource novoStreamSource(InputStream fonte) {
		StreamSource res = null;
		if (isReferencia(fonte)) {
			res = new StreamSource(fonte);
		}
		return res;
	}

	/**
	 * Retorna novo StreamResult.
	 * 
	 * @return novo StreamSource
	 */
	public StreamResult novoStreamResult() {
		return new StreamResult();
	}

	/**
	 * Retorna novo StreamResult.
	 * 
	 * @param output
	 *            Resultado de dados (Ex: inputstream de um XSL)
	 * @return novo StreamSource
	 */
	public StreamResult novoStreamResult(OutputStream output) {
		return new StreamResult(output);
	}

	/**
	 * Retorna novo Transformer.
	 * 
	 * @return novo Transformer
	 * @throws XmlException
	 */
	public Transformer novoTransformer() throws XmlException {
		String path = Constante.getPathArquivoTransformacaoProperties();
		Properties properties = getArquivoFactory().novoProperties(path);

		return novoTransformer(properties);
	}

	/**
	 * Retorna novo Transformer.
	 * 
	 * @param properties
	 *            Properties contendo as configurações do transformador.
	 * @return novo Transformer
	 * @throws XmlException
	 */
	public Transformer novoTransformer(Properties properties)
			throws XmlException {
		Transformer transformer = null;

		if (isReferencia(properties)) {
			try {
				transformer = getTransformerFactory().newTransformer();
				transformer.setOutputProperties(properties);
			} catch (TransformerConfigurationException e) {
				throw UtilXmlException.erroAoCriarTransformer(e);
			}
		}

		return transformer;
	}

	/**
	 * Retorna novo Transformer.
	 * 
	 * @param xslSource
	 *            Source do transformador.
	 * @return Transformer
	 * @throws XmlException
	 */
	public Transformer novoTransformer(Source xslSource) throws XmlException {
		Transformer res = null;

		if (isReferencia(xslSource)) {
			try {
				res = getTransformerFactory().newTransformer(xslSource);
			} catch (TransformerConfigurationException e) {
				throw UtilXmlException.erroAoCriarTransformer(e);
			}
		}
		return res;
	}

	/**
	 * @return fábrica de objetos IO.
	 */
	private ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * Retorna DocumentBuilder.
	 * 
	 * @param factory
	 *            DocumentBuilderFactory
	 * @return DocumentBuilder
	 * @throws XmlException
	 */
	private DocumentBuilder getDocumentBuilder(DocumentBuilderFactory factory)
			throws XmlException {
		DocumentBuilder builder = null;

		try {
			builder = factory.newDocumentBuilder();
			if (!factory.isValidating()) {
				builder.setEntityResolver(novoEntityResolverVazio());
			}
		} catch (ParserConfigurationException e) {
			throw UtilXmlException.erro(e);
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
	private DocumentBuilderFactory getDocumentBuilderFactory(boolean validar) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(validar);
		return factory;
	}

	/**
	 * Retorna TransformerFactory.
	 * 
	 * @return TransformerFactory
	 */
	private TransformerFactory getTransformerFactory() {
		return TransformerFactory.newInstance();
	}

	/**
	 * @param objeto
	 *            Objeto que será validado.
	 * @return true se o objeto tiver referência.
	 * @see UtilObjeto#isReferencia(Object)
	 */
	private boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}
}
