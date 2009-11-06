/*
 * UtilXmlDOMTest.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.util.Collection;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.ap.comum.colecao.Alterador;
import br.com.ap.comum.colecao.Filtro;
import br.com.ap.comum.string.UtilString;
import br.com.ap.xml.excecao.XmlException;

/**
 * JUnit
 * 
 * @author AdrianoP
 * @see UtilXmlDOM
 */
public class UtilXmlDOMTest extends TesteAbstrato {

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#adicionarAtributoNoElemento(org.w3c.dom.Element, org.w3c.dom.Attr)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testAdicionarAtributoNoElemento() throws XmlException {
		String nomeElemento = "elemento";

		Document documento = getXmlFactory().novoDocumento();
		assertNotNull(documento);

		Element elemento = UtilXmlDOM.novoElemento(documento, nomeElemento);
		assertNotNull(elemento);
		assertTrue(elemento.getAttributes().getLength() == 0);

		String nomeAtributo = "atributo";
		String valorAtributo = "valorDoAtributo";
		Attr atributo = UtilXmlDOM.novoAtributo(documento, nomeAtributo,
		        valorAtributo);
		UtilXmlDOM.adicionarAtributoNoElemento(elemento, atributo);
		assertTrue(elemento.getAttributes().getLength() == 1);

		atributo = null;
		UtilXmlDOM.adicionarAtributoNoElemento(elemento, atributo);
		assertTrue(elemento.getAttributes().getLength() == 1);

		elemento = null;
		UtilXmlDOM.adicionarAtributoNoElemento(elemento, atributo);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#adicionarElementoNoDocumento(org.w3c.dom.Document, org.w3c.dom.Element)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testAdicionarElementoNoDocumento() throws XmlException {
		String nomeElemento = "elemento";

		Document documento = getXmlFactory().novoDocumento();
		assertNotNull(documento);

		Element elemento = UtilXmlDOM.novoElemento(documento, nomeElemento);
		assertNotNull(elemento);

		NodeList lista = documento.getElementsByTagName("*");
		assertTrue(lista.getLength() == 0);

		UtilXmlDOM.adicionarElementoNoDocumento(documento, elemento);
		assertTrue(lista.getLength() == 1);

		elemento = null;
		UtilXmlDOM.adicionarElementoNoDocumento(documento, elemento);
		assertTrue(lista.getLength() == 1);

		documento = null;
		UtilXmlDOM.adicionarElementoNoDocumento(documento, elemento);
		assertTrue(lista.getLength() == 1);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#adicionarElementoNoElemento(org.w3c.dom.Element, org.w3c.dom.Element)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testAdicionarElementoNoElemento() throws XmlException {
		Document documento = getXmlFactory().novoDocumento();
		assertNotNull(documento);

		String nomeElementoOrigem = "origem";
		Element origem = UtilXmlDOM.novoElemento(documento, nomeElementoOrigem);
		assertNotNull(origem);

		String nomeElementoDestino = "destino";
		Element destino = UtilXmlDOM.novoElemento(documento,
		        nomeElementoDestino);
		assertNotNull(destino);

		assertTrue(origem.getElementsByTagName("*").getLength() == 0);

		UtilXmlDOM.adicionarElementoNoElemento(origem, destino);
		assertTrue(origem.getElementsByTagName("*").getLength() == 1);

		destino = null;
		UtilXmlDOM.adicionarElementoNoElemento(origem, destino);
		assertTrue(origem.getElementsByTagName("*").getLength() == 1);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#adicionarTextoNoElemento(org.w3c.dom.Element, java.lang.String)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testTextoElementoNoElemento() throws XmlException {
		Document documento = getXmlFactory().novoDocumento();
		assertNotNull(documento);

		Element origem = UtilXmlDOM.novoElemento(documento, "elemento");

		assertEquals("", origem.getTextContent());
		UtilXmlDOM.adicionarTextoNoElemento(origem, "teste teste");
		assertEquals("teste teste", origem.getTextContent());
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#getElementos(org.w3c.dom.Element)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testGetElementosElement() throws XmlException {
		Document doc = getRegistrosDocument();
		Element root = UtilXmlDOM.getRoot(doc);

		Collection<Element> c = UtilXmlDOM.getElementos(root);
		assertTrue(c.size() > 0);

		c = UtilXmlDOM.getElementos(UtilXmlDOM.novoElemento(doc, "x"));
		assertTrue(c.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#getElementos(org.w3c.dom.Element, br.com.ap.comum.colecao.Alterador)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public final void testGetElementosElementAlteradorOfNode()
	        throws XmlException {
		Document doc = getRegistrosDocument();
		Element root = UtilXmlDOM.getRoot(doc);

		Alterador alt = novoAlteradorDeElementoParaTO();
		Collection<Element> c = UtilXmlDOM.getElementos(root, alt);
		assertTrue(c.size() > 0);

		c = UtilXmlDOM.getElementos(UtilXmlDOM.novoElemento(doc, "x"), alt);
		assertTrue(c.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#getFilhos(org.w3c.dom.Element)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testGetFilhosElement() throws XmlException {
		Document doc = getRegistrosDocument();
		Element root = UtilXmlDOM.getRoot(doc);

		Collection<Element> c = UtilXmlDOM.getFilhos(root);
		assertTrue(c.size() > 0);

		c = UtilXmlDOM.getFilhos(UtilXmlDOM.novoElemento(doc, "x"));
		assertTrue(c.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#getFilhos(org.w3c.dom.Element, br.com.ap.comum.colecao.Filtro)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testGetFilhosElementFiltroOfNode() throws XmlException {
		Document doc = getRegistrosDocument();
		Element root = UtilXmlDOM.getRoot(doc);

		Filtro<Node> f = novoFiltroDoRegistro("1598878");
		Collection<Element> c = UtilXmlDOM.getFilhos(root, f);
		assertTrue(c.size() == 1);

		c = UtilXmlDOM.getFilhos(UtilXmlDOM.novoElemento(doc, "x"), f);
		assertTrue(c.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#getFilhos(org.w3c.dom.Element, br.com.ap.comum.colecao.Filtro, br.com.ap.comum.colecao.Alterador)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public final void testGetFilhosElementFiltroOfNodeAlteradorOfNode()
	        throws XmlException {
		Document doc = getRegistrosDocument();
		Element root = UtilXmlDOM.getRoot(doc);

		Filtro<Node> f = novoFiltroDoRegistro("1598878");
		Alterador a = novoAlteradorDeElementoParaTO();

		Collection<Element> c = UtilXmlDOM.getFilhos(root, f, a);
		assertTrue(c.size() == 1);

		c = UtilXmlDOM.getFilhos(UtilXmlDOM.novoElemento(doc, "x"), f, a);
		assertTrue(c.size() == 0);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#getRoot(org.w3c.dom.Document)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testGetRoot() throws XmlException {
		Document doc = getRegistrosDocument();

		Element root = UtilXmlDOM.getRoot(doc);
		assertNotNull(root);

		doc = getXmlFactory().novoDocumento();
		root = UtilXmlDOM.getRoot(doc);
		assertNull(root);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#getValorDoAtributo(org.w3c.dom.Element, java.lang.String)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testGetValorDoAtributo() throws XmlException {
		Document doc = getXmlFactory().novoDocumento();
		Element e = UtilXmlDOM.novoElemento(doc, "elemento");
		Attr a = UtilXmlDOM.novoAtributo(doc, "atributo", "valor");

		UtilXmlDOM.adicionarAtributoNoElemento(e, a);

		String v = UtilXmlDOM.getValorDoAtributo(e, "atributo");
		assertEquals("valor", v);

		v = UtilXmlDOM.getValorDoAtributo(e, "atributoXXX");
		assertEquals("", v);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#getValorDoElemento(org.w3c.dom.Element)}.
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testGetValorDoElemento() throws XmlException {
		Document doc = getXmlFactory().novoDocumento();
		Element e = UtilXmlDOM.novoElemento(doc, "elemento");

		String v = UtilXmlDOM.getValorDoElemento(e);
		assertEquals("", v);
		UtilXmlDOM.adicionarTextoNoElemento(e, "texto texto");

		v = UtilXmlDOM.getValorDoElemento(e);
		assertEquals("texto texto", v);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#novoAtributo(org.w3c.dom.Document, java.lang.String)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testNovoAtributo() throws XmlException {
		Document doc = getXmlFactory().novoDocumento();
		Attr atributo = UtilXmlDOM.novoAtributo(doc, "atributo");
		assertNotNull(atributo);

		atributo = UtilXmlDOM.novoAtributo(null, "atributo");
		assertNull(null);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#novoAtributo(org.w3c.dom.Document, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testNovoAtributo_DocumentStringString()
	        throws XmlException {
		Document doc = getXmlFactory().novoDocumento();
		Attr atributo = UtilXmlDOM.novoAtributo(doc, "atributo", "valor");
		assertNotNull(atributo);

		atributo = UtilXmlDOM.novoAtributo(null, "atributo", "valor");
		assertNull(null);

		atributo = UtilXmlDOM.novoAtributo(doc, "", "valor");
		assertNull(null);
	}

	/**
	 * Test method for
	 * {@link br.com.ap.xml.UtilXmlDOM#novoElemento(org.w3c.dom.Document, java.lang.String)}
	 * .
	 * 
	 * @throws XmlException
	 */
	@Test
	public final void testNovoElemento() throws XmlException {
		Document doc = getXmlFactory().novoDocumento();
		Element elemento = UtilXmlDOM.novoElemento(doc, "atributo");
		assertNotNull(elemento);

		elemento = UtilXmlDOM.novoElemento(null, "atributo");
		assertNull(null);
	}

	/**
	 * @return filtro do registro com o identificador definido.
	 */
	private Filtro<Node> novoFiltroDoRegistro(final String identificador) {
		return new Filtro<Node>() {
			public boolean isFiltrado(Node objeto) {
				boolean resultado = false;

				if (objeto instanceof Element) {
					Element e = (Element) objeto;
					String id = UtilXmlDOM.getValorDoAtributo(e, "id");
					resultado = UtilString.isStringsIguais(id, identificador);
				}
				return resultado;
			}
		};
	}

	/**
	 * @return alterador de element para to
	 */
	private Alterador<Object> novoAlteradorDeElementoParaTO() {
		return new Alterador<Object>() {
			public Object alterar(Object objeto) {
				ElementoTO to = new ElementoTO();

				if (objeto instanceof Element) {
					Element e = (Element) objeto;
					to.setElemento(e);
					to.setNome(e.getNodeName());
				}
				return to;
			}
		};
	}
}
