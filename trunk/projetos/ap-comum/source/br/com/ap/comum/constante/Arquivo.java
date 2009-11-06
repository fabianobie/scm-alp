/*
 * Arquivo.java
 * 
 * Data de criação: 25/06/2007
 *
 * 
 * 
 */
package br.com.ap.comum.constante;

/**
 * Classe contendo as constantes que referenciam arquivos de alguma forma.
 * 
 * @author adrianop
 */
public final class Arquivo {

	/**
	 * Construtor.
	 */
	private Arquivo() {
		// Construtor
	}

	/**
	 * Retorna o path do arquivo mensagem-comum.properties.
	 * 
	 * @return path do arquivo mensagem-comum.properties.
	 */
	public static String getPathArquivoMensagemProperties() {
		return "/br/com/ap/comum/resource/mensagem-comum.properties";
	}

	/**
	 * Retorna o path do arquivo formatadores-padrao.properties.
	 * 
	 * @return path do arquivo formatadores-padrao.properties.
	 */
	public static String getPathFormatadoresPadraoProperties() {
		return "/br/com/ap/comum/resource/formatadores-padrao.properties";
	}

	/**
	 * Retorna o path do arquivo conversores-padrao.properties.
	 * 
	 * @return path do arquivo conversores-padrao.properties.
	 */
	public static String getPathConversoresPadraoProperties() {
		return "/br/com/ap/comum/resource/conversores-padrao.properties";
	}
}
