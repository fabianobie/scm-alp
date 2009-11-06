/*
 * UtilXmlDOM.java
 * 
 * Data de criação: 16/07/2008
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
 * Classe utilitária resonsável pela manipulação de objetos DOM.
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
     * @param elemento elemento que receberá o atributo.
     * @param atributo atributo que será inserido.
     */
    public static void adicionarAtributoNoElemento(Element elemento,
	    Attr atributo) {
	getDomEngine().adicionarAtributoNoElemento(elemento, atributo);
    }

    /**
     * Adiciona um atributo no documento, o documento deverá ser um Document sem
     * elemento, caso contrário uma exceção será lançada.
     * 
     * @param documento documento que receberá o elemento.
     * @param elemento elemento que será adicionado.
     */
    public static void adicionarElementoNoDocumento(Document documento,
	    Element elemento) {
	getDomEngine().adicionarElementoNoDocumento(documento, elemento);
    }

    /**
     * Adiciona um Element em outro Element.
     * 
     * @param origem Elemento de origem.
     * @param filho Elemento que será adicionado..
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
     * Retorna a coleção objetos de um elemento. Os elementos filhos do tipo
     * Text não serão recuperados.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @return Coleção de objetos.
     */
    public static <T extends Element> Collection<T> getElementos(
	    Element elemento) {
	return getDomEngine().getElementos(elemento);
    }

    /**
     * Retorna a coleção objetos de um elemento. Os elementos filhos do tipo
     * Text não serão recuperados.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @param alterador Alterador aplicado no objeto recuperado da api do DOM.
     * @return Coleção de objetos.
     */
    public static <T extends Object> Collection<T> getElementos(
	    Element elemento, Alterador<Node> alterador) {
	return getDomEngine().getElementos(elemento, alterador);
    }

    /**
     * Retorna uma coleção de Node dos filhos do elemento.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @return Coleção de Node
     * @see Node
     * @see Filtro
     */
    public static <T extends Object> Collection<T> getFilhos(Element elemento) {
	return getDomEngine().getFilhos(elemento);
    }

    /**
     * Retorna uma coleção de Node dos filhos do elemento. Para cada objeto
     * recuperado da API do DOM será aplicado um filtro onde será verificado se
     * o objeto será adicionado à coleção de retorno.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @param filtro Filtro aplicado na coleção de objetos recuperados pelo DOM.
     * @return Coleção de Node
     * @see Node
     * @see Filtro
     */
    public static <T extends Object> Collection<T> getFilhos(Element elemento,
	    Filtro<Node> filtro) {
	return getDomEngine().getFilhos(elemento, filtro);
    }

    /**
     * Retorna uma coleção de Node dos filhos do elemento. Para cada objeto
     * recuperado da API do DOM será aplicado um filtro onde será verificado se
     * o objeto será adicionado à coleção de retorno, e os objetos que serão
     * adicionados à coleção de retorno será aplicado um alterador no objeto.
     * 
     * @param <T> Tipo do objeto de retorno.
     * @param elemento Elemento
     * @param filtro Filtro aplicado na coleção de objetos recuperados pelo DOM.
     * @param alterador Alterador do objeto recuperado da coleção
     * @return Coleção de Node
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
