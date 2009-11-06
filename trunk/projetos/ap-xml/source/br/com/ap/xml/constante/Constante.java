/*
 * Constante.java
 * 
 * Data de criação: 04/06/2007
 * 
 *
 *
 */
package br.com.ap.xml.constante;

/**
 * Constantes da API.
 * 
 * @author AdrianoP
 */
public final class Constante {

	/**
	 * Construtor.
	 */
	private Constante() {
		// Construtor
	}

	/**
	 * Retorna o nome do logger.
	 * 
	 * @return Nome do logger
	 */
	public static String getNomeDoLogger() {
		return "br.com.ap.xml";
	}

	/**
	 * Retorna o path do arquivo mensagem-xml.properties.
	 * 
	 * @return path do arquivo mensagem-xml.properties.
	 */
	public static String getPathArquivoMensagemProperties() {
		return "/br/com/ap/xml/recurso/mensagem-xml.properties";
	}

	/**
	 * Retorna o path do arquivo transformacao.properties.
	 * 
	 * @return path do arquivo transformacao.properties.
	 */
	public static String getPathArquivoTransformacaoProperties() {
		return "/br/com/ap/xml/recurso/transformacao.properties";
	}

}
