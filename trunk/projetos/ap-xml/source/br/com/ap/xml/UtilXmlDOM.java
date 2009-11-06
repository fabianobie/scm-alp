/*
 * UtilXmlDOM.java
 * 
 * Data de cria��o: 16/07/2008
 *
 * 
 *
 */
package br.com.ap.xml;

import java.util.Collection;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import br.com.ap.comum.colecao.Alterador;
import br.com.ap.comum.colecao.Filtro;
import br.com.ap.xml.engine.DOMEngine;

/**
 * Classe utilit�ria resons�vel pela manipula��o de objetos DOM.
 * 
 * @author adrianop
 */
public final class UtilXmlDOM extends UtilXmlAbstrato {
    private static DOMEngine domEngine;

    /**
     * Construtor.
     */
    private UtilXmlDOM() {
	// Construtor.
    }

    /**
     * Adiciona um atributo no elemento.
     * 
     * @param elemento elemento que receber� o atributo.
     * @param atributo atributo que ser� inserido.
     */
    public static void adicionarAtributoNoElemento(Element elemento,
	    Attr atributo) {
	getDomEngine().adicionarAtributoNoElemento(elemento, atributo);
    }

    /**
     * Adiciona um atributo no documento, o documento dever� ser um Document sem
     * elemento, caso contr�rio uma exce��o ser� lan�ada.
     * 
     * @param documento documento que receber� o elemento.
     * @param elemento elemento que ser� adicionado.
     */
    public static void adicionarElementoNoDocumento(Document documento,
	    Element elemento) {
	getDomEngine().adicionarElementoNoDocumento(documento, elemento);
    }

    /**
     * Adiciona um Element em outro Element.
     * 
     * @param origem Elemento de origem.
     * @param filho Elemento que ser� adicionado..
     */
    public static void adicionarElementoNoElemento(Element origem, Element filho) {
	getDomEngine().adicionarElementoNoElemento(origem, filho);
    }

    /**
     * Adiciona um texto em um elemento.
     * 
     * @param elemento Elemento.
     * @param texto Texto.
     */
    public static void adicionarTextoNoElemento(Element elemento, String texto) {
	getDomEngine().adicionarTextoNoElemento(elemento, texto);
    }

    /**
     * Retorna a cole��o objetos de um elemento. Os elementos filhos do tipo
     * Text n�o ser�o recuperados.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @return Cole��o de objetos.
     */
    public static <T extends Element> Collection<T> getElementos(
	    Element elemento) {
	return getDomEngine().getElementos(elemento);
    }

    /**
     * Retorna a cole��o objetos de um elemento. Os elementos filhos do tipo
     * Text n�o ser�o recuperados.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @param alterador Alterador aplicado no objeto recuperado da api do DOM.
     * @return Cole��o de objetos.
     */
    public static <T extends Object> Collection<T> getElementos(
	    Element elemento, Alterador<Node> alterador) {
	return getDomEngine().getElementos(elemento, alterador);
    }

    /**
     * Retorna uma cole��o de Node dos filhos do elemento.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @return Cole��o de Node
     * @see Node
     * @see Filtro
     */
    public static <T extends Object> Collection<T> getFilhos(Element elemento) {
	return getDomEngine().getFilhos(elemento);
    }

    /**
     * Retorna uma cole��o de Node dos filhos do elemento. Para cada objeto
     * recuperado da API do DOM ser� aplicado um filtro onde ser� verificado se
     * o objeto ser� adicionado � cole��o de retorno.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @param filtro Filtro aplicado na cole��o de objetos recuperados pelo DOM.
     * @return Cole��o de Node
     * @see Node
     * @see Filtro
     */
    public static <T extends Object> Collection<T> getFilhos(Element elemento,
	    Filtro<Node> filtro) {
	return getDomEngine().getFilhos(elemento, filtro);
    }

    /**
     * Retorna uma cole��o de Node dos filhos do elemento. Para cada objeto
     * recuperado da API do DOM ser� aplicado um filtro onde ser� verificado se
     * o objeto ser� adicionado � cole��o de retorno, e os objetos que ser�o
     * adicionados � cole��o de retorno ser� aplicado um alterador no objeto.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @param filtro Filtro aplicado na cole��o de objetos recuperados pelo DOM.
     * @param alterador Alterador do objeto recuperado da cole��o
     * @return Cole��o de Node
     * @see Node
     * @see Filtro
     * @see Alterador
     */
    public static <T extends Object> Collection<T> getFilhos(Element elemento,
	    Filtro<Node> filtro, Alterador<Node> alterador) {
	return getDomEngine().getFilhos(elemento, filtro, alterador);
    }

    /**
     * Retorna o elemento root.
     * 
     * @param documento Documento
     * @return root
     */
    public static Element getRoot(Document documento) {
	return getDomEngine().getRoot(documento);
    }

    /**
     * Retorna o valor do atributo informado.
     * 
     * @param elemento Elemento
     * @param nome Nome do atributo
     * @return valor
     */
    public static String getValorDoAtributo(Element elemento, String nome) {
	return getDomEngine().getValorDoAtributo(elemento, nome);
    }

    /**
     * Retorna o texto do elemento.
     * 
     * @param elemento Elemento
     * @return texto
     */
    public static String getValorDoElemento(Element elemento) {
	return getDomEngine().getValorDoElemento(elemento);
    }

    /**
     * Retorna novo Atributo.
     * 
     * @param document Document
     * @param nome Nome do atributo
     * @return novo atributo
     */
    public static Attr novoAtributo(Document document, String nome) {
	return getDomEngine().novoAtributo(document, nome);
    }

    /**
     * Retorna novo Atributo.
     * 
     * @param document Document
     * @param nome Nome do atributo
     * @param valor Valor do atributo
     * @return novo atributo
     */
    public static Attr novoAtributo(Document document, String nome, String valor) {
	return getDomEngine().novoAtributo(document, nome, valor);
    }

    /**
     * Retorna novo Element
     * 
     * @param document Document
     * @param nome Nome do elemento.
     * @return novo elemento
     */
    public static Element novoElemento(Document document, String nome) {
	return getDomEngine().novoElemento(document, nome);
    }

    /**
     * @return domEngine
     */
    private static DOMEngine getDomEngine() {
	if (!isReferencia(domEngine)) {
	    domEngine = new DOMEngine();
	}
	return domEngine;
    }
}
