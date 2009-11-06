/*
 * EngineAbstrato.java
 * 
 * Data de cria��o: 04/06/2007
 * 
 *
 *
 */
package br.com.ap.xml.engine;

import java.util.Collection;

import br.com.ap.comum.colecao.UtilColecao;
import br.com.ap.comum.conversor.instancia.IConversor;
import br.com.ap.comum.estrategia.UtilEstrategiaDeConversores;
import br.com.ap.comum.estrategia.UtilEstrategiaDeFormatadores;
import br.com.ap.comum.excecao.ConversorException;
import br.com.ap.comum.excecao.FormatadorException;
import br.com.ap.comum.fabrica.ArquivoFactory;
import br.com.ap.comum.fabrica.ColecaoFactory;
import br.com.ap.comum.fabrica.StringFactory;
import br.com.ap.comum.formatador.instancia.IFormatador;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.string.UtilString;
import br.com.ap.xml.excecao.XmlException;
import br.com.ap.xml.fabrica.XmlFactory;
import br.com.ap.xml.util.UtilXmlException;

/**
 * Classe que representa a engine da manipula��o do XML.
 * 
 * @author AdrianoP
 */
public abstract class EngineAbstrato {

	/**
	 * Formata o valor passado por par�metro.
	 * 
	 * @param tipo
	 *            Tipo do objeto, ser� usado para recuperar o respectivo
	 *            formatador.
	 * @param valor
	 *            Objeto que ser� formatado.
	 * @return String do valor formatado
	 * @throws XmlException
	 */
	@SuppressWarnings("unchecked")
	protected String formatar(Class<?> tipo, Object valor) throws XmlException {
		try {
			return getFormatador(tipo).formatar(valor);
		} catch (FormatadorException e) {
			throw UtilXmlException.erro(e);
		}
	}

	/**
	 * Converte o valor passado por par�metro.
	 * 
	 * @param tipo
	 *            Tipo do objeto, ser� usado para recuperar o respectivo
	 *            conversor.
	 * @param valor
	 *            Objeto que ser� convertido.
	 * @return Objeto do valor convertido
	 * @throws XmlException
	 */
	@SuppressWarnings("unchecked")
	protected Object converter(Class<?> tipo, Object valor) throws XmlException {
		try {
			return getConversor(tipo).converter(valor);
		} catch (ConversorException e) {
			throw UtilXmlException.erro(e);
		}
	}

	/**
	 * @param string
	 *            String que ser� validada.
	 * @return true se a string for vazia.
	 * @see UtilString#isVazio(String)
	 */
	protected boolean isVazio(String string) {
		return UtilString.isVazio(string);
	}

	/**
	 * @param string1
	 *            String que ser� validada.
	 * @param string2
	 *            String que ser� validada.
	 * @return true se as strings forem vazia
	 * @see UtilString#isVazio(String, String)
	 */
	protected boolean isVazio(String string1, String string2) {
		return UtilString.isVazio(string1, string2);
	}

	/**
	 * @param string1
	 *            String que ser� validada.
	 * @param string2
	 *            String que ser� validada.
	 * @param string3
	 *            String que ser� validada.
	 * @return true se as strings forem vazia
	 * @see UtilString#isVazio(String, String, String)
	 */
	protected boolean isVazio(String string1, String string2, String string3) {
		return UtilString.isVazio(string1, string2, string3);
	}

	/**
	 * @param objeto
	 *            Objeto que ser� validado.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferencia(Object)
	 */
	protected boolean isReferencia(Object objeto) {
		return UtilObjeto.isReferencia(objeto);
	}

	/**
	 * @param objeto
	 *            Objeto que ser� validado.
	 * @param objeto2
	 *            Objeto que ser� validado.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferencia(Object, Object)
	 */
	protected boolean isReferencia(Object objeto, Object objeto2) {
		return UtilObjeto.isReferencia(objeto, objeto2);
	}

	/**
	 * @param objeto0
	 *            Objeto que ser� validado.
	 * @param objeto1
	 *            Objeto que ser� validado.
	 * @param objeto2
	 *            Objeto que ser� validado.
	 * @return true se o objeto tiver refer�ncia.
	 * @see UtilObjeto#isReferencia(Object, Object, Object)
	 */
	protected boolean isReferencia(Object objeto0, Object objeto1,
			Object objeto2) {
		return UtilObjeto.isReferencia(objeto0, objeto1, objeto2);
	}

	/**
	 * @return f�brica de string.
	 */
	protected StringFactory getStringFactory() {
		return StringFactory.getInstancia();
	}

	/**
	 * @return f�brica de objetos IO.
	 */
	protected ArquivoFactory getArquivoFactory() {
		return ArquivoFactory.getInstancia();
	}

	/**
	 * Retorna ColecaoFactory.
	 * 
	 * @return ColecaoFactory
	 */
	protected ColecaoFactory getColecaoFactory() {
		return ColecaoFactory.getInstancia();
	}

	/**
	 * Retorna f�brica de objetos XML.
	 * 
	 * @return f�brica de objetos XML
	 */
	protected XmlFactory getXmlFactory() {
		return XmlFactory.getInstancia();
	}

	/**
	 * Retorna o formatador do tipo solicitado.
	 * 
	 * @param tipo
	 *            Tipo de objeto.
	 * @return formatador
	 */
	@SuppressWarnings("unchecked")
	protected IFormatador getFormatador(Class<?> tipo) {
		return getUtilEstrategiaDeFormatadores().recuperar(tipo);
	}

	/**
	 * Retorna o conversor do tipo solicitado.
	 * 
	 * @param tipo
	 *            Tipo de objeto.
	 * @return conversor
	 */
	@SuppressWarnings("unchecked")
	protected IConversor getConversor(Class<?> tipo) {
		return getUtilEstrategiaDeConversores().recuperar(tipo);
	}

	/**
	 * Retorna true se a cole��o estiver vazia.
	 * 
	 * @param colecao
	 *            Cole��o
	 * @return true se a cole��o estiver vazia.
	 */
	protected boolean isVazio(Collection<?> colecao) {
		return UtilColecao.isVazio(colecao);
	}

	/**
	 * @return estrat�gia de formatadores.
	 */
	private UtilEstrategiaDeFormatadores getUtilEstrategiaDeFormatadores() {
		return UtilEstrategiaDeFormatadores.getInstancia();
	}

	/**
	 * @return estrat�gia de conversores
	 */
	private UtilEstrategiaDeConversores getUtilEstrategiaDeConversores() {
		return UtilEstrategiaDeConversores.getInstancia();
	}
}
