/*
 * DOMEngine.java
 * 
 * Data de criação: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml.engine;

import java.util.Collection;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import br.com.ap.comum.colecao.Alterador;
import br.com.ap.comum.colecao.Filtro;

/**
 * Classe que implementa a manipulação de objetos DOM.
 * 
 * @author adrianop
 */
public class DOMEngine extends EngineAbstrato {

    /**
     * @param elemento
     * @param atributo
     * @see br.com.ap.xml.UtilXmlDOM#adicionarAtributoNoElemento(Element, Attr)
     */
    public void adicionarAtributoNoElemento(Element elemento, Attr atributo) {
	if (isReferencia(elemento, atributo)) {
	    elemento.setAttributeNode(atributo);
	}
    }

    /**
     * @param documento
     * @param elemento
     * @see br.com.ap.xml.UtilXmlDOM#adicionarElementoNoDocumento(Document,
     *      Element)
     */
    public void adicionarElementoNoDocumento(Document documento,
	    Element elemento) {
	if (isReferencia(documento, elemento)) {
	    documento.insertBefore(elemento, null);
	}
    }

    /**
     * @param origem
     * @param filho
     * @see br.com.ap.xml.UtilXmlDOM#adicionarElementoNoElemento(Element,
     *      Element)
     */
    public void adicionarElementoNoElemento(Element origem, Element filho) {
	if (isReferencia(origem, filho)) {
	    origem.insertBefore(filho, null);
	}
    }

    /**
     * @param elemento
     * @param texto
     * @see br.com.ap.xml.UtilXmlDOM#adicionarTextoNoElemento(Element, String)
     */
    public void adicionarTextoNoElemento(Element elemento, String texto) {
	if (isReferencia(elemento)) {
	    elemento.setTextContent(texto);
	}
    }

    /**
     * @param <T>
     * @param elemento
     * @return Collection<T>
     * @see br.com.ap.xml.UtilXmlDOM#getElementos(Element)
     */
    public <T extends Object> Collection<T> getElementos(Element elemento) {
	return getFilhos(elemento, novoFiltroDeElement());
    }

    /**
     * @param <T>
     * @param elemento
     * @param alterador
     * @return Collection<T>
     * @see br.com.ap.xml.UtilXmlDOM#getElementos(Element, Alterador)
     */
    public <T extends Object> Collection<T> getElementos(Element elemento,
	    Alterador<Node> alterador) {
	return getFilhos(elemento, novoFiltroDeElement(), alterador);
    }

    /**
     * @param <T>
     * @param elemento
     * @return Collection<T>
     * @see br.com.ap.xml.UtilXmlDOM#getFilhos(Element)
     */
    public <T extends Object> Collection<T> getFilhos(Element elemento) {
	return getFilhos(elemento, null);
    }

    /**
     * @param <T>
     * @param elemento
     * @param filtro
     * @return Collection<T>
     * @see br.com.ap.xml.UtilXmlDOM#getFilhos(Element, Filtro)
     */
    public <T extends Object> Collection<T> getFilhos(Element elemento,
	    Filtro<Node> filtro) {
	return getFilhos(elemento, filtro, null);
    }

    /**
     * @param <T>
     * @param elemento
     * @param filtro
     * @param alterador
     * @return Collection<T>
     * @see br.com.ap.xml.UtilXmlDOM#getFilhos(Element, Filtro, Alterador)
     */
    @SuppressWarnings("unchecked")
    public <T extends Object> Collection<T> getFilhos(Element elemento,
	    Filtro<Node> filtro, Alterador<Node> alterador) {
	Collection<T> resultado = getColecaoFactory().novoArrayList();

	if (isReferencia(elemento)) {
	    NodeList nodes = elemento.getChildNodes();

	    for (int indice = 0; indice < nodes.getLength(); indice++) {
		Node node = nodes.item(indice);

		if (!isReferencia(filtro) || filtro.isFiltrado(node)) {
		    T objeto = (T) node;
		    if (isReferencia(alterador)) {
			objeto = (T) alterador.alterar(node);
		    }
		    resultado.add(objeto);
		}
	    }
	}
	return resultado;
    }

    /**
     * @param documento
     * @return Element
     * @see br.com.ap.xml.UtilXmlDOM#getRoot(Document)
     */
    public Element getRoot(Document documento) {
	Element resultado = null;

	if (isReferencia(documento)) {
	    resultado = documento.getDocumentElement();
	}
	return resultado;
    }

    /**
     * @param elemento
     * @param nome
     * @return String
     * @see br.com.ap.xml.UtilXmlDOM#getValorDoAtributo(Element, String)
     */
    public String getValorDoAtributo(Element elemento, String nome) {
	String resultado = null;

	if (isReferencia(elemento) && !isVazio(nome)) {
	    resultado = elemento.getAttribute(nome);
	}
	return resultado;
    }

    /**
     * @param elemento
     * @return String
     * @see br.com.ap.xml.UtilXmlDOM#getValorDoElemento(Element)
     */
    public String getValorDoElemento(Element elemento) {
	StringBuilder resultado = getStringFactory().novoStringBuilder();

	if (isReferencia(elemento)) {
	    Filtro<Node> filtro = novoFiltroDeText();
	    Alterador<Node> alterador = novoAlteradorTextParaString();

	    Collection<String> colecao = getFilhos(elemento, filtro, alterador);
	    for (String string : colecao) {
		resultado.append(string);
	    }
	}
	return resultado.toString();
    }

    /**
     * @param document
     * @param nome
     * @return Attr
     * @see br.com.ap.xml.UtilXmlDOM#novoAtributo(Document, String)
     */
    public Attr novoAtributo(Document document, String nome) {
	Attr res = null;

	if (isReferencia(document) && !isVazio(nome)) {
	    res = document.createAttribute(nome);
	}
	return res;
    }

    /**
     * @param document
     * @param nome
     * @param valor
     * @return Attr
     * @see br.com.ap.xml.UtilXmlDOM#novoAtributo(Document, String, String)
     */
    public Attr novoAtributo(Document document, String nome, String valor) {
	Attr res = null;

	if (isReferencia(document) && !isVazio(nome)) {
	    res = novoAtributo(document, nome);
	    res.setValue(valor);
	}
	return res;
    }

    /**
     * @param document
     * @param nome
     * @return Element
     * @see br.com.ap.xml.UtilXmlDOM#novoElemento(Document, String)
     */
    public Element novoElemento(Document document, String nome) {
	Element res = null;

	if (isReferencia(document) && !isVazio(nome)) {
	    res = document.createElement(nome);
	}
	return res;
    }

    /**
     * Retorna novo alterador de objetos do tipo TextNode para String.
     * 
     * @return alterador
     */
    private <T extends Object> Alterador<T> novoAlteradorTextParaString() {
	return new Alterador<T>() {
	    @SuppressWarnings("unchecked")
	    public T alterar(T objeto) {
		String resultado = getStringFactory().novaString();

		if (isReferencia(objeto) && isTextNode(objeto)) {
		    resultado = ((Text) objeto).getData();
		}
		return (T) resultado;
	    }

	    /**
	     * Retorna true se o objeto for do tipo texto.
	     * 
	     * @param objeto Objeto validado.
	     * @return booleano
	     */
	    private boolean isTextNode(Object objeto) {
		return (objeto instanceof Text);
	    }
	};
    }

    /**
     * Retorna um filtro de objetos do tipo Element.
     * 
     * @return filtro dos objetos do tipo Element.
     */
    private Filtro<Node> novoFiltroDeElement() {
	return new Filtro<Node>() {
	    public boolean isFiltrado(Node objeto) {
		return (objeto instanceof Element);
	    }
	};
    }

    /**
     * Retorna um filtro de objetos do tipo Text.
     * 
     * @return filtro de objetos do tipo Text.
     */
    private Filtro<Node> novoFiltroDeText() {
	return new Filtro<Node>() {
	    public boolean isFiltrado(Node objeto) {
		return (objeto instanceof Text);
	    }
	};
    }
}
